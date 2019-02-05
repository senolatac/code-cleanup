package com.sha.util;

import java.io.File;

public class FileUtil {

    public static boolean isFileExist(final String filename){
        return new File(filename).exists();
    }

    public static boolean isFile(final String filename){
        return new File(filename).isFile();
    }
}
