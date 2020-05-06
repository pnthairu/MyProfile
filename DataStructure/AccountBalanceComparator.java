import java.util.Comparator;

/**
 * This comparator compares two Accounts by their Balances.
 * @author www.codejava.net
 *
 */
public class AccountBalanceComparator implements Comparator<Account> {
 
    @Override
    public int compare(Account cust1, Account cust2) {
        return (int) (cust1.getBalance() - cust2.getBalance());
    }
}