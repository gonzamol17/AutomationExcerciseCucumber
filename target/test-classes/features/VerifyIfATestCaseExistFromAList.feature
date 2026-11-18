Feature: Verificación de Test Cases listados

  Scenario: Verificar que los Test Cases esperados estén visibles en la lista
    Given el usuario navega al home de Automation Exercise
    When el usuario ingresa a la opción Test Cases
    Then el usuario debe ver los siguientes test cases listados:
      | Test Case 9: Search Product |
      | Test Case 1: Register User |

