package SndExample;

public class Consumer implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void buyProduct() {
        try {
            store.getProductList().take();
            System.out.println(status() + " Bought product");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        buyProduct();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String status() {
        return "Consumer# " + id;
    }
}
