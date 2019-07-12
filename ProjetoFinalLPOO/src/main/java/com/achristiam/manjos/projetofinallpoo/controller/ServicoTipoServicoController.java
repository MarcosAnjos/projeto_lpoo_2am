/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.ServicoTipoServico;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class ServicoTipoServicoController {
    
    private GenericDAO<ServicoTipoServico> genericDao;

    public ServicoTipoServicoController() {
        genericDao = new GenericDAO<ServicoTipoServico>();
    }
    
    public void gravar(ServicoTipoServico servicoTipoServico) {
        genericDao.save(servicoTipoServico);
    }
    
    public ServicoTipoServico buscar(String nome){
        return null;
    }
    
    public void remover (ServicoTipoServico servicoTipoServico) {
        genericDao.delete(servicoTipoServico);
    }
    
    public List buscarTodos(){
        List<ServicoTipoServico> servicoTipoServicos = (List<ServicoTipoServico>) genericDao.listAll(ServicoTipoServico.class);
        return servicoTipoServicos;
    }
    
    public List buscarTipoServicos(int codTipoServico){
        List<ServicoTipoServico> servicoTipoServicos = (List<ServicoTipoServico>) genericDao.listMany("sertser_codTipoServico", codTipoServico, ServicoTipoServico.class);
        return servicoTipoServicos;
    }
    
    public ServicoTipoServico buscarUm(Long codigo){
        return (ServicoTipoServico) genericDao.listOne(codigo, ServicoTipoServico.class);
    }
    
    public void atualizar(ServicoTipoServico servicoTipoServico){
        genericDao.update(servicoTipoServico);
    }
    
    
}
