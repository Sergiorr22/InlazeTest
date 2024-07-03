package steps;

import com.beust.ah.A;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import ui.SignInUI;
import ui.SignUpUI;
import utilities.AccionesWeb;

public class SignInStep {

    private AccionesWeb accionesWeb;
    private EnvironmentVariables environmentVariables;

    public void ingresoAplicativo() {
        String baseUrl = "https://test-qa.inlaze.com/";
        //String baseUrl = environmentVariables.optionalProperty("environments.qa.base.url").get();
        accionesWeb.abrirPaginaConURL(baseUrl);
        accionesWeb.esperaCargarPagina();
    }

    public void diligenciarCampos(){
        accionesWeb.esperoElementoPresente(SignInUI.getSigninEmail());
        accionesWeb.escribirTexto(SignInUI.getSigninEmail(), "sergio@test.com");
        accionesWeb.bordearElemento(SignInUI.getSigninEmail());
        accionesWeb.escribirTexto(SignInUI.getSigninPass(), "Prueba123*");
        accionesWeb.bordearElemento(SignInUI.getSigninPass());
    }

    public void ingresoOk(){
        accionesWeb.esperoElementoPresente(SignInUI.getBtnSingin());
        accionesWeb.bordearElemento(SignInUI.getBtnSingin());
        accionesWeb.clickBoton(SignInUI.getBtnSingin());
        accionesWeb.validarElementoEsteVisible(SignInUI.getBtnImg(), "Se visualiza el elemento");
    }

    public void camposVacios(){
        accionesWeb.esperoElementoPresente(SignInUI.getSigninEmail());
        accionesWeb.bordearElemento(SignInUI.getSigninEmail());
        accionesWeb.bordearElemento(SignInUI.getSigninPass());
    }

    public void btnDeshabilitado(){
        try {
            boolean isEnabled = accionesWeb.confirmarElementoNoHabilitado(SignInUI.getBtnSingin());
            accionesWeb.bordearElemento(SignInUI.getBtnSingin());
            Assert.assertTrue("El boton no esta deshabilitado como se esperaba",isEnabled);
        } catch (Exception e) {
            Assert.fail("La prueba fallo debido a que el boton esta habilitado" + e.getMessage());
        }
    }

    public void credencialesIncorrectas(){
        accionesWeb.esperoElementoPresente(SignInUI.getSigninEmail());
        accionesWeb.escribirTexto(SignInUI.getSigninEmail(), "noexiste@test.com");
        accionesWeb.bordearElemento(SignInUI.getSigninEmail());
        accionesWeb.escribirTexto(SignInUI.getSigninPass(), "Prueba1234*");
        accionesWeb.bordearElemento(SignInUI.getSigninPass());
    }

    public void msjError(){
        accionesWeb.esperoElementoPresente(SignInUI.getBtnSingin());
        accionesWeb.clickBoton(SignInUI.getBtnSingin());
        accionesWeb.bordearElemento(SignInUI.getLblError());
    }

    public void logout(){
        accionesWeb.esperoElementoPresente(SignInUI.getBtnImg());
        accionesWeb.clickBoton(SignInUI.getBtnImg());
        accionesWeb.bordearElemento(SignInUI.getBtnLogout());
        accionesWeb.clickBoton(SignInUI.getBtnLogout());
        accionesWeb.esperoElementoPresente(SignInUI.getLblTxt());
        accionesWeb.bordearElemento(SignInUI.getLblTxt());
    }



}
