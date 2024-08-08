package definitions;

import steps.LoginSteps;
import utilities.Acciones;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.openqa.selenium.WebDriver;

public class LogInDef {

    @Managed(driver = "Appium")
    public WebDriver hisMobileDevice;
    private Acciones acciones;

    @Steps
    LoginSteps loginSteps;


    @Given("Ingresa a la app y selecciona registrate")
    public void IngresaALaApp() {
        loginSteps.registrar();
    }


    @When("ingresa los datos email aleatorio y password {string}")
    public void ingresaLosDatos(String password) {
        loginSteps.ingresoCredenciales(password);
    }


    @Then("el usuario nuevo ingresa a Sevenly")
    public void elUsuarioIngresaASevenly() {

    }

}
