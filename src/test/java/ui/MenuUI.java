package ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class MenuUI extends PageObject {

    private static final By BTN_MENU = By.xpath("//android.view.View[@index='5' and @class='android.view.View']");
    private static final By BTN_SUCURSALES = By.xpath("(//android.view.ViewGroup[@index='0' and @class='android.view.ViewGroup'])[22]");
    private static final By LBL_MAP = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");



    public static By getBtnMenu() {
        return BTN_MENU;
    }

    public static By getBtnSucursales() {
        return BTN_SUCURSALES;
    }

    public static By getLblMap() {
        return LBL_MAP;
    }
}
