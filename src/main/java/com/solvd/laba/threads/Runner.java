package com.solvd.laba.threads;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new MyThread());
//        thread.start();
//        MyThread myThread = new MyThread("MyThread");

        Path filePath = Paths.get("src\\main\\resources\\Война_и_мир.txt").toAbsolutePath();
        String textInString = MyReader.readTextFileOrGetNull(filePath);
        String[] splitedText = MyReader.splitTheStringWithText(textInString);

        System.out.println(splitedText.length);

        ExecutorService exec = Executors.newFixedThreadPool(5);

//        List<Thread> threads = new ArrayList<>();
//
//        double batchCount = 1000;
//        for (int i = 0; i < (splitedText.length / batchCount); i++) {
//            int from = (int)(i * batchCount);
//            int to = (int)(i * batchCount + batchCount);
//
//            threads.add(new Thread(new MyWordsCounter(Arrays.asList(Arrays.copyOfRange(splitedText, from, Math.min(to, splitedText.length))), new EasySearch(), "война")));
//
//            for (Thread thread : threads) {
//                thread.start();
//                thread.join();
//            }
//        }
    }
}
