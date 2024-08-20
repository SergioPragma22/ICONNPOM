package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import steps.HomeSteps;
import utilities.Acciones;

public class HomeDef {


    @Managed(driver = "Appium")
    public WebDriver hisMobileDevice;
    private Acciones acciones;

    @Steps
    HomeSteps homeSteps;

    @Given("el usuario abre la app como invitado")
    public void IngresaALaAppInvitado() {
        homeSteps.ingresoInvitado();
    }

    @When("acepta los permisos de ubicacion")
    public void aceptaLosPermisosDeUbicacion() {
        homeSteps.permisosUbicacion();
    }


    @And("da click en el boton menu")
    public void daClickEnElBotonMenu() {
        homeSteps.clickMenu();
    }

    @Then("da click en sucursales y ve el mapa")
    public void daClickEnSucursalesYVeElMapa() {
        homeSteps.verSucursales();
    }

    @And("da click en el boton de QR")
    public void daClickEnElBotonDeQR() {
        homeSteps.clickQR();
    }

    @Then("muestra el login")
    public void muestraElLogin() {
        homeSteps.verLogin();
    }
}
