package Commands;

import SystemVouchers.SystemVouchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SortTest {

    private SortCommand command;
    private SystemVouchers mockSystemVouchers;

    @BeforeEach
    void setUp() {
        mockSystemVouchers = Mockito.mock(SystemVouchers.class);

        command = new SortCommand("", "");
        command.setVouchers(mockSystemVouchers);
    }

    @Test
    void testExecuteSortByDaysAscending() {
        command.setTitle("Сортувати за кількістю днів");
        command.setType("За зростанням");

        command.execute();

        verify(mockSystemVouchers).sortVouchersByDays(true);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByDaysDescending() {
        command.setTitle("Сортувати за кількістю днів");
        command.setType("За спаданням");
        command.execute();

        verify(mockSystemVouchers).sortVouchersByDays(false);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByPriceAscending() {
        command.setTitle("Сортувати за ціною");
        command.setType("За зростанням");
        command.execute();

        verify(mockSystemVouchers).sortVouchersByPrice(true);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByPriceDescending() {
        command.setTitle("Сортувати за ціною");
        command.setType("За спаданням");
        command.execute();

        verify(mockSystemVouchers).sortVouchersByPrice(false);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByDateAscending() {
        command.setTitle("Сортувати за датою");
        command.setType("За зростанням");
        command.execute();

        verify(mockSystemVouchers).sortVouchersByDate(true);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test
    void testExecuteSortByDateDescending() {
        command.setTitle("Сортувати за датою");
        command.setType("За спаданням");
        command.execute();

        verify(mockSystemVouchers).sortVouchersByDate(false);
        verify(mockSystemVouchers).showVouchers(true);
    }

    @Test void testSetType() {
        command.setType("Новий тип");
        assertEquals("Новий тип", command.getType());
    }
}
