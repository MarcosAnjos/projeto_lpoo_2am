package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.EquipamentoController;
import com.achristiam.manjos.projetofinallpoo.model.bo.JTextFieldSomenteNumeros;
import com.achristiam.manjos.projetofinallpoo.model.vo.Equipamento;
import com.achristiam.manjos.projetofinallpoo.view.model.CadastroPadrao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroEquipamento extends CadastroPadrao {

    private static final long serialVersionUID = 1L;

    private JPanel jpCampos;
    private JLabel jlCodigo, jlDescricao, jlFuncao, jlObservacao, jlStatus, jlValor;
    private JTextField jtfCodigo, jtfDescricao, jtfFuncao, jtfObservacao, jtfValor;
    private JComboBox jtfStatus;

    private EquipamentoController equipamentoController = new EquipamentoController();
    private Equipamento equ;
    
    private List<String> status;
    
    ComboBoxModel modelo;
    
    public CadastroEquipamento() {
        super("Cadastro de Equipamento", true, true, true, true);
        
        this.status = new ArrayList<>();
        this.status.add("Ativado");
        this.status.add("Desativado");
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlDescricao = new JLabel("Descrição");
        jtfDescricao = new JTextField(30);
        jlFuncao = new JLabel("Função");
        jtfFuncao = new JTextField(30);
        jlObservacao = new JLabel("Observação");
        jtfObservacao = new JTextField(30);
        jlValor = new JLabel("Valor Serv");
        jtfValor = new JTextFieldSomenteNumeros(true);
        jlStatus = new JLabel("Status");
        jtfStatus = new JComboBox();

        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlDescricao);
        jpCampos.add(jtfDescricao);
        jpCampos.add(jlFuncao);
        jpCampos.add(jtfFuncao);
        jpCampos.add(jlObservacao);
        jpCampos.add(jtfObservacao);
        jpCampos.add(jlValor);
        jpCampos.add(jtfValor);
        jpCampos.add(jlStatus);
        jpCampos.add(jtfStatus);
        
        try {
            Vector linhas = new Vector();
            
            for (String st : status) {
                Vector linha = new Vector();
                linha.add(st);
                linhas.add(linha);
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfStatus.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }
    

        // posicao dos componentes
        jlCodigo.setBounds(15, 30, 85, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(120, 30, 100, 25);
        jlDescricao.setBounds(15, 60, 85, 25);
        jtfDescricao.setBounds(120, 60, 300, 25);
        jlFuncao.setBounds(15, 90, 85, 25);
        jtfFuncao.setBounds(120, 90, 300, 25);
        jlObservacao.setBounds(15, 120, 85, 25);
        jtfObservacao.setBounds(120, 120, 400, 25);
        jlValor.setBounds(15, 150, 85, 25);
        jtfValor.setBounds(120, 150, 80, 25);
        jlStatus.setBounds(15, 180, 85, 25);
        jtfStatus.setBounds(120, 180, 150, 25);

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
                    equ = new Equipamento();
                    equ = getObjetoFromCampos();
                    if (equ != null){
                        equipamentoController.gravar(equ);
                        JOptionPane.showMessageDialog(null, "O Equipamento foi cadastrado com sucesso!");
                        limpaCampos();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Erro no cadastro do Tipo Serviço!");
                    }
                }
            }
        );

        // ==============================================================
        jbAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (camposValidos()) {
                        equipamentoController.atualizar(getObjetoFromCampos());
                        jbAlterar.setEnabled(false);
                        jbExcluir.setEnabled(false);
                        jbGravar.setEnabled(true);
                        limpaCampos();
                        JOptionPane.showMessageDialog(null, "O Equipamento foi alterado com sucesso!");
                    }
                }
            }
        );

        //=================================================================
        jbExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    equipamentoController.remover(equ);
                    limpaCampos();
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Equipamento excluido com sucesso!");
                }
            }
        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaEquipamento cEqu = new ConsultaEquipamento();
                    cEqu.setModal(true);
                    cEqu.setVisible(true);
                    if (cEqu.getObjetoSelecionado() != null) {
                        preencheCampos(cEqu.getObjetoSelecionado());
                        jbAlterar.setEnabled(true);
                        jbExcluir.setEnabled(true);
                        jbGravar.setEnabled(false);
                    }
                }
            }
        );
    }

    public boolean camposValidos() {
        if (jtfCodigo.getText() == "" || jtfDescricao.getText() == "");
        return true;
    }

    public Equipamento getObjetoFromCampos() {
        equ.setDescricao(jtfDescricao.getText());
        equ.setFuncao(jtfFuncao.getText());
        equ.setObservacao(jtfObservacao.getText());
        try {
            equ.setValorServico(Double.valueOf(jtfValor.getText()));
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Valor invalido no campo Valor Serviço");
            return null;
        }
        if(status.get(jtfStatus.getSelectedIndex()).equals("Ativado"))
            equ.setStatus(true);
        else
            equ.setStatus(false);

        return equ;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfDescricao.setText("");
        this.jtfFuncao.setText("");
        this.jtfObservacao.setText("");
        this.jtfValor.setText("");
        this.jtfStatus.setSelectedIndex(0);
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        equ = (Equipamento) obj;

        this.jtfCodigo.setText(String.valueOf(equ.getId()));
        this.jtfDescricao.setText(equ.getDescricao());
        this.jtfFuncao.setText(equ.getFuncao());
        this.jtfObservacao.setText(equ.getObservacao());
        this.jtfValor.setText(String.valueOf(equ.getValorServico()));
        if(equ.isStatus())
            jtfStatus.setSelectedIndex(0);
        else
            jtfStatus.setSelectedIndex(1);
    }
    

}
