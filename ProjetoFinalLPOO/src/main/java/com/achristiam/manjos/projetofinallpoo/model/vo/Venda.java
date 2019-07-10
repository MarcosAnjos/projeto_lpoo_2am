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
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ven_codCliente")
    private Cliente cliente; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ven_codFuncionario")
    private Funcionario funcionario;
    
    @Column(name = "ven_valTotal", precision = 2)
    private double valorTotal;

    public Venda() {
    }

    public Venda(String formaPagamento, Date data, Cliente cliente, Funcionario funcionario) {
        this.formaPagamento = formaPagamento;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Venda(String formaPagamento, Date data, Cliente cliente, Funcionario funcionario, double valorTotal) {
        this.formaPagamento = formaPagamento;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.valorTotal = valorTotal;
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
    
    

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", formaPagamento=" + formaPagamento + ", data=" + data + ", cliente=" + cliente + ", funcionario=" + funcionario + '}';
    }
    
    
}
