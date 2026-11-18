Feature: Login and Logout verifying the Url on Automation Exercise

  Scenario: Login y logout exitoso con validación de URL
    Given el usuario navega al home de Automation Exercise
    When accede a la opción Signup Login
    And ingresa el email "gonzalo.molina@darwoft.com"
    And ingresa el password "Maestruli10"
    And presiona el botón Login
    Then el usuario debe ver el mensaje "Logged in as"
    When presiona el botón Logout
    Then el usuario debe estar en la url "https://automationexercise.com/login"