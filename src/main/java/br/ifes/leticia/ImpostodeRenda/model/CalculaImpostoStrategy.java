package br.ifes.leticia.ImpostodeRenda.model;

import br.ifes.leticia.ImpostodeRenda.control.Pessoa;
import br.ifes.leticia.ImpostodeRenda.control.ICalculaImposto;

public class CalculaImpostoStrategy implements ICalculaImposto{
    protected double minimo;
    protected double maximo;
    protected double aliquota;
    protected double imposto;
    
    public CalculaImpostoStrategy(){
    	
    }
    
	CalculaImpostoStrategy(double limMinimo, double limMaximo, double aliquota){
        this.minimo = limMinimo;
        this.maximo = limMaximo;
        this.aliquota = aliquota;
    }
    
    
    public double getMinimo() {
		return minimo;
	}

	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
	
	public double calcImposto(double salario){
		this.imposto = (salario * this.aliquota)/100;
        return this.imposto;
	}

	public double calcularImpostoRenda(Pessoa pessoa){
        if (pessoa.getReceita() >= this.minimo && pessoa.getReceita() <= this.maximo){
             this.imposto = pessoa.getReceita() * this.aliquota;
             return this.imposto;
        }
        else{
            throw new UnsupportedOperationException("SalÃ¡rio nÃ£o pertence a esta aliquota \n" + this.toString());
        }
    }
    
    @Override
    public String toString(){
        return "InformaÃ§Ãµes da aliquota: \n" + 
               "Minimo: R$ " + this.minimo + " - Maximo: R$ " + this.maximo + 
               "Aliquota: " + this.aliquota * 100 + "% \n";
    }

    

}
