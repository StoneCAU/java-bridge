package bridge.validator;

import bridge.exception.BridgeException;
import bridge.exception.ErrorMessage;

public class InputValidator {

    public static int validateBridgeSize(String input) {
        int size = parseNumber(input);

        if (!isValidSize(size)) {
            throw new BridgeException(ErrorMessage.INVALID_SIZE);
        }

        return size;
    }

    public static String validateUpAndDown(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new BridgeException(ErrorMessage.INVALID_INPUT);
        }
        return input;
    }

    public static String validateRetryAndQuit(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new BridgeException(ErrorMessage.INVALID_INPUT);
        }
        return input;
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BridgeException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    private static boolean isValidSize(int size) {
        return size >= 3 && size <= 20;
    }
}
