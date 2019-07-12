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
@Table(name = "tb_TipoServicoProduto")
public class TipoServicoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tserpro_codigo")
    private Long id;
    
    @Column(name = "tserpro_quantidade")
    private int quantidade;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tserpro_codProduto")
    private Produto produto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tserpro_codTipoServico")
    private TipoServico tipoServico;

    public TipoServicoProduto() {
    }

    public TipoServicoProduto(int quantidade, Produto produto, TipoServico tipoServico) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.tipoServico = tipoServico;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public String toString() {
        return "TipoServicoProduto{" + "id=" + id + ", quantidade=" + quantidade + ", produto=" + produto + ", tipoServico=" + tipoServico + '}';
    }

    

    
    
    
}
