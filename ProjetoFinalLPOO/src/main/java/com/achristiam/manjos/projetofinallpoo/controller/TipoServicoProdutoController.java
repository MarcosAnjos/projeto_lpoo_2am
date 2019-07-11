/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServicoProduto;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class TipoServicoProdutoController {
    
    private GenericDAO<TipoServicoProduto> genericDao;

    public TipoServicoProdutoController() {
        genericDao = new GenericDAO<TipoServicoProduto>();
    }
    
    public void gravar(TipoServicoProduto tipoServicoProduto) {
        genericDao.save(tipoServicoProduto);
    }
    
    public TipoServicoProduto buscar(String nome){
        return null;
    }
    
    public void remover (TipoServicoProduto tipoServicoProduto) {
        genericDao.delete(tipoServicoProduto);
    }
    
    public List buscarTodos(){
        List<TipoServicoProduto> tipoServicoProdutos = (List<TipoServicoProduto>) genericDao.listAll(TipoServicoProduto.class);
        return tipoServicoProdutos;
    }
    
    public List buscarProdutosVenda(int codProduto){
        List<TipoServicoProduto> tipoServicoProdutos = (List<TipoServicoProduto>) genericDao.listMany("tserequ_codProduto", codProduto, TipoServicoProduto.class);
        return tipoServicoProdutos;
    }
    
    public TipoServicoProduto buscarUm(Long codigo){
        return (TipoServicoProduto) genericDao.listOne(codigo, TipoServicoProduto.class);
    }
    
    public void atualizar(TipoServicoProduto tipoServicoProduto){
        genericDao.update(tipoServicoProduto);
    }
    
    
}
