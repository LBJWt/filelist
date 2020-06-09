package com.wangteng.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangteng
 * @version 1.0
 * @description TODO
 * @date 2020/6/9 3:15
 */
public class FileListInfo {

    public static void traverseFolder2(String path, List<FileInfoVO> fileInfoVOS) {


        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    FileInfoVO fileInfoVO = FileInfoVO.builder().build();
                    if (file2.isDirectory()) {
//                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        long size = FileUtils.sizeOfDirectory(new File(file2.getAbsolutePath()));
//                        System.out.println("size = " + size);
                        fileInfoVO.setFileName(file2.getName());
                        fileInfoVO.setFileSize(size);
                    } else {
                        fileInfoVO.setFileName(file2.getName());
                        fileInfoVO.setFileSize(file2.length());
//                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                    fileInfoVOS.add(fileInfoVO);
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
    public static String FormetFileSize(long fileS) {//转换文件大小
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }
    public static void main(String[] args) {


        System.out.printf("%-8s\t %-9s\n","文件（文件夹）名称","文件（文件夹）大小");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件路径（绝对路径）：");
        String filePath = sc.nextLine();

        List<FileInfoVO> fileInfoVOS = new ArrayList<>();
        FileInfoVO fileInfoVO1 = FileInfoVO.builder().fileName("AppData").fileSize(10000).build();
        fileInfoVOS.add(fileInfoVO1);
        traverseFolder2(filePath,fileInfoVOS);
        fileInfoVOS.sort(Comparator.comparing(a->(((FileInfoVO)a).getFileSize())).reversed());
        System.out.printf("文件夹名称： %s\n" ,filePath);
        System.out.printf("%-100s\t%-50s\n","文件（文件夹）名称","文件（文件夹）大小");


        fileInfoVOS.stream().forEach(fileInfoVO -> {
            System.out.printf("%-100s\t%-100s\n",fileInfoVO.getFileName(),FormetFileSize(fileInfoVO.getFileSize()));
        });




    }


}
