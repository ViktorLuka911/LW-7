package Commands;

import SystemVouchers.SystemVouchers;

public class Command {

    protected String title;
    protected SystemVouchers systemVouchers;

    public Command(String title) {
        this.title = title;
        this.systemVouchers = SystemVouchers.getInstance();
    }

    public void execute() {};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVouchers(SystemVouchers systemVouchers) {
        this.systemVouchers = systemVouchers;
    }
}