 
package personalfinancetracker;
import java.util.ArrayList;

public class FinanceTracker {
    private double initialBalance;
    private ArrayList<Transaction> transactions;
    private ArrayList<String> categories;
    
    public FinanceTracker(double initialBalance){
        this.initialBalance = initialBalance;
        this.transactions = new ArrayList<>();
        this.categories = new ArrayList<>();
        categories.add("Food");
        categories.add("Shopping");
        categories.add("Health");
        categories.add("Transport");
        categories.add("Education");
        categories.add("Entertainment");
       
    }
    public ArrayList<String> getCategories() {
        return categories;
    }
    
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    
    public void deleteTransaction(int index){
        if(index >= 0 && index < transactions.size()){
            transactions.remove(index);
            System.out.println("Transaction deleted.");
        }else{
            System.out.println("Invalid transaction number.");
        }
    }
    
    public void showAllTransactions(){
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for(int i=0;i<transactions.size();i++){
            System.out.println("------------------------");
            System.out.println((i + 1) + ". " + transactions.get(i));
            System.out.println("------------------------");
        }
    }
    
    public double calculateBalance(){
        double balance = initialBalance;
        for (Transaction t : transactions) {
            if(t.getType()== TransactionType.INCOME){
                balance += t.getAmount();
                 
            }if (t.getType() == TransactionType.EXPENSE) {
                balance -= t.getAmount();
            }
        }
         return balance;
    }
    
    public void generateReport(){
        System.out.println();
        System.out.println("==========================================");
        System.out.println("      PERSONAL FINANCE REPORT");
        System.out.println("==========================================");
        System.out.printf("Initial Balance : %.2f TL%n", initialBalance);
        System.out.printf("Current Balance : %.2f TL%n", calculateBalance());
        
        System.out.printf("Total Income    : %.2f TL%n", getTotalIncome());
        System.out.printf("Total Expense   : %.2f TL%n", getTotalExpense());
        
        System.out.println();
        System.out.printf("Number of Transactions : %d%n", transactions.size());
        System.out.println();
        
        System.out.println("===== Expenses By Category =====");
        
        for (String category : categories) {
            System.out.printf("%-15s : %.2f TL%n",
                    category,
                    getCategoryExpense(category));
        }

        System.out.println("=============================================");

        
    }
    
    public void addCategory(String category){
        category = category.trim();
        
        if(category.isEmpty()){
            System.out.println("Category cannot be empty.");
            return;
        }
        
        if (categoryExists(category)) {
        System.out.println("This category already exists.");
        } else {
        categories.add(category);
        System.out.println("Category added successfully.");
        }
    }
    
    public boolean categoryExists(String category){
        for (String currentCategory  : categories){
             if (currentCategory.equalsIgnoreCase(category)) {
            return true;
            }
        }
        return false;
    }
    
    public double getTotalIncome(){
       
        double totalIncome = 0;

        for (Transaction t : transactions) {

            if (t.getType() == TransactionType.INCOME) {
               totalIncome += t.getAmount();
            }

        }return totalIncome;
    }
    
    public double getTotalExpense(){
        
        double totalExpense = 0;

        for (Transaction t : transactions) {

            if (t.getType() == TransactionType.EXPENSE) {
               totalExpense += t.getAmount();
            }

        }return totalExpense;
    }
    
    public double getCategoryExpense(String category){
        double total = 0;

        for (Transaction t : transactions) {

            if (t.getType() == TransactionType.EXPENSE &&
                t.getCategory().equalsIgnoreCase(category)) {

                total += t.getAmount();

            }

        }
        return total;
        
    }
    
    public void showCategories(){
        System.out.println("===== Categories =====");
        
        for (int i = 0; i < categories.size(); i++) {
        System.out.println((i + 1) + ". " + categories.get(i));
        }
        
        System.out.println("======================");
    }
    
    
    
}
