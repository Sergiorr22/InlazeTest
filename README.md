# Prueba tecnica de automatización con Selenium, Serenity BDD y POM

Este proyecto tiene como objetivo automatizar el proceso de pruebas de un sistema que permite registrar nuevos usuarios y loguear usuarios ya registrados en la plataforma, el cual puedes encontrar en https://test-qa.inlaze.com/.


## Tabla de Contenidos

- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Documentacion casos de prueba](#documentacion-casos-de-prueba)


## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/Sergiorr22/InlazeTest.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd tu-proyecto
    ```
3. Instala las dependencias del proyecto:
    ```bash
    ./gradlew clean build
    ```

Asegúrate de tener [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) y [Gradle](https://gradle.org/install/) instalados en tu máquina.


## Uso

Para ejecutar una prueba específica, usa el siguiente comando:

Donde se tienen diferentes tags:

@E2E = Ejecuta todos los casos de prueba

@SignUp = Ejecuta los casos de prueba del formulario de registro

@SignIn = Ejecuta los casos de prueba del formulario de ingreso

```bash
./gradlew clean test -Dcucumber.options="--tags @E2E"
```

O te puedes dirigir dentro del proyecto a la ruta:

src/test/java/runners/Runner.java

Y puedes ejecutar el runner utilizando los mismos tags


Ejemplo para ejecutar todas las pruebas
```bash
./gradlew clean test

```


#### Estructura del Proyecto

```markdown
## Estructura del Proyecto

.
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── data
│   │   │   │   └── Constantes.java
│   │   │   ├── definitions
│   │   │   │   ├── SignInDef.java
│   │   │   │   └── SignUpDef.java
│   │   │   ├── steps
│   │   │   │   ├── SignInStep.java
│   │   │   │   └── SignUpStep.java
│   │   │   ├── ui
│   │   │   │   ├── SignInUI.java
│   │   │   │   └── SignUpUI.java
│   │   │   ├── utilities
│   │   │   │   ├── AccionesWeb.java
│   │   │   │   ├── BeforeSuite.java
│   │   │   │   ├── Conversor.java
│   │   │   │   ├── DataToFeature.java
│   │   │   │   ├── Excel.java
│   │   │   │   ├── ExceptionsProyecto.java
│   │   │   │   ├── GenerarEvidenciasEnPDF.java
│   │   │   │   ├── GenerarEvidenciasSerenityEnPDF.java
│   │   │   │   ├── PlantillaBasePDF.java
│   │   │   │   ├── RandomUserDataGenerator.java
│   │   │   │   ├── ResultTest.java
│   │   │   │   ├── RunnerPersonalizado.java
│   │   │   │   ├── UtilDatos.java
│   │   │   │   └── UtilDatosAleatorios.java
│   │   ├── resources
│   │   │   └── driver
│   │   │       └── chromedriver.exe
│   └── test
│       ├── java
│       │   └── runners
│       │       └── Runner.java
│       └── resources
│           ├── archivos
│           │   └── Inlaze_Logo.png
│           └── features
│               ├── SignIn.feature
│               └── SignUp.feature
└── target
```

## documentacion casos de prueba

Los casos de prueba al finalizar su ejecución 
realizan un aggregate donde como resultado nos 
da un PDF por cada caso de prueba con las evidencias
y estado de cada caso de prueba

los pdf se encuentran en la siguiente ruta:

src/test/resources

