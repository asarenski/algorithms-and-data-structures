package Fixtures;

import java.util.HashMap;
import java.util.Map;

public class DiceOddsFixture {
    public static Map<Integer, Double> mapForTwoSided() {
        Map<Integer, Double> map = new HashMap<>();
        map.put(2, 1d / 4d);
        map.put(3, 2d / 4d);
        map.put(4, 1d / 4d);
        return map;
    }

    public static Map<Integer, Double> mapForThreeSided() {
        Map<Integer, Double> map = new HashMap<>();
        map.put(2, 1d / 9d);
        map.put(3, 2d / 9d);
        map.put(4, 3d / 9d);
        map.put(5, 2d / 9d);
        map.put(6, 1d / 9d);
        return map;
    }
}
