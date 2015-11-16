package pageObjectPattern;

/**
 * Created by IntelliJ IDEA.
 * User: ab83625
 * Date: 10.11.2010
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends Page {
   public static final String PAGE_URL = "/home.html";
   private String loggedinUserName;

   protected HomePage() {
       super(PAGE_URL);
   }

   protected void init() {
       // Инициализация страницы
   }

   protected void parsePage() {
       // Разбор элементов страницы
       this.loggedinUserName = getBrowser().getText("id=userName");
   }

   public String getLoggedinUserName() {
       return loggedinUserName;
   }

   public LoginPage logout() {
       getBrowser().click("id=LogoutLink");
       return new LoginPage();
   }
}
