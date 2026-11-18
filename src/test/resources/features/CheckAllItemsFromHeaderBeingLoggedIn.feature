Feature: Validación de opciones del header en Automation Exercise

  Scenario: Verificar todas las opciones del header luego del login
    Given el usuario navega al home de Automation Exercise
    When accede a la opción Signup Login
    And ingresa el email "gonzalo.molina@darwoft.com"
    And ingresa el password "Maestruli10"
    And presiona el botón Login
    And captura todas las opciones disponibles en el header
    Then el header debe mostrar las siguientes opciones:
      | Home                |
      |  Products         |
      | Cart                |
      | Logout              |
      | Delete Account      |
      | Test Cases          |
      | API Testing         |
      | Video Tutorials     |
      | Contact us          |
      | Logged in as gonzalo|

