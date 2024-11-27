package bridge.view;

import java.util.List;

public class OutputView {
    private final static String NEW_LINE = System.lineSeparator();

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(List<String> upLine, List<String> downLine) {
        System.out.println(makeLineString(upLine));
        System.out.println(makeLineString(downLine));
    }

    public void printResult() {
    }

    public void printErrorMessage(String message) {
        printNewLine();
        System.out.println(message);
    }

    private String makeLineString(List<String> lines) {
        return "[ " + String.join(" | ", lines) + " ]";
    }

    private void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
