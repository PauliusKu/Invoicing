import main.client.config.Client;
import main.client.config.Config;
import main.client.mocks.MockPrinter;
import main.client.mocks.MockReader;
import main.repository.common.IPrepareDB;
import main.repository.mock.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Clients {
    private void prepareDatabase(){
        IPrepareDB prepareDBUsers = new Users();
        prepareDBUsers.clear();
        prepareDBUsers.prepare(List.of("admin", "admin"));
        IPrepareDB prepareDBClients = new main.repository.mock.Clients();
        prepareDBClients.clear();
        prepareDBClients.prepare(List.of("John", "Johnson", "j.johnson@gmail.com", "Company", "5500", "4750"));
    }

    @Test
    public void testViewClientsScenario() {
        prepareDatabase();
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
    public void testAddClientSuccessScenario() {
        prepareDatabase();

        MockPrinter mockPrinter = new MockPrinter();
        Config.EXIT_AFTER_WINDOW_CHANGES = 6;
        Config.INPUT_READER = new MockReader(
                List.of("admin", "admin", "1", "1", "Peter", "Peterson", "p.peterson@gmail.com", "Company2", "0", "0")
        );
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String clientsTitle = outputs.get(9);
        String chooseOptionText = outputs.get(24);
        String addClientOptionText = outputs.get(25);
        String deleteClientOptionText = outputs.get(26);
        String goBackOptionText = outputs.get(27);
        String newClientTitle = outputs.get(28);
        String addFirstNameText = outputs.get(29);
        String addLastNameText = outputs.get(30);
        String addOrganizationText = outputs.get(31);
        String addEmailText = outputs.get(32);
        String clientsTitle2 = outputs.get(33);
        String clientAddedMessage = outputs.get(34);
        String numberOfClientsText = outputs.get(35);
        String clientsTableNameText = outputs.get(36);
        String clientTableCell00 = outputs.get(37);
        String clientTableCell01 = outputs.get(38);
        String clientTableCell02 = outputs.get(39);
        String clientTableCell03 = outputs.get(40);
        String clientTableCell04 = outputs.get(41);
        String clientTableCell05 = outputs.get(42);
        String clientTableCell10 = outputs.get(43);
        String clientTableCell11 = outputs.get(44);
        String clientTableCell12 = outputs.get(45);
        String clientTableCell13 = outputs.get(46);
        String clientTableCell14 = outputs.get(47);
        String clientTableCell15 = outputs.get(48);
        String clientTableCell20 = outputs.get(49);
        String clientTableCell21 = outputs.get(50);
        String clientTableCell22 = outputs.get(51);
        String clientTableCell23 = outputs.get(52);
        String clientTableCell24 = outputs.get(53);
        String clientTableCell25 = outputs.get(54);

        Assertions.assertAll(
                () -> assertEquals("Clients", clientsTitle),
                () -> assertEquals("Choose from the following options: ", chooseOptionText),
                () -> assertEquals("1) Add client", addClientOptionText),
                () -> assertEquals("2) Delete client", deleteClientOptionText),
                () -> assertEquals("3) Go back", goBackOptionText),
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

    @Test
    public void testAddClientAlternativeScenario() {
        prepareDatabase();

        MockPrinter mockPrinter = new MockPrinter();
        Config.EXIT_AFTER_WINDOW_CHANGES = 5;
        Config.INPUT_READER = new MockReader(
                List.of("admin", "admin", "1", "1", "Peter", "", "p.peterson@gmail.com", "Company2", "0", "0")
        );
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String clientsTitle = outputs.get(9);
        String chooseOptionText = outputs.get(24);
        String addClientOptionText = outputs.get(25);
        String deleteClientOptionText = outputs.get(26);
        String goBackOptionText = outputs.get(27);
        String newClientTitle = outputs.get(28);
        String addFirstNameText = outputs.get(29);
        String addLastNameText = outputs.get(30);
        String addOrganizationText = outputs.get(31);
        String addEmailText = outputs.get(32);
        String newClientTitle2 = outputs.get(33);
        String errorMessage = outputs.get(34);

        Assertions.assertAll(
                () -> assertEquals("Clients", clientsTitle),
                () -> assertEquals("Choose from the following options: ", chooseOptionText),
                () -> assertEquals("1) Add client", addClientOptionText),
                () -> assertEquals("2) Delete client", deleteClientOptionText),
                () -> assertEquals("3) Go back", goBackOptionText),
                () -> assertEquals("New client", newClientTitle),
                () -> assertEquals("Write clients' first name:", addFirstNameText),
                () -> assertEquals("Write clients' last name:", addLastNameText),
                () -> assertEquals("Write clients' organization:", addOrganizationText),
                () -> assertEquals("Write clients' email:", addEmailText),
                () -> assertEquals("New client", newClientTitle2),
                () -> assertEquals("Error occurred: [Empty last name]", errorMessage)
        );
    }

    @Test
    public void testDeleteClientSuccessScenario() {
        prepareDatabase();

        MockPrinter mockPrinter = new MockPrinter();
        Config.EXIT_AFTER_WINDOW_CHANGES = 6;
        Config.INPUT_READER = new MockReader(
                List.of("admin", "admin", "1", "2", "1", "Y", "3")
        );
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String clientsTitle = outputs.get(9);
        String chooseOptionText = outputs.get(24);
        String addClientOptionText = outputs.get(25);
        String deleteClientOptionText = outputs.get(26);
        String goBackOptionText = outputs.get(27);
        String deleteClientTitle = outputs.get(28);
        String chooseClientText = outputs.get(29);
        String chooseClientOptionText = outputs.get(30);
        String areYouSureTitle = outputs.get(31);
        String areYouSureText = outputs.get(32);
        String yesText = outputs.get(33);
        String noText = outputs.get(34);
        String clientsTitle2 = outputs.get(35);
        String clientsMessage = outputs.get(36);
        String numberOfClientsText = outputs.get(37);
        String clientsTableNameText = outputs.get(38);
        String clientTableCell00 = outputs.get(39);
        String clientTableCell01 = outputs.get(40);
        String clientTableCell02 = outputs.get(41);
        String clientTableCell03 = outputs.get(42);
        String clientTableCell04 = outputs.get(43);
        String clientTableCell05 = outputs.get(44);

        Assertions.assertAll(
                () -> assertEquals("Clients", clientsTitle),
                () -> assertEquals("Choose from the following options: ", chooseOptionText),
                () -> assertEquals("1) Add client", addClientOptionText),
                () -> assertEquals("2) Delete client", deleteClientOptionText),
                () -> assertEquals("3) Go back", goBackOptionText),
                () -> assertEquals("Delete client", deleteClientTitle),
                () -> assertEquals("Choose client to delete:", chooseClientText),
                () -> assertEquals("1) j.johnson@gmail.com", chooseClientOptionText),
                () -> assertEquals("Are you sure", areYouSureTitle),
                () -> assertEquals("Are you sure?", areYouSureText),
                () -> assertEquals("Yes", yesText),
                () -> assertEquals("No", noText),
                () -> assertEquals("Clients", clientsTitle2),
                () -> assertEquals("Success: Client was deleted", clientsMessage),
                () -> assertEquals("Number of clients that you have: 0", numberOfClientsText),
                () -> assertEquals("Clients information", clientsTableNameText),
                () -> assertEquals("First name", clientTableCell00),
                () -> assertEquals("Last name", clientTableCell01),
                () -> assertEquals("Email", clientTableCell02),
                () -> assertEquals("Organization", clientTableCell03),
                () -> assertEquals("Invoiced amount (EUR)", clientTableCell04),
                () -> assertEquals("Received amount (EUR)", clientTableCell05)
        );
    }

    @Test
    public void testDeleteClientAlternativeScenario() {
        prepareDatabase();

        MockPrinter mockPrinter = new MockPrinter();
        Config.EXIT_AFTER_WINDOW_CHANGES = 6;
        Config.INPUT_READER = new MockReader(
                List.of("admin", "admin", "1", "2", "1", "N", "3")
        );
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String clientsTitle = outputs.get(9);
        String chooseOptionText = outputs.get(24);
        String addClientOptionText = outputs.get(25);
        String deleteClientOptionText = outputs.get(26);
        String goBackOptionText = outputs.get(27);
        String deleteClientTitle = outputs.get(28);
        String chooseClientText = outputs.get(29);
        String chooseClientOptionText = outputs.get(30);
        String areYouSureTitle = outputs.get(31);
        String areYouSureText = outputs.get(32);
        String yesText = outputs.get(33);
        String noText = outputs.get(34);
        String clientsTitle2 = outputs.get(35);
        String clientsMessage = outputs.get(36);
        String numberOfClientsText = outputs.get(37);
        String clientsTableNameText = outputs.get(38);
        String clientTableCell00 = outputs.get(39);
        String clientTableCell01 = outputs.get(40);
        String clientTableCell02 = outputs.get(41);
        String clientTableCell03 = outputs.get(42);
        String clientTableCell04 = outputs.get(43);
        String clientTableCell05 = outputs.get(44);
        String clientTableCell06 = outputs.get(45);
        String clientTableCell07 = outputs.get(46);
        String clientTableCell08 = outputs.get(47);
        String clientTableCell09 = outputs.get(48);
        String clientTableCell10 = outputs.get(49);
        String clientTableCell11 = outputs.get(50);

        Assertions.assertAll(
                () -> assertEquals("Clients", clientsTitle),
                () -> assertEquals("Choose from the following options: ", chooseOptionText),
                () -> assertEquals("1) Add client", addClientOptionText),
                () -> assertEquals("2) Delete client", deleteClientOptionText),
                () -> assertEquals("3) Go back", goBackOptionText),
                () -> assertEquals("Delete client", deleteClientTitle),
                () -> assertEquals("Choose client to delete:", chooseClientText),
                () -> assertEquals("1) j.johnson@gmail.com", chooseClientOptionText),
                () -> assertEquals("Are you sure", areYouSureTitle),
                () -> assertEquals("Are you sure?", areYouSureText),
                () -> assertEquals("Yes", yesText),
                () -> assertEquals("No", noText),
                () -> assertEquals("Clients", clientsTitle2),
                () -> assertEquals("Success: Client was not deleted", clientsMessage),
                () -> assertEquals("Number of clients that you have: 1", numberOfClientsText),
                () -> assertEquals("Clients information", clientsTableNameText),
                () -> assertEquals("First name", clientTableCell00),
                () -> assertEquals("Last name", clientTableCell01),
                () -> assertEquals("Email", clientTableCell02),
                () -> assertEquals("Organization", clientTableCell03),
                () -> assertEquals("Invoiced amount (EUR)", clientTableCell04),
                () -> assertEquals("Received amount (EUR)", clientTableCell05),
                () -> assertEquals("John", clientTableCell06),
                () -> assertEquals("Johnson", clientTableCell07),
                () -> assertEquals("j.johnson@gmail.com", clientTableCell08),
                () -> assertEquals("Company", clientTableCell09),
                () -> assertEquals("5500", clientTableCell10),
                () -> assertEquals("4750", clientTableCell11)
        );
    }
}
