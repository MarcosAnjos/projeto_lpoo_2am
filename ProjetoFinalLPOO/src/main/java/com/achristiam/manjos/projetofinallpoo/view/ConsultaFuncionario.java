package com.achristiam.manjos.projetofinallpoo.view;

import com.achristiam.manjos.projetofinallpoo.controller.FuncionarioController;
import com.achristiam.manjos.projetofinallpoo.controller.UsuarioController;
import com.achristiam.manjos.projetofinallpoo.model.vo.Funcionario;
import com.achristiam.manjos.projetofinallpoo.model.vo.Usuario;
import com.achristiam.manjos.projetofinallpoo.view.model.ConsultaPadrao;
import java.util.List;

import java.util.Vector;

public class ConsultaFuncionario extends ConsultaPadrao {

    // atributos
    private List<Funcionario> funcionarioss;
    private FuncionarioController funcionarioController;
    private Usuario usuario;
    private UsuarioController usuarioController;

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
        funcionarioController = new FuncionarioController();
        funcionarioss = funcionarioController.buscarTodos();

        for (Funcionario f : funcionarioss) {
            Vector linha = new Vector();
            linha.add(f.getId());
            linha.add(f.getNome());
            linha.add(f.getUsuario().getLogin());
            linha.add("*******");
            linhas.add(linha);
        }

        return linhas;
    }

    @Override
    public Object getObjetoSelecionado(int posicao) {
        Funcionario c = new Funcionario();
        c = (Funcionario) funcionarioss.get(posicao);
        return c;
    }
}
