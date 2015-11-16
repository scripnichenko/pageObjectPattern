package pageObjectPattern;

/**
 * Created by IntelliJ IDEA.
 * User: ab83625
 * Date: 10.11.2010
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends Page {
   public static final String PAGE_URL = "/login.html";

   protected LoginPage() {
       super(PAGE_URL);
   }

   public static LoginPage openLoginPage() {
       LoginPage loginPage = new LoginPage();
       loginPage.getBrowser().open(PAGE_URL);
       return loginPage;
   }

   private void setUserName(String userName) {
       // код для заполнения поля Username
       getBrowser().type("id=UserName", userName);
   }

   private void setPassword(String password) {
       // код для заполнения поля Password
       getBrowser().type("id=Password", password);
   }

   private void pushLoginButton() {
       // код для нажатия на кнопку Login
       getBrowser().click("id=LoginButton");
   }

   protected void parsePage() {
       // Разбор элементов страницы
       // Заполнение необходимых переменных данными со страницы
   }

   protected void init() {
       // Инициализация страницы, например проверка адреса (URL) страницы:
       if(!getBrowser().getLocation().equals(PAGE_URL)) {
           throw new IllegalStateException("Invalid page is opened");
       }
       // Можно также добавить проверки наличия необходимых для дальнейшей работы
       // объектов и т.д.
   }

   private void loginAs(String userName, String password) {
       setUserName(userName);
       setPassword(password);
       pushLoginButton();
   }

   public HomePage login(String userName, String password) {
       loginAs(userName, password);
       return new HomePage();
   }

   public ErrorLoginPage loginInvalid(String userName, String password) {
       loginAs(userName, password);
       return new ErrorLoginPage();
   }
}
