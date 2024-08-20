package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Acciones extends PageObject {
    private Logger logger = LoggerFactory.getLogger(Acciones.class);
    private static final Map<String, String> mapDatosCasoPrueba = new LinkedHashMap<>();
    private static final String IGNORE = "<IGNORE>";
    private static final String mensaje = "SE REALIZO ESPERA DE UN ELEMENTO";
    private static final String detalleError = "Detalle Error";

    /**
     * Metodo para escribir Texto
     *
     * @param element  elemento a escribir
     * @param strTexto texto que se va a escribir
     */
    public void escribirTexto(By element, String strTexto) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            input.clear();
            input.sendKeys(strTexto); // Cambiado de type a sendKeys
            Serenity.takeScreenshot();
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport("Detalle Error", String.valueOf(element) + e);
            excepcionAccionesWeb(e);
        }
    }

    public void abrirPaginaConURL(String url) {
        getDriver().get(url);
    }


    /**
     * Espera en segundos
     */
    public void esperarEnSegundos() {
        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            mostrarInformacionEnSerenityReport("Error", "La espera fue interrumpida: " + e.getMessage());
        }
    }


    /**
     * Metodo para hacer click a un boton
     *
     * @param strBoton el elemento a interactuar
     */
    public void clickBoton(By strBoton) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.elementToBeClickable(strBoton));
            element(strBoton).click();
            Serenity.takeScreenshot();
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError, String.valueOf(strBoton) + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Da click a una coordenada
     */

    public void clickEnCoordenada(int x, int y) {
        try {
            // Obtén el WebDriver y luego el AppiumDriver
            WebDriver driver = getDriver();
            AppiumDriver appiumDriver = (AppiumDriver) ((WebDriverFacade) driver).getProxiedDriver();

            // Crear una secuencia de acciones usando W3C PointerInput
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence clickAtCoordinates = new Sequence(finger, 1);

            // Mover a la posición y realizar un clic
            clickAtCoordinates.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
            clickAtCoordinates.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            clickAtCoordinates.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            // Realizar la secuencia de acciones
            appiumDriver.perform(Collections.singletonList(clickAtCoordinates));
        } catch (Exception e) {
            e.printStackTrace(); // Manejar la excepción según tus necesidades
        }
    }




    /**
     * Genera un email aleatorio
     */
    public static String generateRandomEmail() {
        String uniqueID = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return "user" + uniqueID + "@test.com";
    }

    /**
     * Espera a que cargue todos los objetos de la pagina
     */
    public void esperaCargarPagina() {
        int intTimer = 20;
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(intTimer)).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo esperaCargarPagina " + e);
        }
    }

    /**
     * Metodo encargado de abrir la URL
     *
     * @param strURL elemento de tipo String la cual puede ser una IP o URL para
     *               abrirla en el navegador
     */
    public void abrirURL(String strURL) {
        openAt(strURL);
        getDriver().manage().deleteAllCookies();
    }

    /**
     * Este metodo valida si el elemento es clickeable
     *
     * @param xpath elemento que se requiere esperar a que sea clickeable
     * @return retorna true o false si el elemento esta o no visible
     */
    public boolean esperoElementoVisible(By xpath) {
        try {
            logger.info(mensaje);
            WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
            espera.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            if (element(xpath).isVisible()) {
                return true;
            }
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError, String.valueOf(xpath) + e);
        }
        return false;
    }

    public boolean elementoClikeable(By xpath) {
        try {
            WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
            espera.until(ExpectedConditions.elementToBeClickable(xpath));
            if (element(xpath).isClickable()) {
                return true;
            }
        } catch (Exception e) {
            logger.info("en la clase AccionesWeb en el metodo clickeable" + e);
        }
        return false;
    }

    /**
     * Este metodo espera a que un elemento esté habilitado
     *
     * @param xpath elemento que se requiere esperar a que sea visible
     * @return retorna true o false si el elemento esta o no presente
     */
    public boolean esperoElementoHabilitado(By xpath) {
        esperaCargarPagina();
        try {
            logger.info(mensaje);
            WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
            espera.until(ExpectedConditions.elementToBeClickable(xpath));
            if (element(xpath).isEnabled()) {
                return true;
            }
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError, String.valueOf(xpath) + e);
        }
        return false;
    }

    /**
     * Metodo para resaltar el elemento enviado como parametro
     *
     * @param webLocalizador elemento a resaltar
     */
    public void bordearElemento(By webLocalizador) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'",
                    element(webLocalizador));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#cc8f94'",
                    element(webLocalizador));
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para desplazarse hasta el elemento relacionado
     *
     * @param locator localizador tipo WebElement al que se desea desplazarse
     */
    public void posicionarElementoScroll(By locator) {
        try {
            WebElement element = element(locator);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport("Error al posicionar elemento", String.valueOf(locator) + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para aceptar alertas
     */
    public void aceptarAlerta() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * Metodo para validar que el elemento no exista
     */
    public void elementoInexistente(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Metodo para tomar evidencia de la pantalla actual
     */
    public void tomarEvidencia() {
        try {
            Serenity.takeScreenshot();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo tomarEvidencia " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para calcular el tiempo del serenity properties
     *
     * @return retorna el tiempo en segundo del serenity
     */
    public Duration obtenerTiempoSerenity() {
        return getImplicitWaitTimeout();
    }

    /**
     * Metodo para lanzar excepciones a partir del error capturado
     *
     * @param e mensaje de error dado por Java
     */
    public void excepcionAccionesWeb(Exception e) {
        String[] strExcepcion = e.getClass().getCanonicalName().replace(".", "-").split("-");
        ExceptionsProyecto.validaExcepcion(strExcepcion[strExcepcion.length - 1]);
    }

    /**
     * Método que muestra la informacion en el serenity report
     *
     * @param strNombreDescripcion Titulo de la descripción
     * @param strDescrip           texto de la descripción
     */
    public void mostrarInformacionEnSerenityReport(String strNombreDescripcion, String strDescrip) {
        Serenity.recordReportData().withTitle(strNombreDescripcion).andContents(strDescrip);
    }
}
