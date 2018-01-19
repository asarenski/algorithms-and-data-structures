package basicStructures;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class testArrayList {

    @Test
    public void testInsertAtSpecificIndex() throws Exception {
        final ArrayList list = new ArrayList(5);
        final int expectedIndex = 2;
        final int expectedInteger = 22;
        Assert.assertThat(list.putAtIndex(expectedIndex, expectedInteger), CoreMatchers.equalTo(expectedIndex));
        Assert.assertThat(list.get(2), CoreMatchers.equalTo(expectedInteger));
    }

    @Test
    public void testInsertBumpsLastValueUpOneIndex() throws Exception {
        final ArrayList list = new ArrayList(3);
        list.putAtIndex(0, 22);
        list.putAtIndex(1, 33);

        list.putAtIndex(1, 44);
        Assert.assertThat(list.get(0), CoreMatchers.equalTo(22));
        Assert.assertThat(list.get(1), CoreMatchers.equalTo(44));
        Assert.assertThat(list.get(2), CoreMatchers.equalTo(33));
    }

    @Test
    public void testInsertIncreasesMaxSizeIfExceeded() throws Exception {
        final int initialMaxSize = 3;
        final ArrayList list = new ArrayList(initialMaxSize);
        list.putAtIndex(0, 22);
        list.putAtIndex(1, 33);
        list.putAtIndex(1, 44);
        list.putAtIndex(1, 55);

        Assert.assertThat(list.get(0), CoreMatchers.equalTo(22));
        Assert.assertThat(list.get(1), CoreMatchers.equalTo(55));
        Assert.assertThat(list.get(2), CoreMatchers.equalTo(44));
        Assert.assertThat(list.get(3), CoreMatchers.equalTo(33));
        Assert.assertThat(list.getMaxSize(), CoreMatchers.equalTo(initialMaxSize + 1));
    }

    @Test
    public void testCanInsertAtAnyIndex() throws Exception {
        final ArrayList list = new ArrayList(1);
        final int expectedIndex = 299;
        list.putAtIndex(expectedIndex, 22);
        Assert.assertThat(list.getIndexOfLast(), CoreMatchers.equalTo(expectedIndex));
        Assert.assertThat(list.getMaxSize(), CoreMatchers.equalTo(expectedIndex + 1));
    }

    @Test
    public void testGetIndexOfLastItemNegativeOneIfEmpty() throws Exception {
        final ArrayList list = new ArrayList(5);
        Assert.assertThat(list.getIndexOfLast(), CoreMatchers.equalTo(-1));
    }

    @Test
    public void testGetIndexOfLastItemReturnsIndexOfLastItem() throws Exception {
        final ArrayList list1 = new ArrayList(3);
        list1.putAtIndex(0, 1);
        list1.putAtIndex(1, 4);
        list1.putAtIndex(2, 5);
        testReturnCommon(list1, 2);

        final ArrayList list2 = new ArrayList(3);
        list2.putAtIndex(0, 22);
        list2.putAtIndex(1, 33);
        testReturnCommon(list2, 1);
    }

    private void testReturnCommon(ArrayList list, int expectedIndex) {
        Assert.assertThat(list.getIndexOfLast(), CoreMatchers.equalTo(expectedIndex));
    }

    @Test(expected=Exception.class)
    public void testGetIndexOfLastItemThrowsIfAccessingNegativeIndexes() throws Exception {
        final int maxSize = 5;
        final ArrayList list = new ArrayList(maxSize);
        list.putAtIndex(-1, 22);
    }

    @Test
    public void testToString() throws Exception {
        final int initialMaxSize = 3;
        final ArrayList list = new ArrayList(initialMaxSize);
        list.putAtIndex(0, 22);
        list.putAtIndex(1, 33);
        list.putAtIndex(1, 44);
        list.putAtIndex(1, 55);
        Assert.assertThat(list.toString(), CoreMatchers.equalTo("array=[22, 55, 44, 33]"));
    }
}
