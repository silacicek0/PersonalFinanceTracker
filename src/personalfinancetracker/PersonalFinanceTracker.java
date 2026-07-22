 
package personalfinancetracker;
import java.util.Scanner;

public class PersonalFinanceTracker {
 
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== PERSONAL FINANCE TRACKER =====");
        System.out.print("Enter your initial balance: ");
        double initialBalance = scanner.nextDouble();
        if(initialBalance < 0){
            System.out.println("Balance cannot be negative.");
            return;
        }
        scanner.nextLine();

        FinanceTracker tracker = new FinanceTracker(initialBalance);

        boolean running = true;

        while (running) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Transaction");
            System.out.println("2. Delete Transaction");
            System.out.println("3. Show All Transactions");
            System.out.println("4. Show Current Balance");
            System.out.println("5. Generate Report");
            System.out.println("6. Add Category");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Transaction Type:");
                    System.out.println("1. Income");
                    System.out.println("2. Expense");
                    System.out.print("Choose: ");
                    
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    TransactionType type;
                    
                    if (typeChoice == 1) {
                        type = TransactionType.INCOME;
                    } else if (typeChoice == 2) {
                        type = TransactionType.EXPENSE;
                    } else {
                        System.out.println("Invalid transaction type!");
                        break;
                    }
                    
                    tracker.showCategories();

                    System.out.println();
                    System.out.print("Choose category (1-" + tracker.getCategories().size() + "): ");
                    
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(categoryChoice < 1 || categoryChoice > tracker.getCategories().size()){
                        System.out.println("Invalid category.");
                        break;
                    }
                    
                    String category = tracker.getCategories().get(categoryChoice - 1);
                    
                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    Transaction transaction =
                            new Transaction(amount,
                                    type,
                                    category,
                                    description);

                    tracker.addTransaction(transaction);

                    System.out.println("Transaction added successfully.");
                    break;

                case 2:

                    tracker.showAllTransactions();

                    System.out.print("Enter transaction number to delete: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    tracker.deleteTransaction(index - 1);

                    break;

                case 3:

                    tracker.showAllTransactions();
                    break;

                case 4:

                    System.out.printf("Current Balance: %.2f TL%n",
                            tracker.calculateBalance());

                    break;

                case 5:

                    tracker.generateReport();
                    break;

                case 6:
                    
                    tracker.showCategories();

                    System.out.print("New Category: ");
                    String newCategory = scanner.nextLine();

                    tracker.addCategory(newCategory);

                    break;

                case 7:

                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        }

        scanner.close();

    

        
    }
    
}
