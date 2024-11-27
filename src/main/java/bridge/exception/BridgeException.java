package bridge.exception;

public class BridgeException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public BridgeException(ErrorMessage errorMessage) {
        super(PREFIX + errorMessage.getMessage());
    }
}
