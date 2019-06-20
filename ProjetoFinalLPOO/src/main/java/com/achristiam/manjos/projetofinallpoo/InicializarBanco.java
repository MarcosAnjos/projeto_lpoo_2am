/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;

/**
 *
 * @author allainnc
 */
public class InicializarBanco {
    
    public static void inicializar(){
        ClienteController cliC = new ClienteController();

        Cliente cli = new Cliente("Jose");
        cliC.gravar(cli);
        
        cli = new Cliente("Allainn Christiam");
        cliC.gravar(cli);
        
        cli = new Cliente("Maria Heloisa");
        cliC.gravar(cli);
        
        cli = new Cliente("Marcos Anjos");
        cliC.gravar(cli);
    }
    
}
