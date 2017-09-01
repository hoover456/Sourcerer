import org.joda.time.DateTime;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class Parser {

    public static void parse(Document doc, String URL, String domainString) {
        if (doc == null) {
            System.out.println("NO DOCUMENT"); // Display an error if there was no document found and exit the program
            System.exit(0); // TODO: Handle this issue gracefully rather than giving up
        }
        System.out.println(getPublicationDate(doc).toString());
        System.out.println(getAuthors(doc).toString());
    }

    private static DateTime getPublicationDate(Document doc) {
        String[] dateSelectors = {"[itemprop=datePublished]", "time"};
        String[] dateAttrs = {"content", "datetime"};
        DateTime pubDateTime = null;
        for (String selector : dateSelectors) {
            for (String Attr : dateAttrs) {
                try {
                    pubDateTime = new DateTime(doc.select(selector).attr(Attr));
                } catch (Exception E) {
                }
            }
        }

        return (pubDateTime);
    }

    private static ArrayList<String> getAuthors(Document doc) {
        String[] authorSelectors = {"[itemprop=author]"};
        String[] authorAttrs = {"content"};
        ArrayList<String> authors = new ArrayList<>();
        for (String selector : authorSelectors) {
            for (String attr : authorAttrs) {
                try {
                    String authorsString = doc.select(selector).attr(attr);
                    authorsString = authorsString.replaceAll(" and ", ",");
                    authorsString = authorsString.replaceAll(", ",",");
                    if(authorsString.contains(",")){
                        for (String s : authorsString.split(",")) {
                            authors.add(s);
                        }
                    }
                    else
                        authors.add(authorsString);
                } catch (Exception E) {
                }
            }
        }
        return authors;
    }
}
