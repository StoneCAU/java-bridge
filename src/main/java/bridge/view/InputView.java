package bridge.view;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NEW_LINE = System.lineSeparator();

    public int readBridgeSize() {
        printNewLine();
        System.out.println("다리의 길이를 입력해주세요.");

        String input = input();
        return InputValidator.validateBridgeSize(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String input() {
        return Console.readLine();
    }

    private void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
