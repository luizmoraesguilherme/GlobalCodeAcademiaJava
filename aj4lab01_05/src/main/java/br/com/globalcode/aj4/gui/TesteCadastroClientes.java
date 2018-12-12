/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.globalcode.aj4.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Globalcode
 * 
 */
public class TesteCadastroClientes extends JFrame {

	public TesteCadastroClientes(String titulo) {
		super(titulo);
		// Indica que quando a janela for fechada, a execucao da classe
		// sera finalizada, caso contrario, a classe continuara na memoria
		// depois que a janela for fechada
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			add(new PainelCadastroClientes());
			super.setSize(300, 250);
			this.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(),
					"Mensgem de Erro", JOptionPane.OK_OPTION);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TesteCadastroClientes gf = new TesteCadastroClientes(
				"Teste Cadastro Clientes");
		gf.setVisible(true);
	}
}
