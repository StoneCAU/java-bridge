package bridge.exception;

public enum ErrorMessage {
    IS_NOT_NUMBER("다리 길이는 숫자만 입력가능합니다."),
    INVALID_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_INPUT("올바른 값을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
