package SndExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Store {
    private ArrayBlockingQueue productList = new ArrayBlockingQueue<>(100);

    private ExecutorService producerService = Executors.newFixedThreadPool(10);
    private ExecutorService consumerService = Executors.newFixedThreadPool(5);

    public void work() throws InterruptedException {
        for (int i = 0; i < 250; i++) {

            producerService.execute(new Producer(this));
            consumerService.execute(new Consumer(this));
//            if(productList.remainingCapacity()==0){
//               producerService.shutdown();
//                consumerService.execute(new Consumer(this));
//            }
//            if(productList.isEmpty()){
//                consumerService.shutdown();
//                producerService.execute(new Producer(this));
//
//            }


        }
        producerService.shutdown();
        consumerService.shutdown();


    }


    public ArrayBlockingQueue getProductList() {
        return productList;
    }
}
