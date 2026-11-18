Feature: Verificación del listado de productos en Home Page

  Scenario: Capturar y contar productos en el listado del Home Page
    Given el usuario navega al home de Automation Exercise
    When imprime la lista de productos visibles en el Home Page
    Then el número de productos debe ser igual a 40

