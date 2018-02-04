package util;

public class MathUtil {
    public static int randomBetweenOneAndMax(int max) {
        return Double.valueOf(Math.ceil(Math.random() * max)).intValue();
    }
}
