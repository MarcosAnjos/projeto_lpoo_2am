/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import java.util.List;



/**
 *
 * @author allainnc
 */
public class UsuarioController {
    
    private GenericDAO<Usuario> genericDao;

    public UsuarioController() {
        genericDao = new GenericDAO<Usuario>();
    }
    
    public void gravar(Usuario usuario) {
        genericDao.save(usuario);
    }
    
    public Usuario buscar(String nome){
        return (Usuario) genericDao.listOne("usr_login", nome, Usuario.class);
    }
    
    public void remover (Usuario usuario) {
        genericDao.delete(usuario);
    }
    
    public List buscarTodos(){
        List<Usuario> usuarios = (List<Usuario>) genericDao.listAll(Usuario.class);
        return usuarios;
    }
    
    public Usuario buscarUm(Long codigo){
        return (Usuario) genericDao.listOne(codigo, Usuario.class);
    }
    
    public void atualizar(Usuario usuario){
        genericDao.update(usuario);
    }
    
    
}
