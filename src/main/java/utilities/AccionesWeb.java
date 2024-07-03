package utilities;



import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AccionesWeb extends PageObject {
    private Logger logger = LoggerFactory.getLogger(AccionesWeb.class);
    private static Map<String, String> mapDatosCasoPrueba = new LinkedHashMap<>();
    private static final String IGNORE = "<IGNORE>";
    private static  String mensaje="SE REALIZO ESPERA DE UN ELEMENTO";
    private static String detalleError="Detalle Error";

    /**
     * Metodo para escribir Texto
     *
     * @param element  elemento a escribir
     * @param strTexto texto que se va a escribir
     * @throws Exception Ultima modificación: jherrerar
     */
    public void escribirTexto(By element, String strTexto) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            input.clear();
            input.type(strTexto);
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport("Detalle Error",String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
    }
    public void abrirPaginaConURL(String url) {
        getDriver().get(url);
    }



    /**
     * Metodo para cambiar de ventana de trabajo
     *
     * @param numPagina numero al que corresponde la ventana en la
     * que se desea trabajar
     */
    public void cambiarVentana(int numPagina) {
        ArrayList<String> ventanas = new ArrayList<>(getDriver().getWindowHandles());
        try {
            getDriver().switchTo().window(ventanas.get(numPagina));
        } catch (Exception e) {
            logger.error("Se presento un problema al cambiar de ventana");
        }
    }

    /**
     * Metodo para escribir Texto
     *
     * @param element  elemento a escribir
     * @param strTexto texto que se va a escribir
     */
    public void escribirTextoSendKeys(By element, String strTexto) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            input.sendKeys(strTexto);
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
    }

    public void seleccionarOpcionLista(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            input.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
    }

    public void seleccionarOpcionListaARROW(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            esperaTiempoSegundos(3);
            input.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para escribir texto por medio de JavaScript
     * @param webLocalizador elemento a escribir
     * @param strTexto texto que se va a escribir
     * @author cardilar
     * @since 02/05/2022
     */
    public void escribirConJavaScript(By webLocalizador, String strTexto) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + strTexto +"'",
                    element(webLocalizador));
        }catch(Exception e) {
            logger.error("en la clase AccionesWeb en el metodo escribirConJavaScript " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para hacer click por medio de JavaScript
     * @param webLocalizador elemento a escribir
     * @author cardilar
     * @since 12/05/2023
     */
    public void clickConJavaScript(By webLocalizador) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click(true);",
                    element(webLocalizador));
        }catch(Exception e) {
            logger.error("en la clase AccionesWeb en el metodo escribirConJavaScript " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * metodo que limpia el campo
     *
     * @param element elemento a limpiar
     */
    public void limpiarCampo(By element) {
        try {
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            input.clear();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo limpiarCampo " + e);
            excepcionAccionesWeb(e);
        }
    }


    /**
     * Metodo para der click a un boton
     *
     * @param strBoton el elemento a interactuar
     * @throws Exception Ultima modificación: jherrerar
     */
    public void clickBoton(By strBoton) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.elementToBeClickable(strBoton));
            element(strBoton).click();
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(strBoton)+e);
            excepcionAccionesWeb(e);
        }
    }

    public boolean boclickBoton(By strBoton) {
        boolean boo =true;
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.elementToBeClickable(strBoton));
            element(strBoton).click();
            boo =false;
        } catch (Exception e) {
            actualizarPagina();
            esperaCargarPagina();
        }
        return boo;
    }

    /**
     * Metodo de cambio de frame segun el numero del frame
     *
     * @param frame numero del frame
     */
    public void cambioDeFrame(int frame) {
        try {
            getDriver().switchTo().frame(frame);
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo cambioDeFrame" + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para obtener el numero de frame de la pagina
     * @return Retorna el numero de frames encontrados
     */
    public int obtenerNumFrames() {
        editaTiempoImplicito(5);
        try {
            WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            espera.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        } catch (Exception e) {
            logger.error("No se encontraron iframes");
        }
        int intNumFrames = getDriver().findElements(By.tagName("iframe")).size();
        restauraTiempoImplicitoPorDefecto();
        return intNumFrames;
    }

    /**
     * Metodo de cambio de frame al de defecto
     */
    public void cambioDeFrameDefault() {
        try {
            getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo cambioDeFrameDefault " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Espera a que carge todos los objetos de la pagina
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
     * Metodo encargado de abrir la url
     *
     * @param strURL elemento de tipo String la cual pueder ser es una IP o URL para
     *               abrirla en el navegador
     */
    public void abrirURL(String strURL) {
        openAt(strURL);
        getDriver().manage().deleteAllCookies();
    }

    /**
     * Metodo de esperar tiempo en segundos
     *
     * @param tiempo
     */
    public void esperaTiempoSegundos(int tiempo) {
        mostrarInformacionEnSerenityReport("Tiempo","Se esta realizando una espera de "+tiempo+" segundos");
        waitFor(tiempo).seconds();
    }

    /**
     * Metodo que espera a que desaparezca el elemento
     *
     * @param element elemento de tipo by el cual se espera que desaparezca
     */
    public void esperaDesaparezcaElemento(By element) {
        logger.info(mensaje);
        logger.info("Elemento que se valida que desaparezca: " + element);
        cuerpo(element, 8);
        logger.info("Elemento desaparecio de pantalla: " + element);
    }

    public void esperaDesaparezcaElemento(By element,int tiempo) {
        logger.info(mensaje);
        logger.info("Elemento que se valida que desaparezca: " + element);
        cuerpo(element, tiempo);
        logger.info("Elemento desaparecio de pantalla: " + element);
    }

    private void cuerpo(By element,int tiempo) {
        int contador = 0;
        boolean booBandera = true;
        do {
            try {
                editaTiempoImplicito(1);
                WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(tiempo));
                espera.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(element)));
                List<WebElement> numElement = getDriver().findElements(element);
                restauraTiempoImplicitoPorDefecto();
                if (numElement.size() > 0) {
                    booBandera = true;
                } else {
                    booBandera = false;
                }
            } catch (Exception e) {
                restauraTiempoImplicitoPorDefecto();
                logger.info("Clase : AccionesWeb, Metodo: esperaDesaparezcaElemento");
            }
            logger.info("Elemento todavía visible");
            contador++;
        } while ((booBandera) && (contador <= 100));
    }


    /**
     * Este metodo espera a que un elemento este visible
     *
     * @param xpath elemento que se requiere esperar a que sea visible
     * @return retorna true o false si el elemento esta o no visible
     */
    public boolean esperoElementoVisible(By xpath,int tiempo) {
        try {
            logger.info(mensaje);
            WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(tiempo));
            espera.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            if (element(xpath).isVisible()) {
                return true;
            }
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(xpath)+e);
        }
        return false;
    }

    /**
     *
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
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(xpath)+e);
        }
        return false;
    }

    public boolean elemetoClikeable(By xpath){
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
     * Este metodo espera a que un elemento este Habilitado * @param xpath elemento
     * que se requiere esperar a que sea visible
     *
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
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(xpath)+e);
        }
        return false;
    }

    /**
     * Este metodo espera a que un elemento haya sido seleccionado
     *
     * @param xpath elemento que se requiere esperar a que sea visible
     * @return retorna true o false si el elemento esta o no presente
     */
    public boolean esperoElementoPresente(By xpath) {
        esperaCargarPagina();
        try {
            logger.info(mensaje);
            WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            espera.until(ExpectedConditions.presenceOfElementLocated(xpath));
            if (element(xpath).isPresent()) {
                return true;
            }
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(xpath)+e);
        }
        return false;
    }

    /**
     * Metodo que se le da click a un elemento de una lista de elementos dependiendo
     * del texto de este
     *
     * @param xpath lista de objetos
     * @param dato  texto que contiene el objeto
     */
    public void clickElementoLista(By xpath, String dato) {
        try {
            Boolean encontreoElemento = false;
            List<WebElementFacade> elemetos = findAll(xpath);
            for (int i = 0; i < elemetos.size(); i++) {
                if (elemetos.get(i).getText().contains(dato)) {
                    elemetos.get(i).click();
                    encontreoElemento = true;
                    break;
                }
            }
            if (Boolean.FALSE.equals(encontreoElemento)) {
                fail("No se encontró el elemento de la lista que contiene el texto: " + dato);
            }
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo clickElementoLista " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo que cuenta los elementos de una lista y genera un numero aleatorio
     * dependiendo de la cantidad de lineas encontradas y seleccionar un dato
     *
     * @param xpath lista de objetos
     */
    public void contarClickElementoLista(By xpath) {
        try {
            List<WebElement> elemetos = getDriver().findElements(xpath);
            int tam = elemetos.size();
            SecureRandom random = new SecureRandom();
            Integer dato = random.nextInt(tam);
            elemetos.get(dato).click();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo contarClickElementoLista " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo que cuenta los elementos de una lista y genera un numero aleatorio
     * dependiendo de la cantidad de lineas encontradas y seleccionar un dato
     *
     * @param xpath lista de objetos
     */
    public String contarElementoLista(By xpath) {
        try {
            List<WebElement> elementos = getDriver().findElements(xpath);

            return String.valueOf(elementos.size());
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo contarClickElementoLista " + e);
            excepcionAccionesWeb(e);
            return null;
        }
    }

    /**
     * Metodo para resaltar el elemento enviado como parametro
     *
     * @param webLocalizador elemento a resaltar oguzmans 27/10/2021
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
     * Metodo para resaltar el elemento enviado como parametro con la opción de
     * indicar el color del background y el elemento
     *
     * @param webLocalizador elemento
     * @param colorFondo          background oguzmans 27/10/2021
     */
    public void bordearElemento(By webLocalizador, String colorFondo) {
        try {

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'",
                    element(webLocalizador));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background= '" + colorFondo + "'",
                    element(webLocalizador));
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para desplazarse hasta el elemento relacionado
     *
     * @param strWebElement localizador tipo WebElement al que se desea
     * desplazarse
     */
    public void posicionarElementoweb(WebElement strWebElement) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", strWebElement);
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
     * Metodo para esperar a que aparezca un posible elemento, como por ejemplo un
     * PopUp
     *
     * @param elemento elemento ser esperado
     */
    public void clickPosibleElemento(By elemento) {
        try {
            WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            espera.until(ExpectedConditions.elementToBeClickable(elemento));
            element(elemento).click();
        } catch (Exception e) {
            logger.info("No aparecio posibe para click: " + elemento.toString());
        }

    }

    /**
     * Metodo de posicionar Elemento,
     *
     * @param element
     */
    public void posicionarElementoScroll(By element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);",
                    element(element));
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo de posicionar Elemento,
     *
     * @param element
     */
    public void posicionarElementoScrolls(By element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);",
                    element(element));
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo de posicionar el scroll en un punto especifico
     *
     * @param x
     * @param y
     */
    public void desplazarScroll(String x, String y) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    /**
     * Posiciona el Scroll en la parte superior del aplicativo
     */
    public void desplazarScrollArriba() {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo desplazarScrollArriba " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo que selecciona una opcion de un select
     *
     * @param select
     * @param stgOpcion
     */
    public void seleccionarOpcion(By select, String stgOpcion) {
        try {
            WebElementFacade dropbox = element(select);
            dropbox.selectByVisibleText(stgOpcion);
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo seleccionarOpcion" + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo que en un elemento se oprime una keyboard
     *
     * @param element que al que se le realiza la accion
     * @param strTexto tipo de keyboar que se necesita
     */
    public void keyboaraAElemento(By element, String strTexto) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            WebElementFacade input = element(element);
            waitFor(input).isEnabled();
            switch (strTexto) {
                case "Keys.UP":
                    input.sendKeys(Keys.LEFT);
                    break;
                case "Keys.ENTER":
                    input.sendKeys(Keys.ENTER);
                    break;
                case "Keys.ESPACIO":
                    input.sendKeys(Keys.SPACE);
                    break;
                case "Keys.TAB":
                    input.sendKeys(Keys.TAB);
                    break;
                case "Keys.DELETE":
                    input.sendKeys(Keys.DELETE);
                    break;
                case "Keys.CONTROL":
                    input.sendKeys(Keys.CONTROL+"A");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo keyboaraAElemento " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Método de una aserción el cual valida que 2 textos no son iguales
     *
     * @param mensaje        que aparece si la comparacion es igual
     * @param textoaComparar texto a comprar
     * @param elemet         elemeto que se le extrae el texto
     */
    public void validarTextoDeUnElemetoNoEsigual(String mensaje, String textoaComparar, By elemet) {

        String textoElemet = element(elemet).getTextValue();
        Serenity.takeScreenshot();
        assertNotEquals(mensaje, textoaComparar, textoElemet);
    }

    /**
     * Metodo para obtener el valor Value del localizador
     *
     * @param strValue lozalizador de tipo String al cual se desea obtener el valor
     * correspondiente dentro de este
     *
     * @return Retorna el valor obtenido
     */
    public static String getValue(String strValue) {
        String strDato = "";
        try {
            strDato = mapDatosCasoPrueba.get(strValue);
            return strDato;
        } catch (Exception e) {

            fail("Error: en la clase AccionesWev, en el metodo getValue:" + e);
        }
        return strDato;
    }

    /**
     * Metodo que escribe una observación para el proceso de agendamiento
     *
     * @param element lista de objetos
     * @param dato  texto que contiene el objeto
     */
    public void escribirObservacionAgendamiento(Boolean dato, By element) {
        try {
            if (Boolean.TRUE.equals(dato) && !getValue("observacion_agenda").equalsIgnoreCase(IGNORE)) {
                WebElementFacade dropbox = element(element);
                waitFor(dropbox).sendKeys(getValue("observacion_agenda"));
            }
        } catch (Exception e) {
            logger.error(
                    "ERROR: en la clase CapturaPospagoNuevoPageObject, en el metodo escribirObservacionAgendamiento");
            fail("ERROR: en la clase CapturaPospagoNuevoPageObject, en el metodo escribirObservacionAgendamiento: "
                    + e);
        }
    }

    /**
     * Método de una aserción la cual valida que con
     *
     * @param elemet
     * @param textoaComparar
     */
    public void validarTextoDeUnElemetoContieneTexto(By elemet, String textoaComparar) {
        String textoElemet = "";
        try {
            textoElemet = element(elemet).getText();
            Serenity.takeScreenshot();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemetoContieneTexto " + e);
            excepcionAccionesWeb(e);
        }
        assertTrue(textoElemet, containsText(textoaComparar));
    }

    /**
     * Método de una aserción la cual valida que el elemeto contenga un texto
     *
     * @param mensaje
     * @param elemet
     * @param textoaComparar
     */
    public void validarTextoDeUnElemetoContieneTexto(By elemet, String textoaComparar, String mensaje) {
        String textoElemet = "";
        try {
            textoElemet = element(elemet).getText();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemetoContieneTexto " + e);
            excepcionAccionesWeb(e);
        }
        Serenity.takeScreenshot();
        assertTrue(mensaje, textoElemet.contains(textoaComparar));
    }

    /**
     * Método de una aserción la cual valida que el elemeto contenga un texto
     *
     * @param mensaje
     * @param textoOriginal
     * @param textoaComparar
     */
    public void validarDosTextos(String mensaje, String textoOriginal, String textoaComparar) {

        assertTrue(mensaje, textoOriginal.contains(textoaComparar));
    }

    /**
     * Método de una aserción la cual valida que el elemento este visible
     *
     * @param mensaje
     * @param elemet
     */
    public void validarElementoEsteVisible(By elemet, String mensaje) {
        Serenity.takeScreenshot();
        assertTrue(mensaje, element(elemet).isCurrentlyVisible());
    }

    /**
     * Metodo diseñado para extraer el texto de un elemento
     *
     * @param element elemento al que se requiere extraerle el texto
     * @return retorna el texto extraido del elemento
     */
    public String extraerTextodeLabel(By element) {
        try {
            if (element(element).isCurrentlyEnabled()) {
                WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
                wait.until(ExpectedConditions.elementToBeClickable(element));
                return element(element).getText().toString();
            }
            return "";
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
        return null;
    }

    /**
     * Metodo diseñado para extraer el texto de un elemento, sin validar si el elemento esta habilitado
     *
     * @param element elemento al que se requiere extraerle el texto
     * @return retorna el texto extraido del elemento
     */
    public String extraerTextodeLabelSinValidarCampoHabilitado(By element) {
        try {
            if (element(element).isCurrentlyVisible()) {
                WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
                wait.until(ExpectedConditions.presenceOfElementLocated(element));
                return element(element).getText().toString();
            }
            return "";
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo extraerTextodeLabel " + e);
            excepcionAccionesWeb(e);
        }
        return null;
    }

    /**
     * Metodo diseñado para extraer el value de un elemento
     *
     * @param element elemento al que se requiere extraerle el texto
     * @return retorna el texto extraido del elemento
     */
    public String extraerValuedeLabel(By element) {
        try {
            if (element(element).isCurrentlyVisible() && element(element).isCurrentlyEnabled()) {
                WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
                wait.until(ExpectedConditions.elementToBeClickable(element));
                return element(element).getTextValue().toString();
            }
            return "";
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
        return null;
    }

    /**
     * Metodo diseñado para extraer el value de un elemento sin validar que este
     * habilitado
     *
     * @param element elemento al que se requiere extraerle el texto
     * @return retorna el texto extraido del elemento
     */
    public String extraerValuedelElemento(By element) {
        try {
            if (element(element).isCurrentlyVisible()) {
                WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                return element(element).getValue().toString();
            }
            return "";
        } catch (Exception e) {
            mostrarInformacionEnSerenityReport(detalleError,String.valueOf(element)+e);
            excepcionAccionesWeb(e);
        }
        return null;
    }

    /**
     * Metodo alternativo para extraer el value de un elemento
     *
     * @param element elemento al que se quiere extraer el texto
     * @return retorna el value extraido del elemento
     */
    public String obtenerValorXpath(By element) {
        try {
            waitForRenderedElementsToBePresent(element);
            String strValor = "";
            strValor = find(element).getValue();
            return strValor;
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo obtenerValorXpath " + e);
            excepcionAccionesWeb(e);
        }
        return null;
    }

    /**
     * Método que toma evidencia y genera el fallo
     *
     * @param mensaje de la razon del fallo
     */
    public void tomarEvidenciaFallo(String mensaje) {
        tomarEvidencia();
        logger.error(mensaje);
    }

    /**
     * Metodo que confirma si un elemento esta habilitado retornando un true o un
     * false si no lo esta
     *
     * @param element elemento a confirmar
     * @return si el elemento esta habilitado devuelve un true, de lo contrario un
     *         false
     */
    public boolean confirmarElementoHabilitado(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element(element).isEnabled())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean confirmarElementoNoHabilitado(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
            if (!element(element).isEnabled())
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Metodo diseñado para saber la cantidad de elementos existentes por un xpath
     * general
     *
     * @param elementXpath ruta del xpath general
     * @return retorna el numero de elementos
     */
    public int obtenerCantidadDeElementosPorXpath(By elementXpath) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementXpath));
            List<WebElement> elementos = getDriver().findElements(elementXpath);
            return elementos.size();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo obtenerCantidadDeElementosPorXpath" + e);
            excepcionAccionesWeb(e);
            return 0;
        }
    }

    /**
     * Metodo para poder usar el logger desde cualquier clase que instancie
     * AccionesWeb
     *
     * @return retorna el objeto Logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Metodo que confirma si un elemento esta seleccionado retornando un true o un
     * false si no lo esta
     *
     * @param element elemento a confirmar
     * @return si el elemento esta seleccionado devuelve un true, de lo contrario un
     *         false
     */
    public boolean confirmarElementoSeleccionado(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
            wait.until(ExpectedConditions.elementToBeSelected(element));
            if (element(element).isSelected())
                return true;
        } catch (Exception e) {
            logger.info("en la clase AccionesWeb en el metodo confirmarElementoSeleccionado" + e);
        }
        return false;
    }

    /**
     * Metodo que selecciona una opcion de un select con un index
     *
     * @param select    el elemento a seleccionar
     * @param stgOpcion el numero de la opcion
     */
    public void seleccionarOpcionIndex(By select, int stgOpcion) {
        try {
            WebElementFacade dropbox = element(select);
            dropbox.selectByIndex(stgOpcion);
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo seleccionarOpcionIndex " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo que se le da click a un elemento de un dropdown que contenga parte de
     * un texto
     *
     * @param xpath select de los objetos a dar click
     * @param dato  texto que contiene el objeto
     */
    public void seleccionaOpcionContengaTexto(By xpath, String dato) {
        try {
            List<String> elemetos = element(xpath).getSelectOptions();
            for (int i = 0; i < elemetos.size(); i++) {
                if (elemetos.get(i).contains(dato)) {
                    element(xpath).selectByIndex(i);
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo seleccionaOpcionContangaTexto " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo diseñado para dar click a un ckecBox
     *
     * @param xpath direccion del elemento a dar click
     */
    public void darClickCheckBox(By xpath) {
        try {
            esperoElementoVisible(xpath);
            element(xpath).click();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo darClickCheckBox " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo diseñado para validar un elemento
     *
     * @param bandera este es el parametro que recibe el metodo de acuerdo al
     *                elemento
     */
    public void validarElemento(boolean bandera) {
        tomarEvidencia();
        assertTrue(bandera);
    }

    /**
     * Metodo que edita el tiempo implisito predeterminado
     *
     * @param intTime tiempo
     */
    public void editaTiempoImplicito(int intTime) {
        setImplicitTimeout(intTime, ChronoUnit.SECONDS);
    }

    /**
     * restaura el tiempo cambiado con el metodo editaTiempoImplicito
     */
    public void restauraTiempoImplicitoPorDefecto() {
        resetImplicitTimeout();
    }

    /**
     * Metodo diseñado para actualizar la pagina (simula un F5)
     */
    public void actualizarPagina() {
        try {
            getDriver().navigate().refresh();
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo actualizarPagina " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo diseñado para aceptar una alerta que contenga parte del mensaje
     * enviado
     *
     * @param strMensajeAcertado parte del mensaje de la alerta
     */
    public void aceptarAlertaPorMensaje(String strMensajeAcertado) {
        Alert alert;
        String mensajeTexto = "";
        WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            alert = getDriver().switchTo().alert();
            if (alert.getText().contains(strMensajeAcertado)) {
                alert.accept();
            } else {
                mensajeTexto = alert.getText();
                alert.dismiss();
                logger.error("Se presentó una alerta no esperada");
                fail("Se presentó una alerta no esperada: " + mensajeTexto);
            }
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo aceptarAlertaPorMensaje " + e);
            excepcionAccionesWeb(e);
        }
    }

    /**
     * Metodo para validar alertas del aplicativo
     * @return retorna TRUE si encuentra alerta o FALSE
     * lo contrario
     */
    public boolean validaAlerta() {
        boolean booBandera = false;
        WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            booBandera = true;
        } catch (TimeoutException eTO) {
            booBandera = false;
        }
        return booBandera;
    }

    /**
     * Metodo para maximizar pantalla
     *
     */
    public void maximizarPantalla() {
        getDriver().manage().window().maximize();
    }

    /**
     * Metodo para extraer el label del elemento de una lista
     *
     * @param xpath texto que se va a escribir
     */
    public String extraeLabelElementoDeUnaLista(By xpath, String[] dato) {
        try {
            List<WebElementFacade> elementos = findAll(xpath);
            for (int i = 0; i < elementos.size(); i++) {
                for (int j = 0; j < dato.length; j++) {
                    if (elementos.get(i).getText().contains(dato[j])) {
                        posicionarElementoweb(elementos.get(i));
                        return elementos.get(i).getText();
                    }
                }
            }
            return "";
        } catch (Exception e) {
            logger.error("en la clase AccionesWeb en el metodo extraeLabelElementoDeUnaLista " + e);
            excepcionAccionesWeb(e);
            return "";
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
     * @param e mensaje de error dado por Java
     */
    public void excepcionAccionesWeb(Exception e) {
        String[] strExcepcion = e.getClass().getCanonicalName().replace(".", "-").split("-");
        ExceptionsProyecto.validaExcepcion(strExcepcion[strExcepcion.length - 1]);
    }

    /**
     * Método que muestra la informacion en el serenity report
     *
     * @param strNombreDescripcion Titulo De la descripción
     * @param strDescrip           texto de la descripción
     */
    public void mostrarInformacionEnSerenityReport(String strNombreDescripcion, String strDescrip) {
        Serenity.recordReportData().withTitle(strNombreDescripcion).andContents(strDescrip);

    }

    /**
     * Metodo que da click y un keys up en el elemento
     *
     * @param xpathElemento elemento
     */
    public void clickYKeysUpElemento(By xpathElemento) {
        WebElementFacade btn = element(xpathElemento);
        Actions action = new Actions(getDriver());
        action.moveToElement(btn).click().sendKeys(Keys.UP).perform();

    }

    /**
     * Método que cierra la página actualmente abierta
     */
    public void cerrarPagina() {
        getDriver().close();

    }

    /**
     * Metodo que sirve para validar el checked de un elemento
     *
     * @param byElemento
     * @return
     */
    public boolean validarElementoSeleccionado(By byElemento) {
        boolean blnElemHabilitado = true;
        WebElementFacade webElemento = element(byElemento);
        webElemento.waitUntilClickable();
        String strDisable = webElemento.getAttribute("checked");
        if (!strDisable.equals("checked")) {
            blnElemHabilitado = false;
        }

        return blnElemHabilitado;
    }

    /**
     * Metodo para ingresar a un submenu
     *
     * @param byMenu localizador del menu donde se encuentra el submenu
     * @param bySubMenu localizador del submenu
     */
    public void clickOpcionSubMenu(By byMenu, By bySubMenu) {
        boolean booBandera = false;
        int intContador = 0;
        do {
            try {
                clickBoton(byMenu);
                clickBoton(bySubMenu);
                booBandera = true;
            } catch (Exception e) {
                logger.info("Problema al interactuar con el elemento " + e);
            }
            intContador++;
        } while ((!booBandera) && (intContador < 5));
    }

    /**
     * Metodo para obtener texto de un grupo de elementos localizadores
     *
     * @param byElements elemento de tipo by el cual obtienen los elementos
     * a obtener texto
     *
     * @return Retorna los textos correspondientes al localizador ingresado
     */
    public List<String> obtenerTextoGrupodeElementos(By byElements) {
        List<WebElement> objetos = new ArrayList<>(getDriver().findElements(byElements));
        List<String> datosObjetos = new ArrayList<>();
        for(int i = 0; i<objetos.size(); i++) {
            datosObjetos.add(objetos.get(i).getText());
        }
        return datosObjetos;
    }

    /**
     * Metodo para obtener el numero del campo de una tabla respecto al nombre de la columna
     * correspondiente
     * @param byEncabezado dato de tipo by en el cual se desee buscar el numero de la columna
     * @param nombreColumna dato de tipo String el cual es el nombre de la columna
     * @return Retorna en valor numero la posicion de la columna
     */
    public int obtieneNumCampoTabla(By byEncabezado, String nombreColumna) {

        List<WebElement> elementos = new ArrayList<>(getDriver().findElements(byEncabezado));
        String strTitulo = "";
        boolean booBandera = false;
        int numCampoFinal = 0;
        for(int i = 0; i < elementos.size()-2; i++) {
            strTitulo = elementos.get(i).getText();
            if(strTitulo.equalsIgnoreCase(nombreColumna)) {
                numCampoFinal = i+1;
                booBandera = true;
                break;
            }
        }

        if(!booBandera) {
            fail("No se encontró el campo del encabezado");
        }
        return numCampoFinal;

    }


}