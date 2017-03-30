package br.ifes.leticia.ImpostodeRenda;


import static org.junit.Assert.assertEquals;

import br.ifes.leticia.ImpostodeRenda.model.CalculaImpostoStrategy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalcImpostodeRendaSteps {
	
	CalculaImpostoStrategy calcImposto;
	double salario;
	
	@Given("^Eu tenho um salario$")
	public void eu_tenho_um_salario() throws Throwable {
		calcImposto = new CalculaImpostoStrategy();
	}

	@When("^Eu quero calcular o imposto de renda do salario \"([^\"]*)\"$")
	public void eu_quero_calcular_o_imposto_de_renda_do_salario(String arg1) throws Throwable {
		salario = Double.parseDouble(arg1);
	}

	@Then("^Eu tenho o valor da aliquota \"([^\"]*)\"$")
	public void eu_tenho_o_valor_da_aliquota(String arg1) throws Throwable {
		calcImposto.setAliquota(Double.parseDouble(arg1));
	    calcImposto.calcImposto(salario);
	}
	
	@Then("^Eu tenho o valor \"([^\"]*)\" do imposto de renda$")
	public void eu_tenho_o_valor_do_imposto_de_renda(String arg1) throws Throwable {
		assertEquals(arg1, Double.toString(calcImposto.getImposto()));
	}
	
	
	
}
