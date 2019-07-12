package com.bilqu.java8.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class DesktopAwtEx {

    public static void main(String[] a) throws InterruptedException, ExecutionException {
        ScheduledExecutorService schedThreadPool  = Executors.newScheduledThreadPool(5);
        //The following code shows how to execute a task after 100000 milliseconds delay and then repeat it every 900000 milliseconds.
        ScheduledFuture<?> sfuture = schedThreadPool.scheduleAtFixedRate(new DesktopAwtEx().new WinTaskRunn(),
                100000,
                900000,
                TimeUnit.MILLISECONDS);

        //After scheduling the task, we wait until it fires three times using the CountDownLatch lock,
        //then cancel it using the Future.cancel() method
//        CountDownLatch lock = new CountDownLatch(3);
//        lock.await(900000, TimeUnit.MILLISECONDS);
//        sfuture.cancel(true);
    }

    public class WinTaskRunn implements Runnable{
        File file = new File("C:/Vimalraj/Test.txt");
        @Override
        public void run() {
            try {
                System.out.println("Calling Windows Task");
                Desktop.getDesktop().open(file);
                Robot robot = new Robot();
                Random random = new Random();
                int x = random.nextInt() % 640;
                int y = random.nextInt() % 480;
                robot.mouseMove(x,y);
                System.out.println("Done moving mouse");
//              Desktop.getDesktop().browse(new URI("http://wiki:8086"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
