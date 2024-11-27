package bridge.domain;

import bridge.generator.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            if (number == 0) bridges.add("D");
            if (number == 1) bridges.add("U");
        }

        return bridges;
    }
}
