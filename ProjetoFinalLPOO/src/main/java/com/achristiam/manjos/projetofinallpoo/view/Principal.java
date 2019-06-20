/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.InicializarBanco;
import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.model.dao.ConexaoHibernate;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import java.util.List;

/**
 *
 * @author allainnc
 */
public class Principal {
    
    public static void main(String[] args) {
        InicializarBanco.inicializar();
        
        
        ClienteController cliC = new ClienteController();
        List<Cliente> clientes;
        
        clientes = cliC.buscarTodos();
        for(Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
        
        ConexaoHibernate.close();
    }
    
    
    
}
