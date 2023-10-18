package io.github.boniu.excel.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import io.github.boniu.excel.util.EasyExcelListener;
import io.github.boniu.excel.util.EasyExcelUtil;
import io.github.boniu.excel.util.ExcelUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/************************************************************************
 * author: wg
 * description: Test 
 * createTime: 10:00 2023/8/10
 * updateTime: 10:00 2023/8/10
 ************************************************************************/
public class Test {

    // public static void main(String[] args) {
    //    /* File file = new File("");
    //     ExcelReaderBuilder readerBuilder = EasyExcel.read(file);
    //     readerBuilder.doReadAll();*/
    //
    //     try {
    //         getList();
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    public static void getList() throws Exception {
        String path = "static/excel/内检测数据.xlsx";
        ClassPathResource resource = new ClassPathResource(path);
        File file = resource.getFile();
        List<IliDetailExcel> list = ExcelUtil.getData(file, null, IliDetailExcel.class);
        list.forEach(System.out::println);
    }

    /************************************************************************
     * @author: wg
     * @description: 总结: easyexcel 无法指定标题行
     * @params:
     * @return:
     * @createTime: 14:49  2023/10/7
     * @updateTime: 14:49  2023/10/7
     ************************************************************************/
    public static void main(String[] args) throws IOException {
        String path = "static/excel/月报模板20231007.xlsx";
        ClassPathResource resource = new ClassPathResource(path);
        File file = resource.getFile();
        EasyExcelListener<DemoExcelDto> easyExcelListener = new EasyExcelListener<>();
        Map<Integer, String> errorMap = EasyExcelUtil.importExcel(file, DemoExcelDto.class, easyExcelListener);
        List<DemoExcelDto> data = easyExcelListener.getData();
        List<Map<String, Object>> mapData = easyExcelListener.getMapData();

        for (DemoExcelDto datum : data) {
            System.out.println(datum);
        }

        System.out.println();
        EasyExcel.read(file, DemoExcelDto.class, new PageReadListener<DemoExcelDto>(dataList -> {
            for (DemoExcelDto demoData : dataList) {
                System.out.println(demoData);
            }
        })).sheet().headRowNumber(1).doRead();
    }
}
