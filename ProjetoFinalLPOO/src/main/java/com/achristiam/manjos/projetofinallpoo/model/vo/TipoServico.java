/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import java.util.ArrayList;
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
@Table(name = "tb_TipoServico")
public class TipoServico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tser_codigo")
    private int id;
    
    @Column(name = "tser_descricao")
    private String descricao;
    
    @Column(name = "tser_tempo")
    private double tempoMin;
    
    @Column(name = "tser_custoMaoObra")
    private double custoMaoObra;
    
    @Column(name = "tser_tempoTotal")
    private double tempoTotal;
    
    @Column(name = "tser_valorTotal")
    private double valorTotal;


    public TipoServico() {
    }
    
    public TipoServico(int id, String descricao, double tempoMin, double custoMaoObra, double tempoTotal, double valorTotal) {
        this.id = id;
        this.descricao = descricao;
        this.tempoMin = tempoMin;
        this.custoMaoObra = custoMaoObra;
        this.tempoTotal = tempoTotal;
        this.valorTotal = valorTotal;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTempoMin() {
        return tempoMin;
    }

    public void setTempoMin(double tempoMin) {
        this.tempoMin = tempoMin;
    }

    public double getCustoMaoObra() {
        return custoMaoObra;
    }

    public void setCustoMaoObra(double custoMaoObra) {
        this.custoMaoObra = custoMaoObra;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(double tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    
    @Override
    public String toString() {
        return "TipoServico{" + "id=" + id + ", descricao=" + descricao + ", tempoMin=" + tempoMin + ", custoMaoObra=" + custoMaoObra + ", tempoTotal=" + tempoTotal + '}';
    }
    
    
    
}
