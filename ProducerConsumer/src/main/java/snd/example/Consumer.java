package snd.example;

public class Consumer implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }


    @Override
    public void run() {
        try {
            store.sellProduct();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String status() {
        return "Consumer# " + id;
    }

    public int getId() {
        return id;
    }
}
