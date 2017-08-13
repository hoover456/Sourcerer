import java.util.ArrayList;

/**
 * Created by Andrew on 8/13/2017.
 *
 * Article object
 */
public class Article {
    private String url;
    private String domain;
    private String body;
    private String date;
    private String author;
    public int[] test = new int[3];

    public Article(String url, String domain, String body, String date, String author) {
        this.url = url;
        this.domain = domain;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
