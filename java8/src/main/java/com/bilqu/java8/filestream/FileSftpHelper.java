package com.bilqu.java8.filestream;

import com.jcraft.jsch.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSftpHelper {

    public static void main(String[] a){
        String[] remoteHostList = {"10.21.19.51","10.21.19.52"};
        String basePath = "/Temp/Logs/";
        String  uid = "suser";
        String  pswd = "spwd";
        Arrays.stream(remoteHostList).forEach(host -> scpProfileLogs(host,basePath,uid,pswd));
    }

    private static List<String> scpProfileLogs(String host,String basePath,String uid, String pswd)  {
        Session jschSession = null;
        ChannelSftp channelSftp = null;
        LocalDate localDate = LocalDate.now();
        List<String> logFileList = new ArrayList<>();
        String remoteCatlinaLogFile = "/logs/catalina.out";
        String localCatlinaLogFile = basePath+"/logs/catalina"+localDate.toString()+".out";
        String remoteAppLogFile = "/logs/application.log";
        String localAppLogFile = basePath+"/logs/application-"+localDate.toString()+".log";
        try {

            JSch jsch = new JSch();
//          jsch.setKnownHosts("C:/Users/vimal/.ssh/known_hosts");

            jschSession = jsch.getSession(uid, host);
            jschSession.setPassword(pswd);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            jschSession.setConfig(config);

            jschSession.connect();

            channelSftp =  (ChannelSftp) jschSession.openChannel("sftp");
            channelSftp.connect();

            System.out.println("Connected to "+host);
            channelSftp.get(remoteCatlinaLogFile, localCatlinaLogFile);
            //channelSftp.put(remoteFile, localDir );
            System.out.println("scp "+remoteCatlinaLogFile);
            logFileList.add(localCatlinaLogFile);

            channelSftp.get(remoteAppLogFile, localAppLogFile);
            System.out.println("scp "+remoteAppLogFile);
            logFileList.add(localAppLogFile);

        } catch (JSchException | SftpException e) {
            System.err.println("SCP failed from "+host+", Exception : "+e.getMessage());
        }finally {
            channelSftp.exit();
            jschSession.disconnect();
        }
        return logFileList;
    }
}
