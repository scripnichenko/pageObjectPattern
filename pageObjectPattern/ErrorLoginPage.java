package pageObjectPattern;

/**
 * Created by IntelliJ IDEA.
 * User: ab83625
 * Date: 10.11.2010
 * To change this template use File | Settings | File Templates.
 */
public class ErrorLoginPage extends Page {
   public static final String PAGE_URL = "/loginError.html";
   private String errorMessage;

   protected ErrorLoginPage() {
       super(PAGE_URL);
   }

   protected void init() {
       // Инициализация страницы
   }

   protected void parsePage() {
       // Разбор элементов страницы
       this.errorMessage = getBrowser().getText("id=ErrorMessage");
   }

   public String getErrorMessage() {
       return this.errorMessage;
   }

   public LoginPage backToLoginPage() {
       getBrowser().click("id=BackLink");
       return new LoginPage();
   }
}
