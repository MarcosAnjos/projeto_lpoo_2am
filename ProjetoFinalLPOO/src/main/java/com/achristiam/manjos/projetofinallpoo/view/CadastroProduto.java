package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.model.bo.JTextFieldSomenteNumeros;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.view.model.CadastroPadrao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CadastroProduto extends CadastroPadrao {

    private static final long serialVersionUID = 1L;

    private JPanel jpCampos;
    private JLabel jlCodigo, jlDescricao, jlValCompra, jlValVenda;
    private JLabel jlValServico, jlQuantidade;
    private JTextField jtfCodigo, jtfDescricao;
    private JTextField jtfValCompra, jtfValVenda, jtfValServico;
    
    private JTextField jtfQuantidade;

    private ProdutoController produtoController = new ProdutoController();
    private Produto prod;
    
    private boolean gravar;
    
    DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat format = new DecimalFormat("#0.00", unusualSymbols);

    public CadastroProduto() throws ParseException {
        super("Cadastro de Produto", true, true, true, true);   
        
        gravar = false;
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlDescricao = new JLabel("Descrição");
        jtfDescricao = new JTextField(30);
        jlValCompra = new JLabel("Valor Compra");
        jtfValCompra = new JTextFieldSomenteNumeros(true);
        jlValVenda = new JLabel("Valor Venda");
        jtfValVenda = new JTextFieldSomenteNumeros(true);
        jlValServico = new JLabel("Valor Serviço");
        jtfValServico = new JTextFieldSomenteNumeros(true);
        jlQuantidade = new JLabel("Quantidade");
        jtfQuantidade = new JTextFieldSomenteNumeros();
        

        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlDescricao);
        jpCampos.add(jtfDescricao);
        jpCampos.add(jlValCompra);
        jpCampos.add(jtfValCompra);
        jpCampos.add(jlValVenda);
        jpCampos.add(jtfValVenda);
        jpCampos.add(jlValServico);
        jpCampos.add(jtfValServico);
        jpCampos.add(jlQuantidade);
        jpCampos.add(jtfQuantidade);
        

        // posicao dos componentes
        jlCodigo.setBounds(15, 30, 65, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(120, 30, 100, 25);
        jlDescricao.setBounds(15, 60, 75, 25);
        jtfDescricao.setBounds(120, 60, 100, 25);
        jlValCompra.setBounds(15, 90, 95, 25);
        jtfValCompra.setBounds(120, 90, 100, 25);
        jlValVenda.setBounds(15, 120, 95, 25);
        jtfValVenda.setBounds(120, 120, 100, 25);
        jlValServico.setBounds(15, 150, 95, 25);
        jtfValServico.setBounds(120, 150, 100, 25);
        jlQuantidade.setBounds(15, 180, 85, 25);
        jtfQuantidade.setBounds(120, 180, 100, 25);
        
        
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
                    prod = getObjetoFromCampos();
                    if(prod != null){
                        produtoController.gravar(prod);
                        JOptionPane.showMessageDialog(null, "O Produto foi cadastrado com sucesso!");
                        limpaCampos();
                    }
                }
            }
        );

        // ==============================================================
        jbAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (camposValidos()) {
                        prod = getObjetoFromCampos();
                        if(prod != null){
                            produtoController.atualizar(getObjetoFromCampos());
                            jbAlterar.setEnabled(false);
                            jbExcluir.setEnabled(false);
                            jbGravar.setEnabled(true);
                            limpaCampos();
                            JOptionPane.showMessageDialog(null, "O Produto foi alterado com sucesso!");
                        }
                    }
                }
            }
        );

        //=================================================================
        jbExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    produtoController.remover(prod);
                    limpaCampos();
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
                }
            }
        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaProduto cProd = new ConsultaProduto();
                    cProd.setModal(true);
                    cProd.setVisible(true);
                    if (cProd.getObjetoSelecionado() != null) {
                        preencheCampos(cProd.getObjetoSelecionado());
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

    public Produto getObjetoFromCampos() {
        String val;
        
        if(gravar) prod = new Produto();
        
        
        
        prod.setDescricao(jtfDescricao.getText());
        try {
            val = format.format(Double.valueOf(jtfValCompra.getText()));
            prod.setValorCompra(Double.valueOf(val));
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Valor invalido de Compra");
            gravar = false;
            return null;
        }
        try {
            val = format.format(Double.valueOf(jtfValVenda.getText()));
            prod.setValorVenda(Double.valueOf(jtfValVenda.getText()));
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Valor invalido de Venda");
            gravar = false;
            return null;
        }
        
        try {
            val = format.format(Double.valueOf(jtfValServico.getText()));
            prod.setValorServico(Double.valueOf(jtfValServico.getText()));
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Valor invalido de Serviço");
            gravar = false;
            return null;
        }

        prod.setQuantidadeEstoque(Integer.valueOf(jtfQuantidade.getText()));
        
        gravar = false;
        return prod;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfDescricao.setText("");
        this.jtfValCompra.setText("");
        this.jtfValVenda.setText("");
        this.jtfValServico.setText("");
        this.jtfQuantidade.setText("");
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        prod = (Produto) obj;

        this.jtfCodigo.setText(String.valueOf(prod.getId()));
        this.jtfDescricao.setText(prod.getDescricao());
        this.jtfValCompra.setText(String.valueOf(prod.getValorCompra()));
        this.jtfValVenda.setText(String.valueOf(prod.getValorVenda()));
        this.jtfValServico.setText(String.valueOf(prod.getValorServico()));
        this.jtfQuantidade.setText(String.valueOf(prod.getQuantidadeEstoque()));
    }

}
