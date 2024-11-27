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

    public String readMoving() {
        printNewLine();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        return InputValidator.validateUpAndDown(input());
    }

    public String readGameCommand() {
        printNewLine();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        return InputValidator.validateRetryAndQuit(input());
    }

    private String input() {
        return Console.readLine();
    }

    private void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
