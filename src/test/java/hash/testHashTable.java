package hash;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class testHashTable {

    @Test
    public void testGetAndPut() {
        HashTable table = new HashTable();
        table.put(128, 1222);
        table.put(512, 3);

        assertThat(table.get(128), equalTo(1222));
        assertThat(table.get(512), equalTo(3));
    }
}
