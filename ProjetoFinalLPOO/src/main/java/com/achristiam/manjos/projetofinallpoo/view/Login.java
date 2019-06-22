/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.InicializarBanco;
import com.achristiam.manjos.projetofinallpoo.controller.SistemaController;
import com.achristiam.manjos.projetofinallpoo.model.bo.ValidarUsuario;
import com.achristiam.manjos.projetofinallpoo.model.dao.ConexaoHibernate;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javafx.application.Platform;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author allainnc
 */
public class Login extends JFrame {
    
    private JButton jbOk      = new JButton("Ok");
    private JButton jbCancela = new JButton("Cancelar");
    private JLabel jlLogin = new JLabel("Login");
    private JLabel jlSenha = new JLabel("Senha");
    private JTextField jtfLogin = new JTextField();
    private JPasswordField jtfSenha = new JPasswordField();
    
    public Login(){
        super("Login");
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();

        
        this.setSize(240, 160);
        this.setLocation((d.width/2) - (240/2), (d.height/2) - (160/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.getContentPane().setLayout(null);
        
        this.getContentPane().add(jlLogin);
        this.getContentPane().add(jtfLogin);
        this.getContentPane().add(jlSenha);
        this.getContentPane().add(jtfSenha);
        this.getContentPane().add(jbOk);
        this.getContentPane().add(jbCancela);
        
        jlLogin.setBounds(10, 10, 50, 30);
        jtfLogin.setBounds(70, 10, 160, 30);
        jlSenha.setBounds(10, 50, 50, 30);
        jtfSenha.setBounds(70, 50, 160, 30);
        jbOk.setBounds(10, 90, 100, 30);
        jbCancela.setBounds(130, 90, 100, 30);
        
        jtfSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(ValidarUsuario.validar(jtfLogin.getText(), jtfSenha.getText())){
                        dispose();
                        new Sistema();
                    }
                }
            }
        
        });
        
        jtfLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(ValidarUsuario.validar(jtfLogin.getText(), jtfSenha.getText())){
                        dispose();
                        new Sistema();
                    }
                }
            }
        
        });
        
        jbOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(ValidarUsuario.validar(jtfLogin.getText(), jtfSenha.getText())){
                    dispose();
                    new Sistema();
                }
            }
        });
        
        jbCancela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ConexaoHibernate.close();
                Platform.exit();
                System.exit(0);
            }
        });
        
        this.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        SistemaController.iniciarSistema();
        InicializarBanco.inicializarAdmin();
        new Login();
    }
}

