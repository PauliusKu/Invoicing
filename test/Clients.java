import main.client.Client;
import main.client.Config;
import main.client.mocks.MockPrinter;
import main.client.mocks.MockReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Clients {
    @Test
    public void testViewClientsScenario() {
        MockPrinter mockPrinter = new MockPrinter();
        Config.EXIT_AFTER_WINDOW_CHANGES = 3;
        Config.INPUT_READER = new MockReader(List.of("admin", "admin", "1"));
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String mainMenuTitle = outputs.get(4);
        String chooseOptionText = outputs.get(6);
        String viewClientsOptionText = outputs.get(7);
        String logoutOptionText = outputs.get(8);
        String clientsTitle = outputs.get(9);
        String numberOfClientsText = outputs.get(10);
        String clientsTableNameText = outputs.get(11);
        String clientTableCell00 = outputs.get(12);
        String clientTableCell01 = outputs.get(13);
        String clientTableCell02 = outputs.get(14);
        String clientTableCell03 = outputs.get(15);
        String clientTableCell04 = outputs.get(16);
        String clientTableCell05 = outputs.get(17);
        String clientTableCell10 = outputs.get(18);
        String clientTableCell11 = outputs.get(19);
        String clientTableCell12 = outputs.get(20);
        String clientTableCell13 = outputs.get(21);
        String clientTableCell14 = outputs.get(22);
        String clientTableCell15 = outputs.get(23);

        Assertions.assertAll(
                () -> assertEquals("Main menu", mainMenuTitle),
                () -> assertEquals("Choose from the following options: ", chooseOptionText),
                () -> assertEquals("1) View Clients", viewClientsOptionText),
                () -> assertEquals("2) Logout", logoutOptionText),
                () -> assertEquals("Clients", clientsTitle),
                () -> assertEquals("Number of clients that you have: 1", numberOfClientsText),
                () -> assertEquals("Clients information", clientsTableNameText),
                () -> assertEquals("First name", clientTableCell00),
                () -> assertEquals("Last name", clientTableCell01),
                () -> assertEquals("Email", clientTableCell02),
                () -> assertEquals("Organization", clientTableCell03),
                () -> assertEquals("Invoiced amount", clientTableCell04),
                () -> assertEquals("Received amount", clientTableCell05),
                () -> assertEquals("John", clientTableCell10),
                () -> assertEquals("Johnson", clientTableCell11),
                () -> assertEquals("j.johnson@gmail.com", clientTableCell12),
                () -> assertEquals("Company", clientTableCell13),
                () -> assertEquals("5500 Eur", clientTableCell14),
                () -> assertEquals("4750", clientTableCell15)

        );

    }
}
