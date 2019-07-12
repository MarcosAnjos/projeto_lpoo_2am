/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allainnc
 */
@Entity
@Table(name = "tb_Servico")
public class Servico {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ser_codigo")
    private Long id;
    
    @Column(name = "ser_descricao")
    private String descricao;
    
    @Column(name = "ven_dataRequisicao")
    @Temporal(TemporalType.DATE)
    private Date dataRequisicao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ven_codCliente")
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ven_codFuncionario")
    private Funcionario funcionario;

    @Column(name = "ser_valorTotal")
    private double valorTotal;
    
    @Column(name = "ser_tempoTotal")
    private double tempoTotal;
    
    @Column(name = "ser_observacao")
    private String observacao;
    
    @Column(name = "ven_dataEntrega")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    
    @Column(name = "ser_formaPagamento")
    private String formaPagamento;
    
    public Servico() {
    }

    public Servico(Long id, String descricao, Date dataRequisicao, Cliente cliente, Funcionario funcionario, double valorTotal, double tempoTotal, String observacao, Date dataEntrega) {
        this.id = id;
        this.descricao = descricao;
        this.dataRequisicao = dataRequisicao;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
        this.tempoTotal = tempoTotal;
        this.observacao = observacao;
        this.dataEntrega = dataEntrega;
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

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", descricao=" + descricao + ", cliente=" 
                + cliente + ", funcionario=" + funcionario + ", valorTotal=" 
                + valorTotal + ", tempoTotal=" + tempoTotal + '}';
    }  
    
}
