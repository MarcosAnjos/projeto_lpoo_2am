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
@Table(name = "tb_TipoServicoEquipamento")
public class TipoServicoEquipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tserequ_codigo")
    private Long id;
    
    @Column(name = "tserequ_tempoGasto")
    private double tempoGasto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tserequ_codEquipamento")
    private Equipamento equipamento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tserequ_codTipoServico")
    private TipoServico tipoServico;

    public TipoServicoEquipamento() {
    }

    public TipoServicoEquipamento(double tempoGasto, Equipamento equipamento, TipoServico tipoServico) {
        this.tempoGasto = tempoGasto;
        this.equipamento = equipamento;
        this.tipoServico = tipoServico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(double tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public String toString() {
        return "TipoServicoEquipamento{" + "id=" + id + ", tempoGasto=" + tempoGasto + ", equipamento=" + equipamento + ", tipoServico=" + tipoServico + '}';
    }

    
    
    
}
