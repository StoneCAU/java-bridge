package bridge.view;

import bridge.domain.BridgeGame;
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

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getUpLine(), bridgeGame.getDownLine());
        printNewLine();
        printSuccessOrFail(bridgeGame);
        printTotalTrial(bridgeGame);
    }

    public void printErrorMessage(String message) {
        printNewLine();
        System.out.println(message);
    }

    private void printTotalTrial(BridgeGame bridgeGame) {
        System.out.printf("총 시도한 횟수: %d%n", bridgeGame.getTrialCount());
    }

    private void printSuccessOrFail(BridgeGame bridgeGame) {
        if (bridgeGame.getUpLine().contains("X") || bridgeGame.getDownLine().contains("X")) {
            System.out.println("게임 성공 여부: 실패");
            return;
        }
        System.out.println("게임 성공 여부: 성공");
    }

    private String makeLineString(List<String> lines) {
        return "[ " + String.join(" | ", lines) + " ]";
    }

    private void printNewLine() {
        System.out.printf(NEW_LINE);
    }
}
