package io.github.boniu.excel.demo;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import io.github.boniu.excel.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        try {
            getHaiyouguoji();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static List<HaiyouguojiExcel> getHaiyouguoji() throws Exception {
        List<HaiyouguojiExcel> lists = new ArrayList<>();

        ArrayList<File> files = new ArrayList<>();
        String sourcePath = "E:\\文档\\海油国际设备设施完整性\\表视图";
        List<File> allFile = FileUtil.getAllFile(sourcePath, files);

        for (File file : allFile) {
            ExcelReader reader = ExcelUtil.getReader(file);
            List<HaiyouguojiExcel> excels = reader.readAll(HaiyouguojiExcel.class);
            lists.addAll(excels);

            // List<HaiyouguojiExcel> list = ExcelUtil.getImportList(file, null, new HaiyouguojiExcel());
            // lists.addAll(list);
        }

        // String path = "static/excel/监测检验.xlsx";
        // for (String inputPath : paths) {
        //     ClassPathResource resource = new ClassPathResource(inputPath);
        //     File file = resource.getFile();
        //     List<HaiyouguojiExcel> list = ExcelUtil.getImportList(file, null, new HaiyouguojiExcel());
        //     lists.addAll(list);
        // }

        return lists;
    }
}
