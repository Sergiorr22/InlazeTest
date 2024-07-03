@SignIn @E2E
  Feature: SignIn

    @CP008
    Scenario: Login exitoso
      Given Ingreso al formulario de logueo
      When diligencio los campos correctamente
      Then permite el ingreso

    @CP009
    Scenario: Campos Login vacios
      Given Ingreso al formulario de logueo
      When Dejo los campos vacios
      Then NO permite el ingreso

    @CP010
    Scenario: Credenciales incorrectas
      Given Ingreso al formulario de logueo
      When Ingreso credenciales incorrectas
      Then muestra mensaje de error

    @CP011
      Scenario: Cerrar sesión
        Given Ingreso al formulario de logueo
        When diligencio los campos correctamente
        Then permite el ingreso
        Then permite cerrar sesion