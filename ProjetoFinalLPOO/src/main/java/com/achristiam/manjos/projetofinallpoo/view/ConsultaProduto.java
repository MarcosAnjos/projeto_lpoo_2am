package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.text.NumberFormat;
import java.util.List;

import java.util.Vector;

public class ConsultaProduto extends ConsultaPadrao {

    //NumberFormat z = NumberFormat.getCurrencyInstance();
    
    // atributos
    private List<Produto> produtoss;
    private ProdutoController produtoController;

    // metodos
    @Override
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Descrição");
        cab.add("Valor Compra");
        cab.add("Valor Venda");
        cab.add("Valor Serviço");
        cab.add("Quantidade");
        return cab;
    }

    @Override
    public Vector getLinhas() {
        Vector linhas = new Vector();
        produtoController = new ProdutoController();
        produtoss = produtoController.buscarTodos();

        for (Produto p : produtoss) {
            Vector linha = new Vector();
            linha.add(p.getId());
            linha.add(p.getDescricao());
            linha.add(p.getValorCompra());
            linha.add(p.getValorVenda());
            linha.add(p.getValorServico());
            linha.add(p.getQuantidadeEstoque());
            linhas.add(linha);
        }

        return linhas;
    }

    @Override
    public Object getObjetoSelecionado(int posicao) {
        Produto p = new Produto();
        p = (Produto) produtoss.get(posicao);
        return p;
    }
}
