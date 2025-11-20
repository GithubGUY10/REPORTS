import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Serializable;

/**
 * Represents a single financial record within a user's budget
 * 
 *
 * @author Nathan Morales
 * @author Omar Azad
 * @author Moises Liberato
 * @author Arianna Ebanks
 */
public class Transactions implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
  /** The date of the transaction in MM/DD/YYYY format. */
  private final String date;

  /** The category or type of the transaction (e.g., "Investments", "Food"). */
  private final String category;

  /** The transaction amount. Positive for income, negative for expenses. */
  private final double amount;

  /**
   * Constructs a new Transaction with the specified fields.
   *
   * @param date the date of the transaction (MM/DD/YYYY)
   * @param category the category of the transaction
   * @param amount the transaction amount (positive or negative)
   */
  public Transactions(String date, String category, double amount) {
    this.date = date;
    this.category = category;
    this.amount = amount;
  }

  /**
   * Returns the transaction date.
   *
   * @author TBD
   * @return the date of the transaction as a string
   */
  public String getDate() { return date; }

  /**
   * Returns the transaction category.
   *
   * @author TBD
   * @return the category of this transaction
   */
  public String getCategory() { return category; }

  /**
   * Returns the transaction amount.
   *
   * @author TBD
   * @return the amount of this transaction
   */
  public double getAmount() { return amount; }

/**
* Evaluates the value of the amount to distinguish income.
* Incomes will be greater than zero.
* @author Arianna Ebanks
* 
* @return true if positive, negative if false
  */
public boolean isIncome() {
  return (this.amount > 0);
}
/**
* Evaluates the value of the amount to distinguish an expense.
* Expenses will be less than zero.
* @author Arianna Ebanks
*
* @return true if positive, negative if false
  */
public boolean isExpense() {
  return (this.amount < 0);
}

/**
	* Reads and parses data from a CSV file named YYYY.csv.
	*Enforces that all dates are within one calendar year.
	* @author Arianna Ebanks
	*
	* @param filename the name of the CSV file being parsed
	* @return a List of Transactions objects gathered from the file
	* @throws IOException if the file cannot be read.
	* @throws IllegalArgumentException if there is a violation of the contract.
	  */
	public static List<Transactions> obtainVariables(String filename) throws IOException {
	  List<Transactions> transactionsList = new ArrayList<>();

	  try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	    String line;
	    int lineNumber = 0;

	    while ((line = br.readLine()) != null) {
	      lineNumber++;

	      if(line.trim().isEmpty()) { continue; }

	      if (lineNumber == 1) { continue; } 

	      String[] parts = line.split(",");


	      try {
	        String date = parts[0].trim();
	        String category = parts[1].trim();	    
	        int amountIsInt = Integer.parseInt(parts[2].trim());
	        double amount = (double)amountIsInt;
	        
	       transactionsList.add(new Transactions(date, category, amount));
	       
	      } catch (NumberFormatException e) { 
	    	  System.err.println("Skipping line " + lineNumber + ": Invalid format for a numeric value."); 
	      } 
	    }
	  }
	  return transactionsList;
	}

}
