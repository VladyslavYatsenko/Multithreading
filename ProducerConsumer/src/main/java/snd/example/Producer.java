package snd.example;


public class Producer implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            store.addProduct();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String status() {
        return "Producer# " + id;
    }

    public int getId() {
        return id;
    }
}
