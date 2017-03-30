/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.leticia.ImpostodeRenda.control;

/**
 *
 * @author Leticia
 */
public class Pessoa {
    private double salario;
    
    public Pessoa(double receita){
        this.salario = receita;
    }

    public double getReceita() {
        return salario;
    }

    public void setReceita(double receita) {
        this.salario = receita;
    }
}
