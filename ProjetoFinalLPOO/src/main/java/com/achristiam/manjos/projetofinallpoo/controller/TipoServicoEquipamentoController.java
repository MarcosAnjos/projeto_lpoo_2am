/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServicoEquipamento;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class TipoServicoEquipamentoController {
    
    private GenericDAO<TipoServicoEquipamento> genericDao;

    public TipoServicoEquipamentoController() {
        genericDao = new GenericDAO<TipoServicoEquipamento>();
    }
    
    public void gravar(TipoServicoEquipamento tipoServicoEquipamento) {
        genericDao.save(tipoServicoEquipamento);
    }
    
    public TipoServicoEquipamento buscar(String nome){
        return null;
    }
    
    public void remover (TipoServicoEquipamento tipoServicoEquipamento) {
        genericDao.delete(tipoServicoEquipamento);
    }
    
    public List buscarTodos(){
        List<TipoServicoEquipamento> tipoServicoEquipamentos = (List<TipoServicoEquipamento>) genericDao.listAll(TipoServicoEquipamento.class);
        return tipoServicoEquipamentos;
    }
    
    public List buscarProdutosVenda(int codEquipamento){
        List<TipoServicoEquipamento> tipoServicoEquipamentos = (List<TipoServicoEquipamento>) genericDao.listMany("tserequ_codEquipamento", codEquipamento, TipoServicoEquipamento.class);
        return tipoServicoEquipamentos;
    }
    
    public TipoServicoEquipamento buscarUm(Long codigo){
        return (TipoServicoEquipamento) genericDao.listOne(codigo, TipoServicoEquipamento.class);
    }
    
    public void atualizar(TipoServicoEquipamento tipoServicoEquipamento){
        genericDao.update(tipoServicoEquipamento);
    }
    
    
}
