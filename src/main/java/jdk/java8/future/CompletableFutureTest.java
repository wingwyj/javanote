package jdk.java8.future;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture java8新特性
 * @author wyj
 * @version 1.0
 * @date 2025/5/2
 */
public class CompletableFutureTest {
    public static void main(String[] args) {

        CompletableFuture<Void> futureVoid = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("this is runAsync");
        });

        try {
            futureVoid.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("这是主线程输出的字符串");
    }
}
