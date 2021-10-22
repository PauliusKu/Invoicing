import main.client.Client;
import main.client.mocks.MockLoginPrinter;
import main.client.mocks.MockLoginReader;
import main.controller.access.LoginController;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Login {
    @Test
    public void testLoginSuccessScenario() {
        //when
        MockLoginPrinter mockLoginPrinter = new MockLoginPrinter();
        MockLoginReader mockLoginReader = new MockLoginReader("admin", "admin");
        Client.run(mockLoginReader, mockLoginPrinter);
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

}