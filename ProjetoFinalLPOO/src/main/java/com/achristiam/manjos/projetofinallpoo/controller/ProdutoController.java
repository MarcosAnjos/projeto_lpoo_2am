/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class ProdutoController {
    
    private GenericDAO<Produto> genericDao;

    public ProdutoController() {
        genericDao = new GenericDAO<Produto>();
    }
    
    public void gravar(Produto produto) {
        genericDao.save(produto);
    }
    
    public Produto buscar(String nome){
        return null;
    }
    
    public void remover (Produto produto) {
        genericDao.delete(produto);
    }
    
    public List buscarTodos(){
        List<Produto> produtos = (List<Produto>) genericDao.listAll(Produto.class);
        return produtos;
    }
    
    public Produto buscarUm(Long codigo){
        return (Produto) genericDao.listOne(codigo, Produto.class);
    }
    
    public void atualizar(Produto produto){
        genericDao.update(produto);
    }
    
    
}
