package Commands;

import SystemVouchers.SystemVouchers;
import VoucherParameters.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import SelectParameters.SelectParameters;

import static org.mockito.Mockito.*;

class ShowListTest {

    private ShowListCommand command;
    private SystemVouchers mockSystemVouchers;
    private MockedStatic<SelectParameters> mockedParameters;

    @BeforeEach
    void setUp() {
        command = new ShowListCommand("");
        mockSystemVouchers = Mockito.mock(SystemVouchers.class);
        mockedParameters = Mockito.mockStatic(SelectParameters.class);

        command.setVouchers(mockSystemVouchers);
    }

    @AfterEach
    void tearDown() {
        if (mockedParameters != null) {
            mockedParameters.close();
        }
    }

    @Test
    void testExecuteShowAllVouchers() {
        command.setTitle("Вивести всі путівки");
        command.execute();

        verify(mockSystemVouchers).resetVouchers();
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteFilterByType() {
        command.setTitle("За типом");
        VoucherType mockType = Mockito.mock(VoucherType.class);
        mockedParameters.when(SelectParameters::selectVoucherType).thenReturn(mockType);

        command.execute();

        verify(mockSystemVouchers).setVouchersByType(mockType);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteFilterByCountry() {
        command.setTitle("За країною");
        Country mockCountry = Mockito.mock(Country.class);
        mockedParameters.when(SelectParameters::selectCountry).thenReturn(mockCountry);

        command.execute();

        verify(mockSystemVouchers).setVouchersByCountry(mockCountry);
        verify(mockSystemVouchers).showVouchers(true);

    }

    @Test
    void testExecuteFilterByTransport() {
        command.setTitle("За транспортом");
        VoucherTransport mockTransport = Mockito.mock(VoucherTransport.class);
        mockedParameters.when(SelectParameters::selectTransport).thenReturn(mockTransport);

        command.execute();

        verify(mockSystemVouchers).setVouchersByTransport(mockTransport);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteFilterByBudget() {
        command.setTitle("За бюджетом");
        Budget mockBudget = Mockito.mock(Budget.class);
        mockedParameters.when(SelectParameters::selectBudget).thenReturn(mockBudget);

        command.execute();

        verify(mockSystemVouchers).setVouchersByBudget(mockBudget);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteFilterByNutrition() {
        command.setTitle("За харчуванням");
        Nutrition mockNutrition = Mockito.mock(Nutrition.class);
        mockedParameters.when(SelectParameters::selectNutrition).thenReturn(mockNutrition);

        command.execute();

        verify(mockSystemVouchers).setVouchersByNutrition(mockNutrition);
        verify(mockSystemVouchers).showVouchers(true);
    }
}