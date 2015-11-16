package pageObjectPattern;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: ab83625
 * Date: 10.11.2010
 * To change this template use File | Settings | File Templates.
 */
public abstract class Page {
    private Context context;
    private String currentPage;

    protected Page(String pageUrl) {
        this.currentPage = pageUrl;
        setContext(Context.getInstance());
        init();
        parsePage();
    }

    private void setContext(Context instance) {
        this.context = instance;
    }

    protected abstract void init();
    protected abstract void parsePage();

    public String getCurrentPage() {
  return context.getSiteUrl() + this.currentPage;
    }

    protected Selenium getBrowser() {
        return context.getBrowser();
    }

    // ....
    // service methods...
    // ....
}