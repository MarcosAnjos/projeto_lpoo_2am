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


    public TipoServico() {
    }
    
    public TipoServico(int id, String descricao, double tempoMin, double custoMaoObra) {
        this.id = id;
        this.descricao = descricao;
        this.tempoMin = tempoMin;
        this.custoMaoObra = custoMaoObra;
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
    
}
