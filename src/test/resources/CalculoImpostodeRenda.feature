Feature: Calcular imposto de renda dos salarios maiores que zero
  Calcular a taxa do imposto de renda dos salarios informados maiores que zero.

  Scenario Outline: calculando os impostos de renda dos salarios
    Given Eu tenho um salario
    When Eu quero calcular o imposto de renda do salario "<Salario>"
    And Valor minimo "<Valor_min>" e maximo "<Valor_max>"
    Then Eu tenho o valor da aliquota "<Aliquota>"
    And Eu tenho o valor "<Deducao>" do imposto de renda

    Examples: 
      | Salario | Valor_min | Valor_max | Aliquota | Deducao |
      | 1900.00 |      0.00 |   1903.98 |     0.00 |    0.00 |
      | 2000.00 |   1903.99 |   2826.65 |      7.5 |  150.00 |
      | 3000.00 |   2826.66 |   3751.05 |       15 |  450.00 |
      | 4000.00 |   3751.06 |   4664.68 |     22.5 |  900.00 |
      | 5000.00 |   4664.69 | 999999.00 |     27.5 | 1375.00 |
