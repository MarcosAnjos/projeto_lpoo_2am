package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.TipoServicoController;
import com.achristiam.manjos.projetofinallpoo.model.vo.TipoServico;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.util.List;

import java.util.Vector;

public class ConsultaTipoServico extends ConsultaPadrao {

    // atributos
    private List<TipoServico> tipoServicoss;
    private TipoServicoController tipoServicoController;

    // metodos
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Descricao");
        cab.add("Tempo");
        cab.add("Custo Mão de Obra");
        cab.add("Tempo Total");
        cab.add("Custo Total");
        return cab;
    }

    public Vector getLinhas() {
        Vector linhas = new Vector();
        tipoServicoController = new TipoServicoController();
        tipoServicoss = tipoServicoController.buscarTodos();

        for (TipoServico ts : tipoServicoss) {
            Vector linha = new Vector();
            linha.add(ts.getId());
            linha.add(ts.getDescricao());
            linha.add(ts.getTempoMin());
            linha.add(ts.getCustoMaoObra());
            linha.add(ts.getTempoTotal());
            linha.add(ts.getValorTotal());
            linhas.add(linha);
        }

        return linhas;
    }

    public Object getObjetoSelecionado(int posicao) {
        TipoServico ts = new TipoServico();
        ts = (TipoServico) tipoServicoss.get(posicao);
        return ts;
    }
}
