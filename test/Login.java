import main.client.Client;
import main.client.Config;
import main.client.mocks.MockLoginPrinter;
import main.client.mocks.MockLoginReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Login {
    @Test
    public void testLoginSuccessScenario() {
        //when
        MockLoginPrinter mockLoginPrinter = new MockLoginPrinter();
        Config.INPUT_READER = new MockLoginReader("admin", "admin");
        Config.OUTPUT_PRINTER = mockLoginPrinter;
        Client.run();
        List<String> outputs = mockLoginPrinter.getOutputs();
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
        MockLoginPrinter mockLoginPrinter = new MockLoginPrinter();
        Config.INPUT_READER = new MockLoginReader("admin", "not_admin");
        Config.OUTPUT_PRINTER = mockLoginPrinter;
        Client.run();
        List<String> outputs = mockLoginPrinter.getOutputs();
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
                () -> assertEquals("Error: [Wrong email or password]", mainMenuMessage)
        );
    }

}