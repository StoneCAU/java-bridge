package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final static String UP = "U";
    private final static String DOWN = "D";
    private final static String BLANK = " ";
    private final static String SUCCESS = "O";
    private final static String FAIL = "X";

    private List<String> bridges;
    private List<String> upLine = new ArrayList<>();
    private List<String> downLine = new ArrayList<>();
    private int round;

    public BridgeGame(List<String> bridges) {
        this.bridges = bridges;
        this.round = 0;
    }

    public List<String> getUpLine() {
        return upLine;
    }

    public List<String> getDownLine() {
        return downLine;
    }

    public int getRound() {
        return round;
    }

    public void move(String direction) {
        if (isSuccess(direction)) {
            addToSuccessLine(direction);
            round++;
            return;
        }
        addToFailLine(direction);
        round++;
    }

    public void retry() {
        upLine.clear();
        downLine.clear();
        round = 0;
    }

    public void quit() {
        round = bridges.size();
    }

    public boolean isRoundOver() {
        return round == bridges.size();
    }

    public boolean isFailure(String direction) {
        return upLine.contains(FAIL) || downLine.contains(FAIL);
    }

    private boolean isSuccess(String direction) {
        return bridges.get(round).equals(direction);
    }

    private void addToSuccessLine(String direction) {
        if (direction.equals(UP)) {
            upLine.add(SUCCESS);
            downLine.add(BLANK);
        }
        if (direction.equals(DOWN)) {
            downLine.add(SUCCESS);
            upLine.add(BLANK);
        }
    }

    private void addToFailLine(String direction) {
        if (direction.equals(UP)) {
            upLine.add(FAIL);
            downLine.add(BLANK);
        }
        if (direction.equals(DOWN)) {
            downLine.add(FAIL);
            upLine.add(BLANK);
        }
    }
}
