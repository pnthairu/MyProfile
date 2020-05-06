import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
 
/**
 * This is a chained comparator that is used to sort a list by multiple
 * attributes by chaining a sequence of comparators of individual fields
 * together.
 * @author www.codejava.net
 *
 */
public class AccountChainedComparator implements Comparator<Account> {
 
    private List<Comparator<Account>> listComparators;
 
    @SafeVarargs
    public AccountChainedComparator(Comparator<Account>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Account cust1, Account cust2) {
        for (Comparator<Account> comparator : listComparators) {
            int result = comparator.compare(cust1, cust2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}