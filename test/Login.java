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

class Login {
    private void prepareDatabase(){
        IPrepareDB prepareDB = new Users();
        prepareDB.clear();
        prepareDB.prepare(List.of("admin", "admin"));
    }

    @Test
    public void testLoginSuccessScenario() {
        prepareDatabase();
        //when
        MockPrinter mockPrinter = new MockPrinter();
        Config.INPUT_READER = new MockReader(List.of("admin", "admin"));
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String loginWindowName = outputs.get(0);
        String loginMessage = outputs.get(1);
        String inputEmailText = outputs.get(2);
        String inputPasswordText = outputs.get(3);
        String mainMenuTitle = outputs.get(4);
        String mainMenuMessage = outputs.get(5);
        //then
        Assertions.assertAll(
                () -> assertEquals("Sign in", loginWindowName),
                () -> assertEquals("Welcome to Invoicing!", loginMessage),
                () -> assertEquals("Write your email:", inputEmailText),
                () -> assertEquals("Write your password:", inputPasswordText),
                () -> assertEquals("Main menu", mainMenuTitle),
                () -> assertEquals("Success: you are logged in", mainMenuMessage)
        );

    }

    @Test
    public void testLoginErrorScenario() {
        prepareDatabase();
        MockPrinter mockPrinter = new MockPrinter();
        Config.INPUT_READER = new MockReader(List.of("admin", "not_admin"));
        Config.OUTPUT_PRINTER = mockPrinter;
        Client.run();
        List<String> outputs = mockPrinter.getOutputs();
        String loginWindowName = outputs.get(0);
        String loginMessage = outputs.get(1);
        String inputEmailText = outputs.get(2);
        String inputPasswordText = outputs.get(3);
        String mainMenuTitle = outputs.get(4);
        String mainMenuMessage = outputs.get(5);
        //then
        Assertions.assertAll(
                () -> assertEquals("Sign in", loginWindowName),
                () -> assertEquals("Welcome to Invoicing!", loginMessage),
                () -> assertEquals("Write your email:", inputEmailText),
                () -> assertEquals("Write your password:", inputPasswordText),
                () -> assertEquals("Sign in", mainMenuTitle),
                () -> assertEquals("Error occurred: [Wrong email or password]", mainMenuMessage)
        );
    }

}