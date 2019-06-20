/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class FuncionarioController {
    
    private GenericDAO<Funcionario> genericDao;

    public FuncionarioController() {
        genericDao = new GenericDAO<Funcionario>();
    }
    
    public void gravar(Funcionario funcionario) {
        genericDao.save(funcionario);
    }
    
    public Funcionario buscar(String nome){
        return null;
    }
    
    public void remover (Funcionario funcionario) {
        genericDao.delete(funcionario);
    }
    
    public List buscarTodos(){
        List<Funcionario> funcionarios = (List<Funcionario>) genericDao.listAll(Funcionario.class);
        return funcionarios;
    }
    
    public Funcionario buscarUm(Long codigo){
        return (Funcionario) genericDao.listOne(codigo, Funcionario.class);
    }
    
    public void atualizar(Funcionario funcionario){
        genericDao.update(funcionario);
    }
    
    
}
