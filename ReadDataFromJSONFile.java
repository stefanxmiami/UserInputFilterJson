import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ReadDataFromJSONFile {
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("jsonfiles/package.json"));
        //Fill the lists

        List<Account> accountList = new ArrayList<>();
        for (Object o  : jsonArray){
            JSONObject jsonobj = (JSONObject) o;
            accountList.add(new Account(jsonobj.get("rating"),jsonobj.get("reviewFullText"),jsonobj.get("reviewCreatedOnDate")));
        }
        List<Account> filteredList = null;
        //List<Account> filteredList = accountList.stream().sorted().collect(Collectors.toList());
          //List<Account> filteredList = accountList.stream().filter(account -> account.rating >= 3).sorted(Comparator.comparing(account -> account.reviewCreatedOnTime)).sorted(Comparator.comparing(account -> account.reviewFullText)).collect(Collectors.toList());
        //List<Account> filteredList = accountList.stream().sorted(Comparator.comparing(account -> account.rating)).collect(Collectors.toList());
          //Collections.reverse(filteredList);
        //filteredList = filteredList.stream().sorted(Comparator.comparing(account -> account.reviewCreatedOnTime)).collect(Collectors.toList());
        //filteredList = filteredList.stream().sorted(Comparator.comparing(account -> account.reviewFullText)).collect(Collectors.toList());
          //filteredList.forEach(account -> System.out.println(account.rating + " " + account.reviewFullText + " " + account.reviewCreatedOnDate));
        //filteredList.forEach(account -> System.out.println(account.rating));
        //System.out.println(LocalDateTime.parse(accountList.get(0).reviewCreatedOnDate));
        Scanner sc = new Scanner(System.in);

        Boolean menuLoop = false;

        Boolean prioritizeTextBol = false;
        Boolean ratingHiLoBol = false;
        Boolean datePriorityBol = false;
        int minRating = 1;

        System.out.println("Rating - [Highest First | Lowest First]");
 Rating:    switch (sc.nextLine()){
            case "Highest":
            case "Highest First":
                System.out.println("Date - [Newest First | Oldest First]");
                switch (sc.nextLine()){
                    case "Newest":
                    case "Newest First":
                        System.out.println("Text - Prioritize by text: [Yes | No]");
                        switch (sc.nextLine()){
                            case "Yes":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                            filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 1).collect(Collectors.toList());
                                            break Rating;
                                    case 2:
                                            filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 2).collect(Collectors.toList());
                                            break Rating;
                                    case 3:
                                            filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 3).collect(Collectors.toList());
                                            break Rating;
                                    case 4:
                                            filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 4).collect(Collectors.toList());
                                            break Rating;
                                    case 5:
                                            filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 5).collect(Collectors.toList());
                                            break Rating;
                                }
                            case "No":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 1).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 2:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 2).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 3:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 3).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 4:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 4).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 5:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 5).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                }
                        }

                    case "Oldest":
                    case "Oldest First":
                        System.out.println("Text - Prioritize by text: [Yes | No]");
                        switch (sc.nextLine()){
                            case "Yes":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 1).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 2:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 2).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 3:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 3).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 4:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 4).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 5:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 5).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        break Rating;
                                }
                            case "No":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 1).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 2:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 2).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 3:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 3).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 4:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 4).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                    case 5:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewCreatedOnDate).thenComparing(Account::getRating)).filter(account -> account.getRating() >= 5).sorted(Comparator.comparing(Account::getReviewFullText).reversed()).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getReviewFullText)).collect(Collectors.toList());
                                        filteredList = filteredList.stream().sorted(Comparator.comparing(Account::getRating).reversed()).collect(Collectors.toList());
                                        break Rating;
                                }
                        }
                }

            case "Lowest":
            case "Lowest First":
                System.out.println("Date - [Newest First | Oldest First]");
                switch (sc.nextLine()){
                    case "Newest":
                    case "Newest First":
                        System.out.println("Text - Prioritize by text: [Yes | No]");
                        switch (sc.nextLine()){
                            case "Yes":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(account -> account.getRating())).sorted(Comparator.comparing(Account::getReviewCreatedOnDate).reversed()).sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(account -> account.getReviewFullText()).reversed()).filter(account -> account.getRating() >= 1).collect(Collectors.toList());
                                        break Rating;
                                    case 2:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(account -> account.getRating())).sorted(Comparator.comparing(Account::getReviewCreatedOnDate).reversed()).sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(account -> account.getReviewFullText()).reversed()).filter(account -> account.getRating() >= 2).collect(Collectors.toList());
                                        break Rating;
                                    case 3:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(account -> account.getRating())).sorted(Comparator.comparing(Account::getReviewCreatedOnDate).reversed()).sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(account -> account.getReviewFullText()).reversed()).filter(account -> account.getRating() >= 3).collect(Collectors.toList());
                                        break Rating;
                                    case 4:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(account -> account.getRating())).sorted(Comparator.comparing(Account::getReviewCreatedOnDate).reversed()).sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(account -> account.getReviewFullText()).reversed()).filter(account -> account.getRating() >= 4).collect(Collectors.toList());
                                        break Rating;
                                    case 5:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(account -> account.getRating())).sorted(Comparator.comparing(Account::getReviewCreatedOnDate).reversed()).sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(account -> account.getReviewFullText()).reversed()).filter(account -> account.getRating() >= 5).collect(Collectors.toList());
                                        break Rating;
                                }
                            case "No":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 1).collect(Collectors.toList());
                                        break Rating;
                                    case 2:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 2).collect(Collectors.toList());
                                        break Rating;
                                    case 3:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 3).collect(Collectors.toList());
                                        break Rating;
                                    case 4:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 4).collect(Collectors.toList());
                                        break Rating;
                                    case 5:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).reversed().thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 5).collect(Collectors.toList());
                                        break Rating;
                                }
                        }

                    case "Oldest":
                    case "Oldest First":
                        System.out.println("Text - Prioritize by text: [Yes | No]");
                        switch (sc.nextLine()){
                            case "Yes":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getRating).reversed().thenComparing(Account::getReviewFullText).thenComparing(Account::getReviewCreatedOnDate).reversed()).filter(account -> account.getRating() >= 1).collect(Collectors.toList());

                                        break Rating;
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                }
                            case "No":
                                System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
                                switch (sc.nextInt()){
                                    case 1:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).filter(account -> account.getRating() >= 1).collect(Collectors.toList());
                                        break Rating;
                                    case 2:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).filter(account -> account.getRating() >= 2).collect(Collectors.toList());
                                        break Rating;
                                    case 3:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).filter(account -> account.getRating() >= 3).collect(Collectors.toList());
                                        break Rating;
                                    case 4:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).filter(account -> account.getRating() >= 4).collect(Collectors.toList());
                                        break Rating;
                                    case 5:
                                        filteredList = accountList.stream().sorted(Comparator.comparing(Account::getReviewFullText).thenComparing(Account::getRating).thenComparing(Account::getReviewCreatedOnDate)).filter(account -> account.getRating() >= 5).collect(Collectors.toList());
                                        break Rating;
                                }
                        }
                }
        }

        filteredList.forEach(account -> System.out.println(account.getRating() + " " + account.getReviewFullText() + " " + account.getReviewCreatedOnDate()));



    }
}
