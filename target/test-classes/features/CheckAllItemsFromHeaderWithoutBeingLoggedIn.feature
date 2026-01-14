Feature: Validación de opciones del header sin login en Automation Exercise

  Scenario: Verificar todas las opciones del header para un usuario no logueado
    Given el usuario navega al home de Automation Exercise
    When captura todas las opciones disponibles en el header
    Then el header debe mostrar las siguientes opciones:
      | Home            |
      |  Products     |
      | Cart            |
      | Signup / Login  |
      | Test Cases      |
      | API Testing     |
      | Video Tutorials |
      | Contact us      |
