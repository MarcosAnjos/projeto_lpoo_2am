/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.bo;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author DevMedia
 */
public final class JTextFieldSomenteNumeros extends JTextField {

    private int maximoCaracteres = 10;// definição de -1 
// como  valor normal de um textfield sem limite de caracters
    

    public JTextFieldSomenteNumeros() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt, false);
            }
        });
    }
    
    public JTextFieldSomenteNumeros(boolean decimal) {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt, decimal);
            }
        });
    }

    private void jTextFieldKeyTyped(KeyEvent evt, boolean decimal) {
        String caracteres = "0987654321";
        if (decimal) {caracteres = "0987654321.";}
        if (!caracteres.contains(evt.getKeyChar() + "")) {// se o caracter que gerou o evento estiver não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento
        }
        if ((getText().length() >= getMaximoCaracteres()) && (getMaximoCaracteres() != -1)) {
//if para saber se precisa verificar também o tamanho da string do campo
// maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
            evt.consume();
            setText(getText().substring(0, getMaximoCaracteres()));
// esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o //conteúdo de algum lugar, ou seja, com tamanho maior que o definido

        }//fim do if do tamanho da string do campo

    }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }

    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}
