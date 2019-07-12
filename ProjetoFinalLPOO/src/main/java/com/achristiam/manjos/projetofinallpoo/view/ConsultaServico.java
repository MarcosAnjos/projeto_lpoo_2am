package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ServicoController;
import com.achristiam.manjos.projetofinallpoo.model.bo.ParseDate;
import com.achristiam.manjos.projetofinallpoo.model.vo.Servico;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.util.List;

import java.util.Vector;

public class ConsultaServico extends ConsultaPadrao {

    // atributos
    private List<Servico> servicoss;
    private ServicoController servicoController;
    
    // metodos
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Data Requisição");
        cab.add("Descrição");
        cab.add("Cliente");
        cab.add("Funcionario");
        cab.add("Valor Total");
        cab.add("Tempo Total");
        cab.add("Data Entrega");
        cab.add("Forma Pagamento");
        cab.add("Observação");
        return cab;
    }

    public Vector getLinhas() {
        Vector linhas = new Vector();
        servicoController = new ServicoController();
        servicoss = servicoController.buscarTodos();

        for (Servico v : servicoss) {
            Vector linha = new Vector();
            linha.add(v.getId());
            linha.add(ParseDate.parseString(v.getDataRequisicao()));
            linha.add(v.getDescricao());
            linha.add(v.getCliente().getNome());
            linha.add(v.getFuncionario().getNome());
            linha.add(v.getValorTotal());
            linha.add(v.getTempoTotal());
            linha.add(v.getDataEntrega());
            linha.add(v.getFormaPagamento());
            linha.add(v.getObservacao());
            linhas.add(linha);
        }

        return linhas;
    }

    public Object getObjetoSelecionado(int posicao) {
        Servico c = new Servico();
        c = (Servico) servicoss.get(posicao);
        return c;
    }
}
