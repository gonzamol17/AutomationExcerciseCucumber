Feature: Verificación de scroll y visibilidad de elementos en Home Page

  Scenario: Verificar visibilidad de elementos en el bottom y top de la Home Page
    Given el usuario navega al home de Automation Exercise
    When hace scroll down hasta el final de la página
    Then el usuario debe ver visible el elemento "Subscription" en el footer
    When hace scroll up hasta el inicio de la página
    Then el usuario debe ver visible el icono "Website for automation practice" con el título de la página
