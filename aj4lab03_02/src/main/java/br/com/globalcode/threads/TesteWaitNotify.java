package br.com.globalcode.threads;

import javax.swing.JOptionPane;

public class TesteWaitNotify {

	public static void main(String args[]) throws Exception {

		// inicializando repositorio de dados
		ListaConvidados lista = new ListaConvidados();

		Thread t1 = new Thread(new EntregadorDeConvite(lista),"entregador1");
		Thread t2 = new Thread(new EntregadorDeConvite(lista),"entregador2");
		// disparando entregadores de convites
		// sao as threads consumidoras do repositorio de dados
		t1.start();
		t2.start();

		// loop de entrada de dados
		// esta thread (main) é a produtora de dados
		while (true) {
			// obtem um novo email para adicionar na lista
			String email = JOptionPane.showInputDialog(
					"Digite o email do proximo convidado ", "");
			if (email != null) {
				lista.adicionar(email);
			} else {
				lista.fecharLista();
				break; // para sair do loop
			}
		}
	}
}
