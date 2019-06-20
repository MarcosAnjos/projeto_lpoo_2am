/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author allainnc
 */
//@Entity
//@Table(name = "tb_servico")
public class Servico {
    
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ser_codigo")
    private Long id;
    
//    @Column(name = "ser_descricao")
    private String descricao;
    
//    @Column(name = "ser_cliente")
    private Cliente cliente;
    
    private Funcionario funcionario;
    
//    @ElementCollection
//    @CollectionTable(name="tb_tiposerv")
    private ArrayList<TipoServico> tiposServico;
    private ArrayList<Integer> quantidades;
    
    
    private double valorTotal;
    private double tempoTotal;

    
    
    public Servico() {
    }

    public Servico(String descricao, Cliente cliente, Funcionario funcionario, ArrayList<TipoServico> tiposServico, ArrayList<Integer> quantidades, double valorTotal, double tempoTotal) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.tiposServico = tiposServico;
        this.quantidades = quantidades;
        this.valorTotal = valorTotal;
        this.tempoTotal = tempoTotal;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<TipoServico> getTiposServico() {
        return tiposServico;
    }

    public void setTiposServico(ArrayList<TipoServico> tiposServico) {
        this.tiposServico = tiposServico;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(double tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
    
    public void Imprimir() {
        System.out.println("ID: " + this.id);
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Funcionario: " + this.funcionario.getNome());
        for(int i=0;i<tiposServico.size();i++){
            System.out.print("Tipo de Serviço: " + tiposServico.get(i).getDescricao());
            System.out.println("\tQuantidade: " + quantidades.get(i).intValue());
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Valor Total: " +df.format(this.valorTotal));
        System.out.println("Tempo Total: " + df.format(this.tempoTotal));
    }
    
    
    
}
