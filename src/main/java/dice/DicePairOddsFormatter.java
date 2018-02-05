package dice;

public class DicePairOddsFormatter {
    private DicePairOdds dicePairOdds;

    public DicePairOddsFormatter(DicePairOdds dicePairOdds) {
        this.dicePairOdds = dicePairOdds;
    }

    public String printFormattedOdds() {
        StringBuilder builder = new StringBuilder();
        builder.append("Odds for: " + dicePairOdds.getDice().getSidesPerDie() + " sided dice");
        dicePairOdds.generateDicePairOddsWithFractions().entrySet().stream()
                .forEach(entry -> builder.append("\n" + entry.getKey() + ": " + entry.getValue()));
        return builder.toString();
    }
}
