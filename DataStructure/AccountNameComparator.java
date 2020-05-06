import java.util.Comparator;
 
/**
 * This comparator compares two Accounts by their job titles.
 * @author www.codejava.net
 *
 */
public class AccountNameComparator implements Comparator<Account> {
 
    @Override
    public int compare(Account cust1, Account cust2) {
        return cust1.getName().compareTo(cust2.getName());
    }
    
}