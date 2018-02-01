package dice;

import org.junit.Test;

public class testDicePairGraph {
    @Test
    public void testDicePairGraph() throws Exception {
        DicePairGraph dicePairGraph = new DicePairGraph(new DicePair(6));
        System.out.println(dicePairGraph);
    }
}
