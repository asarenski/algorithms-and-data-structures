package fixtures;

import com.google.common.collect.Lists;
import dice.Tuple;

import java.util.List;

public class DicePairGraphFixture {
    public static List<Tuple> combinationsFor2() {
        return Lists.newArrayList(
                new Tuple<>(1, 1)
        );
    }

    public static List<Tuple> combinationsFor3() {
        return Lists.newArrayList(
                new Tuple<>(1, 2),
                new Tuple<>(2, 1)
        );
    }

    public static List<Tuple> combinationsFor4() {
        return Lists.newArrayList(
                new Tuple<>(1, 3),
                new Tuple<>(2, 2),
                new Tuple<>(3, 1)
        );
    }

    public static List<Tuple> combinationsFor7() {
        return Lists.newArrayList(
                new Tuple<>(1, 6),
                new Tuple<>(2, 5),
                new Tuple<>(3, 4),
                new Tuple<>(4, 3),
                new Tuple<>(5, 2),
                new Tuple<>(6, 1)
        );
    }
}
