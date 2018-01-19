package savingsExperiment;

public class Expenses {
    private static final double factorOfExpenses = 0.80;
    private double annualExpenses;
    private double expensePerDay;

    public Expenses(SavingsAndSalary savingsAndSalary) {
        this.annualExpenses = savingsAndSalary.getAnnualSalary() * factorOfExpenses;
        this.expensePerDay = annualExpenses / 365;
    }

    public double getAnnualExpenses() {
        return annualExpenses;
    }

    public double getExpensePerDay() {
        return expensePerDay;
    }
}
