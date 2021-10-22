package main.client.mocks;

import main.client.interfaces.IOutputPrinter;

import java.util.ArrayList;
import java.util.List;

public class MockLoginPrinter implements IOutputPrinter {
    private final List<String> outputs = new ArrayList<>();
    @Override
    public void printTitle(String title) {
        if (!title.equals("")) {
            outputs.add(title);
        }
    }

    @Override
    public void printText(String text) {
        if (!text.equals("")) {
            outputs.add(text);
        }
    }

    @Override
    public void printMessage(String message) {
        if (!message.equals("")){
            outputs.add(message);
        }
    }

    public List<String> getOutputs() {
        return outputs;
    }
}
