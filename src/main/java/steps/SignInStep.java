package steps;

import net.thucydides.core.util.EnvironmentVariables;
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

}
