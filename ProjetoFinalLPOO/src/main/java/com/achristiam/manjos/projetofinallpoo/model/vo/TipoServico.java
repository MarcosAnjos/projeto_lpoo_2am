/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.vo;

import java.util.ArrayList;

/**
 *
 * @author allainnc
 */
public class TipoServico {
    
    private int id;
    private String descricao;
    private double tempoMin;
    private double custoMaoObra;
    private ArrayList<Equipamento> equipamentos;
    private ArrayList<Produto> produtos;
    private ArrayList<Integer> quantidadeProdGasto;

    public TipoServico() {
    }
    
    public TipoServico(int id, String descricao, double tempoMin, double custoMaoObra, ArrayList<Equipamento> equipamentos, ArrayList<Produto> produtos, ArrayList<Integer> quantidadeProdGasto) {
        this.id = id;
        this.descricao = descricao;
        this.tempoMin = tempoMin;
        this.custoMaoObra = custoMaoObra;
        this.equipamentos = equipamentos;
        this.produtos = produtos;
        this.quantidadeProdGasto = quantidadeProdGasto;
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

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Integer> getQuantidadeProdGasto() {
        return quantidadeProdGasto;
    }

    public void setQuantidadeProdGasto(ArrayList<Integer> quantidadeProdGasto) {
        this.quantidadeProdGasto = quantidadeProdGasto;
    }
    
    
}
