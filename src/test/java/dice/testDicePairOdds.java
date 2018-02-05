package dice;

import fixtures.DiceOddsFixture;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class testDicePairOdds {
    @Test
    public void testGenerateBaseOddsFor6Sided() throws Exception {
        DicePairCombinationsGraph graph = new DicePairCombinationsGraph(new DicePair(6));
        DicePairOdds dicePairOdds = new DicePairOdds(graph);
        BigDecimal diceDecimal = new BigDecimal(dicePairOdds.calculateBaseOdds());
        BigDecimal expectedDecimal = new BigDecimal(1d / (6d * 6d));
        Assert.assertThat(diceDecimal, CoreMatchers.equalTo(expectedDecimal));
    }

    @Test
    public void testOddsMap() throws Exception {
        DicePair twoSidedDice = new DicePair(2);
        DicePairCombinationsGraph graphTwoSided = new DicePairCombinationsGraph(twoSidedDice);
        DicePairOdds twoSidedOdds = new DicePairOdds(graphTwoSided);
        Assert.assertThat(twoSidedOdds.generateDicePairOdds(), CoreMatchers.equalTo(DiceOddsFixture.mapForTwoSided()));

        DicePair threeSidedDice = new DicePair(3);
        DicePairCombinationsGraph graphThreeSided = new DicePairCombinationsGraph(threeSidedDice);
        DicePairOdds threeSidedOdds = new DicePairOdds(graphThreeSided);
        Assert.assertThat(threeSidedOdds.generateDicePairOdds(), CoreMatchers.equalTo(DiceOddsFixture.mapForThreeSided()));
    }

    @Test
    public void testOddsMapAsFractions() throws Exception {
        DicePair threeSidedDice = new DicePair(3);
        DicePairCombinationsGraph graphThreeSided = new DicePairCombinationsGraph(threeSidedDice);
        DicePairOdds threeSidedOdds = new DicePairOdds(graphThreeSided);
        Assert.assertThat(threeSidedOdds.generateDicePairOddsWithFractions(), CoreMatchers.equalTo(DiceOddsFixture.mapForThreeSidedAsFractions()));
    }
}
