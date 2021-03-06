import java.util.Scanner;

public class Menu extends ReadDataFromJSONFile {
    Scanner sc = new Scanner(System.in);
    Filters filters = new Filters();

    String ratingUserInput;
    String dateUserInput;
    String textUserInput;
    String againStr;
    boolean menuLoop = false;
    boolean sortAgain = false;


    public void printMenu() {
        do {
            menuLoop = false;
            filteredList.clear();

            System.out.println("Rating - [Highest First | Lowest First]");
            ratingUserInput = sc.next().toLowerCase();
            System.out.println("Date - [Newest First | Oldest First]");
            dateUserInput = sc.next().toLowerCase();
            System.out.println("Text - Prioritize by text: [Yes | No]");
            textUserInput = sc.next().toLowerCase();
            System.out.println("Minimum rating - [ 5, 4, 3, 2, 1 ]");
            minRatingUserInput = sc.nextInt();

            Switch: switch (ratingUserInput) {
                case "highest":
                case "highest first":

                    switch (dateUserInput) {

                        case "newest":
                        case "newest first":

                            switch (textUserInput) {
                                case "yes":
                                    filters.highestNewestYes();
                                    break Switch;
                                case "no":
                                    filters.highestNewestNo();
                                    break Switch;
                            }

                        case "oldest":
                        case "oldest first":

                            switch (textUserInput) {
                                case "yes":
                                    filters.highestOldestYes();
                                    break Switch;
                                case "no":
                                    filters.highestOldestNo();
                                    break Switch;
                            }
                    }


                case "lowest":
                case "lowest first":


                    switch (dateUserInput) {

                        case "newest":
                        case "newest First":

                            switch (textUserInput) {
                                case "yes":
                                    filters.lowestNewestYes();
                                    break Switch;
                                case "no":
                                    filters.lowestNewestNo();
                                    break Switch;
                            }

                        case "oldest":
                        case "oldest first":

                            switch (textUserInput) {
                                case "yes":
                                    filters.lowestOldestYes();
                                    break Switch;
                                case "no":
                                    filters.lowestOldestNo();
                                    break Switch;
                            }
                    }
            }

            sortAgainMenu();

        }while (menuLoop);
    }




    public void sortAgainMenu (){
        System.out.println("Sort again? Yes/No ");
        do {
            sortAgain = false;
            againStr = sc.next();
            if (againStr.equalsIgnoreCase("yes")) {
                menuLoop = true;
            } else if (againStr.equalsIgnoreCase("no")) {
                System.out.println("Good Bye!");
                menuLoop = false;
            } else {
                System.out.println("Incorrect input, try again!");
                sortAgain = true;
            }
        }while (sortAgain);
    }
}
