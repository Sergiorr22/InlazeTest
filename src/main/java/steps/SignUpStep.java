package steps;


import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import ui.SignUpUI;
import utilities.AccionesWeb;
import utilities.RandomUserDataGenerator;
import org.openqa.selenium.By;



public class SignUpStep extends PageObject {

    private AccionesWeb accionesWeb;
    private EnvironmentVariables environmentVariables;

    public void ingresoAplicativo(){
        String baseUrl = "https://test-qa.inlaze.com/";
        //String baseUrl = environmentVariables.optionalProperty("environments.qa.base.url").get();
        accionesWeb.abrirPaginaConURL(baseUrl);
        accionesWeb.esperaCargarPagina();
    }

    public void formSignUp(){
        accionesWeb.bordearElemento(SignUpUI.getBtnSignup());
        accionesWeb.clickBoton(SignUpUI.getBtnSignup());
    }

    public void diligenciarFormOk(){
        String randomName = RandomUserDataGenerator.generateRandomName();
        String randomEmail = RandomUserDataGenerator.generateRandomEmail();
        String password = "Password123!";
        accionesWeb.esperoElementoHabilitado(SignUpUI.getLblName());
        accionesWeb.escribirTexto(SignUpUI.getLblName(), randomName);
        accionesWeb.bordearElemento(SignUpUI.getLblName());
        accionesWeb.escribirTexto(SignUpUI.getLblEmail(), randomEmail);
        accionesWeb.bordearElemento(SignUpUI.getLblEmail());
        accionesWeb.escribirTexto(SignUpUI.getLblPassword(), password);
        accionesWeb.bordearElemento(SignUpUI.getLblPassword());
        accionesWeb.escribirTexto(SignUpUI.getLblRepeatpass(), password);
        accionesWeb.bordearElemento(SignUpUI.getLblRepeatpass());
        accionesWeb.bordearElemento(SignUpUI.getBtnConfirm());
        accionesWeb.clickBoton(SignUpUI.getBtnConfirm());
    }

    public void confirmRegistro(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblOk());
        accionesWeb.bordearElemento(SignUpUI.getLblOk());
    }

    public void nombreIncorrecto(){
        String onlyName = RandomUserDataGenerator.generateOnlyName();
        accionesWeb.esperoElementoPresente(SignUpUI.getLblName());
        accionesWeb.escribirTexto(SignUpUI.getLblName(), onlyName);
        accionesWeb.bordearElemento(SignUpUI.getLblName());
    }

    private void fillFieldIfEmpty(By field, String value) {
        if (find(field).getValue().isEmpty()) {
            find(field).sendKeys(value);
        }
    }

    public void diligenciarDemasCampos(){
        fillFieldIfEmpty(SignUpUI.getLblName(), RandomUserDataGenerator.generateRandomName());
        fillFieldIfEmpty(SignUpUI.getLblEmail(), RandomUserDataGenerator.generateRandomEmail());
        fillFieldIfEmpty(SignUpUI.getLblPassword(), "Prueba123*");
        fillFieldIfEmpty(SignUpUI.getLblRepeatpass(), "Prueba123*");
    }

    public void btnDeshabilitado(){
        try {
            boolean isEnabled = accionesWeb.confirmarElementoNoHabilitado(SignUpUI.getBtnConfirm());
            accionesWeb.bordearElemento(SignUpUI.getBtnConfirm());
            Assert.assertTrue("El boton no esta deshabilitado como se esperaba",isEnabled);
        } catch (Exception e) {
            Assert.fail("La prueba fallo debido a que el boton esta habilitado" + e.getMessage());
        }
    }

    public void emailIncorrecto(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblEmail());
        accionesWeb.escribirTexto(SignUpUI.getLblEmail(), "Test@fail");
        accionesWeb.bordearElemento(SignUpUI.getLblEmail());
    }

    public void emailExistente(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblEmail());
        accionesWeb.escribirTexto(SignUpUI.getLblEmail(), "sergio@test.com");
        accionesWeb.bordearElemento(SignUpUI.getLblEmail());
    }

    public void passwordFailed(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblPassword());
        accionesWeb.escribirTexto(SignUpUI.getLblPassword(), "Prueba123");
        accionesWeb.bordearElemento(SignUpUI.getLblPassword());
        accionesWeb.esperoElementoPresente(SignUpUI.getLblRepeatpass());
        accionesWeb.escribirTexto(SignUpUI.getLblRepeatpass(), "Prueba123");
        accionesWeb.bordearElemento(SignUpUI.getLblRepeatpass());
    }

    public void camposVacios(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblName());
        accionesWeb.escribirTexto(SignUpUI.getLblName(), "");
        accionesWeb.bordearElemento(SignUpUI.getLblName());
    }

    public void diligenciarSinName(){
        fillFieldIfEmpty(SignUpUI.getLblEmail(), RandomUserDataGenerator.generateRandomEmail());
        fillFieldIfEmpty(SignUpUI.getLblPassword(), "Prueba123*");
        fillFieldIfEmpty(SignUpUI.getLblRepeatpass(), "Prueba123*");
    }

    public void passwordSinCoincidencia(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblPassword());
        accionesWeb.escribirTexto(SignUpUI.getLblPassword(), "Prueba123*");
        accionesWeb.bordearElemento(SignUpUI.getLblPassword());
        accionesWeb.esperoElementoPresente(SignUpUI.getLblRepeatpass());
        accionesWeb.escribirTexto(SignUpUI.getLblRepeatpass(), "Prueba1234*");
        accionesWeb.bordearElemento(SignUpUI.getLblRepeatpass());
    }

    public void passwordNoMatch(){
        accionesWeb.esperoElementoPresente(SignUpUI.getLblNomatch());
        accionesWeb.bordearElemento(SignUpUI.getLblNomatch());
    }




}
