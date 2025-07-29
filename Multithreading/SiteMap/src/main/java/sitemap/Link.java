package sitemap;

public class Link implements Comparable<Link>{
    private String url;
    private int tabCount;

    public String getUrl() {
        return url;
    }

    public int getTabCount() {
        return tabCount;
    }

    public Link(String url, int tabCount){
        this.url = url;
        this.tabCount = tabCount;
    }

    @Override
    public int compareTo(Link o) {
        return this.url.compareTo(o.url);
    }
}
