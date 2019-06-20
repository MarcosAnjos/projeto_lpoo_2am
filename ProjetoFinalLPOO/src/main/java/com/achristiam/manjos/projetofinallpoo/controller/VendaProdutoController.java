/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.VendaProduto;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class VendaProdutoController {
    
    private GenericDAO<VendaProduto> genericDao;

    public VendaProdutoController() {
        genericDao = new GenericDAO<VendaProduto>();
    }
    
    public void gravar(VendaProduto vendaProduto) {
        genericDao.save(vendaProduto);
    }
    
    public VendaProduto buscar(String nome){
        return null;
    }
    
    public void remover (VendaProduto vendaProduto) {
        genericDao.delete(vendaProduto);
    }
    
    public List buscarTodos(){
        List<VendaProduto> vendaProdutos = (List<VendaProduto>) genericDao.listAll(VendaProduto.class);
        return vendaProdutos;
    }
    
    public VendaProduto buscarUm(Long codigo){
        return (VendaProduto) genericDao.listOne(codigo, VendaProduto.class);
    }
    
    public void atualizar(VendaProduto vendaProduto){
        genericDao.update(vendaProduto);
    }
    
    
}
