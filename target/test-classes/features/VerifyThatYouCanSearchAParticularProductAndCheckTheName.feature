Feature: Verificación de búsqueda y visualización de productos en la Home Page

  Scenario Outline: Buscar un producto y verificar el nombre en la página de detalles
    Given el usuario navega al home de Automation Exercise
    When el usuario selecciona la opción "Products" desde la Home Page
    And el usuario ingresa el nombre de un producto existente en el buscador "<producto>" y ejecuta la búsqueda
    And el usuario selecciona la opción View Product del producto encontrado
    Then el nombre del producto en la página de detalles debe coincidir con el nombre buscado

     Examples:
      | producto          |
      | Stylish Dress     |
