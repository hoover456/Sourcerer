import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
/**
 * Created by Andrew on 8/13/2017.
 *
 * Article object
 */
public class Article {
    private String url; // URL article is found at
    private String domain; // Domain of website eg. cnn.com
    private String body; // Full text of the article
    private Date pubDate; // Date and time the article was published
    private String author; // Author of the article
    private String[] links;

    public Article(String url, String domain, String body, String date, String author, String[] links) {
        this.url = url;
        this.domain = domain;
        this.body = body;
        try {
            this.pubDate = DateFormat.getDateTimeInstance().parse(date);
        } catch (ParseException e) {
            this.pubDate = null;
        }
        this.author = author;
        this.links=links;
    }

    public String getUrl() {
        return url;
    }

    public String getDomain() {
        return domain;
    }

    public String getBody() {
        return body;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getAuthor() {
        return author;
    }
}
