
Feature: Search a product and add it to the cart on Automation Exercise

  @smoke
  Scenario: Search a product and verify the Continue Shopping button

    Given el usuario navega al home de Automation Exercise
    When accede a la opción Signup Login
    And ingresa el email "gonzalo.molina@darwoft.com"
    And ingresa el password "Maestruli10"
    And presiona el botón Login
    When selecciona la opción Products
    And ingresa el nombre del producto "Men Tshirt" en el buscador y ejecuta la búsqueda
    And selecciona Add to cart
    Then debe visualizar el botón "Continue Shopping" en el banner de confirmación
