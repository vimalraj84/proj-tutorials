package com.bilqu.java8.test;


import com.bilqu.java8.filestream.ProfileLogParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss.SSS");
    public static void main(String[] args) {
       String file = "C:\\Temp\\SFU\\2021-03-13\\profiling_aspect-172163253.log";
        String server = file.substring(file.indexOf("aspect-")+7,file.indexOf(".log"));
        System.out.println(server);
                
    }



}