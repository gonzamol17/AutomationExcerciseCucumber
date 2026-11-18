Feature: Product review submission


  Scenario: Verify a logged user can successfully submit a review for a product
    Given el usuario navega al home de Automation Exercise
    When accede a la opción Signup Login
    And ingresa el email "gonzalo.molina@darwoft.com"
    And ingresa el password "Maestruli10"
    And presiona el botón Login
    When el usuario selecciona la opción Products
    And busca el producto "Blue Top"
    And selecciona la opción de View Detail Page del producto
    And en el detalle de la pagina del producto completa los campos de la review y lo envía:
      | name        | Gonzalo |
      | email       | gonzalo.molina@darwoft.com |
      | review      | Great product, very good quality |
    Then el usuario tiene que visualizar la confirmación de la review con el mensaje "Thank you for your review."