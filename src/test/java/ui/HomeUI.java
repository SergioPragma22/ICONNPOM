package ui;

import io.appium.java_client.AppiumBy;
import lombok.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomeUI extends PageObject {

    private static final By BTN_INVITADO = By.xpath("(//com.horcrux.svg.GroupView[@index='0' and @class='com.horcrux.svg.GroupView'])[9]");
    private static final By BTN_SELUBICACION = By.xpath("//android.view.ViewGroup[@index='3' and @class='android.view.ViewGroup']");
    private static final By LIST_UBICACION = By.xpath("//android.widget.EditText[@resource-id=\"undefined-input\"]");
    private static final By OPTION_LEON = By.xpath("(//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"])[2]");
    private static final By BTN_GUARDAR = AppiumBy.accessibilityId("Guardar");
    private static final By BTN_QR = By.xpath("//android.view.ViewGroup[@content-desc=\"Escanea y Gana\"]");


    public static By getBtnInvitado() {
        return BTN_INVITADO;
    }

    public static By getBtnSelubicacion() {
        return BTN_SELUBICACION;
    }

    public static By getListUbicacion() {
        return LIST_UBICACION;
    }

    public static By getOptionLeon() {
        return OPTION_LEON;
    }

    public static By getBtnGuardar() {
        return BTN_GUARDAR;
    }

    public static By getBtnQr() {
        return BTN_QR;
    }
}
