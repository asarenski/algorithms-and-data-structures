package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Child hop problem.
 * A child is running up a staircase of N steps.
 * The child can hop up the staircase at 1, 2, or 3 steps with each hop.
 * How many possible ways can the child reach the top?
 */
public class ChildHop {
    public int hopDP(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        List<Integer> hops = new ArrayList<>();
        hops.add(0, 1);
        hops.add(1, 1);
        hops.add(2, 2);

        for (int i=3; i<=n; i++) {
            int prevSum = hops.get(i-3) + hops.get(i-2) + hops.get(i-1);
            hops.add(i, prevSum);
        }

        return hops.get(n);
    }
}
