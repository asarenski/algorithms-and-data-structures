package binarySearch;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class testBinarySearch {
    final private List<Integer> testList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    @Test
    public void isIncludedInListTrue() throws Exception {
        testList.forEach((integer) -> {
            Assert.assertThat(BinarySearch.isIncludedInList(integer, testList), CoreMatchers.equalTo(true));
        });
    }

    @Test
    public void isIncludedInListFalse() throws Exception {
        final List<Integer> falseTestList = testList.stream().map((integer) -> integer * 100).collect(Collectors.toList());
        falseTestList.forEach((integer) -> {
            Assert.assertThat(BinarySearch.isIncludedInList(integer, testList), CoreMatchers.equalTo(false));
        });
    }
}
