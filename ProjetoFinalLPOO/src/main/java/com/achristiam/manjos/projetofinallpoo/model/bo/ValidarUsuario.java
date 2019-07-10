/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.bo;

import com.achristiam.manjos.projetofinallpoo.controller.UsuarioController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author allainnc
 */
public class ValidarUsuario {
    
    public static boolean validar(String login, String senha){
        UsuarioController  uc = new UsuarioController();
        Usuario usr = uc.buscar(login);
        if(usr == null) {
            JOptionPane.showMessageDialog(null, "Usuario Incorreto!");
            return false;
        }
        else {
            if(senha.equals(usr.getSenha())){
                JOptionPane.showMessageDialog(null, "Logado com sucesso");
                SingletonUsuario.setInstance(usr);
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Senha Incorreto!");
                return false;
            }
        }
    }
    
}
