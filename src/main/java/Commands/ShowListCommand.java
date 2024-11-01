package Commands;

import SelectParameters.SelectParameters;
import VoucherParameters.*;

public class ShowListCommand extends Command {

    public ShowListCommand(String title) {
        super(title);
    }

    @Override
    public void execute() {
        switch (title) {
            case "Вивести всі путівки":
                systemVouchers.resetVouchers();
                break;

            case "За типом":
                VoucherType type = SelectParameters.selectVoucherType();
                systemVouchers.setVouchersByType(type);
                break;

            case "За країною":
                Country country = SelectParameters.selectCountry();
                systemVouchers.setVouchersByCountry(country);
                break;

            case "За транспортом":
                VoucherTransport transport = SelectParameters.selectTransport();
                systemVouchers.setVouchersByTransport(transport);
                break;

            case "За бюджетом":
                Budget budget = SelectParameters.selectBudget();
                systemVouchers.setVouchersByBudget(budget);
                break;

            case "За харчуванням":
                Nutrition nutrition = SelectParameters.selectNutrition();
                systemVouchers.setVouchersByNutrition(nutrition);
                break;
        }

        systemVouchers.showVouchers(true);
    }
}