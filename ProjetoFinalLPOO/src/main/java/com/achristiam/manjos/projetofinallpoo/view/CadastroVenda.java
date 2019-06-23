package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.controller.VendaController;
import com.achristiam.manjos.projetofinallpoo.controller.VendaProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.bo.JTextFieldSomenteNumeros;
import com.achristiam.manjos.projetofinallpoo.model.bo.ParseDate;
import com.achristiam.manjos.projetofinallpoo.model.bo.SingletonUsuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Venda;
import com.achristiam.manjos.projetofinallpoo.model.vo.VendaProduto;
import com.achristiam.manjos.projetofinallpoo.view.model.CadastroPadrao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class CadastroVenda extends CadastroPadrao {

    private static final long serialVersionUID = 1L;

    NumberFormat z = NumberFormat.getCurrencyInstance();
    
    Usuario usr = SingletonUsuario.getInstance();
    
    private JPanel jpCampos;
    private JLabel jlCodigo, jlData, jlProduto, jlQuantidade, jlTotal, jtfTotal;
    private JLabel jlCliente, jlFuncionario;
    private JTextField jtfCodigo, jtfData, jtfQuantidade;
      
    private JComboBox jtfProduto, jtfCliente;

    private JButton btAdicionar, btRemover;
    
    private JScrollPane jspDados;
    private JTable jtDados;
    
    private VendaController vendaController = new VendaController();
    private VendaProdutoController vendaProdutoController = new VendaProdutoController();
    private Venda ven;
    private VendaProduto venProd = new VendaProduto();
    
    private ClienteController clienteController = new ClienteController();
    private List<Cliente> clientes;
    
    private ProdutoController produtoController = new ProdutoController();
    private Produto prod;
    private List<Produto> produtos;
    
    private List<Produto> listProdutos;
    private List<Integer> quantidades;
    
    private Double total = 0.0;
    
    private Date hoje = new Date();
    
    DefaultTableModel model;

    
    private boolean gravar;
    
    public CadastroVenda() {
        super("Cadastro de Venda", true, true, true, true);
        
        this.listProdutos = new ArrayList<>();
        this.quantidades = new ArrayList<>();
        
        gravar = false;
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlData = new JLabel("Data");
        try {
            jtfData = new JFormattedTextField(new MaskFormatter("##/##/####"));
            jtfData.setText(ParseDate.parseString(hoje));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlCliente = new JLabel("Cliente");
        jtfCliente = new JComboBox();
        jlProduto = new JLabel("Produto");
        jtfProduto = new JComboBox();
        jlQuantidade = new JLabel("Quantidade");
        jtfQuantidade = new JTextFieldSomenteNumeros();
        btAdicionar = new JButton("Adicionar");
        btRemover = new JButton("Remover");
        jlTotal = new JLabel("Total");
        jtfTotal = new JLabel("R$ 0,00");
        
        jlTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        jtfTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));

        jtDados = new JTable(null,getCabecalho());
        model = (DefaultTableModel)jtDados.getModel();
        jspDados = new JScrollPane(jtDados);
        
        jlFuncionario = new JLabel();
        
        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlData);
        jpCampos.add(jtfData);
        jpCampos.add(jlCliente);
        jpCampos.add(jtfCliente);
        jpCampos.add(jlProduto);
        jpCampos.add(jtfProduto);
        jpCampos.add(jlQuantidade);
        jpCampos.add(jtfQuantidade);
        jpCampos.add(btAdicionar);
        jpCampos.add(btRemover);
        jpCampos.add(jlTotal);
        jpCampos.add(jtfTotal);
        jpCampos.add(jlFuncionario);
        
        ComboBoxModel modelo;
        
        try {
            Vector linhas = new Vector();
            clientes = clienteController.buscarTodos();
            
            for (Cliente c : clientes) {
                Vector linha = new Vector();
                linha.add(c.getNome());
                linhas.add(linha);
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfCliente.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        try {
            Vector linhas = new Vector();
            produtos = produtoController.buscarTodos();
            
            for (Produto p : produtos) {
                Vector linha = new Vector();
                linha.add(p.getDescricao());
                linhas.add(linha);
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfProduto.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        
        
        jpCampos.add(jspDados);
        

        // posicao dos componentes
        jlCodigo.setBounds(15, 40, 65, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(100, 40, 100, 25);
        jlData.setBounds(15, 70, 65, 25);
        jtfData.setBounds(100, 70, 100, 25);
        jlCliente.setBounds(15, 100, 100, 25);
        jtfCliente.setBounds(100, 100, 150, 25);
        jlProduto.setBounds(15, 130, 100, 25);
        jtfProduto.setBounds(100, 130, 150, 25);
        jlQuantidade.setBounds(15, 160, 100, 25);
        jtfQuantidade.setBounds(100, 160, 100, 25);
        btAdicionar.setBounds(210, 160, 120, 25);
        
        jspDados.setBounds(15, 190, 605, 200);
        
        jlTotal.setBounds(15, 400, 100, 25);
        jtfTotal.setBounds(90, 400, 250, 25);
        btRemover.setBounds(500, 400, 120, 25);
        
        jlFuncionario.setBounds(15, 8, 200, 25);

        this.add(jpBotoes, BorderLayout.SOUTH);
        jpBotoes.setVisible(true);

        this.add(jpCampos);
        this.setVisible(true);
        this.pack();
        
        jlFuncionario.setText("Funcionario: " + usr.getFuncionario().getNome());
        
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        btRemover.setEnabled(false);
        
        btAdicionar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    try {
                        int quant = Integer.parseInt(jtfQuantidade.getText());
                        
                        prod = (Produto) getProdutoSelecionado(jtfProduto.getSelectedIndex());
                        listProdutos.add(prod);
                        quantidades.add(quant);
                        Vector linha = new Vector();
                        linha.add(prod.getId());
                        linha.add(prod.getDescricao());
                        linha.add(quant);
                        linha.add(z.format(prod.getValorVenda()));
                        linha.add(z.format(prod.getValorVenda() * quant));
                        total += prod.getValorVenda() * quant;
                        model.addRow(linha);                      
                        jtDados.validate();
                        
                        jtfTotal.setText(z.format(total));
                        jtfQuantidade.setText("");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo quantidade");
                    }
                }
            }
        );
        
        
        btRemover.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    //System.out.println(jtDados.getSelectedRow());
                    total -= (listProdutos.get(jtDados.getSelectedRow()).getValorVenda() 
                            * quantidades.get(jtDados.getSelectedRow()));
                    listProdutos.remove(jtDados.getSelectedRow());
                    quantidades.remove(jtDados.getSelectedRow());    
                    model.removeRow(jtDados.getSelectedRow());
                    jtfTotal.setText(z.format(total));
                    btRemover.setEnabled(false);
                   
                }
            }
        );
        
        jtDados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btRemover.setEnabled(true);
                //System.out.println(jtDados.rowAtPoint(evt.getPoint()));
            }
        });
        

        jbGravar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    gravar = true;
                    ven = getObjetoFromCampos();
                    ven.setValorTotal(total);
                    vendaController.gravar(ven);
                    
                    for(int i = 0; i < quantidades.size(); i++){
                        venProd.setProduto(listProdutos.get(i));
                        venProd.setQuantidade(quantidades.get(i));
                        venProd.setValorVenda(listProdutos.get(i).getValorVenda());
                        venProd.setVenda(ven);
                        
                        vendaProdutoController.gravar(venProd);
                    }
                    
                    JOptionPane.showMessageDialog(null, "O Venda foi cadastrado com sucesso!");
                    limpaCampos();
                }
            }
        );

        // ==============================================================
        jbAlterar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (camposValidos()) {
                        vendaController.atualizar(getObjetoFromCampos());
                        jbAlterar.setEnabled(false);
                        jbExcluir.setEnabled(false);
                        jbGravar.setEnabled(true);
                        limpaCampos();
                        JOptionPane.showMessageDialog(null, "O Venda foi alterado com sucesso!");
                    }
                }
            }
        );

        //=================================================================
        jbExcluir.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    vendaController.remover(ven);
                    limpaCampos();
                    jbAlterar.setEnabled(false);
                    jbExcluir.setEnabled(false);
                    jbGravar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Venda excluido com sucesso!");
                }
            }
        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaVenda cVen = new ConsultaVenda();
                    cVen.setModal(true);
                    cVen.setVisible(true);
                    if (cVen.getObjetoSelecionado() != null) {
                        preencheCampos(cVen.getObjetoSelecionado());
                        jbAlterar.setEnabled(true);
                        jbExcluir.setEnabled(true);
                        jbGravar.setEnabled(false);
                    }
                }
            }
        );
    }

    public boolean camposValidos() {
        if (jtfCodigo.getText() == "" || jtfData.getText() == "");
        return true;
    }

    public Venda getObjetoFromCampos() {
        if(gravar) ven = new Venda();
        ven.setData(ParseDate.parseDate(jtfData.getText()));
        ven.setCliente((Cliente) getClienteSelecionado(jtfCliente.getSelectedIndex()));
        ven.setFuncionario(usr.getFuncionario());
        ven.setDesconto(0.0);
        ven.setFormaPagamento("");
        gravar = false;
        return ven;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfData.setText(ParseDate.parseString(hoje));
        this.jtfCliente.setSelectedIndex(0);
        this.jtfProduto.setSelectedIndex(0);
        this.jtfTotal.setText("R$ 0,00");
        while(model.getRowCount() > 0) model.removeRow(0);
        total = 0.0;
        listProdutos.clear();
        quantidades.clear();
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        ven = (Venda) obj;

        this.jtfCodigo.setText(String.valueOf(ven.getId()));
        this.jtfData.setText(ParseDate.parseString(ven.getData()));
    }
    
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Produto");
        cab.add("Quantidade");
        cab.add("Valor Unitario");
        cab.add("Valor Total");
        return cab;
    }

    
    public Object getProdutoSelecionado(int posicao) {
        Produto p = new Produto();
        p = (Produto) produtos.get(posicao);
        
        return p;
    }
    
    public Object getClienteSelecionado(int posicao) {
        Cliente c = new Cliente();
        c = (Cliente) clientes.get(posicao);
        
        return c;
    }

}
