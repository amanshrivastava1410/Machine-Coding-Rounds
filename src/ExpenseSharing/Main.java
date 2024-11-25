package ExpenseSharing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        manager.addUser("u1", "Ronnie", "ronnie@example.com", "1234567890");
        manager.addUser("u2", "Leo", "leo@example.com", "0987654321");
        manager.addUser("u3", "Charles", "charles@example.com", "1122334455");
        manager.addUser("u4", "David", "david@example.com", "2233445566");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter commands (SHOW, EXPENSE, EXIT):");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("EXIT")) {
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens[0].equalsIgnoreCase("SHOW")) {
                if (tokens.length == 1) {
                    manager.showBalances();
                } else {
                    manager.showUserBalances(tokens[1]);
                }
            } else if (tokens[0].equalsIgnoreCase("EXPENSE")) {
                String payer = tokens[1];
                double amount = Double.parseDouble(tokens[2]);
                int numUsers = Integer.parseInt(tokens[3]);
                List<String> participants = Arrays.asList(tokens).subList(4, 4 + numUsers);
                String splitType = tokens[4 + numUsers];
                List<Double> splitValues = new ArrayList<>();
                for (int i = 5 + numUsers; i < tokens.length; i++) {
                    splitValues.add(Double.parseDouble(tokens[i]));
                }
                Expense expense = new Expense(payer, amount, participants, splitType, splitValues);
                manager.addExpense(expense);
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
        scanner.close();
    }
}
