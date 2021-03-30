package com.bilqu.java8.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WinSvsKiller {

    public static final int STATE_UNKNOWN       = -1;
    public static final int STATE_STOPPED       = 1;
    public static final int STATE_START_PENDING = 2;
    public static final int STATE_STOP_PENDING  = 3;
    public static final int STATE_RUNNING       = 4;

    public static void main(String[] args) throws IOException, InterruptedException {

        String[] status = {"cmd.exe", "/c", "sc", "query", "Umbrella_RC", "|", "find", "/C", "\"RUNNING\""};

        // start service
        String[] start = {"cmd.exe", "/c", "sc", "start", "Umbrella_RC"};

        // stop service
        String[] stop = {"cmd.exe", "/c", "sc", "stop", "Umbrella_RC"};

        Process process = Runtime.getRuntime().exec(status);
        process.waitFor();
//        process = Runtime.getRuntime().exec(start);
        process = Runtime.getRuntime().exec(stop);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }
}
