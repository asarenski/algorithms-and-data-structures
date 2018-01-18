package util;

public class MathUtil {
    public static int randomBetweenOneAndMax(int max) {
        return new Double(Math.ceil(Math.random() * max)).intValue();
    }
}
