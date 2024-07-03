package utilities;

import net.serenitybdd.core.exceptions.TestCompromisedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ExceptionsProyecto {

    private ExceptionsProyecto() {}
    private static final String ELEMENT_CLICK_INTERCEPTED_COMENTARIO = "No se pudo clickear el elemento porque estaba oculto  ";
    private static final String ELEMENT_NOT_SELECTABLE_COMENTARIO = "El elemento está deshabilitado, no se puede hacer clic o seleccionar  ";
    private static final String ELEMENT_NOT_VISIBLE_COMENTARIO = "El elemento no es visible y, por lo tanto, no se puede interactuar con él.  ";
    private static final String ELEMENT_NOT_INTERACTABLE_COMENTARIO = "El elemento estaba presente pero se encuentra en un estado en el que no se puede interactuar con el  ";
    private static final String INVALID_ELEMENT_STATE_COMENTARIO = "El elemento está oculto por otro elemento o no es visible en la ventana actual  ";
    private static final String STATE_ELEMENT_REFERENCE_COMENTARIO = "El elemento pertenece a un frame diferente al actual  ";
    private static final String TIME_OUT_COMENTARIO = "El elemento no se mostró en el tiempo establecido  ";
    private static final String SCRIPT_TIMEOUT_EXCEPTION_COMENTARIO = "El comando no se pudo ejecutar en el tiempo establecido ";
    private static final String NO_SUNCH_FRAME_COMENTARIO = "Se presentó un problema al intentar cambiar de frame";
    private static final String NO_SUCH_ELEMENT = "El webdriver no pudo determinar el elemento durante el tiempo de ejecución ";
    private static final String NO_ALERT_PRESENT_EXCEPTION_COMENTARIO = "Se esta intentando acceder a una alerta que no se encuentra disponible";
    private static final String ELEMENT_SHOULD_BE_ENABLED_EXCEPTION = "El elemento debería estar habilitado para poder interactuar con el";

    private static final String SQL_SERVER_EXCEPTION_COMENTARIO = "Se presentó un error en la conexión con la base de datos";

    private static final String COD_400 = "Solicitud incorrecta";
    private static final String COD_401 = "No autorizado";
    private static final String COD_403 = "Sin permisos";
    private static final String COD_404 = "No encontro contenido";
    private static final String COD_409 = "Conflicto";
    private static final String COD_500 = "Error de servidor interno";
    private static final String COD_503 = "Servicio no disponible";

    private static final String STR_ASSERTIONERROR= "AssertionError";
    private static final String STR_NULLPOINTEREXCEPTION= "NullPointerException";
    private static final String MENSAJE_ERROR_POR_CONSULTA_ARRAY =", dado que se está intentando consultar un parámetro está fuera de rango en un arreglo o lista ";
    private static final String STR_MENSAJE_EXEPCION_NO_ENCONTRADA = " estatus no detectado contactar con el Automatizador ";
    private static final String STR_TIPO_EXCEPTION_RUNTIMEEXCEPTION = "Tipo_Exepction_RunTimeExecption";
    private static final String STR_ELEMENT_CLICK_INTERCEPTED_EXCEPTION = "ElementClickInterceptedException";
    private static final String STR_ELEMENT_NOT_SELECTABLE_EXCEPTION = "ElementNotSelectableException";
    private static final String STR_ELEMENT_NOT_VISIBLE_EXCEPTION = "ElementNotVisibleException";
    private static final String STR_ELEMENT_NOT_INTERACTABLE_EXCEPTION = "ElementNotInteractableException";
    private static final String STR_INVALID_STATE_EXCEPTION = "InvalidElementStateException";
    private static final String STR_STALE_ELEMENT_REFERENCE_EXCEPTION = "StaleElementReferenceException";
    private static final String STR_TIMEOUT_EXCEPTION = "TimeoutException";
    private static final String STR_SCRIPT_TIMEOUT_EXCEPTION = "ScriptTimeoutException";
    private static final String STR_NO_SUCH_FRAME_EXCEPTION = "NoSuchFrameException";
    private static final String STR_NO_SUCH_ELEMENT_EXCEPTION = "NoSuchElementException";
    private static final String STR_NO_ALERT_PRESENT_EXCEPTION = "NoAlertPresentException";
    private static final String STR_ELEMENT_SHOULD_BE_ENABLED_EXCEPTION = "ElementShouldBeEnabledException";
    private static final String STR_PARSER_CONFIGURATION_EXCEPTION = "ParserConfigurationException";
    private static final String STR_FACTORY_CONFIGURATION_ERROR = "FactoryConfigurationError";
    private static final String STR_SAX_EXCEPTION = "SAXException";
    private static final String STR_SAX_PARSE_EXCEPTION = "SAXParseException";
    private static final String STR_IO_EXCEPTION = "IOException";
    private static final String STR_FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException";
    private static final String STR_DOCUMENT_EXCEPTION = "DocumentException";
    private static final String STR_INDEX_OUT_OF_BOUNDS_EXCEPTION = "IndexOutOfBoundsException";
    private static final String STR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION = "ArrayIndexOutOfBoundsException";
    private static final String STR_CLASS_CAST_EXCEPTION = "ClassCastException";
    private static final String STR_RUN_TIME_EXCEPTION = "RuntimeException";
    private static final String STR_TEST_COMPROMISED_EXCEPTION = "TestCompromisedException";
    private static final Logger logger = LoggerFactory.getLogger(ExceptionsProyecto.class);


    public static void validaExcepcion(String strExcepcion) {
        switch(strExcepcion) {
            case  STR_ELEMENT_CLICK_INTERCEPTED_EXCEPTION:
                lanzarExcepcion(ELEMENT_CLICK_INTERCEPTED_COMENTARIO);
                break;
            case STR_ELEMENT_NOT_SELECTABLE_EXCEPTION:
                lanzarExcepcion(ELEMENT_NOT_SELECTABLE_COMENTARIO);
                break;
            case STR_ELEMENT_NOT_VISIBLE_EXCEPTION:
                lanzarExcepcion(ELEMENT_NOT_VISIBLE_COMENTARIO);
                break;
            case STR_ELEMENT_NOT_INTERACTABLE_EXCEPTION:
                lanzarExcepcion(ELEMENT_NOT_INTERACTABLE_COMENTARIO);
                break;
            case STR_INVALID_STATE_EXCEPTION:
                lanzarExcepcion(INVALID_ELEMENT_STATE_COMENTARIO);
                break;
            case STR_STALE_ELEMENT_REFERENCE_EXCEPTION:
                lanzarExcepcion(STATE_ELEMENT_REFERENCE_COMENTARIO);
                break;
            case STR_TIMEOUT_EXCEPTION:
                lanzarExcepcion(TIME_OUT_COMENTARIO);
                break;
            case STR_SCRIPT_TIMEOUT_EXCEPTION:
                lanzarExcepcion(SCRIPT_TIMEOUT_EXCEPTION_COMENTARIO);
                break;
            case STR_NO_SUCH_FRAME_EXCEPTION:
                lanzarExcepcion(NO_SUNCH_FRAME_COMENTARIO);
                break;
            case STR_NO_SUCH_ELEMENT_EXCEPTION:
                lanzarExcepcion(NO_SUCH_ELEMENT);
                break;
            case STR_NO_ALERT_PRESENT_EXCEPTION:
                lanzarExcepcion(NO_ALERT_PRESENT_EXCEPTION_COMENTARIO);
                break;
            case STR_ELEMENT_SHOULD_BE_ENABLED_EXCEPTION:
                lanzarExcepcion(ELEMENT_SHOULD_BE_ENABLED_EXCEPTION);
                break;
            default:
                fail(strExcepcion + " Se presento un problema inesperado");
                break;
        }
    }

    public static void lanzarExcepcion(String strMensaje) {
        fail(strMensaje);
    }

    /**
     * Metodo el cual valida una condicion
     * @param strMensaje mensaje de la condicion
     * @param condicion
     */
    public static void validaLaCondicion(String strMensaje,Boolean condicion) {
        assertTrue(strMensaje, condicion);
    }

    /**
     * Método que valida que los servicios respondan OK
     * @param strURL URL del servicio
     * @param tipodeServicio PST GET PUT DELET ..
     * @param intStatusResponse  el status del Servicio
     * @param condicion comparación  de status
     */
    public static void validarEnElServicioElResponseOK(String strURL,String tipodeServicio, int intStatusResponse, Boolean condicion) {
        assertTrue("Para el servicio "+tipodeServicio+" con la url "+ strURL+" se esperaba un <200> pero la respuesta fue <"
                +intStatusResponse+">"+" ("+tiposEstadosServicios(intStatusResponse)+")" , condicion);
    }

    private static String  tiposEstadosServicios(int response) {
        String strMensaje = "";
        switch (response) {
            case 400:
                strMensaje = COD_400;
                break;
            case 401:
                strMensaje = COD_401;
                break;
            case 403:
                strMensaje = COD_403;
                break;
            case 404:
                strMensaje = COD_404;
                break;
            case 409:
                strMensaje = COD_409;
                break;
            case 500:
                strMensaje = COD_500;
                break;
            case 503:
                strMensaje = COD_503;
                break;
            default:
                strMensaje = STR_MENSAJE_EXEPCION_NO_ENCONTRADA;
                break;
        }
        return strMensaje;
    }

    public static void excepcionBD(String strExcepcion) {
        if(strExcepcion.equals("SQLServerException")) {
            lanzarExcepcion(SQL_SERVER_EXCEPTION_COMENTARIO);
        }else {
            fail(strExcepcion + " Se presento un problema inesperado con la base de datos");
        }
    }


    public static void excepcionCunsultaDataServiciosSoaP(String error, String tipoError,String mensajeExcepcion) {


        switch (tipoError) {
            case STR_ASSERTIONERROR:
                lanzarExcepcion(error);
                break;
            case STR_PARSER_CONFIGURATION_EXCEPTION:
                lanzarExcepcion("Problemas en la lectura del xml  por el DocumentBuilderFactory, el mensaje del método es:   "+error);
                break;
            case STR_FACTORY_CONFIGURATION_ERROR:
                lanzarExcepcion("Problemas en la lectura del xml por el Factory, el mensaje del método es:   "+error);
                break;
            case STR_NULLPOINTEREXCEPTION:
                lanzarExcepcion(error+"dado se está intentando consultar un parámetro que no está o tiene otro nombre \n  el mensaje de la excepción,"+tipoError+": "+mensajeExcepcion);
                break;
            case STR_SAX_EXCEPTION:
                lanzarExcepcion("Problemas en la lectura del xml por eso"+error + "\n  el mensaje de la excepción,"+mensajeExcepcion);
                break;
            case STR_SAX_PARSE_EXCEPTION:
                lanzarExcepcion("Problemas en la lectura del xml por tal motivo"+error +"\n  el mensaje de la excepción,"+mensajeExcepcion);
                break;
            case STR_IO_EXCEPTION:
                lanzarExcepcion(error+" dado que no  encontro un archivo \n  el mensaje de la excepción"+tipoError+" :"+mensajeExcepcion);
                break;
            case STR_FILE_NOT_FOUND_EXCEPTION:
                lanzarExcepcion(error+" se está intentando un archivo no encontrado \n  el mensaje de la excepción,"+tipoError+" :"+mensajeExcepcion);
                break;
            case STR_DOCUMENT_EXCEPTION:
                lanzarExcepcion(error+"\n el mensaje de la excepción,"+tipoError+" :"+mensajeExcepcion);

                break;
            default:
                lanzarExcepcion(error+"\n"+STR_MENSAJE_EXEPCION_NO_ENCONTRADA+tipoError+" "+mensajeExcepcion);

                break;
        }
    }

    public static void excepcionCunsultaDataServiciosJson(String error, String tipoError,String mensajeExcepcion) {

        switch (tipoError) {
            case STR_ASSERTIONERROR:
                lanzarExcepcion(error);
                break;
            case STR_INDEX_OUT_OF_BOUNDS_EXCEPTION:
                lanzarExcepcion(error+MENSAJE_ERROR_POR_CONSULTA_ARRAY);
                break;
            case STR_NULLPOINTEREXCEPTION:
                lanzarExcepcion(error+"dado se está intentando consultar un parámetro que no está o tiene otro nombre \n  el mensaje de la excepción,"+tipoError+": "+mensajeExcepcion);
                break;
            case STR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION:
                lanzarExcepcion(error+MENSAJE_ERROR_POR_CONSULTA_ARRAY);
                break;
            case STR_CLASS_CAST_EXCEPTION:
                lanzarExcepcion(error+" se está intentando consultar un parámetro en la respues que es otro tipo Json \n  el mensaje de la excepción"+tipoError+" :"+mensajeExcepcion);
                break;
            case STR_RUN_TIME_EXCEPTION:
                lanzarExcepcion("Problemas con la ejecucion de servicio " + error);
                break;
            case STR_TIPO_EXCEPTION_RUNTIMEEXCEPTION:
                if(error.contains("sesamo"))
                    excepcionComprometidoServicios("Problemas con la ejecución de servicio "+error);
                else
                    lanzarExcepcion("Problemas con la ejecución de servicio " + error);
                break;
            case STR_TEST_COMPROMISED_EXCEPTION:
                excepcionComprometidoServicios(mensajeExcepcion);
                break;
            default:
                lanzarExcepcion(error+"\n"+STR_MENSAJE_EXEPCION_NO_ENCONTRADA+tipoError+" "+mensajeExcepcion);

                break;
        }
    }


    /**
     * Método que muestra el mensaje de fallo por data y genera el fallo en estado compromised
     * @param message de la razon del fallo
     */
    public static void excepcionComprometidoServicios(String message) {
        logger.error(message);
        throw new TestCompromisedException(message);
    }

    public static void validarConexionSesamoOK(String strURL,String tipodeServicio, int intStatusResponse, Boolean condicion) {
        if(Boolean.FALSE.equals(condicion)) {
            throw new TestCompromisedException("Para el servicio "+tipodeServicio+" con la url "+ strURL+" se esperaba un <200> pero la respuesta fue <"
                    +intStatusResponse+">"+" ("+tiposEstadosServicios(intStatusResponse)+")");
        }
    }


}
