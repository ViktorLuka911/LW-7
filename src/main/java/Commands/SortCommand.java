package Commands;

public class SortCommand extends Command {

    private String type;

    public SortCommand(String title, String type) {
        super(title);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void execute() {
        boolean ascending = getType().equals("За зростанням");

        switch (getTitle()) {
            case "Сортувати за кількістю днів":
                systemVouchers.sortVouchersByDays(ascending);
                break;

            case "Сортувати за ціною":
                systemVouchers.sortVouchersByPrice(ascending);
                break;

            case "Сортувати за датою":
                systemVouchers.sortVouchersByDate(ascending);
                break;
        }
        systemVouchers.showVouchers(true);
    }

    public void setType(String type) {
        this.type = type;
    }
}