package ui;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SignInUI extends PageObject {

    private static final By SIGNIN_EMAIL = By.id("email");
    private static final By SIGNIN_PASS = By.xpath("//app-password//input[@id='password']");
    private static final By BTN_SINGIN = By.xpath("//button[.=' Sign in ']");
    private static final By BTN_IMG = By.xpath("//img[@alt='Rengoku']");
    private static final By BTN_LOGOUT = By.xpath("//a[.='Logout']");
    private static final By LBL_ERROR = By.xpath("//div[@role='alert']");
    private static final By LBL_TXT = By.xpath("//h1[.='Sign in']");

    public static By getSigninEmail() {
        return SIGNIN_EMAIL;
    }

    public static By getSigninPass() {
        return SIGNIN_PASS;
    }

    public static By getBtnSingin() {
        return BTN_SINGIN;
    }

    public static By getBtnImg() {
        return BTN_IMG;
    }

    public static By getBtnLogout() {
        return BTN_LOGOUT;
    }

    public static By getLblError() {
        return LBL_ERROR;
    }

    public static By getLblTxt() {
        return LBL_TXT;
    }
}
