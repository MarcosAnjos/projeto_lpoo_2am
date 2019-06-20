package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.ClienteController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Cliente;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.util.List;

import java.util.Vector;

public class ConsultaCliente extends ConsultaPadrao {

    // atributos
    private List<Cliente> clientess;
    private ClienteController clienteController;

    // metodos
    public Vector getCabecalho() {
        Vector cab = new Vector();
        cab.add("Código");
        cab.add("Nome");
        return cab;
    }

    public Vector getLinhas() {
        Vector linhas = new Vector();
        clienteController = new ClienteController();
        clientess = clienteController.buscarTodos();

        for (Cliente c : clientess) {
            Vector linha = new Vector();
            linha.add(c.getId());
            linha.add(c.getNome());
            linhas.add(linha);
        }

        return linhas;
    }

    public Object getObjetoSelecionado(int posicao) {
        Cliente c = new Cliente();
        c = (Cliente) clientess.get(posicao);
        return c;
    }
}
