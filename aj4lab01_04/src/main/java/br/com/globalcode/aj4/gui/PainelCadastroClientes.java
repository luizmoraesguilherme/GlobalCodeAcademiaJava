/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.globalcode.aj4.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.globalcode.aj4.gui.eventos.EventosMouseListener;
import br.com.globalcode.model.Cliente;
import br.com.globalcode.util.GlobalcodeException;

/**
 * Esta classe monta um painel para cadastro de clientes. Para ser visualizada,
 * ela deve ser adicionada a um JFrame ou outro container.
 * 
 */
public class PainelCadastroClientes extends JPanel {

	private JLabel lNome;
	private JTextField tfNome;
	private JLabel lTelefone;
	private JTextField tfTelefone;
	private JLabel lCPF;
	private JTextField tfCPF;
	private JLabel lID;
	private JTextField tfID;
	private JPanel pCadastroCliente;
	private JPanel pBotoesCadastro;
	private JButton bExcluir;
	private JButton bSalvar;
	private JButton bNovo;

	/**
	 * Este construtor monta um Panel para insercao de dados de Cadastro de
	 * Clientes,
	 */
	public PainelCadastroClientes() throws GlobalcodeException {
		this.setLayout(new BorderLayout());
		// Montagem do painel com caixas de texto para o cadastro de cliente
		pCadastroCliente = montaPanelCadastroCliente();
		// Montagem do painel com botoes para salvar ou excluir clientes
		pBotoesCadastro = montaPanelBotoesCadastro();
		// Adicao dos dois paineis no frame principal
		this.add(pCadastroCliente, BorderLayout.CENTER);
		this.add(pBotoesCadastro, BorderLayout.SOUTH);
	}

	/**
	 * Metodo utilizado internamente para montagem do JPanel com o botao Salvar,
	 * por isto ele foi declarado como private.
	 * 
	 * @return JPanel com o botao Salvar, para salvar um cliente
	 */
	private JPanel montaPanelBotoesCadastro() {
		JPanel pBotoesCadastro = new JPanel();

		bSalvar = new JButton("Salvar");
		bSalvar.setMnemonic(KeyEvent.VK_S);

		/*
		 * f) Este deve ser o ultimo passo a ser executado no lab.
		 * 
		 * Altere o listener do botao bSalvar: use um listener da Inner Class
		 * SalvarClienteListener.
		 */
		bSalvar.addMouseListener(new EventosMouseListener());
		
		pBotoesCadastro.add(bSalvar);

		bExcluir = new JButton("Excluir");
		bExcluir.setMnemonic(KeyEvent.VK_E);
		pBotoesCadastro.add(bExcluir);

		bNovo = new JButton("Novo");
		bNovo.setMnemonic(KeyEvent.VK_N);
		pBotoesCadastro.add(bNovo);

		return pBotoesCadastro;
	}

	/**
	 * Metodo utilizado internamente para montagem do JPanel para cadastro ou
	 * edicao de um cliente, por isto ele foi declarado como private.
	 * 
	 * @return JPanel para cadastro ou edicao de um cliente
	 * 
	 */
	private JPanel montaPanelCadastroCliente() {
		JPanel pCadastroCliente = new JPanel();
		GridLayout layout = new GridLayout(8, 1);
		pCadastroCliente.setLayout(layout);

		lNome = new JLabel("Nome:");
		tfNome = new JTextField();

		lTelefone = new JLabel("Telefone:");
		tfTelefone = new JTextField();

		lCPF = new JLabel("CPF:");
		tfCPF = new JTextField();

		lID = new JLabel("ID:");
		tfID = new JTextField();
		tfID.setEditable(false);

		pCadastroCliente.add(lNome);
		pCadastroCliente.add(tfNome);
		pCadastroCliente.add(lTelefone);
		pCadastroCliente.add(tfTelefone);
		pCadastroCliente.add(lCPF);
		pCadastroCliente.add(tfCPF);
		pCadastroCliente.add(lID);
		pCadastroCliente.add(tfID);

		return pCadastroCliente;
	}

	/**
	 * Metodo utilizado internamente para fazer a leitura dos dados do cliente
	 * dos JTextFields. Os dados lidas dos campos de texto sao usados para criar
	 * um objeto do tipo Cliente.
	 * 
	 * @return Cliente com os dados obtidos dos JTextFields
	 * 
	 */
	private Cliente loadClienteFromPanel() throws GlobalcodeException {
		System.out.println("Salvando os dados do Cliente...");
		/*
		 * a) Obtenha os dados digitados nos JTextFields (tfXXX) usando o metodo
		 * getText(). Armazene cada dado lido em uma variavel para usar
		 * posteriormente.
		 */

		String nome = null;
		String telefone = null;
		String cpf = null;

		/*
		 * b) Instancie um objeto do tipo Cliente usando os dados lidos dos
		 * JTextFields e retorne este objeto como resultado do metodo.
		 */
		return null;
	}

	/**
	 * Metodo utilizado internamente para fazer a limpeza dos JTextFields dos
	 * dados do cliente.
	 */
	private void clearClienteFromPanel() {
		// c) Faca a limpeza dos campos de texto colocando uma String vazia ("")
		// por meio do metodo setText(String s) do componente JTextField
		System.out.println("Limpando o painel de cadastro de clientes");
	}

	/**
	 * Metodo utilizado internamente para atribuir aos JTextField, os dados de
	 * um objeto Cliente.
	 * 
	 * @param cliente
	 *            cliente a ser apresentado na tela
	 */
	private void loadClienteToPanel(Cliente c) {
		if (c != null) {
			/*
			 * d) Obtenha os dados do objeto Cliente recebido como parametro e
			 * atribua aos JTextFields para apresentar os dados do cliente na
			 * tela (use o metodo setText do JTextField).
			 */
		}
	}

	/**
	 * Listener de eventos de mouse exclusivo para o botao bSalvar (para salvar
	 * clientes).
	 */
	class SalvarClienteListener extends MouseAdapter {

		/*
		 * e) Sobrescreva o metodo (handler) mouseClicked.
		 * 
		 * Esse handler deve acionar o metodo loadClienteFromPanel para guardar
		 * os dados da tela no objeto Cliente.
		 * 
		 * O objeto Cliente recuperado deve ser impresso na console.
		 */
	}
}