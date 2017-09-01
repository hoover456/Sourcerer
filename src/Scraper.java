import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Scraper {
    private String startURL; // First URL to scrape, input by user
    private Parser p;

    public Scraper(String startURL) {
        this.startURL = startURL;
        p = new Parser();
        scrape(startURL); // Start scraping
    }

    private void scrape(String URL){
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).timeout(3000).get(); // get document with 3 second timeout
        } catch (IOException e) {
            System.err.println("IOException on Document Fetch");
            //TODO: Notify USER URL was invalid or unreachable and prompt for next step (new URL, try again, stop, etc)
        }

        try {
            Parser.parse(doc, URL, getDomainName(URL));
        } catch (URISyntaxException e) {
            e.printStackTrace(); // Thrown if java.net.URI can't extract the domain from the URL. Unlikely to be reached because JSoup.connect() comes first in program
        }
         // TODO: Add Queue of URLs to scrape
    }

    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain; // returns domain name without "www." if it starts with www., otherwise just returns domain name
        //TODO: May need to be extended for all subdomains (ie. politics.cnn.com)
    }

    public void addURL(String URL){
        //TODO add URL to URL Queue
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("URL to search: ");
        String url = scan.nextLine();
        new Scraper(url);
    }
}
