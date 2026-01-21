package io.github.boniu.excel.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import io.github.boniu.excel.util.EasyExcelListener;
import io.github.boniu.excel.util.ExcelUtil;
import io.github.boniu.excel.util.FileUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * headRowNumber: 就指的是excel的行号
     * @params:
     * @return:
     * @createTime: 14:49  2023/10/7
     * @updateTime: 14:49  2023/10/7
     ************************************************************************/
    public static void main(String[] args) throws IOException {
       /* String path = "static/excel/月报模板20231007.xlsx";
        ClassPathResource resource = new ClassPathResource(path);
        File file = resource.getFile();
        EasyExcelListener<DemoExcelDto> easyExcelListener = new EasyExcelListener<>();*/

        // Map<Integer, String> errorMap = EasyExcelUtil.importExcel(file, DemoExcelDto.class, easyExcelListener);
        // List<DemoExcelDto> data = easyExcelListener.getData();
        // List<Map<String, Object>> mapData = easyExcelListener.getMapData();
        //
        // for (DemoExcelDto datum : data) {
        //     System.out.println(datum);
        // }
        //
        // System.out.println();
        // EasyExcel.read(file, DemoExcelDto.class, new PageReadListener<DemoExcelDto>(dataList -> {
        //     for (DemoExcelDto demoData : dataList) {
        //         System.out.println(demoData);
        //     }
        // })).sheet().headRowNumber(1).doRead();


        // ↓↓*******************  <code> 结论: 遇到错误类型, 无法报错, 直接不读了, 跳过了  *******************↓↓
        // String path = "static/excel/月报模板20231007.xlsx";
        // ClassPathResource resource = new ClassPathResource(path);
        // File file = resource.getFile();
        // EasyExcelListener<DemoExcelDto> easyExcelListener = new EasyExcelListener<>();
        // FileInputStream fileInputStream = new FileInputStream(file);
        // EasyExcel.read(fileInputStream, DemoExcelDto.class, easyExcelListener).headRowNumber(5).sheet(2).doRead();
        //
        // List<DemoExcelDto> data = easyExcelListener.getData();
        // data.forEach(System.out::println);
        // ↑↑*******************  <code>  end  *******************↑↑

        // ↓**********************************************
        String path = "static/excel/月报模板20231007.xlsx";
        ClassPathResource resource = new ClassPathResource(path);
        // File file1 = resource.getFile();

        EasyExcelListener<EquipmentExcelWg> easyExcelListener1 = new EasyExcelListener<>();
        String path1 = "C:\\Users\\wg\\Documents\\海油国际设备设施完整性\\excel\\英国公司台账.xlsx";
        File file1 = new File(path1);
        FileInputStream fileInputStream1 = new FileInputStream(file1);
        EasyExcel.read(fileInputStream1, EquipmentExcelWg.class, easyExcelListener1).headRowNumber(5).sheet(0).doRead();
        List<EquipmentExcelWg> data = easyExcelListener1.getData();

        System.out.println(data.size());
        System.out.println("data.get(0).toString() = " + data.get(0).toString());
        // data.stream().forEach(System.out::println);
        // ↑**********************************************
    }
}
