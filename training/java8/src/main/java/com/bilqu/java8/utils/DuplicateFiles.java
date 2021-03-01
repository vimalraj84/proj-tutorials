package com.bilqu.java8.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DuplicateFiles {


    private static MessageDigest md;
    static {
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("cannot initialize SHA-512 hash function", e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Remove Duplicate Files");
        analyze("C:/Temp/Video");
    }

    private static void  analyze(String dir) throws FileNotFoundException {
        File ipDir = new File(dir);
        if(ipDir.isDirectory()){
            System.out.println(ipDir.getName());
//            Arrays.stream(ipDir.listFiles()).forEach(i -> System.out.println(i.getName() +" -> Hash="+i.hashCode()));

            for(File file : ipDir.listFiles()){
                FileInputStream fis = new FileInputStream(file);
                byte fileData[] = new byte[(int) file.length()];
                String uniqueFileHash = new BigInteger(1, md.digest(fileData)).toString(16);
                System.out.println(file.getName() +" -> UniqueFileHash="+uniqueFileHash);
            }

//            Path source = Paths.get(fromFile);
//            Path target = Paths.get(toFile);
//            Files.move(source, target);
        }


    }
}
