import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadDataFromJSONFile {

    static List<Account> accountList = new ArrayList<>();
    static List<Account> nullTxtAccountList = new ArrayList<>();
    static List<Account> filteredList = new ArrayList<>();
    static Integer minRatingUserInput;

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        Menu menu = new Menu();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("jsonfiles/package.json"));

        //Fill the lists
        for (Object o  : jsonArray){
            JSONObject jsonobj = (JSONObject) o;
            if(!jsonobj.get("reviewFullText").toString().isBlank())
                accountList.add(new Account(jsonobj.get("rating"),jsonobj.get("reviewFullText"),jsonobj.get("reviewCreatedOnDate")));
            else
                nullTxtAccountList.add(new Account(jsonobj.get("rating"),jsonobj.get("reviewFullText"),jsonobj.get("reviewCreatedOnDate")));
        }
        //Print the menu
        menu.printMenu();
    }
}
