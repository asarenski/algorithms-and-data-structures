package binarySearch;

import java.util.List;

public class BinarySearch {
    public static Boolean isIncludedInList(Integer desiredNum, List<Integer> list) {
        Integer low = 0;
        Integer high = list.size() - 1;

        while (high >= low) {
            final Integer mid = (high + low) / 2;
            if (list.get(mid).equals(desiredNum)) {
                return true;
            } else if (list.get(mid) > desiredNum) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
