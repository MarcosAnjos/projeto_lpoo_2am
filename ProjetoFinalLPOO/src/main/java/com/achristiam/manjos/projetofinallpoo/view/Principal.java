/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.InicializarBanco;
import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.controller.FuncionarioController;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.dao.ConexaoHibernate;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import java.util.List;

/**
 *
 * @author allainnc
 */
public class Principal {
    
    public static void main(String[] args) {
        InicializarBanco.inicializar();
        
        
        ClienteController cliC = new ClienteController();
        FuncionarioController fc = new FuncionarioController();
        ProdutoController pc = new ProdutoController();
        
        List<Cliente> clientes;
        List<Funcionario> funcionarios;
        List<Produto> produtos;
        
        clientes = cliC.buscarTodos();
        for(Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
        
        funcionarios = fc.buscarTodos();
        for(Funcionario funcionario:funcionarios){
            System.out.println(funcionario.toString());
        }
        
        produtos = pc.buscarTodos();
        for(Produto produto:produtos){
            System.out.println(produto.toString());
        }
        
        ConexaoHibernate.close();
    }
    
    
    
}
