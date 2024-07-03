package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SignInStep;

public class SignInDef {

    @Steps
    SignInStep signInStep;

    @Given("Ingreso al formulario de logueo")
    public void ingresoAlFormularioDeLogueo() {
        signInStep.ingresoAplicativo();
    }

    @When("diligencio los campos correctamente")
    public void diligencioLosCamposCorrectamente() {
        signInStep.diligenciarCampos();
    }

    @Then("permite el ingreso")
    public void permiteElIngreso() {
        signInStep.ingresoOk();
    }

    @When("Dejo los campos vacios")
    public void dejoLosCamposVacios() {
        signInStep.camposVacios();
    }

    @Then("NO permite el ingreso")
    public void noPermiteElIngreso() {
        signInStep.btnDeshabilitado();
    }

    @When("Ingreso credenciales incorrectas")
    public void ingresoCredencialesIncorrectas() {
        signInStep.credencialesIncorrectas();
    }

    @Then("muestra mensaje de error")
    public void muestraMensajeDeError() {
        signInStep.msjError();
    }

    @Then("permite cerrar sesion")
    public void permiteCerrarSesion() {
        signInStep.logout();
    }
}
