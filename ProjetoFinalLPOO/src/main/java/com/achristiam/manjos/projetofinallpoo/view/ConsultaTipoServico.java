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
