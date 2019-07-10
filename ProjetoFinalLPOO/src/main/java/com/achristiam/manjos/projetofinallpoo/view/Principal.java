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
import com.achristiam.manjos.projetofinallpoo.controller.UsuarioController;
import com.achristiam.manjos.projetofinallpoo.controller.VendaController;
import com.achristiam.manjos.projetofinallpoo.controller.VendaProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.dao.ConexaoHibernate;
import com.achristiam.manjos.projetofinallpoo.model.dao.GenericDAO;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Venda;
import com.achristiam.manjos.projetofinallpoo.model.vo.VendaProduto;
import java.util.List;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;
import org.jboss.jandex.Main;

/**
 *
 * @author allainnc
 */
public class Principal {
    
    public static void main(String[] args) {
        InicializarBanco.inicializar();
  
        Image img = new Image("/home/allainnc/Imagens/icon.png");
        
        ImageIcon im = new ImageIcon();
        
        if(img == null) System.out.println("Bugo");
        else System.out.println("Nao bugo");
        
        
        //InicializarBanco.inicializarAdmin();
//        GenericDAO<Usuario> genericDao = new GenericDAO<Usuario>();
//        UsuarioController uc = new UsuarioController();
//        FuncionarioController fc = new FuncionarioController();
//        Usuario usr = new Usuario();
//        Funcionario fun1 = new Funcionario("João da Silva");
//        usr.setLogin("admin");
//        usr.setSenha("admin");
//        
//        usr.setFuncionario(fun1);
//
//        fc.gravar(fun1);        
//        uc.gravar(usr);
//        
//        
//        //usr = (Usuario) genericDao.listOne("usr_codigo", 1, Usuario.class);
//        
//        usr = uc.buscar("admin");
//        fun1 = fc.buscarUm(4L);
//        
//        //System.out.println(usr.getClass().getSimpleName());
//
//        System.out.println(usr.toString());
//        System.out.println(fun1.toString());
        
        
//        ClienteController cliC = new ClienteController();
//        FuncionarioController fc = new FuncionarioController();
//        ProdutoController pc = new ProdutoController();
//        VendaController vc = new VendaController();
//        VendaProdutoController vpc = new VendaProdutoController();
//        
//        List<Cliente> clientes;
//        List<Funcionario> funcionarios;
//        List<Produto> produtos;
//        List<Venda> vendas;
//        List<VendaProduto> vendasProdutos;
//        
//        clientes = cliC.buscarTodos();
//        for(Cliente cliente:clientes){
//            System.out.println(cliente.toString());
//        }
//        
//        funcionarios = fc.buscarTodos();
//        for(Funcionario funcionario:funcionarios){
//            System.out.println(funcionario.toString());
//        }
//        
//        produtos = pc.buscarTodos();
//        for(Produto produto:produtos){
//            System.out.println(produto.toString());
//        }
//        
//        vendas = vc.buscarTodos();
//        for(Venda venda:vendas){
//            System.out.println(venda.toString());
//        }
//        
//        vendasProdutos = vpc.buscarTodos();
//        for(VendaProduto vendaProd:vendasProdutos){
//            System.out.println(vendaProd.toString());
//        }
        
        ConexaoHibernate.close();
    }
    
    
    
}
