package FstExample.server;

import FstExample.staff.Staff;

public class Server implements Runnable {
    private Staff staff;

    public Server(Staff staff) {
        this.staff = staff;
    }

    @Override
    public void run() {
        try {
            staff.serve();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
