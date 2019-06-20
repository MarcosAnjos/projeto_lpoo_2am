/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author allainnc
 */
@Entity
@Table(name = "tb_Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_codigo")
    private Long id;
    
    @Column(name = "pro_descricao")
    private String descricao;
    
    @Column(name = "pro_valCompra", precision = 2)
    private double valorCompra;
    
    @Column(name = "pro_valVenda", precision = 2)
    private double valorVenda;
    
    @Column(name = "pro_valServico", precision = 2)
    private double valorServico;
    
    @Column(name = "pro_quantEstoque")
    private int quantidadeEstoque;

    public Produto() {
    }

    public Produto(String descricao, double valorCompra, double valorVenda, double valorServico, int quantidadeEstoque) {
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.valorServico = valorServico;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public double getValor() {
        return valorCompra;
    }

    public void setValor(double valor) {
        this.valorCompra = valor;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }   

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", valorCompra=" + valorCompra + ", valorVenda=" + valorVenda + ", valorServico=" + valorServico + ", quantidadeEstoque=" + quantidadeEstoque + '}';
    }
   
    
}
