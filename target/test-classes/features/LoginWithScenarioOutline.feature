Feature: Login en Automation Exercise con Scenario Outline

  Scenario Outline: Login con resultado esperado "<resultado>"
    Given el usuario navega al home de Automation Exercise
    When accede a la opción Signup Login
    And ingresa el email "<email>"
    And ingresa el password "<password>"
    And presiona el botón Login
    Then el usuario debe ver el mensaje "<resultado>"

    Examples:
      | email                          | password     | resultado     |
      | gonzalo.molina@darwoft.com     | Maestruli10  | Logged in as  |
      | gonza_mol@hotmail.com          | Maestruli10  | Logged in as  |
      | Laura.Molina@hotmail.com       | Maestruli10  | Logged in as  |
      | Nielse.Molina@hotmail.com      | Maestruli10  | Logged in as  |



