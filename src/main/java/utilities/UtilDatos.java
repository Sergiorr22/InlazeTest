package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.fail;

public class UtilDatos {

    private UtilDatos() {
    }

    private static String[] arrayUrl = new String[10];

    /**
     * Método que lee un txt
     *
     * @return List<String> donde se almacena el contenido del archivo txt
     */
    public static List<String> leerDatosTxt(String path) {
        List<String> arrDatos = new ArrayList<>();
        try {
            File file = new File(path);
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    arrDatos.add(linea);
                }
            }
            return arrDatos;
        } catch (Exception e) {
            fail("Error en la clase: UtilDatos, y el metodo: leerDatosTxt, ERROR: " + e);
        }
        return arrDatos;
    }

    public static String organizarValor(String cadena) {
        return cadena.replaceAll("[!\\\"#$%&'()*+,-./:;<=>?@^_`{|}~]", "");

    }

    public static String[] obtenerUrl(String path) {
        String[] strPath;
        strPath = UtilDatos.consultarUrl(path);
        return strPath;

    }

    /**
     * Metodo para obtener las cerdenciales según el perfil, el mercado y ambiente
     * del archivo CredencialesPerfil.properties
     *
     * @param url
     * @return
     */
    public static String[] consultarUrl(String url) {
        String[] strCredencialesPerfil;
        strCredencialesPerfil = UtilDatos.obtenerConfigCredencialesPerfil(url, 1);
        return strCredencialesPerfil;

    }

    public static String[] obtenerConfigCredencialesPerfil(String strPalabraABuscar, int intCantidadLineas) {
        String[] strDatos = new String[intCantidadLineas];
        try {
            File file = new File("src/test/resources/archivos/Url.txt");
            int cantidadDato = 0;
            try (BufferedReader obj = new BufferedReader(new FileReader(file))) {
                String strLinea = "";
                while ((strLinea = obj.readLine()) != null) {
                    if (strLinea.contains(strPalabraABuscar)) {
                        int encontrarIgual = strLinea.indexOf("=");
                        strDatos[cantidadDato] = strLinea.substring(encontrarIgual + 1).trim();
                        cantidadDato++;
                        if (cantidadDato == intCantidadLineas) {
                            return strDatos;
                        }
                    }
                }
            }
        } catch (Exception e) {
            fail("Error en la clase: UtilDatos, y el metodo: obtenerConfigCredencialesPerfil, ERROR: " + e);
        }
        return arrayUrl;
    }

}
