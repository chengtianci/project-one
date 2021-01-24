package org.chengtc.TTJJcrawler.utils;

import java.io.*;

public class FileUtils {

    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return FileUtils.class.getResource(File.separator).getPath();
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static void wirteHtml(String filename,String content) throws IOException {
        StringBuffer buffer = new StringBuffer();
        FileWriter file = new FileWriter(getPath()+filename+".html");
        BufferedWriter out=new  BufferedWriter(file);
        out.write(content);
    }
}
