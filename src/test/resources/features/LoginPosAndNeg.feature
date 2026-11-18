
Feature: Login en Automation Exercise

  Background:
    Given el usuario navega al home de Automation Exercise
    And accede a la opción Signup Login

  Scenario: Login exitoso con credenciales válidas
    When ingresa el email "gonzalo.molina@darwoft.com"
    And ingresa el password "Maestruli10"
    And presiona el botón Login
    Then el usuario debe ver el mensaje "Logged in as"

  Scenario: Login fallido con credenciales inválidas
    When ingresa el email "gonzalo.mol@gmail.com"
    And ingresa el password "Masilla32"
    And presiona el botón Login
    Then el usuario debe ver el mensaje de error "Your email or password is incorrect!"

