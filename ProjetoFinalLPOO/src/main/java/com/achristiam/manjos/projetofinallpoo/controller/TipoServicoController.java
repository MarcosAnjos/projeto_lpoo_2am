/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServico;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class TipoServicoController {
    
    private GenericDAO<TipoServico> genericDao;

    public TipoServicoController() {
        genericDao = new GenericDAO<TipoServico>();
    }
    
    public void gravar(TipoServico tipoServico) {
        genericDao.save(tipoServico);
    }
    
    public TipoServico buscar(String nome){
        return null;
    }
    
    public void remover (TipoServico tipoServico) {
        genericDao.delete(tipoServico);
    }
    
    public List buscarTodos(){
        List<TipoServico> tipoServicos = (List<TipoServico>) genericDao.listAll(TipoServico.class);
        return tipoServicos;
    }
    
    public TipoServico buscarUm(Long codigo){
        return (TipoServico) genericDao.listOne(codigo, TipoServico.class);
    }
    
    public void atualizar(TipoServico tipoServico){
        genericDao.update(tipoServico);
    }
    
    
}
