/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.bo;

import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.view.Login;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;

/**
 *
 * @author allainnc
 */
public class SingletonUsuario {
    private volatile static Usuario usuario;
    
    private SingletonUsuario() {
    }
    
    public static void setInstance(Usuario usuario){
        SingletonUsuario.usuario = usuario;
    }
    
    public static Usuario getInstance() {
        if(usuario == null){
           synchronized (SingletonUsuario.class){
               if(usuario == null) {
                   try {
                       new Login();
                   }
                   catch (HibernateException he) {
                       System.err.println(he.getMessage());
                   }
               }
           }
        }
        return usuario;
    }
    
    public static void close(){
        usuario = null;
    }
}
