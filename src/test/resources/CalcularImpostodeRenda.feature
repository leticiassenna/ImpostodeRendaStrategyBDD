Feature: Calcular imposto de renda dos salarios maiores que zero
  Calcular a taxa do imposto de renda dos salarios informados maiores que zero.

  Scenario Outline: calculando os impostos de renda dos salarios
    Given Eu tenho um salario
    When Eu quero calcular o imposto do salario maior que o valor inicial "<Valor_inicial>"
    And menor que o valor final "<Valor_final>"
    Then Eu tenho o valor da aliquota "<Aliquota>"

    Examples: 
      | Valor inicial | Valor final | Aliquota |
      |               |     1903,98 |          |
      |       1903,99 |     2826,65 |      7,5 |
      |       2826,66 |     3751,05 |       15 |
      |       3751,06 |     4664,68 |     22,5 |
      |       4664,69 |             |     27,5 |

  Scenario: calculando o imposto de renda
    Given Eu tenho um salario
    When Eu quero calcular o imposto de renda do salario "1900.0"
    And Valor minimo "0.0" e maximo "1903.98"
    Then Eu tenho o valor da aliquota "0.0"
    And Eu tenho o valor "0.0" do imposto de renda 

  Scenario: calculando o imposto de renda
    Given Eu tenho um salario
    When Eu quero calcular o imposto de renda do salario "2000.0"
    And Valor minimo "1903.99" e maximo "2826.65"
    Then Eu tenho o valor da aliquota "7.5"
    And Eu tenho o valor "150.0" do imposto de renda 

  Scenario: calculando o imposto de renda
    Given Eu tenho um salario
    When Eu quero calcular o imposto de renda do salario "3000.00"
    And Valor minimo "2826.66" e maximo "3751.05"
    Then Eu tenho o valor da aliquota "15"
    And Eu tenho o valor "450.0" do imposto de renda 
