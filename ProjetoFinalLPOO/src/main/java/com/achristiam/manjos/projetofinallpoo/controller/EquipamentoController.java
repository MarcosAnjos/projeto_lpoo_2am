/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Equipamento;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class EquipamentoController {
    
    private GenericDAO<Equipamento> genericDao;

    public EquipamentoController() {
        genericDao = new GenericDAO<Equipamento>();
    }
    
    public void gravar(Equipamento equipamento) {
        genericDao.save(equipamento);
    }
    
    public Equipamento buscar(String nome){
        return null;
    }
    
    public void remover (Equipamento equipamento) {
        genericDao.delete(equipamento);
    }
    
    public List buscarTodos(){
        List<Equipamento> equipamentos = (List<Equipamento>) genericDao.listAll(Equipamento.class);
        return equipamentos;
    }
    
    public Equipamento buscarUm(Long codigo){
        return (Equipamento) genericDao.listOne(codigo, Equipamento.class);
    }
    
    public void atualizar(Equipamento equipamento){
        genericDao.update(equipamento);
    }
    
    
}
