package recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public int fibDP(int n) {
        List<Integer> solutions = new ArrayList<>();
        solutions.add(0, 0);
        solutions.add(1, 1);
        solutions.add(2, 1);

        for (int i=3; i<=n; i++) {
            int sum = solutions.get(i-2) + solutions.get(i-1);
            solutions.add(i, sum);
        }

        return solutions.get(n);
    }
}
