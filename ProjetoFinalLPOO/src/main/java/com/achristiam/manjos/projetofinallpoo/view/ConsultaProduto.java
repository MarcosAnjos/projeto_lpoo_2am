package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ProdutoController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Produto;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.util.List;

import java.util.Vector;

public class ConsultaProduto extends ConsultaPadrao {

    // atributos
    private List<Produto> produtoss;
    private ProdutoController produtoController;

    // metodos
    @Override
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Nome");
        cab.add("Login");
        cab.add("Senha");
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
        Produto c = new Produto();
        c = (Produto) produtoss.get(posicao);
        return c;
    }
}
