package io.github.boniu.excel.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import io.github.boniu.excel.util.ExcelUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.List;

/************************************************************************
 * author: wg
 * description: Test 
 * createTime: 10:00 2023/8/10
 * updateTime: 10:00 2023/8/10
 ************************************************************************/
public class Test {

    public static void main(String[] args) {
       /* File file = new File("");
        ExcelReaderBuilder readerBuilder = EasyExcel.read(file);
        readerBuilder.doReadAll();*/

        try {
            getList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void getList() throws Exception {
        String path = "static/excel/内检测数据.xlsx";
        ClassPathResource resource = new ClassPathResource(path);
        File file = resource.getFile();
        List<IliDetailExcel> list = ExcelUtil.getData(file, null, IliDetailExcel.class);
        list.forEach(System.out::println);
    }
}
