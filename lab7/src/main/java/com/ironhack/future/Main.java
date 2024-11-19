package com.ironhack.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService customExecutor = Executors.newFixedThreadPool(4);
        CompletableFuture<String> completable = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Primera llamada a la API");
                    return "{'orderId': '123234'}";
                }, customExecutor)
                .thenApplyAsync(s -> {
                    System.out.println("Result 1: " + s);
                    System.out.println("Segunda llamada a la API");
                    return "{'products': ['productId': '213123']}";
                }, customExecutor)
                .thenApplyAsync(s -> {
                    System.out.println("Result 2: " + s);
                    System.out.println("Tercera llamada a la API");
                    return "{'orderId': '123234', 'products': ['productId': '213123']}";
                }, customExecutor);
        String result = completable.join();
        System.out.println("Resultado final: " + result);
        customExecutor.shutdown();
    }
}
