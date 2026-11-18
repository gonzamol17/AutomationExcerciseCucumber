Feature: Visualización correcta de productos por marca

  Scenario: El sistema muestra la cantidad correcta de productos por marca
    Given el usuario navega al home de Automation Exercise
    When selecciona cada marca del panel izquierdo
    Then el sistema debe mostrar únicamente productos de la marca seleccionada
    And el total de productos debe coincidir con la cantidad indicada en el panel de marcas
