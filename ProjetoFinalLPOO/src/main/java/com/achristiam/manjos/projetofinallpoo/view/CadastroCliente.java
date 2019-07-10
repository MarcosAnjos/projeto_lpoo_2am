package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.view.model.CadastroPadrao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCliente extends CadastroPadrao {

    private static final long serialVersionUID = 1L;

    private JPanel jpCampos;
    private JLabel jlCodigo, jlNome;
    private JTextField jtfCodigo, jtfNome;

    private ClienteController clienteController = new ClienteController();
    private Cliente cli;
    
    public CadastroCliente() {
        super("Cadastro de Cliente", true, true, true, true);
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlNome = new JLabel("Nome");
        jtfNome = new JTextField(30);

        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlNome);
        jpCampos.add(jtfNome);

        // posicao dos componentes
        jlCodigo.setBounds(15, 30, 65, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(100, 30, 100, 25);
        jlNome.setBounds(15, 60, 65, 25);
        jtfNome.setBounds(100, 60, 100, 25);

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
                    cli = new Cliente();
                    clienteController.gravar(getObjetoFromCampos());
                    JOptionPane.showMessageDialog(null, "O Cliente foi cadastrado com sucesso!");
                    limpaCampos();
                }
            }
        );

        // ==============================================================
        jbAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (camposValidos()) {
                        clienteController.atualizar(getObjetoFromCampos());
                        jbAlterar.setEnabled(false);
                        jbExcluir.setEnabled(false);
                        jbGravar.setEnabled(true);
                        limpaCampos();
                        JOptionPane.showMessageDialog(null, "O Cliente foi alterado com sucesso!");
                    }
                }
            }
        );

        //=================================================================
        jbExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    clienteController.remover(cli);
                    limpaCampos();
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
                }
            }
        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaCliente cCli = new ConsultaCliente();
                    cCli.setModal(true);
                    cCli.setVisible(true);
                    if (cCli.getObjetoSelecionado() != null) {
                        preencheCampos(cCli.getObjetoSelecionado());
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

    public Cliente getObjetoFromCampos() {
        cli.setNome(jtfNome.getText());

        return cli;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfNome.setText("");
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        cli = (Cliente) obj;

        this.jtfCodigo.setText(String.valueOf(cli.getId()));
        this.jtfNome.setText(cli.getNome());
    }

}
