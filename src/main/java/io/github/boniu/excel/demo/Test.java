package io.github.boniu.excel.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;

import java.io.File;

/************************************************************************
 * author: wg
 * description: Test 
 * createTime: 10:00 2023/8/10
 * updateTime: 10:00 2023/8/10
 ************************************************************************/
public class Test {

    public static void main(String[] args) {
        File file = new File("");
        ExcelReaderBuilder readerBuilder = EasyExcel.read(file);
        readerBuilder.doReadAll();
    }
}
