package utilities;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.fail;

public class UtilDatosAleatorios {

    private UtilDatosAleatorios() {
    }

    private static final Logger logger = LoggerFactory.getLogger(UtilDatosAleatorios.class);

    /**
     * Método que obtiene un dato de manera aleatoria de un archivo txt
     *
     * @param path path donde se encuentra el archivo txt
     * @return String del dato aleatorio que se obtuvo del archivo txt
     */
    public static String obtenerDatoAleatorioTxt(String path) {
        try {
            List<String> arrDatosObtenido = UtilDatos.leerDatosTxt(path);
            Random rand = SecureRandom.getInstanceStrong();
            String datoAleatorio = arrDatosObtenido.get(rand.nextInt(arrDatosObtenido.size()));
            arrDatosObtenido.clear();
            return datoAleatorio;
        } catch (Exception e) {
            logger.error("ERROR: en la clase UtilDatosAleatorios, en el método obtenerDatoAleatorioTxt: " + e);
            fail("ERROR: en la clase UtilDatosAleatorios, en el método obtenerDatoAleatorioTxt: " + e);
        }
        return null;
    }

    /**
     * Método que selecciona un dato de manera aleatoria de un arreglo
     *
     * @param arrDatos arreglo de datos que se busca seleccionar uno
     * @return datoAleatorio que se obtuvo
     */
    public static String obtenerAleatorio(String[] arrDatos) {
        try {
            Random rand = SecureRandom.getInstanceStrong();
            String datoAleatorio = arrDatos[rand.nextInt(arrDatos.length)];
            logger.info("dato aleatorio: " + datoAleatorio);
            return datoAleatorio;
        } catch (Exception e) {
            logger.error("ERROR: en la clase AccionesWeb, en el metodo obtenerAleatorio: " + e);
            fail("ERROR: en la clase AccionesWeb, en el metodo obtenerAleatorio: " + e);
        }

        return null;
    }

    /**
     * Método que obtiene un DNI aleatorio
     *
     * @return int Cedula aleatorio que se obtuvo
     */
    public static int cedulaAleatorio(int min, int max) {
        SecureRandom random = new SecureRandom();
        int range = max - min + 1;
        return random.nextInt(range) + min;
    }

    /**
     * MEtodo para obtener numero de cliente aleatorio dependiendo del tipo de documento
     *
     * @return retorna documento del cliente
     */
    public static String obtenerClienteAleatorio() {
        String strCliente = "";
        try {
            strCliente = Integer.toString(UtilDatosAleatorios.cedulaAleatorio(41933000, 1094000000));
        } catch (Exception e) {
            logger.error("ERROR: en la clase Utilidades, en el metodo obtenerClienteAleatorio: " + e);
            fail("ERROR: en la clase Utilidades, en el metodo obtenerClienteAleatorio: " + e);
        }
        return strCliente;
    }

}
