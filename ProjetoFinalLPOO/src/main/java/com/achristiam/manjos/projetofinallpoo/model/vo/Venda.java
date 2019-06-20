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
@Table(name = "tb_Venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ven_codigo")
    private Long id;
    
    @Column(name = "ven_formaPagamento")
    private String formaPagamento;
    
    @Column(name = "ven_data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "ven_desconto", precision = 2)
    private double desconto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ven_codCliente")
    private Cliente cliente; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ven_codFuncionario")
    private Funcionario funcionario;

    public Venda() {
    }

    public Venda(String formaPagamento, Date data, double desconto, Cliente cliente, Funcionario funcionario) {
        this.formaPagamento = formaPagamento;
        this.data = data;
        this.desconto = desconto;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
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

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", formaPagamento=" + formaPagamento + ", data=" + data + ", desconto=" + desconto + ", cliente=" + cliente + ", funcionario=" + funcionario + '}';
    }
    
    
}
