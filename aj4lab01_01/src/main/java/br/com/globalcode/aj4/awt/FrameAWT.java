/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.globalcode.aj4.awt;

import java.awt.*;

public class FrameAWT extends Frame {

	public FrameAWT(String title) {
		// Indicacao do titulo da janela
		this.setTitle(title);
		// Configuracao do tamanho da janela
		this.setSize(200, 100);
		// Tornando a janela visivel
		this.setVisible(true);
	}

	// O metodo main cria uma instancia do FrameAWT que faz com que a janela
	// seja exibida.
	public static void main(String args[]) {
		FrameAWT janela = new FrameAWT("Titulo da Janela");
	}
}
