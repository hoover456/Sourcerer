public class Domain {
    private String name; // domain name ie. cnn.com
    private String dateSelector; // Unique CSS selector for a tag containing an ISO8601-compliant date of publication
    private String authorSelector; // Unique CSS Selector for a tag containing the author's name
    private String bodySelector; // CSS Selector for all tags who's text content is the text of a news article

    public Domain(String name, String dateSelector, String authorSelector, String bodySelector) {
        this.name = name;
        this.dateSelector = dateSelector;
        this.authorSelector = authorSelector;
        this.bodySelector = bodySelector;
    }

    public Domain(String name, String dateSelector) {
        new Domain(name, dateSelector, "", "");
    }

    public String getName() {
        return name;
    }

    public String getDateSelector() {
        return dateSelector;
    }

    public String getAuthorSelector() {
        return authorSelector;
    }

    public String getBodySelector() {
        return bodySelector;
    }
}
