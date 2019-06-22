/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.controller.FuncionarioController;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.controller.UsuarioController;
import com.achristiam.manjos.projetofinallpoo.controller.VendaController;
import com.achristiam.manjos.projetofinallpoo.controller.VendaProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.bo.ParseDate;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Venda;
import com.achristiam.manjos.projetofinallpoo.model.vo.VendaProduto;
import java.util.Date;

/**
 *
 * @author allainnc
 */
public class InicializarBanco {
    
    public static void inicializarAdmin(){
        FuncionarioController fc = new FuncionarioController();
        UsuarioController uc = new UsuarioController();
        Usuario u = new Usuario();
        Funcionario fun = new Funcionario("Administrador");
        fc.gravar(fun);
        u.setLogin("admin");
        u.setSenha("admin");
        u.setFuncionario(fun);
        uc.gravar(u);
    }
    
    public static void inicializar(){
        ClienteController cliC = new ClienteController();
        FuncionarioController fc = new FuncionarioController();
        ProdutoController pc = new ProdutoController();
        VendaController vc = new VendaController();
        VendaProdutoController vpc = new VendaProdutoController();
        

        Cliente cli1 = new Cliente("Jose");
        cliC.gravar(cli1);
        
        Cliente cli2 = new Cliente("Allainn Christiam");
        cliC.gravar(cli2);
        
        Cliente cli3 = new Cliente("Maria Heloisa");
        cliC.gravar(cli3);
        
        Cliente cli4 = new Cliente("Marcos Anjos");
        cliC.gravar(cli4);
        
        Funcionario fun1 = new Funcionario("João da Silva");
        fc.gravar(fun1);
        
        Funcionario fun2 = new Funcionario("Gabriel Sousa");
        fc.gravar(fun2);
        
        Funcionario fun3 = new Funcionario("Juarez");
        fc.gravar(fun3);
        
        Produto pro1 = new Produto("Papel A4", 0.02, 0.10, 0.05, 100);
        pc.gravar(pro1);
        
        Produto pro2 = new Produto("Caneta", 0.60, 1.00, 0.00, 100);
        pc.gravar(pro2);
        
        Produto pro3 = new Produto("Qualquer", 0.50, 1.20, 0.60, 100);
        pc.gravar(pro3);
        
        Date data = ParseDate.parseDate("20/06/2019");
        System.out.println(data.getTime());
        Venda ven = new Venda("Dinheiro", ParseDate.parseDate("20/06/2019"), 0.00, cli2, fun3);
        vc.gravar(ven);
        
        VendaProduto venpro1 = new VendaProduto(5, pro3.getValorVenda(), pro3, ven);
        vpc.gravar(venpro1);
        VendaProduto venpro2 = new VendaProduto(10, pro2.getValorVenda(), pro2, ven);
        vpc.gravar(venpro2);
        VendaProduto venpro3 = new VendaProduto(2, pro1.getValorVenda(), pro1, ven);
        vpc.gravar(venpro3);
        
        
        
    }
    
}
