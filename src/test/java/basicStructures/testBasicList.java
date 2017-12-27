package basicStructures;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class testBasicList {

    @Test
    public void testInsertAtSpecificIndex() throws Exception {
        final BasicList list = new BasicList(5);
        final int expectedIndex = 2;
        final int expectedInteger = 22;
        Assert.assertThat(list.insert(expectedIndex, expectedInteger), CoreMatchers.equalTo(expectedIndex));
        Assert.assertThat(list.get(2), CoreMatchers.equalTo(expectedInteger));
    }

    @Test
    public void testInsertBumpsLastValue() throws Exception {
        final BasicList list = new BasicList(3);
        list.insert(0, 22);
        list.insert(1, 33);

        list.insert(1, 44);
        Assert.assertThat(list.get(0), CoreMatchers.equalTo(22));
        Assert.assertThat(list.get(1), CoreMatchers.equalTo(44));
        Assert.assertThat(list.get(2), CoreMatchers.equalTo(33));
    }

    @Test
    public void testInsertBumpsLastValueOutOfList() throws Exception {
        final BasicList list = new BasicList(3);
        list.insert(0, 22);
        list.insert(1, 33);

        list.insert(1, 44);
        list.insert(1, 55);
        Assert.assertThat(list.get(0), CoreMatchers.equalTo(22));
        Assert.assertThat(list.get(1), CoreMatchers.equalTo(55));
        Assert.assertThat(list.get(2), CoreMatchers.equalTo(44));
    }

    @Test
    public void testGetIndexOfLastItemNegativeOneIfEmpty() throws Exception {
        final BasicList list = new BasicList(5);
        Assert.assertThat(list.getIndexOfLastItem(), CoreMatchers.equalTo(-1));
    }

    @Test
    public void testGetIndexOfLastItemReturnsLastItem() throws Exception {
        final BasicList list1 = new BasicList(3);
        list1.insert(0, 1);
        list1.insert(1, 4);
        list1.insert(2, 5);
        testReturnCommon(list1, 2);

        final BasicList list2 = new BasicList(3);
        list2.insert(0, 22);
        list2.insert(1, 33);
        testReturnCommon(list2, 1);
    }

    private void testReturnCommon(BasicList list, int expectedIndex) {
        Assert.assertThat(list.getIndexOfLastItem(), CoreMatchers.equalTo(expectedIndex));
    }

    @Test(expected=Exception.class)
    public void testGetIndexOfLastItemThrowsIfIndexGreaterThanMaxSize() throws Exception {
        final int maxSize = 5;
        final BasicList list = new BasicList(maxSize);
        list.insert(maxSize + 1, 22);
    }

    @Test(expected=Exception.class)
    public void testGetIndexOfLastItemThrowsIfAccessingNegativeIndexes() throws Exception {
        final int maxSize = 5;
        final BasicList list = new BasicList(maxSize);
        list.insert(-1, 22);
    }
}
