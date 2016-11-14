package com.wkl.l.health.util;

import java.io.File;

/**
 * 概述：文件管理工具类 <br />
 */
public class FileUtils {

    /**
    * 在SD卡上创建目录
    * @param dirPath
    */
    public static File createSDDir(String dirPath) {
        File dir = new File(dirPath);
        dir.mkdirs();
        return dir;
    }

    /**
     * 判断SD卡上的文件夹是否存在
     */
    public static boolean isFileExist(String dirPath) {
        File file = new File(dirPath);
        return file.exists();
    }

    /**
     * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 <br />
     * 可应用于清理缓存
     * @param directoryPath
     */
    private static void deleteFilesByDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (file.exists() && file.isDirectory()) {
            for (File item : file.listFiles()) {
                item.delete();
            }
        }
    }
}