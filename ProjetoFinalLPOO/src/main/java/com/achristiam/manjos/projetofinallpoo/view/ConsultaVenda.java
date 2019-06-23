package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.VendaController;
import com.achristiam.manjos.projetofinallpoo.model.bo.ParseDate;
import com.achristiam.manjos.projetofinallpoo.model.vo.Venda;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.text.NumberFormat;
import java.util.List;

import java.util.Vector;

public class ConsultaVenda extends ConsultaPadrao {

    // atributos
    private List<Venda> vendass;
    private VendaController vendaController;
    
    //NumberFormat z = NumberFormat.getCurrencyInstance();
    
    
    // metodos
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Data Venda");
        cab.add("Forma Pagamento");
        cab.add("Desconto");
        cab.add("Valor Total");
        cab.add("Cliente");
        cab.add("Funcionario");
        return cab;
    }

    public Vector getLinhas() {
        Vector linhas = new Vector();
        vendaController = new VendaController();
        vendass = vendaController.buscarTodos();

        for (Venda v : vendass) {
            Vector linha = new Vector();
            linha.add(v.getId());
            linha.add(ParseDate.parseString(v.getData()));
            linha.add(v.getFormaPagamento());
            linha.add(v.getDesconto());
            linha.add(v.getValorTotal());
            linha.add(v.getCliente().getNome());
            linha.add(v.getFuncionario().getNome());
            linhas.add(linha);
        }

        return linhas;
    }

    public Object getObjetoSelecionado(int posicao) {
        Venda v = new Venda();
        v = (Venda) vendass.get(posicao);
        return v;
    }
}
