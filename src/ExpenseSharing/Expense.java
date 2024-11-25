package ExpenseSharing;

import java.util.List;

public class Expense {
    private String payer;
    private double amount;
    private List<String> participants;
    private String splitType;
    private List<Double> splitValues;

    public Expense(String payer, double amount, List<String> participants, String splitType, List<Double> splitValues) {
        this.payer = payer;
        this.amount = amount;
        this.participants = participants;
        this.splitType = splitType;
        this.splitValues = splitValues;
    }

    public String getPayer() {
        return payer;
    }

    public double getAmount() {
        return amount;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public String getSplitType() {
        return splitType;
    }

    public List<Double> getSplitValues() {
        return splitValues;
    }

    public boolean validate() {
        if (splitType.equals("EQUAL")) {
            return true;
        } else if (splitType.equals("EXACT")) {
            double total = 0.0;
            for (double value : splitValues) {
                total += value;
            }
            return Math.abs(total - amount) < 0.01;
        } else if (splitType.equals("PERCENT")) {
            double total = 0.0;
            for (double value : splitValues) {
                total += value;
            }
            return Math.abs(total - 100) < 0.01;
        }
        return false;
    }
}
