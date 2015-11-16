package pageObjectPattern;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ab83625
 * Date: 10.11.2010
 * To change this template use File | Settings | File Templates.
 */
public class TestLogin extends TestCase {
   public void setUp() {
        // Инициализация контекста.
        Context.initInstance(Context.BROWSER_IE, "http://ua.proffstore.com/");
    }
   @Test
   public void testLoginLogout() {
        String userName = "tester";
        String password = "testPass";
        LoginPage loginPage = LoginPage.openLoginPage();
        HomePage homePage = loginPage.login(userName, password);
        assertEquals(userName, homePage.getLoggedinUserName());
        homePage.logout();
    }
    @Test
    public void testInvalidLogin() {
        String userName = "$tester@#";
        String password = "********";
        String expectedMessage = "Invalid username or password";
        LoginPage loginPage = LoginPage.openLoginPage();
        ErrorLoginPage errorLoginPage = loginPage.loginInvalid(userName, password);
        assertEquals(expectedMessage, errorLoginPage.getErrorMessage());
        errorLoginPage.backToLoginPage();
    }

    protected void tearDown() throws Exception {
        // закрытие браузера
       Context.getInstance().close();
    }
}