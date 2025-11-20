import java.util.List;
import java.io.Serializable;

/**
 * Represents user's financial record for one year.
 * It maintains a list of transactions and provides summaru calculations.
 *
 * @author Nathan Morales
 * @author Omar Azad
 * @author Moises Liberato
 * @author Arianna Ebanks
 */
public class Budget implements Serializable {

  private static final long serialVersionUID = 1L;

  /** The year that this budget represents. */
  private final int year;

  /** The list of all transactions within this budget. */
  private final List<Transactions> transactions;
  
  /**
   * Constructs a new Budget with the specified fields.
   *
   * @param year the year of the budget data
   * @param transactions the list of transactions for this budget
   */
  public Budget(int year, List<Transactions> transactions) {
    this.year = year;
    this.transactions = transactions;
  }

  /**
   * Adds a transaction to the list of transactions.
   * Note: implementation requires special @Overrride calls that have not been implemented yet.
   * 
   * @author Omar Azad
   * @param transaction the transaction to add
   */
  public void addTransaction(Transactions transaction)
  {
     this.transactions.add(transaction);
  }

  /**
   * Removes a specific transaction from this budget.
   * Note: implementation requires special @Overrride calls that have not been implemented yet.
   *
   * @author Omar Azad`
   * @param transaction the transaction to remove
   */
  public void removeTransaction(Transactions transaction)
  {
    this.transactions.remove(transaction);
  }

  /**
   * Calculates the total income and expenses for each month.
   *
   * @author Moises Liberato 
   * @return a list of monthly total values
   */
  public List<Integer> getMonthlyTotals()
  {
    return null;
  }

  /**
   * Calculates the total income, expenses, and net total for the year.
   *
   * @author Moises Liberato 
   * @return a summary of the annual financial performance
   */
  public List<Integer> getAnnualSummary()
  {
    return null;
  }

  /**
   * Retrieves the year associated with this budget.
   *
   * @author Moises Liberato 
   * @return the year value
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Retrieves the list of transactions associated with this budget.
   *
   * @author Omar Azad
   * @return the list of transactions
   */
  public List<Transactions> getTransactions()
  {
      return transactions;
  }
}
