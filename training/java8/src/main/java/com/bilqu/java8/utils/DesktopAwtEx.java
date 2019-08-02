package com.bilqu.java8.utils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

public class DesktopAwtEx {

    public static void main(String[] a) throws InterruptedException, ExecutionException {

        System.out.format("Activating Robot at %s \n", LocalDateTime.now());
        System.out.format("Robot Started %s \n",LocalDateTime.now());

        ScheduledExecutorService schedThreadPool  = Executors.newScheduledThreadPool(3);
        //The following code shows how to execute a task after 100000 milliseconds delay and then repeat it every 900000 milliseconds.
        ScheduledFuture<?> sfuture = schedThreadPool.scheduleAtFixedRate(new DesktopAwtEx().new WinTaskRunn(),
                100000,
                900000,
                TimeUnit.MILLISECONDS);

        //After scheduling the task, we wait until it fires three times using the CountDownLatch lock,
        //then cancel it using the Future.cancel() method
        CountDownLatch lock = new CountDownLatch(5);
        lock.await(30000, TimeUnit.MILLISECONDS);
        sfuture.cancel(true);
        System.out.format("Robot Stopped %s \n",LocalDateTime.now());
        System.out.format("Robot Deactivated %s \n",LocalDateTime.now());
        if (!schedThreadPool.isTerminated()) schedThreadPool.shutdown();
        System.exit(1);
    }

    public class WinTaskRunn implements Runnable{

        @Override
        public void run() {
                //Desktop.getDesktop().open(file);
                //Desktop.getDesktop().browse(new URI("http://wiki:8086"));
//            moveMouse();
//            launchSkype();
//            moveMouse();
//            launchNote();
            moveMouse();
//            launchCmd();
        }

        private void launchSkype(){
            try {
                Runtime runTime = Runtime.getRuntime();
                Process process  = runTime.exec("C:/Program Files (x86)/Microsoft Office/root/Office16/lync.exe");
//                process.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        private void launchNote(){
            try {
                Runtime runTime = Runtime.getRuntime();
                Process process = runTime.exec("notepad.exe");
//                process.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        private void launchCmd(){
            try {
                Runtime runTime = Runtime.getRuntime();
                Process process = runTime.exec(new String[]{"C:/Program Files/Git/git-bash.exe","ls"});
//                process.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }


        private void moveMouse(){
            try {
                Random random = new Random();
                int x = random.nextInt() % 320;
                int y = random.nextInt() % 240;
                Robot robot = new Robot();
                robot.mouseMove(x,y);
                System.out.println("Robot moving mouse pointer");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
