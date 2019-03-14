package FstExample.app;

import FstExample.kitchen.Kitchen;
import FstExample.server.Server;
import FstExample.staff.Staff;

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
 