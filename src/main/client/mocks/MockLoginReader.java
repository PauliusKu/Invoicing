package main.client.mocks;

import main.client.interfaces.IInputReader;

public class MockLoginReader implements IInputReader {
    private int stringNr = 0;
    public String email;
    public String password;

    public MockLoginReader(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String readString() {
        if (stringNr == 0) {
            stringNr++;
            return email;
        }
        else {
            return password;
        }
    }
}
