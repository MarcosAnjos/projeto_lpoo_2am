package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.FuncionarioController;
import com.achristiam.manjos.projetofinallpoo.controller.UsuarioController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.view.model.CadastroPadrao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CadastroFuncionario extends CadastroPadrao {

    private static final long serialVersionUID = 1L;

    private JPanel jpCampos;
    private JLabel jlCodigo, jlNome, jlLogin, jlSenha;
    private JTextField jtfCodigo, jtfNome, jtfLogin;
    private JPasswordField jtfSenha;

    private FuncionarioController funcionarioController = new FuncionarioController();
    private Funcionario fun = new Funcionario();
    private UsuarioController usuarioController = new UsuarioController();
    private Usuario usr = new Usuario();
    private boolean gravar;
    
    public CadastroFuncionario() {
        super("Cadastro de Funcionario", true, true, true, true);
        gravar = false;
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlNome = new JLabel("Nome");
        jtfNome = new JTextField(30);
        jlLogin = new JLabel("Login");
        jtfLogin = new JTextField(30);
        jlSenha = new JLabel("Senha");
        jtfSenha = new JPasswordField();

        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlNome);
        jpCampos.add(jtfNome);
        jpCampos.add(jlLogin);
        jpCampos.add(jtfLogin);
        jpCampos.add(jlSenha);
        jpCampos.add(jtfSenha);

        // posicao dos componentes
        jlCodigo.setBounds(15, 30, 65, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(75, 30, 100, 25);
        jlNome.setBounds(15, 60, 65, 25);
        jtfNome.setBounds(75, 60, 250, 25);
        jlLogin.setBounds(15, 90, 65, 25);
        jtfLogin.setBounds(75, 90, 200, 25);
        jlSenha.setBounds(15, 120, 65, 25);
        jtfSenha.setBounds(75, 120, 200, 25);

        this.add(jpBotoes, BorderLayout.SOUTH);
        jpBotoes.setVisible(true);

        this.add(jpCampos);
        this.setVisible(true);
        this.pack();
        
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);

        jbGravar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    gravar = true;
                    usr = getObjetoFromCampos();
                    fun = usr.getFuncionario();
                    funcionarioController.gravar(fun);
                    usuarioController.gravar(usr);
                    JOptionPane.showMessageDialog(null, "O Funcionario foi cadastrado com sucesso!");
                    limpaCampos();
                }
            }
        );

        // ==============================================================
        jbAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (camposValidos()) {
                        usr = getObjetoFromCampos();
                        funcionarioController.atualizar(usr.getFuncionario());
                        usuarioController.atualizar(usr);
                        jbAlterar.setEnabled(false);
                        jbExcluir.setEnabled(false);
                        jbGravar.setEnabled(true);
                        limpaCampos();
                        JOptionPane.showMessageDialog(null, "O Funcionario foi alterado com sucesso!");
                    }
                }
            }
        );

        //=================================================================
        jbExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    funcionarioController.remover(usr.getFuncionario());
                    usuarioController.remover(usr);
                    limpaCampos();
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso!");
                }
            }
        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaFuncionario cFun = new ConsultaFuncionario();
                    cFun.setModal(true);
                    cFun.setVisible(true);
                    if (cFun.getObjetoSelecionado() != null) {
                        preencheCampos(cFun.getObjetoSelecionado());
                        jbAlterar.setEnabled(true);
                        jbExcluir.setEnabled(true);
                        jbGravar.setEnabled(false);
                    }
                }
            }
        );
    }

    public boolean camposValidos() {
        if (jtfCodigo.getText() == "" || jtfNome.getText() == "");
        return true;
    }

    public Usuario getObjetoFromCampos() {
        if(gravar) {
            fun = new Funcionario();
            usr = new Usuario();
        }
        else{
           fun = usr.getFuncionario();
        }
        fun.setNome(jtfNome.getText());
        usr.setLogin(jtfLogin.getText());
        usr.setSenha(jtfSenha.getText());
        usr.setFuncionario(fun);
        //fun.setUsuario(usr);

        gravar = false;
        return usr;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfNome.setText("");
        this.jtfLogin.setText("");
        this.jtfSenha.setText("");
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        usr = (Usuario) obj;

        this.jtfCodigo.setText(String.valueOf(usr.getFuncionario().getId()));
        this.jtfNome.setText(usr.getFuncionario().getNome());
        this.jtfLogin.setText(usr.getLogin());
        this.jtfSenha.setText(usr.getSenha());
    }

}
