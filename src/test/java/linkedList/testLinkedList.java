package linkedList;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class testLinkedList {

    @Test
    public void testAdd() {
        LinkedList list = new LinkedList();
        list.add(15);
        list.add(14);
        list.add(13);

        Node nextval;
        nextval = list.getFirst();
        Assert.assertThat(nextval.getValue(), CoreMatchers.equalTo(13));

        nextval = nextval.getNextVal();
        Assert.assertThat(nextval.getValue(), CoreMatchers.equalTo(14));

        nextval = nextval.getNextVal();
        Assert.assertThat(nextval.getValue(), CoreMatchers.equalTo(15));

        nextval = nextval.getNextVal();
        Assert.assertThat(nextval, CoreMatchers.nullValue());
    }
}
