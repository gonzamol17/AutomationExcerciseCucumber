Feature: Suscripción exitosa desde el footer de la web

  Scenario: Suscribirse exitosamente con un email válido desde el footer
    Given el usuario navega al home de Automation Exercise
    When hace scroll down hasta el final de la página
    And ingresa un email válido "pedro01@gmail.com"
    And hace clic en el botón Suscribirse
    Then se muestra un mensaje de confirmación con el texto "You have been successfully subscribed!" y en color verde
