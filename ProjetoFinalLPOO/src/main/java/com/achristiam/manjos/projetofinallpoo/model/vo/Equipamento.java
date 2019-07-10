/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import javax.annotation.Generated;
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
@Table(name = "tb_Equipamento")
public class Equipamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equ_codigo")
    private int id;
    
    @Column(name = "equ_descricao")
    private String descricao;
    
    @Column(name = "equ_funcao")
    private String funcao;
    
    @Column(name = "equ_observacao")
    private String observacao;
    
    @Column(name = "equ_status")
    private boolean status;

    public Equipamento() {
    }

    public Equipamento(int id, String descricao, String funcao, String observacao, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.funcao = funcao;
        this.observacao = observacao;
        this.status = status;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
