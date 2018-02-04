package fixtures;

import java.util.Map;

public class DiceOddsFixture {
    public static Map<Integer, Double> mapForTwoSided() {
        return Map.of(
            2, 1d / 4d,
            3, 2d / 4d,
            4, 1d / 4d
        );
    }

    public static Map<Integer, Double> mapForThreeSided() {
        return Map.of(
            2, 1d / 9d,
            3, 2d / 9d,
            4, 3d / 9d,
            5, 2d / 9d,
            6, 1d / 9d
        );
    }

    public static Map<Integer, String> mapForThreeSidedAsFractions() {
        return Map.of(
            2, "1 / 9",
            3, "2 / 9",
            4, "1 / 3",
            5, "2 / 9",
            6, "1 / 9"
        );
    }
}
