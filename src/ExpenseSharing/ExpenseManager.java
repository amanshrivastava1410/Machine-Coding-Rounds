package ExpenseSharing;

import java.util.*;

public class ExpenseManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    public void addUser(String userId, String name, String email, String mobileNumber) {
        User user = new User(userId, name, email, mobileNumber);
        users.put(userId, user);
        balances.put(userId, new HashMap<>());
    }

    public void addExpense(Expense expense) {
        if (!expense.validate()) {
            System.out.println("Invalid expense split");
            return;
        }

        String payer = expense.getPayer();
        List<String> participants = expense.getParticipants();

        for (String participant : participants) {
            if (!users.containsKey(participant)) {
                System.out.println("Invalid user in participants: " + participant);
                return;
            }
        }

        double amount = expense.getAmount();
        List<Double> splitValues = expense.getSplitValues();

        if (expense.getSplitType().equals("EQUAL")) {
            double share = Math.round((amount / participants.size()) * 100.0) / 100.0;
            for (String participant : participants) {
                if (!participant.equals(payer)) {
                    updateBalances(payer, participant, share);
                }
            }
        } else if (expense.getSplitType().equals("EXACT")) {
            for (int i = 0; i < participants.size(); i++) {
                if (!participants.get(i).equals(payer)) {
                    updateBalances(payer, participants.get(i), splitValues.get(i));
                }
            }
        } else if (expense.getSplitType().equals("PERCENT")) {
            for (int i = 0; i < participants.size(); i++) {
                if (!participants.get(i).equals(payer)) {
                    double share = Math.round((amount * splitValues.get(i) / 100) * 100.0) / 100.0;
                    updateBalances(payer, participants.get(i), share);
                }
            }
        }
    }

    private void updateBalances(String payer, String participant, double amount) {
        balances.get(payer).put(participant, balances.get(payer).getOrDefault(participant, 0.0) + amount);
        balances.get(participant).put(payer, balances.get(participant).getOrDefault(payer, 0.0) - amount);
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (String userId : balances.keySet()) {
            Map<String, Double> userBalances = balances.get(userId);
            for (Map.Entry<String, Double> entry : userBalances.entrySet()) {
                if (entry.getValue() != 0) {
                    isEmpty = false;
                    printBalance(userId, entry.getKey(), entry.getValue());
                }
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showUserBalances(String userId) {
        if (!users.containsKey(userId)) {
            System.out.println("User not found: " + userId);
            return;
        }

        boolean isEmpty = true;
        Map<String, Double> userBalances = balances.get(userId);
        for (Map.Entry<String, Double> entry : userBalances.entrySet()) {
            if (entry.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, entry.getKey(), entry.getValue());
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String userId1, String userId2, double amount) {
        if (amount > 0) {
            System.out.printf("%s owes %s: %.2f%n", userId2, userId1, amount);
        } else {
            System.out.printf("%s owes %s: %.2f%n", userId1, userId2, -amount);
        }
    }
}
