Feature: Verificar detalle de producto

  Scenario Outline: El usuario abre el detalle de un producto
    Given el usuario navega al home de Automation Exercise
    When abre el detalle del producto "<producto>"
    Then el nombre del producto mostrado debe ser "<producto>"

    Examples:
      | producto |
      | Winter Top |
