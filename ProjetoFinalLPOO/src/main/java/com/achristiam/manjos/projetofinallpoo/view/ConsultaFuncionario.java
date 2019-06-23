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
    private List<Usuario> usuarioss;
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
        usuarioController = new UsuarioController();
        usuarioss = usuarioController.buscarTodos();

        for (Usuario u : usuarioss) {
            Vector linha = new Vector();
            linha.add(u.getFuncionario().getId());
            linha.add(u.getFuncionario().getNome());
            linha.add(u.getLogin());
            linha.add("****");
            linhas.add(linha);
        }

        return linhas;
    }

    @Override
    public Object getObjetoSelecionado(int posicao) {
        Usuario u = new Usuario();
        u = (Usuario) usuarioss.get(posicao);
        return u;
    }
}
