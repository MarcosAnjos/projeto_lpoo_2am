/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

/**
 *
 * @author allainnc
 */
public class Equipamento {
    
    private int id;
    private String descricao;
    private String funcao;
    private String observacao;
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
