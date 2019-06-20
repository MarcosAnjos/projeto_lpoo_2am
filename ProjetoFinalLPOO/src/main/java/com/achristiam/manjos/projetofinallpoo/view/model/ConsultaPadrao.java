package com.achristiam.manjos.projetofinallpoo.view.model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class ConsultaPadrao extends JDialog {
	
	//	 atributos
	private JButton jbOk      = new JButton("Ok");
	private JButton jbCancela = new JButton("Cancela");	
	private JScrollPane jspDados;
	protected JTable      jtDados;
	private Object objetoSelecionado = null;
	
	// metodos
	public ConsultaPadrao()
	{
            super();

            this.getContentPane().setLayout(new BorderLayout());

            JPanel jpBotoes = new JPanel();
            jpBotoes.add(jbOk);
            jpBotoes.add(jbCancela);

            this.add(jpBotoes, BorderLayout.SOUTH);

            jtDados = new JTable(getLinhas(), getCabecalho());
            jspDados = new JScrollPane(jtDados);

            this.add(jspDados, BorderLayout.CENTER);

            this.setSize(670,500);

            jbOk.addActionListener( new ActionListener(){

                public void actionPerformed(ActionEvent e)
                {
                       if (jtDados.getSelectedRow() != -1)
                               objetoSelecionado = getObjetoSelecionado(jtDados.getSelectedRow());					 
                       dispose();  
                }
            });

            jbCancela.addActionListener( new ActionListener(){

                      public void actionPerformed(ActionEvent e)
                      {
                              objetoSelecionado = null;
                              dispose(); 
                      }
            });
	}

	public Object getObjetoSelecionado()
	{
		return this.objetoSelecionado;
	}	

	public abstract Vector getLinhas();
	public abstract Vector getCabecalho();
	public abstract Object getObjetoSelecionado(int posicao);
}
