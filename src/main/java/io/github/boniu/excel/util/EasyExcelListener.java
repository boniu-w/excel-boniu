package io.github.boniu.excel.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import io.github.boniu.util.BeanUtil;
import io.github.boniu.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/************************************************************************
 * author: wg
 * description: EasyExcelListener 
 * createTime: 10:02 2023/10/7
 * updateTime: 10:02 2023/10/7
 ************************************************************************/
public class EasyExcelListener<T> implements ReadListener<T> {
    private final Logger logger = LoggerFactory.getLogger(EasyExcelListener.class);
    private Class<?> headClazz;
    //读取数据map形式
    private final List<Map<String, Object>> mapData = new ArrayList<>();

    //读取数据实体类泛型形式
    private final List<T> data = new ArrayList<>();

    //非空校验map
    private final Map<String, Boolean> nullAbleFieldMap = new HashMap<>();

    //格式校验map
    private final Map<String, String> checkFormatFieldMap = new HashMap<>();

    //长度校验map
    private final Map<String, Integer> checkLengthFieldMap = new HashMap<>();

    //枚举值校验map
    private final Map<String, String[]> checkEnumFieldMap = new HashMap<>();

    //数据校验错误信息map key:错误的行号  value:错误信息描述
    private final Map<Integer, String> errorMessageMap = new HashMap<>();

    public List<Map<String, Object>> getMapData() {
        return mapData;
    }

    public List<T> getData() {
        return data;
    }

    public Map<Integer, String> getErrorMessageMap() {
        return errorMessageMap;
    }

    public EasyExcelListener() {
    }

    /**
     * @param headClazz excel model 类对象
     */
    public EasyExcelListener(Class<?> headClazz) {
        this.headClazz = headClazz;
    }

    /**
     * 读取发生异常时的方法
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        logger.debug("发生了异常");
    }

    /**
     * 读取头信息
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        ExcelPropertyCheck clazzHeadAnno = this.headClazz.getAnnotation(ExcelPropertyCheck.class);
        Field[] declaredFields = headClazz.getDeclaredFields();
        if (clazzHeadAnno != null && clazzHeadAnno.required()) {
            for (Field declaredField : declaredFields) {
                nullAbleFieldMap.put(declaredField.getName(), true);
            }
        }

        for (Field declaredField : declaredFields) {
            ExcelPropertyCheck annotation = declaredField.getAnnotation(ExcelPropertyCheck.class);
            if (annotation != null) {
                if (annotation.checkFormat()) {
                    checkFormatFieldMap.put(declaredField.getName(), annotation.type() + "");
                }
                if (annotation.required()) {
                    nullAbleFieldMap.put(declaredField.getName(), true);
                } else {
                    nullAbleFieldMap.remove(declaredField.getName());
                }
                if (annotation.required() && annotation.length() != -1) {
                    checkLengthFieldMap.put(declaredField.getName(), annotation.length());
                }
                if (annotation.required() && annotation.value().length != 0) {
                    checkEnumFieldMap.put(declaredField.getName(), annotation.value());
                }

            }
        }
    }

    /**
     * 读取每一行数据
     *
     * @param t
     * @param analysisContext
     */
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        int rowIndex = ((ReadSheetHolder) analysisContext.currentReadHolder()).getRowIndex() + 1;
        StringBuilder error = new StringBuilder();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        //必填校验和格式校验
        for (Field declaredField : declaredFields) {
            try {
                declaredField.setAccessible(true);
                if (nullAbleFieldMap.get(declaredField.getName()) != null) {
                    if (nullAbleFieldMap.get(declaredField.getName())) {
                        Object o = declaredField.get(t);
                        if (!Objects.nonNull(o)) {
                            error.append(declaredField.getName()).append("为空;");
                        } else {
                            //字段不为空进行长度校验
                            if (checkLengthFieldMap.get(declaredField.getName()) != null) {
                                if (String.valueOf(o).length() > checkLengthFieldMap.get(declaredField.getName())) {
                                    error.append(declaredField.getName()).append("长度错误;");
                                }
                            }
                            if (checkEnumFieldMap.get(declaredField.getName()) != null) {
                                if (Integer.parseInt(String.valueOf(o)) == -1) {
                                    error.append(declaredField.getName()).append("枚举值错误;");
                                }
                            }
                        }
                    }
                }
                //是否需要进行格式校验
                if (checkFormatFieldMap.get(declaredField.getName()) != null) {
                    String res = check(String.valueOf(declaredField.get(t)), Integer.valueOf(checkFormatFieldMap.get(declaredField.getName())));
                    if (StringUtils.hasText(res)) {
                        error.append(res);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.hasText(error.toString())) {
            errorMessageMap.put(rowIndex, error.toString());
        }
        mapData.add(BeanUtil.bean2Map(t));
        data.add(t);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        logger.info("excel解析完毕,共解析{}条数据,错误数据{}条，错误详情{}", data.size(), errorMessageMap.size(), errorMessageMap);
    }

    private String check(String str, Integer checkType) {
        switch (checkType) {
            case 0:
                return DateUtil.isDate(str) ? "" : "日期格式错误;";
            default:
                return "";
        }
    }

}
