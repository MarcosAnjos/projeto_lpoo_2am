/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.controller.FuncionarioController;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;

/**
 *
 * @author allainnc
 */
public class InicializarBanco {
    
    public static void inicializar(){
        ClienteController cliC = new ClienteController();
        FuncionarioController fc = new FuncionarioController();
        ProdutoController pc = new ProdutoController();
        

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
        
        Produto pro = new Produto("Papel A4", 0.02, 0.10, 0.05, 100);
        pc.gravar(pro);
        
        pro = new Produto("Caneta", 0.60, 1.00, 0.00, 100);
        pc.gravar(pro);
        
        pro = new Produto("Qualquer", 0.50, 1.20, 0.60, 100);
        pc.gravar(pro);
        
    }
    
}
