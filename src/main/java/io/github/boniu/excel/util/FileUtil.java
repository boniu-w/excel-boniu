package io.github.boniu.excel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/************************************************************************
 * @author: wg
 * @description:
 * @createTime: 16:50 2022/3/14
 * @updateTime: 16:50 2022/3/14
 ************************************************************************/
public class FileUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /************************************************************************
     * @author: wg
     * @description: 获取文件夹下所有文件
     * @params:
     * @return:
     * @createTime: 17:28  2022/9/8
     * @updateTime: 17:28  2022/9/8
     ************************************************************************/
    public static List<File> getAllFile(String path, List<File> fileList) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files && files.length > 0) {
                BasicFileAttributes basicFileAttributes = null;
                for (File file1 : files) {
                    basicFileAttributes = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
                    if (basicFileAttributes.isRegularFile()) {
                        fileList.add(file1);
                    } else if (basicFileAttributes.isDirectory()) {
                        getAllFile(file1.getPath(), fileList);
                    }
                }
            }
        }

        return fileList;
    }
}
