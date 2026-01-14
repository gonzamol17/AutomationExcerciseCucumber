
Feature: Login exitoso en Automation Exercise

  Scenario: Login exitoso con credenciales válidas
    Given el usuario navega al home de Automation Exercise
    When accede a la opción Signup Login
    And ingresa el email "gonzalo.molina@darwoft.com"
    And ingresa el password "Maestruli10"
    And presiona el botón Login
    Then el usuario debe ver el mensaje "Logged in as"
