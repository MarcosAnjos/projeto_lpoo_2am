package com.achristiam.manjos.projetofinallpoo.view.model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public abstract class CadastroPadrao extends JInternalFrame {

    public JPanel jpBotoes = new JPanel();
    private JPanel jpComponentes = new JPanel();
    public JButton jbGravar = new JButton("Gravar");
    public JButton jbBuscar = new JButton("Buscar");
    public JButton jbExcluir = new JButton("Excluir");
    public JButton jbAlterar = new JButton("Alterar");
    private JButton jbCancelar = new JButton("Cancelar");
    private JButton jbSair = new JButton("Sair");

    // metodos
    //===============================================
    public CadastroPadrao(String titulo, boolean b, boolean c, boolean d, boolean e) {
        super(titulo, true, true, true, true);

        this.setLayout(new BorderLayout());
        jpBotoes.setLayout(new FlowLayout());

        jpBotoes.add(jbGravar);
        jpBotoes.add(jbGravar);
        jpBotoes.add(jbBuscar);
        jpBotoes.add(jbExcluir);
        jpBotoes.add(jbAlterar);
        jpBotoes.add(jbCancelar);
        jpBotoes.add(jbSair);

        //mostra os botoes na parte de baixo
        this.add(jpComponentes);
        this.add(jpBotoes, BorderLayout.SOUTH);
        //	jpBotoes.setVisible(true);

        jbCancelar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    limpaCampos();
                }
            }
        );

        jbSair.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    dispose();
                }
            }
        );

        this.setVisible(true);
        this.pack();
    }

    //=================================================
    //metodos abstratos - que dever�o ser implementados nas classes derivadas
    //=================================================
    public abstract boolean camposValidos();

    public abstract Object getObjetoFromCampos();

    public abstract void limpaCampos();

    public abstract void preencheCampos(Object obj);
}
