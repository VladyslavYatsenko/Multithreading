package fst.ex.kitchen;

import fst.ex.staff.Staff;

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
