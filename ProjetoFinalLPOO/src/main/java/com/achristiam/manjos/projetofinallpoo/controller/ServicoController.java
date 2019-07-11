/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Servico;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class ServicoController {
    
    private GenericDAO<Servico> genericDao;

    public ServicoController() {
        genericDao = new GenericDAO<Servico>();
    }
    
    public void gravar(Servico servico) {
        genericDao.save(servico);
    }
    
    public Servico buscar(String nome){
        return null;
    }
    
    public void remover (Servico servico) {
        genericDao.delete(servico);
    }
    
    public List buscarTodos(){
        List<Servico> servicos = (List<Servico>) genericDao.listAll(Servico.class);
        return servicos;
    }
    
    public Servico buscarUm(Long codigo){
        return (Servico) genericDao.listOne(codigo, Servico.class);
    }
    
    public void atualizar(Servico servico){
        genericDao.update(servico);
    }
    
    
}
