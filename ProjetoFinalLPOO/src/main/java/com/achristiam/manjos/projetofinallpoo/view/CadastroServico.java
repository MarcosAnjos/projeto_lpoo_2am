package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.controller.TipoServicoController;
import com.achristiam.manjos.projetofinallpoo.controller.ServicoController;
import com.achristiam.manjos.projetofinallpoo.controller.ServicoTipoServicoController;
import com.achristiam.manjos.projetofinallpoo.controller.TipoServicoEquipamentoController;
import com.achristiam.manjos.projetofinallpoo.controller.TipoServicoProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.bo.JTextFieldSomenteNumeros;
import com.achristiam.manjos.projetofinallpoo.model.bo.ParseDate;
import com.achristiam.manjos.projetofinallpoo.model.bo.SingletonUsuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServico;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Servico;
import com.achristiam.manjos.projetofinallpoo.model.vo.ServicoTipoServico;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServicoEquipamento;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServicoProduto;
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

public class CadastroServico extends CadastroPadrao {

    private static final long serialVersionUID = 1L;

    NumberFormat z = NumberFormat.getCurrencyInstance();
    
    Usuario usr = SingletonUsuario.getInstance();
    
    private JPanel jpCampos;
    
    private JLabel jlCodigo, jlDataRequisicao, jlDescricao, jlTipoServico; 
    private JLabel jlQuantidade, jlValTotal, jtfValTotal, jlTempoTotal, jtfTempoTotal;
    private JLabel jlCliente, jlFuncionario, jlClienteNome, jlFormaPagamento;
    private JLabel jtfFormaPagamentoRet, jlDataEntrega, jlObservacao;
    
    private JTextField jtfCodigo, jtfDataRequisicao, jtfDescricao, jtfQuantidade;
    private JTextField jtfDataEntrega, jtfObservacao;
      
    private JComboBox jtfTipoServico, jtfCliente, jtfFormaPagamento;

    private JButton btAdicionar, btRemover;
    
    private JScrollPane jspDados;
    private JTable jtDados;
    
    private ServicoController servicoController = new ServicoController();
    private ServicoTipoServicoController servicoTipoServicoController = new ServicoTipoServicoController();
    private Servico ser;
    private ServicoTipoServico serTpSer = new ServicoTipoServico();
    
    private ClienteController clienteController = new ClienteController();
    private List<Cliente> clientes;
    
    private TipoServicoController tipoServicoController = new TipoServicoController();
    private TipoServico tpSer;
    private List<TipoServico> tipoServicos;
    
    private List<TipoServico> listTipoServicos;
    private List<Integer> quantidades;
    private List<Double> tempos;
    private List<Double> valores;
    
    private List<ServicoTipoServico> servicoTipoServicos;
    
    private List<String> opcoes;
    
    private Double totalTempo = 0.0;
    private Double totalValor = 0.0;
    
    private Date hoje = new Date();
    
    DefaultTableModel model;
    
    ComboBoxModel modelo;
    
    private TipoServicoEquipamentoController tsec = new TipoServicoEquipamentoController();
    private TipoServicoProdutoController tspc = new TipoServicoProdutoController();
    private ProdutoController produtoController = new ProdutoController();
    
    private Produto prod;
    
    private List<TipoServicoEquipamento> tipoServicoEquipamentos;
    private List<TipoServicoProduto> tipoServicoProdutos;
    
    private List<Produto> produtos = new ArrayList<>();
    private List<List<Produto>> listProdutos = new ArrayList<>();
    
    public CadastroServico() {
        super("Cadastro de Serviço", true, true, true, true);
        
        this.listTipoServicos = new ArrayList<>();
        this.quantidades = new ArrayList<>();
        this.tempos = new ArrayList<>();
        this.valores = new ArrayList<>();
        
        this.servicoTipoServicos = new ArrayList<>();
        
        this.opcoes = new ArrayList<>();
        
        this.opcoes.add("Cartão de Credito");
        this.opcoes.add("Cartão de Debito");
        this.opcoes.add("Dinheiro");
        this.opcoes.add("Cheque");
        
        
        jpCampos = new JPanel();

        jlCodigo = new JLabel("Código");
        jtfCodigo = new JTextField(10);
        jtfCodigo.setEditable(false);
        jlDataRequisicao = new JLabel("Data Requisição");
        try {
            jtfDataRequisicao = new JFormattedTextField(new MaskFormatter("##/##/####"));
            jtfDataRequisicao.setText(ParseDate.parseString(hoje));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlDataEntrega = new JLabel("Data Entrega");
        try {
            jtfDataEntrega = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        jlDescricao = new JLabel("Descrição");
        jtfDescricao = new JTextField();
        jlObservacao = new JLabel("Observação");
        jtfObservacao = new JTextField();
        jlCliente = new JLabel("Cliente");
        jlClienteNome = new JLabel();
        jtfCliente = new JComboBox();
        jlTipoServico = new JLabel("TipoServiço");
        jtfTipoServico = new JComboBox();
        jlQuantidade = new JLabel("Quantidade");
        jtfQuantidade = new JTextFieldSomenteNumeros();
        btAdicionar = new JButton("Adicionar");
        btRemover = new JButton("Remover");
        jlValTotal = new JLabel("Total");
        jtfValTotal = new JLabel("R$ 0,00");
        jlTempoTotal = new JLabel("Tempo Total");
        jtfTempoTotal = new JLabel("0.00");
        
        jlFormaPagamento = new JLabel("Forma de Pagamento");
        jtfFormaPagamentoRet = new JLabel();
        jtfFormaPagamentoRet.setVisible(false);
        jtfFormaPagamento = new JComboBox();
        
        jlValTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        jtfValTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        jlTempoTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        jtfTempoTotal.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        
        
        

        jtDados = new JTable(null,getCabecalho());
        model = (DefaultTableModel)jtDados.getModel();
        jspDados = new JScrollPane(jtDados);
        
        jlFuncionario = new JLabel();
        
        this.setLayout(new BorderLayout());
        jpCampos.setLayout(null);
        jpCampos.add(jlCodigo);
        jpCampos.add(jlClienteNome);
        jpCampos.add(jtfCodigo);
        jpCampos.add(jlDataRequisicao);
        jpCampos.add(jtfDataRequisicao);
        jpCampos.add(jlDataEntrega);
        jpCampos.add(jtfDataEntrega);
        jpCampos.add(jlDescricao);
        jpCampos.add(jtfDescricao);
        jpCampos.add(jlObservacao);
        jpCampos.add(jtfObservacao);
        jpCampos.add(jlCliente);
        jpCampos.add(jtfCliente);
        jpCampos.add(jlTipoServico);
        jpCampos.add(jtfTipoServico);
        jpCampos.add(jlQuantidade);
        jpCampos.add(jtfQuantidade);
        jpCampos.add(btAdicionar);
        jpCampos.add(btRemover);
        jpCampos.add(jlValTotal);
        jpCampos.add(jtfValTotal);
        jpCampos.add(jlTempoTotal);
        jpCampos.add(jtfTempoTotal);
        jpCampos.add(jlFuncionario);
        
        jpCampos.add(jlFormaPagamento);
        jpCampos.add(jtfFormaPagamentoRet);
        jpCampos.add(jtfFormaPagamento);
        
        
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
        
        preencherTipoServicos();
        
        
        try {
            Vector linhas = new Vector();
            
            for (String op : opcoes) {
                Vector linha = new Vector();
                linha.add(op);
                linhas.add(linha);
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfFormaPagamento.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        
        jpCampos.add(jspDados);
        
        jlClienteNome.setVisible(false);

        // posicao dos componentes
        jlCodigo.setBounds(15, 40, 100, 25);  // MD, MS, Lrg ,Alt
        jtfCodigo.setBounds(140, 40, 100, 25);
        
        jlFormaPagamento.setBounds(450, 130, 170, 25);
        jtfFormaPagamentoRet.setBounds(450, 160, 170, 25);
        jtfFormaPagamento.setBounds(450, 160, 170, 25);
        
        jlDataRequisicao.setBounds(15, 70, 120, 25);
        jtfDataRequisicao.setBounds(140, 70, 100, 25);
        jlDescricao.setBounds(300, 70, 90, 25);
        jtfDescricao.setBounds(300, 100, 320, 25);
        jlCliente.setBounds(15, 100, 120, 25);
        jtfCliente.setBounds(140, 100, 150, 25);
        jlClienteNome.setBounds(140, 120, 150, 25);
        jlTipoServico.setBounds(15, 130, 120, 25);
        jtfTipoServico.setBounds(140, 130, 150, 25);
        jlQuantidade.setBounds(15, 160, 120, 25);
        jtfQuantidade.setBounds(140, 160, 150, 25);
        btAdicionar.setBounds(300, 160, 120, 25);
        
        jspDados.setBounds(15, 190, 605, 340);
        
        jlValTotal.setBounds(15, 540, 100, 25);
        jtfValTotal.setBounds(90, 540, 250, 25);
        btRemover.setBounds(500, 540, 120, 25);
        
        jlObservacao.setBounds(15, 580, 100, 25);
        jtfObservacao.setBounds(110, 580, 300, 25);
        jlDataEntrega.setBounds(420, 580, 100, 25);
        jtfDataEntrega.setBounds(530, 580, 90, 25);
        
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
                        
                        if(quant > 0) {
                            boolean flag = true;
                            tpSer = (TipoServico) getTipoServicoSelecionado(jtfTipoServico.getSelectedIndex());
                            tipoServicoProdutos = tspc.buscarProdutosTipoServico(tpSer.getId().intValue());
                            tipoServicoEquipamentos = tsec.buscarEquipamentosTipoServico(tpSer.getId().intValue());
                            
                            for (TipoServicoProduto i : tipoServicoProdutos){
                                if(!(i.getProduto().getQuantidadeEstoque() - quant * i.getQuantidade() >= 0)){
                                    jtfQuantidade.setText("");
                                    JOptionPane.showMessageDialog(null, "Produto "+i.getProduto().getDescricao()+" não é suficiente");
                                    produtos.clear();
                                    flag = false;
                                    break;
                                }
                                i.getProduto().setQuantidadeEstoque(i.getProduto().getQuantidadeEstoque() - quant * i.getQuantidade());
                                produtos.add(i.getProduto());
                            }
                            
                            for (TipoServicoEquipamento i : tipoServicoEquipamentos){
                                if(!(i.getEquipamento().isStatus())){
                                    jtfQuantidade.setText("");
                                    JOptionPane.showMessageDialog(null, "Equipamento "+i.getEquipamento().getDescricao()+" Desativado");
                                    flag = false;
                                    break;
                                }
                            }

                            if(flag){
                                //tpSer.setQuantidadeEstoque(tpSer.getQuantidadeEstoque()-quant);

                                //tipoServicos.set(jtfTipoServico.getSelectedIndex(),tpSer);
                                
                                listProdutos.add(produtos);
                                produtos.clear();

                                quantidades.add(quant);
                                listTipoServicos.add(tpSer);
//                                tempos.add(tpSer.getTempoTotal());
//                                valores.add(tpSer.getValorTotal());

                                Vector linha = new Vector();
                                linha.add(tpSer.getId());
                                linha.add(tpSer.getDescricao());
                                linha.add(quant);
                                linha.add(tpSer.getTempoTotal());
                                linha.add(tpSer.getTempoTotal() * quant);
                                linha.add(z.format(tpSer.getValorTotal()));
                                linha.add(z.format(tpSer.getValorTotal() * quant));
                                totalValor += tpSer.getValorTotal() * quant;
                                totalTempo += tpSer.getTempoTotal() * quant;
                                model.addRow(linha);                      
                                jtDados.validate();
                                
                                jtfTempoTotal.setText(totalTempo.toString());
                                jtfValTotal.setText(z.format(totalValor));
                                jtfQuantidade.setText("");
                            }
                        } else {
                            jtfQuantidade.setText("");
                            JOptionPane.showMessageDialog(null, "Digite um valor maior que 0");
                        }
                       

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
                    totalValor -= (listTipoServicos.get(jtDados.getSelectedRow()).getValorTotal()
                            * quantidades.get(jtDados.getSelectedRow()));
                    totalTempo -= (listTipoServicos.get(jtDados.getSelectedRow()).getTempoTotal()
                            * quantidades.get(jtDados.getSelectedRow()));
                    listProdutos.remove(jtDados.getSelectedRow());
                    listTipoServicos.remove(jtDados.getSelectedRow());
                    quantidades.remove(jtDados.getSelectedRow());    
                    model.removeRow(jtDados.getSelectedRow());
                    jtfValTotal.setText(z.format(totalValor));
                    jtfTempoTotal.setText(z.format(totalTempo));
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
                    ser = new Servico();
                    ser = getObjetoFromCampos();
                    servicoController.gravar(ser);
                    
                    for(int i = 0; i < quantidades.size(); i++){
                        serTpSer = new ServicoTipoServico();
                        
                        
                        
                        listProdutos.get(i).forEach((_item) -> {
                            prod = produtoController.buscarUm(_item.getId());
                            prod.setQuantidadeEstoque(_item.getQuantidadeEstoque());
                            produtoController.atualizar(prod);
                        });
                        
                        serTpSer.setTipoServico(tpSer);
                        serTpSer.setQuantidade(quantidades.get(i));
                        serTpSer.setValorServico(tpSer.getValorTotal());
                        serTpSer.setServico(ser);
                        
                        servicoTipoServicoController.gravar(serTpSer);
                    }
                    
                    JOptionPane.showMessageDialog(null, "O Servico foi cadastrado com sucesso!");
                    limpaCampos();
                    preencherTipoServicos();
                }
            }
        );

//        // ==============================================================
//        jbAlterar.addActionListener(
//            new ActionListener() {
//                public void actionPerformed(ActionEvent ev) {
//                    if (camposValidos()) {
//                        servicoController.atualizar(getObjetoFromCampos());
//                        jbAlterar.setEnabled(false);
//                        jbExcluir.setEnabled(false);
//                        jbGravar.setEnabled(true);
//                        limpaCampos();
//                        JOptionPane.showMessageDialog(null, "O Servico foi alterado com sucesso!");
//                    }
//                }
//            }
//        );
//
//        //=================================================================
//        jbExcluir.addActionListener(
//            new ActionListener() {
//                public void actionPerformed(ActionEvent ev) {
//                    servicoController.remover(ser);
//                    limpaCampos();
//                    jbAlterar.setEnabled(false);
//                    jbExcluir.setEnabled(false);
//                    jbGravar.setEnabled(true);
//                    JOptionPane.showMessageDialog(null, "Servico excluido com sucesso!");
//                }
//            }
//        );

        //=================================================================
        jbBuscar.addActionListener(
            new ActionListener() {

                public void actionPerformed(ActionEvent ev) {
                    ConsultaServico cVen = new ConsultaServico();
                    cVen.setModal(true);
                    cVen.setVisible(true);
                    if (cVen.getObjetoSelecionado() != null) {
                        preencheCampos(cVen.getObjetoSelecionado());
//                        if(usr.getLogin() == "admin"){
//                            jbAlterar.setEnabled(true);
//                            jbExcluir.setEnabled(true);
//                        }
                        jbGravar.setEnabled(false);
                    }
                }
            }
        );
    }

    public boolean camposValidos() {
        if (jtfCodigo.getText() == "" || jtfDataRequisicao.getText() == "");
        return true;
    }

    public Servico getObjetoFromCampos() {
        ser.setDataRequisicao(ParseDate.parseDate(jtfDataRequisicao.getText()));
        ser.setCliente((Cliente) getClienteSelecionado(jtfCliente.getSelectedIndex()));
        ser.setFuncionario(usr.getFuncionario());
        ser.setFormaPagamento(getFormaPagamentoSelecionado(jtfFormaPagamento.getSelectedIndex()));
        ser.setDataEntrega(ParseDate.parseDate(jtfDataEntrega.getText()));
        ser.setDescricao(jtfDescricao.getText());
        ser.setObservacao(jtfObservacao.getText());
        ser.setTempoTotal(totalTempo);
        ser.setValorTotal(totalValor);
        return ser;
    }
	
    public void limpaCampos() {
        this.jtfCodigo.setText("");
        this.jtfDataRequisicao.setText(ParseDate.parseString(hoje));
        try{
            this.jtfCliente.setSelectedIndex(0);
            this.jtfTipoServico.setSelectedIndex(0);
            this.jtfFormaPagamento.setSelectedIndex(0);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        this.jtfValTotal.setText("R$ 0,00");
        this.jtfTempoTotal.setText("0.00");
        this.jtfDescricao.setText("");
        this.jtfObservacao.setText("");
        this.jtfDataEntrega.setText("");
        
        totalValor = 0.0;
        totalTempo = 0.0;
        
        while(model.getRowCount() > 0) model.removeRow(0);
        
        listTipoServicos.clear();
        quantidades.clear();
        
        this.jtfCliente.setVisible(true);
        this.jlClienteNome.setVisible(false);
        this.jtfTipoServico.setVisible(true);
        this.jtfQuantidade.setVisible(true);
        this.btAdicionar.setVisible(true);
        this.btRemover.setVisible(true);
        this.jtfDataEntrega.setEditable(true);
        
        this.jtDados.setEnabled(true);
        
        this.jtfFormaPagamentoRet.setVisible(false);
        this.jtfFormaPagamento.setVisible(true);
    }

    public void preencheCampos(Object obj) {
        limpaCampos();
        ser = (Servico) obj;
        
        this.jlFuncionario.setText(ser.getFuncionario().getNome());

        this.jtfCodigo.setText(String.valueOf(ser.getId()));
        this.jtfDataRequisicao.setText(ParseDate.parseString(ser.getDataRequisicao()));
        this.jlClienteNome.setText(ser.getCliente().getNome());
        this.jtfFormaPagamentoRet.setText(ser.getFormaPagamento());
        this.jtfValTotal.setText(String.valueOf(ser.getValorTotal()));
        this.jtfTempoTotal.setText(String.valueOf(ser.getTempoTotal()));
        this.jtfDescricao.setText(ser.getDescricao());
        this.jtfObservacao.setText(ser.getObservacao());
        this.jtfDataEntrega.setText(ParseDate.parseString(ser.getDataEntrega()));
        
        this.jtfDataEntrega.setEditable(false);
        this.jtfCliente.setVisible(false);
        this.jlClienteNome.setVisible(true);
        this.jtfTipoServico.setVisible(false);
        this.jtfQuantidade.setVisible(false);
        this.btAdicionar.setVisible(false);
        this.btRemover.setVisible(false);
        
        this.jtDados.setEnabled(false);
        
        this.jtfFormaPagamentoRet.setVisible(true);
        this.jtfFormaPagamento.setVisible(false);
        
        this.jtfValTotal.setText(String.valueOf(z.format(ser.getValorTotal())));
        this.jtfTempoTotal.setText(String.valueOf(ser.getTempoTotal()));
        
        servicoTipoServicos = servicoTipoServicoController.buscarTipoServicos(ser.getId().intValue());
        
        for (ServicoTipoServico vp : servicoTipoServicos) {
            Vector linha = new Vector();
            linha.add(vp.getTipoServico().getId());
            linha.add(vp.getTipoServico().getDescricao());
            linha.add(vp.getQuantidade());
            linha.add(vp.getTipoServico().getTempoTotal());
            linha.add(vp.getQuantidade() * vp.getTipoServico().getTempoTotal());
            linha.add(z.format(vp.getTipoServico().getValorTotal()));
            linha.add(z.format(vp.getTipoServico().getValorTotal()* vp.getQuantidade()));
            model.addRow(linha);
            jtDados.validate();
        }
        
    }
    
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("TipoServico");
        cab.add("Quantidade");
        cab.add("Tempo Unitario");
        cab.add("Tempo Total");
        cab.add("Valor Unitario");
        cab.add("Valor Total");
        return cab;
    }

    
    public Object getTipoServicoSelecionado(int posicao) {
        TipoServico ts = new TipoServico();
        ts = (TipoServico) tipoServicos.get(posicao);
        
        return ts;
    }
    
    public Object getClienteSelecionado(int posicao) {
        Cliente c = new Cliente();
        c = (Cliente) clientes.get(posicao);
        
        return c;
    }
    
    public String getFormaPagamentoSelecionado(int posicao) {
        return opcoes.get(posicao);
    }

    private void preencherTipoServicos() {
        try {
            Vector linhas = new Vector();
            tipoServicos = tipoServicoController.buscarTodos();
            
            for (int i = 0;i < tipoServicos.size();i++) {
//                if(tipoServicos.get(i)..getQuantidadeEstoque() > 0){
                    Vector linha = new Vector();
                    linha.add(tipoServicos.get(i).getDescricao());
                    linhas.add(linha);
//                }
//                else {
//                    tipoServicos.remove(i);
//                    i--;
//                }
            }
            modelo = new DefaultComboBoxModel(linhas);
            jtfTipoServico.setModel(modelo);
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

}
