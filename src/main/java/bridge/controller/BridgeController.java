package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.exception.BridgeException;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        gameStart();
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

    private void gameStart() {
        int bridgeSize = getBridgeSize();
        List<String> bridges = makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridges);
        gamePlay(bridgeGame);
    }

    private List<String> makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }

    private void gamePlay(BridgeGame bridgeGame) {
        while (!bridgeGame.isRoundOver()) {
            String direction = getDirection();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getUpLine(), bridgeGame.getDownLine());
            if (bridgeGame.isFailure(direction)) {
                bridgeGame = proceedCommand(bridgeGame);
            }
        }
        outputView.printResult(bridgeGame);
    }

    private String getDirection() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (BridgeException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BridgeGame proceedCommand(BridgeGame bridgeGame) {
        String command = getRetryOrQuit();
        if (command.equals("R")) {
            bridgeGame.retry();
            return bridgeGame;
        }
        bridgeGame.quit();
        return bridgeGame;
    }

    private String getRetryOrQuit() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (BridgeException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
