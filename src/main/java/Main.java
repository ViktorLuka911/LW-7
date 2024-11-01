import Menu.MenuMain;
import SystemVouchers.SystemVouchers;

public class Main {
    public static void main() {

        SystemVouchers systemVouchers = SystemVouchers.getInstance();

        MenuMain menu = new MenuMain();
        menu.startMenu();

        systemVouchers.closeDataFileLogger();
    }
}