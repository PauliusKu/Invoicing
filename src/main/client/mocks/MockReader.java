package main.client.mocks;

import main.client.interfaces.IInputReader;

import java.util.List;

public class MockReader implements IInputReader {
    private int inputNr = 0;
    private final List<String> inputs;

    public MockReader(List<String> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String readString() {
        try {
            String input = this.inputs.get(inputNr);
            inputNr++;
            return input;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough inputs were given");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
