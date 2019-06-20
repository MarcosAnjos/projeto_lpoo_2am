/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class ClienteController {
    
    private GenericDAO<Cliente> genericDao;

    public ClienteController() {
        genericDao = new GenericDAO<Cliente>();
    }
    
    public void gravar(Cliente cliente) {
        genericDao.save(cliente);
    }
    
    public Cliente buscar(String nome){
        return null;
    }
    
    public void remover (Cliente cliente) {
        genericDao.delete(cliente);
    }
    
    public List buscarTodos(){
        List<Cliente> clientes = (List<Cliente>) genericDao.listAll(Cliente.class);
        return clientes;
    }
    
    public Cliente buscarUm(Long codigo){
        return (Cliente) genericDao.listOne(codigo, Cliente.class);
    }
    
    public void atualizar(Cliente cliente){
        genericDao.update(cliente);
    }
    
    
}
