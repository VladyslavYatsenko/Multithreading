package FstExample.staff;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    private List<Integer> ordersList;
    private int maxOrders = 10;

    public Staff() {
        ordersList = new ArrayList<>();
    }

    public void prepare() throws InterruptedException {
        synchronized (this) {
            int order = 0;
            while (true) {
                if (ordersList.size() == maxOrders) {
                    wait();
                } else {
                    Thread.sleep(1000);
                    ordersList.add(order++);
                    System.out.println("Order #" + order + "is ready to served");
                    notifyAll();
                }
            }

        }
    }

    public void serve() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (ordersList.isEmpty()) {
                    wait();
                } else {
                    System.out.println("Serving order #" + ordersList.remove(0));
                    notifyAll();
                }
            }
        }
    }
}
