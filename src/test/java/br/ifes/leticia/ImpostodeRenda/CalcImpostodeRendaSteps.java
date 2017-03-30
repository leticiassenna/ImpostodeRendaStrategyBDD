package br.ifes.leticia.ImpostodeRenda;


import static org.junit.Assert.assertEquals;

import br.ifes.leticia.ImpostodeRenda.control.Pessoa;
import br.ifes.leticia.ImpostodeRenda.model.CalculaImpostoStrategy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalcImpostodeRendaSteps {
	Pessoa pessoa;
	CalculaImpostoStrategy calcImposto;
	double min, max;
	
	@Given("^Eu tenho um salario$")
	public void eu_tenho_um_salario() throws Throwable {
		
	}

	@When("^Eu quero calcular o imposto de renda do salario \"([^\"]*)\"$")
	public void eu_quero_calcular_o_imposto_de_renda_do_salario(String arg1) throws Throwable {
		pessoa = new Pessoa(Double.parseDouble(arg1));
	}
	
	@When("^Valor minimo \"([^\"]*)\" e maximo \"([^\"]*)\"$")
	public void valor_minimo_e_maximo(String arg1, String arg2) throws Throwable {
		this.min = Double.parseDouble(arg1);
		this.max = Double.parseDouble(arg2);
	}

	@Then("^Eu tenho o valor da aliquota \"([^\"]*)\"$")
	public void eu_tenho_o_valor_da_aliquota(String arg1) throws Throwable {
		calcImposto = new CalculaImpostoStrategy(this.min, this.max, Double.parseDouble(arg1));
	    calcImposto.calcularImpostoRenda(pessoa);
	}
	
	@Then("^Eu tenho o valor \"([^\"]*)\" do imposto de renda$")
	public void eu_tenho_o_valor_do_imposto_de_renda(String arg1) throws Throwable {
		Double.compare(Double.parseDouble(arg1),calcImposto.getImposto());
	}
	
	
	
}
