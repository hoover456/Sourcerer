import org.jsoup.nodes.Document;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private HashMap<String, Domain> domainParseMap; // HashMap of Domain name Strings (ie. "cnn.com") and their corresponding Domain object.
    // TODO: Read serialized domainParseMap from file
    public Parser(){
        domainParseMap = new HashMap<String, Domain>();
    }

    public void parse(Document doc, String URL, String domainString){
        if(doc == null){
            System.err.println("NO DOCUMENT"); // Display an error if there was no document found and exit the program
            System.exit(0);
            // TODO: Handle this issue gracefully rather than dying
        }
        // IF the domain is not in the list of known, go through process of adding it
        if(domainParseMap.get(domainString)==null){
            domainParseMap.put(domainString, new Domain(domainString, addDateSelector(domainParseMap, doc))); // Add domain to list
        }
    }

    // Prompt user for input of CSS Selector for ISO8601 date and verify w/ user that it works correctly
    public String addDateSelector(HashMap dpm, Document doc){

        String dateSelector = "";
        // Java Regex pattern for ISO8601 compliant date from https://www.myintervals.com/blog/2009/05/20/iso-8601-date-validation-that-doesnt-suck/
        Pattern ISO8601_PATTERN = Pattern.compile("([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?");
        Matcher ISO8601_MATCHER; // Regex Matcher
        Scanner scan = new Scanner(System.in);
        String answer; // Declare answer string

        System.out.println("Domain not found, Please add it to the list");
        do{
            System.out.println("\nEnter CSS Selector for date of publication: ");
            dateSelector = scan.nextLine();
            ISO8601_MATCHER = ISO8601_PATTERN.matcher(doc.select(dateSelector).toString()); // Feed result of CSS Query to Matcher
            ISO8601_MATCHER.find(); // find all matches
            System.out.println("Pub-Date tag: " + doc.select(dateSelector).toString() + " Pub-Date: " + ISO8601_MATCHER.group(0) + "\nDoes this look correct? (Y/n)");
            answer = scan.nextLine();
        }while(answer.toLowerCase().equals("n")); // continue if user says no, otherwise accept input
        return dateSelector;
    }

    public String addAuthorSelector(HashMap dpm, Document doc){
        //TODO: Add author selector method
        return null;
    }

    public String addBodySelector(HashMap dpm, Document doc){
        //TODO: Add body selector method
        return null;
    }
}