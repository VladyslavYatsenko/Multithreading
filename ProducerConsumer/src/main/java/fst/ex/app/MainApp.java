package fst.ex.app;

import fst.ex.kitchen.Kitchen;
import fst.ex.server.Server;
import fst.ex.staff.Staff;

public class MainApp {
    public static void main(String[] args) {
        Staff staff=new Staff();
        Kitchen kitchen=new Kitchen(staff);
        Server server=new Server(staff);
        Thread kt=new Thread(kitchen);
        Thread sv=new Thread(server);
        kt.start();
        sv.start();
    }


}
 