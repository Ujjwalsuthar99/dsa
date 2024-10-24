package org.example.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading {

    public static void addition() {
        System.out.println("Addition");
    }

    public static void multiply() {
        System.out.println("multiplication");
    }

    public static void subtraction() {
        System.out.println("subtraction");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable callMultiply = () -> multiply();  //Create Runnable reference using lambda
        executor.execute(callMultiply);
        executor.execute(() -> addition()); //inline
        executor.execute(() -> subtraction());

        executor.shutdown();
    }
}