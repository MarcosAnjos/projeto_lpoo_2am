package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.SistemaController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        super("Projeto Base");
        telaInterna = new JDesktopPane();

        this.setSize(670, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setJMenuBar(jmBarraMenus);

        // exibe a tela
        this.add(telaInterna);

        mOpcoes = new JMenu();

        mOpcoes.setText("Opcoes");

        jmBarraMenus.add(mOpcoes);

        JMenuItem miCliente = new JMenuItem();

        // nomes dos items do menu opcoes
        miCliente.setText("Cliente");

        // 	adicionar itens nos menus	
        mOpcoes.add(miCliente);

        telaInterna.setLayout(new BorderLayout());

        miCliente.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                CadastroCliente cadCliente = new CadastroCliente();
                telaInterna.add(cadCliente);
            }
        }
        );

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SistemaController.iniciarSistema();
        new Sistema();
    }
}
