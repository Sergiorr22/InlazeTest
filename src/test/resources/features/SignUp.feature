@SignUp @E2E
  Feature: SignUp

    @CP001
    Scenario: Registro exitoso
      Given ingreso al formulario de registro
      When diligencio el formulario de manera correcta
      Then el sistema permite el registro

    @CP002
    Scenario: Campo nombre con una palabra
      Given ingreso al formulario de registro
      When diligencio el campo nombre con una sola palabra
      And Diligencio los demas campos de manera correcta
      Then el sistema no permite el registro

    @CP003
    Scenario: Formato de Email invalido
      Given ingreso al formulario de registro
      When diligencio el campo Email de manera incorrecta
      And Diligencio los demas campos de manera correcta
      Then el sistema no permite el registro

    Scenario: Email duplicado
      Given ingreso al formulario de registro
      When diligencio el campo Email ingreso un email ya existente
      And Diligencio los demas campos de manera correcta
      Then el sistema no permite el registro

    Scenario: Contraseña no cumple con seguridad
      Given ingreso al formulario de registro
      When diligencio el campo Password de manera incorrecta
      And Diligencio los demas campos de manera correcta
      Then el sistema no permite el registro

    Scenario: Campos obligatorios vacios
      Given ingreso al formulario de registro
      When dejo el campo nombre vacio
      And Diligencio los demas campos de manera correcta
      Then el sistema no permite el registro

    Scenario: Contraseñas no coinciden
      Given ingreso al formulario de registro
      When diligencio los campos de contraseña con diferente informacion
      Then el sistema muestra mensaje de no coincidencia