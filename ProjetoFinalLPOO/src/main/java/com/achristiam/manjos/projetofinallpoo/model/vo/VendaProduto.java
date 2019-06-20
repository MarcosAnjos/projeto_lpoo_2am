/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author allainnc
 */
@Entity
@Table(name = "tb_VendaProduto")
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venprod_codigo")
    private Long id;
    
    @Column(name = "venpro_quantidade")
    private int quantidade;
    
    @Column(name = "venpro_valVenda", precision = 2)
    private double valorVenda;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venpro_codProduto")
    private Produto produto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venpro_codVenda")
    private Venda venda;

    public VendaProduto() {
    }

    public VendaProduto(int quantidade, double valorVenda, Produto produto, Venda venda) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.produto = produto;
        this.venda = venda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "VendaProduto{" + "id=" + id + ", quantidade=" + quantidade + ", valorVenda=" + valorVenda + ", produto=" + produto + ", venda=" + venda + '}';
    }
    
    
}
