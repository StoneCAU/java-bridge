package bridge.controller;

import bridge.exception.BridgeException;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        int bridgeSize = getBridgeSize();

    }

    private int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (BridgeException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
