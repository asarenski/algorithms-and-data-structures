package savingsExperiment;

public class Experiment {
    public void run(int n) {
        SavingsAndSalary savingsAndSalary = new SavingsAndSalary(3500, 100000);
        Expenses expenses = new Expenses(savingsAndSalary);
    }
}
