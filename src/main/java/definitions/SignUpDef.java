package definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SignUpStep;
import ui.SignUpUI;

public class SignUpDef {

    @Steps
    SignUpStep signUpStep;

    @Given("ingreso al formulario de registro")
    public void ingresoAlFormularioDeRegistro() {
       signUpStep.ingresoAplicativo();
       signUpStep.formSignUp();
    }

    @When("diligencio el formulario de manera correcta")
    public void diligencioElFormularioDeManeraCorrecta() {
        signUpStep.diligenciarFormOk();
    }

    @Then("el sistema permite el registro")
    public void elSistemaPermiteElRegistro() {
        signUpStep.confirmRegistro();
    }


    @When("diligencio el campo nombre con una sola palabra")
    public void diligencioElCampoNombreConUnaSolaPalabra() {
        signUpStep.nombreIncorrecto();
    }
    @When("Diligencio los demas campos de manera correcta")
    public void diligencioLosDemasCamposDeManeraCorrecta() {
        signUpStep.diligenciarDemasCampos();
    }

    @Then("el sistema no permite el registro")
    public void elSistemaNoPermiteElRegistro() {
        signUpStep.btnDeshabilitado();
    }

    @When("diligencio el campo Email de manera incorrecta")
    public void diligencioElCampoEmailDeManeraIncorrecta() {
        signUpStep.emailIncorrecto();
    }

    @When("diligencio el campo Email ingreso un email ya existente")
    public void diligencioElCampoEmailIngresoUnEmailYaExistente() {

    }

    @When("diligencio el campo Password de manera incorrecta")
    public void diligencioElCampoPasswordDeManeraIncorrecta() {

    }

    @When("dejo el campo nombre vacio")
    public void dejoElCampoNombreVacio() {

    }

    @When("diligencio los campos de contraseña con diferente informacion")
    public void diligencioLosCamposDeContraseñaConDiferenteInformacion() {

    }
    @Then("el sistema muestra mensaje de no coincidencia")
    public void elSistemaMuestraMensajeDeNoCoincidencia() {

    }




}
