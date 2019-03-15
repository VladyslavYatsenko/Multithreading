package snd.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        ExecutorService producerService = Executors.newFixedThreadPool(15);
        ExecutorService consumerService = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 100; i++) {
            producerService.execute(new Producer(store));
            consumerService.execute(new Consumer(store));
        }
        producerService.shutdown();
        consumerService.shutdown();


    }
}
