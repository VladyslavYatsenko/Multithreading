package snd.example;

import java.util.concurrent.*;

public class Store {
    private ArrayBlockingQueue productList = new ArrayBlockingQueue<>(100);


    public void addProduct() throws InterruptedException {
        try {
            Product product = new Product(Math.random() * 100, new StringGenerator().getUuid());
            productList.add(product);
            System.out.println("PRODUCER added Product->>>>> " + product.toString());
        } catch (IllegalStateException ex) {
            Thread.sleep(1000);
        }


    }

    public void sellProduct() throws InterruptedException {
        try {
            Product product = (Product) productList.take();
            productList.take();
            System.out.println("Consumer bought Product->>>>>>>>>" + product.toString());
        } catch (Exception ex) {
            Thread.sleep(1000);
        }

    }
}
