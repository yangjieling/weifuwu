package com.xiaoxin.spring.common.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件操作工具类
 */
public class FileUtil {

    public static void main(String[] args) {
        String fileName = "pycharm-professional-2019.3.4.exe";
        String oldPath = "G:\\DATA";
        String newPath = "G:\\DATABAK";
        removeFile(fileName,oldPath,newPath);
        System.out.println("SUCCESS");
    }

    /**
     * 文件移动
     * @param fileName 文件名
     * @param oldPath 源目录
     * @param newPath 目标目录
     */
    public static void removeFile(String fileName,String oldPath,String newPath){
        if(!oldPath.equals(newPath)){
            File oldFile = new File(oldPath + "/" + fileName);
            File newFile = new File(newPath + "/" + fileName);
            if (oldFile.exists()){
                if (newFile.exists()){
                    newFile.renameTo(new File(newPath +"/" +fileName+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".bak"));
                    oldFile.renameTo(newFile);
                }else {
                    oldFile.renameTo(newFile);
                }
            }
        }
    }

    /**
     * 获取文件内容的行数
     * @param file 文本文件
     * @return
     */
    public static long getFileLine(File file){
        long line = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            LineNumberReader numberReader = new LineNumberReader(fileReader);
            numberReader.skip(Long.MAX_VALUE);
            line = numberReader.getLineNumber() + 1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }

    public void test(){
        System.out.println("this master");
        System.out.println("有冲突 with dev");

    }
}