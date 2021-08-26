import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filters extends ReadDataFromJSONFile {

//HighNew
    public void highestNewestYes(){
        highestNewest(accountList, nullTxtAccountList);
    }
    public void highestNewestNo(){
        highestNewest(nullTxtAccountList, accountList);
    }

    public void highestNewest(List<Account> nullTxtAccountList, List<Account> accountList) {
        filteredList = nullTxtAccountList.stream().sorted(Comparator.comparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        printList();
        filteredList.clear();
        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        printList();
    }

//HighOld
    public void highestOldestYes(){
        highestOldest(accountList, nullTxtAccountList);
    }
    public void highestOldestNo(){
        highestOldest(nullTxtAccountList, accountList);
    }

    public void highestOldest(List<Account> nullTxtAccountList, List<Account> accountList) {
        filteredList = nullTxtAccountList.stream().sorted(Comparator.comparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate)).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        printList();
        filteredList.clear();
        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate)).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        printList();
    }

//LowNew
    public void lowestNewest(List<Account> nullTxtAccountList, List<Account> accountList){
        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        printList(); filteredList.clear();
        filteredList = nullTxtAccountList.stream().sorted(Comparator.comparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        printList();
    }


    public void lowestNewestYes(){
        lowestNewest(accountList, nullTxtAccountList);
    }
    public void lowestNewestNo(){
        lowestNewest(nullTxtAccountList, accountList);
    }

//LowOld
    public void lowestOldest(List<Account> nullTxtAccountList, List<Account> accountList){
        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        Filters.printList(); filteredList.clear();
        filteredList = nullTxtAccountList.stream().sorted(Comparator.comparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(account -> account.getRating() >= minRatingUserInput).collect(Collectors.toList());
        Filters.printList();
    }

    public void lowestOldestYes(){
        lowestOldest(accountList, nullTxtAccountList);
    }
    public void lowestOldestNo(){
        lowestOldest(nullTxtAccountList,accountList);
    }


//Print
    public static void printList(){
        filteredList.forEach(account -> System.out.println(account.getRating() + " " + account.getReviewFullText() + " " + account.getReviewCreatedOnDate()));
    }
}
