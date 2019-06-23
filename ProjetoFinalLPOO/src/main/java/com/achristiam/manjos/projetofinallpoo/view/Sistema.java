package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.InicializarBanco;
import com.achristiam.manjos.projetofinallpoo.controller.SistemaController;
import com.achristiam.manjos.projetofinallpoo.model.bo.SingletonUsuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Sistema extends JFrame {

    private static final long serialVersionUID = 1;
    private JMenuBar jmBarraMenus = new JMenuBar();
    private JMenu mOpcoes;
    private JDesktopPane telaInterna;

    
    
    public Sistema() {
        super("Sistemãooo");
        
        //InicializarBanco.inicializar();
        
        telaInterna = new JDesktopPane();
        
        Usuario usuario = SingletonUsuario.getInstance();
        if(usuario == null) {
            return;
        }
        
        System.out.println(usuario.getLogin());

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        this.setSize(650, 550);
        this.setLocation((d.width/2) - (670/2), (d.height/2) - (500/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setJMenuBar(jmBarraMenus);

        // Iniciar com tela maximizada
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // exibe a tela
        this.add(telaInterna);

        mOpcoes = new JMenu();

        mOpcoes.setText("Opcoes");

        jmBarraMenus.add(mOpcoes);

        JMenuItem miCliente = new JMenuItem();
        JMenuItem miFuncionario = new JMenuItem();
        JMenuItem miProduto = new JMenuItem();
        JMenuItem miVenda = new JMenuItem();

        // nomes dos items do menu opcoes
        miCliente.setText("Cliente");
        miFuncionario.setText("Funcionario");
        miProduto.setText("Produto");
        miVenda.setText("Venda");

        // 	adicionar itens nos menus	
        mOpcoes.add(miCliente);
        mOpcoes.add(miFuncionario);
        mOpcoes.add(miProduto);
        mOpcoes.add(miVenda);

        telaInterna.setLayout(new BorderLayout());

        miCliente.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    CadastroCliente cadCliente = new CadastroCliente();
                    telaInterna.add(cadCliente);
                }
            }
        );
        
        miFuncionario.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    CadastroFuncionario cadFuncionario = new CadastroFuncionario();
                    telaInterna.add(cadFuncionario);
                }
            }
        );
        
        miProduto.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    CadastroProduto cadProduto = null;
                    try {
                        cadProduto = new CadastroProduto();
                    } catch (ParseException ex) {
                        Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    telaInterna.add(cadProduto);
                }
            }
        );
        
        miVenda.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    CadastroVenda cadVenda = new CadastroVenda();
                    telaInterna.add(cadVenda);
                }
            }
        );

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SistemaController.iniciarSistema();
        InicializarBanco.inicializarAdmin();
        new Sistema();
        //ConexaoHibernate.close();
    }
}
