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
        Config.INPUT_READER = new MockReader(List.of("admin", "admin", "1", "2"));
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
                () -> assertEquals("Invoiced amount (EUR)", clientTableCell04),
                () -> assertEquals("Received amount (EUR)", clientTableCell05),
                () -> assertEquals("John", clientTableCell10),
                () -> assertEquals("Johnson", clientTableCell11),
                () -> assertEquals("j.johnson@gmail.com", clientTableCell12),
                () -> assertEquals("Company", clientTableCell13),
                () -> assertEquals("5500", clientTableCell14),
                () -> assertEquals("4750", clientTableCell15)

        );

    }
    @Test
    public void testAddClientScenario() {
        MockPrinter mockPrinter = new MockPrinter();
        Config.EXIT_AFTER_WINDOW_CHANGES = 5;
        Config.INPUT_READER = new MockReader(
                List.of("admin", "admin", "1", "1", "Peter", "Peterson", "p.peterson@gmail.com", "Company2", "0", "0")
        );
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String clientsTitle = outputs.get(9);
        String chooseOptionText = outputs.get(24);
        String addClientOptionText = outputs.get(25);
        String goBackOptionText = outputs.get(26);
        String newClientTitle = outputs.get(27);
        String addFirstNameText = outputs.get(28);
        String addLastNameText = outputs.get(29);
        String addOrganizationText = outputs.get(30);
        String addEmailText = outputs.get(31);
        String clientsTitle2 = outputs.get(32);
        String clientAddedMessage = outputs.get(33);
        String numberOfClientsText = outputs.get(34);
        String clientsTableNameText = outputs.get(35);
        String clientTableCell00 = outputs.get(36);
        String clientTableCell01 = outputs.get(37);
        String clientTableCell02 = outputs.get(38);
        String clientTableCell03 = outputs.get(39);
        String clientTableCell04 = outputs.get(40);
        String clientTableCell05 = outputs.get(41);
        String clientTableCell10 = outputs.get(42);
        String clientTableCell11 = outputs.get(43);
        String clientTableCell12 = outputs.get(44);
        String clientTableCell13 = outputs.get(45);
        String clientTableCell14 = outputs.get(46);
        String clientTableCell15 = outputs.get(47);
        String clientTableCell20 = outputs.get(48);
        String clientTableCell21 = outputs.get(49);
        String clientTableCell22 = outputs.get(50);
        String clientTableCell23 = outputs.get(51);
        String clientTableCell24 = outputs.get(52);
        String clientTableCell25 = outputs.get(53);

        Assertions.assertAll(
                () -> assertEquals("Clients", clientsTitle),
                () -> assertEquals("Choose from the following options: ", chooseOptionText),
                () -> assertEquals("1) Add client", addClientOptionText),
                () -> assertEquals("2) Go back", goBackOptionText),
                () -> assertEquals("New client", newClientTitle),
                () -> assertEquals("Write clients' first name:", addFirstNameText),
                () -> assertEquals("Write clients' last name:", addLastNameText),
                () -> assertEquals("Write clients' organization:", addOrganizationText),
                () -> assertEquals("Write clients' email:", addEmailText),
                () -> assertEquals("Clients information", clientsTableNameText),
                () -> assertEquals("Clients", clientsTitle2),
                () -> assertEquals("Success: Client was added", clientAddedMessage),
                () -> assertEquals("Number of clients that you have: 2", numberOfClientsText),
                () -> assertEquals("Clients information", clientsTableNameText),
                () -> assertEquals("First name", clientTableCell00),
                () -> assertEquals("Last name", clientTableCell01),
                () -> assertEquals("Email", clientTableCell02),
                () -> assertEquals("Organization", clientTableCell03),
                () -> assertEquals("Invoiced amount (EUR)", clientTableCell04),
                () -> assertEquals("Received amount (EUR)", clientTableCell05),
                () -> assertEquals("John", clientTableCell10),
                () -> assertEquals("Johnson", clientTableCell11),
                () -> assertEquals("j.johnson@gmail.com", clientTableCell12),
                () -> assertEquals("Company", clientTableCell13),
                () -> assertEquals("5500", clientTableCell14),
                () -> assertEquals("4750", clientTableCell15),
                () -> assertEquals("Peter", clientTableCell20),
                () -> assertEquals("Peterson", clientTableCell21),
                () -> assertEquals("p.peterson@gmail.com", clientTableCell22),
                () -> assertEquals("Company2", clientTableCell23),
                () -> assertEquals("0", clientTableCell24),
                () -> assertEquals("0", clientTableCell25)
        );
    }
}
