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
@Table(name = "tb_ServicoTipoServico")
public class ServicoTipoServico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sertser_codigo")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sertser_codServico")
    private Servico servico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sertser_codTipoServico")
    private TipoServico tipoServico;
    
    @Column(name = "sertser_quantidade")
    private int quantidade;
    
    @Column(name = "sertser_valorServico")
    private double valorServico;

    public ServicoTipoServico() {
    }

    
    
    public ServicoTipoServico(Servico servico, TipoServico tipoServico, int quantidade, double valorServico) {
        this.servico = servico;
        this.tipoServico = tipoServico;
        this.quantidade = quantidade;
        this.valorServico = valorServico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    @Override
    public String toString() {
        return "ServicoTipoServico{" + "id=" + id + ", servico=" + servico + 
                ", tipoServico=" + tipoServico + ", quantidade=" + quantidade + 
                ", valorServico=" + valorServico + '}';
    }
    
    
    
}
