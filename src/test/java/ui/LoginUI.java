package ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class LoginUI extends PageObject {

    private static final By LBL_NOTIFICACION = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");
    private static final By FRAME = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]");
    private static final By BTN_REGISTRATE = By.xpath("(//android.widget.TextView[@index='1' and @class='android.widget.TextView'])[2]");
    private static final By INPUT_EMAIL = By.xpath("(//android.widget.EditText[@index='0' and @class='android.widget.EditText'])[1]");
    private static final By INPUT_PASSWORD = By.xpath("(//android.widget.EditText[@index='0' and @class='android.widget.EditText'])[2]");
    private static final By BTN_SIGNUP = AppiumBy.accessibilityId("Crear cuenta");
    private static final By BTN_SIGNIN = By.xpath("(//android.widget.TextView[@index='0' and @class='android.widget.TextView'])[2]");


    public static By getLblNotificacion() {
        return LBL_NOTIFICACION;
    }

    public static By getFRAME() {
        return FRAME;
    }

    public static By getBtnRegistrate() {
        return BTN_REGISTRATE;
    }

    public static By getInputEmail() {
        return INPUT_EMAIL;
    }

    public static By getInputPassword() {
        return INPUT_PASSWORD;
    }

    public static By getBtnSignup() {
        return BTN_SIGNUP;
    }

    public static By getBtnSignin() {
        return BTN_SIGNIN;
    }
}
