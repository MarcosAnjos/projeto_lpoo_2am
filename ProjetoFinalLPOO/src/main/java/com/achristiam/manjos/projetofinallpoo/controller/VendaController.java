/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Venda;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class VendaController {
    
    private GenericDAO<Venda> genericDao;

    public VendaController() {
        genericDao = new GenericDAO<Venda>();
    }
    
    public void gravar(Venda venda) {
        genericDao.save(venda);
    }
    
    public Venda buscar(String nome){
        return null;
    }
    
    public void remover (Venda venda) {
        genericDao.delete(venda);
    }
    
    public List buscarTodos(){
        List<Venda> vendas = (List<Venda>) genericDao.listAll(Venda.class);
        return vendas;
    }
    
    public Venda buscarUm(Long codigo){
        return (Venda) genericDao.listOne(codigo, Venda.class);
    }
    
    public void atualizar(Venda venda){
        genericDao.update(venda);
    }
    
    
}
