Feature: Verificación de Subcategorías en Home Page

  Scenario Outline: Verificar subcategorías al expandir cada categoría
    Given el usuario navega al home de Automation Exercise
    When el usuario expande la categoría "<Category>"
    Then se deben visualizar las siguientes subcategorías "<Subcategories>"

    Examples:
      | Category   | Subcategories  |
      | WOMEN  | DRESS, TOPS, SAREE |
      | MEN  | TSHIRTS, JEANS       |
      | KIDS  | DRESS, TOPS & SHIRTS|
