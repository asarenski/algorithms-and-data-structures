package dice;

import Fixtures.DiceOddsFixture;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class testDicePairOdds {
    @Test
    public void testGenerateBaseOddsFor6Sided() throws Exception {
        DicePairGraph graph = new DicePairGraph(new DicePair(6));
        DicePairOdds dicePairOdds = new DicePairOdds(graph);
        BigDecimal diceDecimal = new BigDecimal(dicePairOdds.calculateBaseOdds());
        BigDecimal expectedDecimal = new BigDecimal(1d / (6d * 6d));
        Assert.assertThat(diceDecimal, CoreMatchers.equalTo(expectedDecimal));
    }

    @Test
    public void testGenerateOddsMap() throws Exception {
        DicePairGraph graphTwoSided = new DicePairGraph(new DicePair(2));
        DicePairOdds twoSidedOdds = new DicePairOdds(graphTwoSided);
        Assert.assertThat(twoSidedOdds.generateOddsMap(), CoreMatchers.equalTo(DiceOddsFixture.mapForTwoSided()));

        DicePairGraph graphThreeSided = new DicePairGraph(new DicePair(3));
        DicePairOdds threeSidedOdds = new DicePairOdds(graphThreeSided);
        Assert.assertThat(threeSidedOdds.generateOddsMap(), CoreMatchers.equalTo(DiceOddsFixture.mapForThreeSided()));
    }
}
