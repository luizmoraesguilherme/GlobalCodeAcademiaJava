/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.globalcode.aj4.swing;

import javax.swing.JFrame;

public class FrameSwing extends JFrame {

	public FrameSwing(String title) {
		// Indicacao do titulo da janela
		super(title);

		// Utilizamos a constante declarada na classe JFrame para definir
		// o comportamento padrao no fechamento da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Configuracao do tamanho da janela
		this.setSize(275, 100);
		// Tornando a janela visivel
		this.setVisible(true);
	}

	// O metodo main cria uma instancia do FrameAWT que faz com que a janela
	// seja exibida.
	public static void main(String args[]) {
		FrameSwing t = new FrameSwing("Janela Swing");
	}
}
