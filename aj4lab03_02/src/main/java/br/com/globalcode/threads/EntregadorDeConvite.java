package br.com.globalcode.threads;

public class EntregadorDeConvite implements Runnable {

	private ListaConvidados listaConvidados;

	public EntregadorDeConvite(ListaConvidados lista) {
		this.listaConvidados = lista;
	}

	public void run() {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + " iniciando atividades");
		boolean estaAberta = listaConvidados.isAberta();
		int quantidadePendente = listaConvidados.getQuantidadeEmailsPendentes();
		while (estaAberta || quantidadePendente > 0) {
			try {
				String email = listaConvidados.obterEmailConvidado();
				if (email != null) {
					System.out.println(nomeThread + " enviando email para "
							+ email);
					// acesso ao servidor de email e envio da mensagem
					// simulando uma lentidao de ate 10 segundos
					Thread.sleep((int) (Math.random() * 10000));
					System.out.println("... envio de convite para " + email
							+ " concluido");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// verificando situacao da lista
			estaAberta = listaConvidados.isAberta();
			quantidadePendente = listaConvidados.getQuantidadeEmailsPendentes();
		}
		System.out.println(nomeThread + " encerrando atividades");
	}
}
