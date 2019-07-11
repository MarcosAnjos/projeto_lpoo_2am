package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.EquipamentoController;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.controller.TipoServicoController;
import com.achristiam.manjos.projetofinallpoo.model.bo.JTextFieldSomenteNumeros;
import com.achristiam.manjos.projetofinallpoo.model.vo.Equipamento;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServico;
import com.achristiam.manjos.projetofinallpoo.view.model.CadastroPadrao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CadastroTipoServico extends CadastroPadrao {

    private static final long serialVersionUID = 1L;
    
    NumberFormat money = NumberFormat.getCurrencyInstance();
    
    private ProdutoController produtoController = new ProdutoController();
    private List<Produto> produtos;
    private List<Produto> listProdutos;
    
    private EquipamentoController equipamentoController = new EquipamentoController();
    private List<Equipamento> equipamentos;
    private List<Equipamento> listEquipamentos;
    
    private List<Double> tempos;
    private List<Integer> quantidades;
    
    private Equipamento equi;
    private Produto prod;
    
    private ComboBoxModel modelo;
    private DefaultTableModel modelEqui, modelProd;

    private JPanel jpCampos;
    private JLabel jlCodigo, jlDescricao, jlTempo, jlEquipamento, jlProduto;
    private JLabel jlCustoMaoObra, jlTempoEquipamento, jlQuantidadeProd;
    private JLabel jlTempoTotal, jlValorTotal, jtfTempoTotal, jtfValorTotal;
    private JTextField jtfCodigo, jtfDescricao, jtfTempo, jtfCustoMaoObra;
    private JTextField jtfTempoEquipamento, jtfQuantidadeProd;
    private JComboBox jtfEquipamento, jtfProduto;
    
    private JButton btAdicionarEquipamento, btAdicionarProduto;
    private JButton btRemoverEquipamento, btRemoverProduto;
    
    private JScrollPane jspEquipamentos, jspProdutos;
    private JTable jtEquipamentos, jtProdutos;

    private TipoServicoController tipoServicoController = new TipoServicoController();
    private TipoServico tserv;
    
    private Double tempoTotal = 0.0;
    private Double valorTotal = 0.0;
    
    public CadastroTipoServico() {
        super("Cadastro de TipoServico", true, true, true, true);


        tempos = new ArrayList<>();
        quantidades = new ArrayList<>();
        listEquipamentos = new ArrayList<>();
        listProdutos = new ArrayList<>();
        
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlDescricao = new JLabel("Descrição");
        jtfDescricao = new JTextField(30);
        jlTempo = new JLabel("Tempo");
        jtfTempo = new JTextFieldSomenteNumeros(true);
        jlCustoMaoObra = new JLabel("Val Mão Obra");
        jtfCustoMaoObra = new JTextFieldSomenteNumeros(true);
        jlEquipamento = new JLabel("Equipamento");
        jtfEquipamento = new JComboBox();
        jlProduto = new JLabel("Produto");
        jtfProduto = new JComboBox();
        
        jlTempoEquipamento = new JLabel("Tempo");
        jtfTempoEquipamento = new JTextFieldSomenteNumeros(true);
        
        btAdicionarEquipamento = new JButton("Adicionar");
        btRemoverEquipamento = new JButton("Remover");
        
        jlQuantidadeProd = new JLabel("Quantidade");
        jtfQuantidadeProd = new JTextFieldSomenteNumeros(true);
        
        btAdicionarProduto = new JButton("Adicionar");
        btRemoverProduto = new JButton("Remover");
        
        jlTempoTotal = new JLabel("Tempo Total");
        jtfTempoTotal = new JLabel("0.00");
        jlValorTotal = new JLabel("Valor Total");
        jtfValorTotal = new JLabel("R$ 0.00");
        
        jlTempoTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        jtfTempoTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        jlValorTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        jtfValorTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
                
        jtEquipamentos = new JTable(null,getCabecalhoEquipamento());
        modelEqui = (DefaultTableModel)jtEquipamentos.getModel();
        jspEquipamentos = new JScrollPane(jtEquipamentos);
        
        jtProdutos = new JTable(null,getCabecalhoProduto());
        modelProd = (DefaultTableModel)jtProdutos.getModel();
        jspProdutos = new JScrollPane(jtProdutos);
        
        try {
            Vector linhas = new Vector();
            produtos = produtoController.buscarTodos();
            
            for (int i = 0;i < produtos.size();i++) {
                Vector linha = new Vector();
                linha.add(produtos.get(i).getDescricao());
                linhas.add(linha);
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfProduto.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        try {
            Vector linhas = new Vector();
            equipamentos = equipamentoController.buscarTodos();
            
            for (int i = 0;i < equipamentos.size();i++) {
                Vector linha = new Vector();
                linha.add(equipamentos.get(i).getDescricao());
                linhas.add(linha);
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfEquipamento.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }

        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlDescricao);
        jpCampos.add(jtfDescricao);
        jpCampos.add(jlTempo);
        jpCampos.add(jtfTempo);
        jpCampos.add(jlCustoMaoObra);
        jpCampos.add(jtfCustoMaoObra);
        jpCampos.add(jlEquipamento);
        jpCampos.add(jtfEquipamento);
        jpCampos.add(jlTempoEquipamento);
        jpCampos.add(jtfTempoEquipamento);
        jpCampos.add(btAdicionarEquipamento);
        jpCampos.add(btRemoverEquipamento);
        
        jpCampos.add(jspEquipamentos);
        
        jpCampos.add(jlTempoTotal);
        jpCampos.add(jtfTempoTotal);
        
        jpCampos.add(jlProduto);
        jpCampos.add(jtfProduto);
        jpCampos.add(jlQuantidadeProd);
        jpCampos.add(jtfQuantidadeProd);
        jpCampos.add(btAdicionarProduto);
        jpCampos.add(btRemoverProduto);
        
        jpCampos.add(jspProdutos);
        
        jpCampos.add(jlValorTotal);
        jpCampos.add(jtfValorTotal);

        // posicao dos componentes
        jlCodigo.setBounds(15, 30, 105, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(140, 30, 100, 25);
        jlDescricao.setBounds(15, 60, 105, 25);
        jtfDescricao.setBounds(140, 60, 100, 25);
        jlTempo.setBounds(15, 90, 105, 25);
        jtfTempo.setBounds(140, 90, 100, 25);
        jlCustoMaoObra.setBounds(15, 120, 105, 25);
        jtfCustoMaoObra.setBounds(140, 120, 100, 25);
        jlEquipamento.setBounds(15, 150, 105, 25);
        jtfEquipamento.setBounds(140, 150, 200, 25);
        jlTempoEquipamento.setBounds(15, 180, 105, 25);
        jtfTempoEquipamento.setBounds(140, 180, 100, 25);
        
        btAdicionarEquipamento.setBounds(500, 180, 120, 25);
        btRemoverEquipamento.setBounds(500, 350, 120, 25);
        jlTempoTotal.setBounds(15, 350, 140, 25);
        jtfTempoTotal.setBounds(160, 350, 120, 25);
        
        jspEquipamentos.setBounds(15, 210, 605, 130);
        
        jlProduto.setBounds(15, 380, 105, 25);
        jtfProduto.setBounds(140, 380, 200, 25);
        jlQuantidadeProd.setBounds(15, 410, 105, 25);
        jtfQuantidadeProd.setBounds(140, 410, 100, 25);
        btAdicionarProduto.setBounds(500, 410, 120, 25);
        
        jspProdutos.setBounds(15, 440, 605, 130);
        btRemoverProduto.setBounds(500, 580, 120, 25);
        jlValorTotal.setBounds(15, 580, 120, 25);
        jtfValorTotal.setBounds(140, 580, 120, 25);
        
        this.add(jpBotoes, BorderLayout.SOUTH);
        jpBotoes.setVisible(true);

        this.add(jpCampos);
        this.setVisible(true);
        this.pack();
        
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        
        btRemoverEquipamento.setEnabled(false);
        btRemoverProduto.setEnabled(false);
        
        btAdicionarEquipamento.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    try {
                        double tempo = Double.parseDouble(jtfTempoEquipamento.getText());
                        
                        if(tempo > 0) {
                        
                            equi = (Equipamento) getEquipamentoSelecionado(jtfEquipamento.getSelectedIndex());

                            tempos.add(tempo);
                            listEquipamentos.add(equi);

                            Vector linha = new Vector();
                            linha.add(equi.getId());
                            linha.add(equi.getDescricao());
                            linha.add(tempo);
                            linha.add(equi.getValorServico());
                            tempoTotal += tempo;
                            modelEqui.addRow(linha);                      
                            jtEquipamentos.validate();
                            
                            jtfTempoTotal.setText(String.valueOf(tempoTotal));
                            jtfTempoEquipamento.setText("");
                        } else {
                            jtfTempoEquipamento.setText("");
                            JOptionPane.showMessageDialog(null, "Digite um valor maior que 0");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo quantidade");
                    }
                }
            }
        );
        
        btRemoverEquipamento.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    //System.out.println(jtDados.getSelectedRow());
                    tempoTotal -= tempos.get(jtEquipamentos.getSelectedRow());
                    listEquipamentos.remove(jtEquipamentos.getSelectedRow());
                    tempos.remove(jtEquipamentos.getSelectedRow());    
                    modelEqui.removeRow(jtEquipamentos.getSelectedRow());
                    jtfTempoTotal.setText(String.valueOf(tempoTotal));
                    btRemoverEquipamento.setEnabled(false);
                    jtfTempo.setFocusable(true);
                }
            }
        );
        
        jtEquipamentos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btRemoverEquipamento.setEnabled(true);
                //System.out.println(jtDados.rowAtPoint(evt.getPoint()));
            }
        });
        
        btAdicionarProduto.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    try {
                        int quant = Integer.parseInt(jtfQuantidadeProd.getText());
                        
                        if(quant > 0) {
                        
                            prod = (Produto) getProdutoSelecionado(jtfProduto.getSelectedIndex());

                            quantidades.add(quant);
                            listProdutos.add(prod);

                            Vector linha = new Vector();
                            linha.add(prod.getId());
                            linha.add(prod.getDescricao());
                            linha.add(quant);
                            linha.add(prod.getValorServico());
                            valorTotal += prod.getValorServico() * quant;
                            linha.add(valorTotal);
                            modelProd.addRow(linha);                      
                            jtProdutos.validate();
                            
                            jtfValorTotal.setText(money.format(valorTotal));
                            jtfQuantidadeProd.setText("");
                        } else {
                            jtfQuantidadeProd.setText("");
                            JOptionPane.showMessageDialog(null, "Digite um valor maior que 0");
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo quantidade");
                    }
                }
            }
        );
        
        btRemoverProduto.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    //System.out.println(jtDados.getSelectedRow());
                    valorTotal -= (listProdutos.get(jtProdutos.getSelectedRow()).getValorVenda() 
                            * quantidades.get(jtProdutos.getSelectedRow()));
                    listProdutos.remove(jtProdutos.getSelectedRow());
                    quantidades.remove(jtProdutos.getSelectedRow());    
                    modelProd.removeRow(jtProdutos.getSelectedRow());
                    jtfValorTotal.setText(money.format(valorTotal));
                    btRemoverProduto.setEnabled(false);
                    jtfQuantidadeProd.setFocusable(true);
                   
                }
            }
        );
        
        jtProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btRemoverProduto.setEnabled(true);
                //System.out.println(jtDados.rowAtPoint(evt.getPoint()));
            }
        });

        jbGravar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    tserv = new TipoServico();
                    tipoServicoController.gravar(getObjetoFromCampos());
                    JOptionPane.showMessageDialog(null, "O TipoServico foi cadastrado com sucesso!");
                    limpaCampos();
                }
            }
        );

        // ==============================================================
        jbAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (camposValidos()) {
                        tipoServicoController.atualizar(getObjetoFromCampos());
                        jbAlterar.setEnabled(false);
                        jbExcluir.setEnabled(false);
                        jbGravar.setEnabled(true);
                        limpaCampos();
                        JOptionPane.showMessageDialog(null, "O TipoServico foi alterado com sucesso!");
                    }
                }
            }
        );

        //=================================================================
        jbExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    tipoServicoController.remover(tserv);
                    limpaCampos();
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "TipoServico excluido com sucesso!");
                }
            }
        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaTipoServico cTserv = new ConsultaTipoServico();
                    cTserv.setModal(true);
                    cTserv.setVisible(true);
                    if (cTserv.getObjetoSelecionado() != null) {
                        preencheCampos(cTserv.getObjetoSelecionado());
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

    public TipoServico getObjetoFromCampos() {
        tserv.setDescricao(jtfDescricao.getText());

        return tserv;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfDescricao.setText("");
        this.jtfCustoMaoObra.setText("");
        this.jtfEquipamento.setSelectedIndex(0);
        this.jtfProduto.setSelectedIndex(0);
        this.jtfTempo.setText("");
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        tserv = (TipoServico) obj;

        this.jtfCodigo.setText(String.valueOf(tserv.getId()));
        this.jtfDescricao.setText(tserv.getDescricao());
        this.jtfCustoMaoObra.setText(String.valueOf(tserv.getCustoMaoObra()));
        this.jtfTempo.setText(String.valueOf(tserv.getTempoMin()));
    }
    
    public Vector getCabecalhoEquipamento() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Equipamento");
        cab.add("Tempo");
        cab.add("Valor Serv");
        return cab;
    }
    
    public Vector getCabecalhoProduto() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Produto");
        cab.add("Quantidade");
        cab.add("Valor Serv");
        cab.add("Valor Total");
        return cab;
    }
    
    public Object getProdutoSelecionado(int posicao) {
        Produto p = new Produto();
        p = (Produto) produtos.get(posicao);
        
        return p;
    }
    
    public Object getEquipamentoSelecionado(int posicao) {
        Equipamento e = new Equipamento();
        e = (Equipamento) equipamentos.get(posicao);
        
        return e;
    }

}
