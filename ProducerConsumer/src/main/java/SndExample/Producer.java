package SndExample;


public class Producer implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void addProduct() {
        Product product = new Product(Math.random()*100, new StringGenerator().generateString());
        store.getProductList().add(product);
        System.out.println(status() + "Product was added" + product.toString());

    }

    @Override
    public void run() {
        addProduct();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String status() {
        return "Producer# " + id;
    }
}
