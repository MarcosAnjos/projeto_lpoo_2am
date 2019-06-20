/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.controller.FuncionarioController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;

/**
 *
 * @author allainnc
 */
public class InicializarBanco {
    
    public static void inicializar(){
        ClienteController cliC = new ClienteController();
        FuncionarioController fc = new FuncionarioController();

        Cliente cli = new Cliente("Jose");
        cliC.gravar(cli);
        
        cli = new Cliente("Allainn Christiam");
        cliC.gravar(cli);
        
        cli = new Cliente("Maria Heloisa");
        cliC.gravar(cli);
        
        cli = new Cliente("Marcos Anjos");
        cliC.gravar(cli);
        
        Funcionario fun = new Funcionario("João da Silva");
        fc.gravar(fun);
        
        fun = new Funcionario("Gabriel Sousa");
        fc.gravar(fun);
        
        fun = new Funcionario("Juarez");
        fc.gravar(fun);
    }
    
}
