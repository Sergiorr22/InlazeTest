package data;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.ArrayList;

public class Constantes {
    public static final String ACTOR = "CH";
    public static String URL = "https://app.x-celera.com/xcelera-api/api/";
    public static String ENDPOINT_AUTH = "auth";
    public static String ENDPOINT_EXECUTE_PLAN_EXECUTION = "v1/executions";
    public static String ENDPOINT_STATUS_PLAN_EXECUTION = "v1/execution-plans/*/executions/last-execution-report";
    public static String AUTH_JSON = "src/main/java/archivos/obtenerToken.json";
    public static String TESTEXECUTION_JSON = "src/main/java/archivos/testExecution.json";
    public static String PATH_JSON_AUTH = "Data.accessToken";
    public static String PATH_JSON_STATUS_EXECUTION = "Data.StatusExecution";
    public static String baseAzure = "https://dev.azure.com/organizacion/proyecto/_apis/test";
    public static String uriPuntos = "/plans/idTestPlan/suites/idTestSuite/points?testCaseId=IDTEST&api-version:5.0";
    public static final String URI_CREAR_TEST_RUN = "/runs?api-version=7.1-preview.3";
    public static String uriActualizarResultados = "/runs/REEMPLAZAR/results?api-version=7.1-preview.6";
    public static String uriActualizarTestRun = "/runs/REEMPLAZAR?api-version=7.2-preview";
    public static String uriSubirEvidencias = "/Runs/REEMPLAZAR/attachments?api-version=7.2-preview.1";
    public static String uriSubirEvidenciasPorCaso = "/Runs/REEMPLAZAR/results/NUMRESULTADO/attachments?api-version=7.2-preview";
    public static final String REEMPLAZAR = "REEMPLAZAR";
    public static final String HEADER_AUTHORIZATION = "Authorization:Basic ";
    public static final String HEADER_CONTENT_TYPE_JSON = ",Content-Type:application/json";
    public static final String RUTABASE = System.getProperty("user.dir");
    public static ArrayList<String> listaCasosEjecutados = new ArrayList();
    public static ArrayList<String> listaResultadosCasosEjecutados = new ArrayList();
    public static ArrayList<Integer> listaIdPuntosCasosEjecutados = new ArrayList();

    public Constantes() {
    }
}

