package ui;


import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SignUpUI  extends PageObject {

    private static final By BTN_SIGNUP = By.xpath("//a[.=' Sign up ']");
    private static final By LBL_NAME = By.id("full-name");
    private static final By LBL_EMAIL = By.id("email");
    private static final By LBL_PASSWORD = By.xpath("//app-password//input[@id='password']");
    private static final By LBL_REPEATPASS = By.xpath("//app-password//input[@id='confirm-password']");
    private static final By BTN_CONFIRM = By.xpath("//button[.=' Sign up ']");
    private static final By LBL_OK = By.xpath("//div[.='Successful registration!']");

    public static By getBtnSignup(){
        return BTN_SIGNUP;
    }

    public static By getLblName() {
        return LBL_NAME;
    }

    public static By getLblEmail() {
        return LBL_EMAIL;
    }

    public static By getLblPassword() {
        return LBL_PASSWORD;
    }

    public static By getLblRepeatpass() {
        return LBL_REPEATPASS;
    }

    public static By getBtnConfirm() {
        return BTN_CONFIRM;
    }

    public static By getLblOk() {
        return LBL_OK;
    }


}
