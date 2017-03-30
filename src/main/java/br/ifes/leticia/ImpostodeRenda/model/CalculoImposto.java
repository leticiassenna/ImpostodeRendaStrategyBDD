/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.ImpostodeRenda.model;

import br.ifes.leticia.ImpostodeRenda.control.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leticia
 */
public class CalculoImposto {
    List<CalculaImpostoStrategy> calculoImposto;
    Pessoa cliente;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public CalculoImposto(Pessoa pessoa){
        
        Aliquota1 aliquota1 = new Aliquota1();
        Aliquota2 aliquota2 = new Aliquota2();
        Aliquota3 aliquota3 = new Aliquota3();
        Aliquota4 aliquota4 = new Aliquota4();
        Aliquota5 aliquota5 = new Aliquota5();
        
        this.calculoImposto = new ArrayList();
        this.calculoImposto.add(aliquota1);
        this.calculoImposto.add(aliquota2);
        this.calculoImposto.add(aliquota3);
        this.calculoImposto.add(aliquota4);
        this.calculoImposto.add(aliquota5);
        
        cliente = new Pessoa(pessoa.getReceita());
        this.calcularImpostoRenda(pessoa);
    }

    
    public final void calcularImpostoRenda(Pessoa pessoa) {
        double imposto = -1;
                
        for (CalculaImpostoStrategy calculo: this.calculoImposto){
            if (pessoa.getReceita() >= calculo.getMinimo()&& this.cliente.getReceita() <= calculo.getMaximo()){
                imposto = calculo.calcularImpostoRenda(this.cliente);
            }
        }
        if(imposto == -1){
            System.out.println("Salário negativo não é válido\n");
        }else{
            System.out.println("Valor salário: R$ " + cliente.getReceita() + ", valor imposto: R$ " + imposto);
        }
          
    }
    
    
}
