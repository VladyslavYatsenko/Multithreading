package FstExample.kitchen;

import FstExample.staff.Staff;

public class Kitchen implements Runnable {
    private Staff staff;
    public  Kitchen(Staff staff){
        this.staff=staff;
    }
    @Override
    public void run() {
        try {
            staff.prepare();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
