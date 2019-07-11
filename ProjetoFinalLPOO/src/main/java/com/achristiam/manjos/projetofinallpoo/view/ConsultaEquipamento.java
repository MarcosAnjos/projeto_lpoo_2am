package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.EquipamentoController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Equipamento;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.util.List;

import java.util.Vector;

public class ConsultaEquipamento extends ConsultaPadrao {

    // atributos
    private List<Equipamento> equipamentoss;
    private EquipamentoController equipamentoController;

    // metodos
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Descrição");
        cab.add("Função");
        cab.add("Observação");
        cab.add("Valor Serv");
        cab.add("Status");
        return cab;
    }

    public Vector getLinhas() {
        Vector linhas = new Vector();
        equipamentoController = new EquipamentoController();
        equipamentoss = equipamentoController.buscarTodos();

        for (Equipamento e : equipamentoss) {
            Vector linha = new Vector();
            linha.add(e.getId());
            linha.add(e.getDescricao());
            linha.add(e.getFuncao());
            linha.add(e.getObservacao());
            linha.add(e.getValorServico());
            if(e.isStatus())
                linha.add("Ativado");
            else
                linha.add("Desativado");
            linhas.add(linha);
        }

        return linhas;
    }

    public Object getObjetoSelecionado(int posicao) {
        Equipamento e = new Equipamento();
        e = (Equipamento) equipamentoss.get(posicao);
        return e;
    }
}
