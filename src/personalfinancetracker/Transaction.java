 
package personalfinancetracker;
import java.time.LocalDate;
public class Transaction {
    private double amount;
    private TransactionType type; 
    private LocalDate date;
    private String category;  
    private String description;
    
    public Transaction(double amount, TransactionType type, String category, String description){
        if(amount <= 0){
           throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = LocalDate.now();
        
    }
    
    //getters
    public double getAmount(){
        return this.amount;
    }
    
    public TransactionType getType(){
        return this.type;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public String getCategory(){
        return this.category;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    //setters
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "\nAmount      : "+this.amount+"TL"+
               "\nType        : "+this.type+
               "\nCategory    : "+this.category+
               "\nDescription : "+this.description+
               "\nDate        : "+this.date;
    }
    
    
    
    
    
    
    
}
