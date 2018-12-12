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

	/*
	 * a) Defina um atributo private do tipo ComboClientes
	 */

	/**
	 * Este construtor monta um Panel para insercao de dados de Cadastro de
	 * Clientes,
	 */
	public PainelCadastroClientes() throws GlobalcodeException {
		this.setLayout(new BorderLayout());
		pCadastroCliente = montaPanelCadastroCliente();
		pBotoesCadastro = montaPanelBotoesCadastro();
		this.add(pCadastroCliente, BorderLayout.CENTER);
		this.add(pBotoesCadastro, BorderLayout.SOUTH);
		/*
		 * b) Instancie o cbClientes e adicione ao painel na posicao NORTE
		 */
		/*
		 * g)Associe um listener da classe CarregarClienteListener ao componente
		 * cbClientes
		 */

	}

	/**
	 * Metodo utilizado internamente para montagem do JPanel com o botao Salvar,
	 * por isto ele foi declarado como private.
	 * 
	 * @return JPanel com o botao Salvar, para salvar um cliente
	 */
	private JPanel montaPanelBotoesCadastro() {
		pBotoesCadastro = new JPanel();

		bSalvar = new JButton("Salvar");
		bSalvar.setMnemonic(KeyEvent.VK_S);
		bSalvar.addMouseListener(new SalvarClienteListener());
		pBotoesCadastro.add(bSalvar);

		bExcluir = new JButton("Excluir");
		bExcluir.setMnemonic(KeyEvent.VK_E);
		pBotoesCadastro.add(bExcluir);

		bNovo = new JButton("Novo");
		bNovo.setMnemonic(KeyEvent.VK_N);

		/*
		 * f) Associe um listener de NovoClienteListener ao botao bNovo
		 */

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
		pCadastroCliente = new JPanel();
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
	 * dos JTextFields referentes aos dados do cliente, cria um objeto da classe
	 * Cliente e retorna o Cliente.
	 * 
	 * @return Cliente com os dados obtidos dos JTextFields apresentados
	 * 
	 */
	private Cliente loadClienteFromPanel() throws GlobalcodeException {
		System.out.println("Salvando os dados do Cliente");
		String nome = tfNome.getText();
		String telefone = tfTelefone.getText();
		String cpf = tfCPF.getText();
		String strId = tfID.getText();
		int id = 0;
		if ((strId != null) && (strId.length() > 0)) {
			id = Integer.parseInt(strId);
		}
		Cliente clienteAtual = new Cliente(nome, telefone, cpf, id);
		return clienteAtual;
	}

	/**
	 * Metodo utilizado internamente para fazer a limpeza dos JTextFields dados
	 * do cliente.
	 * 
	 */
	private void clearClienteFromPanel() {
		System.out.println("Limpando o painel de cadastro de clientes");
		this.tfCPF.setText("");
		this.tfNome.setText("");
		this.tfTelefone.setText("");
		this.tfID.setText("");
	}

	/**
	 * Metodo utilizado internamente para fazer a escrita dos dados do cliente
	 * dentro dos JTextFields referentes aos dados do cliente, cria um objeto da
	 * classe Cliente e retorna o Cliente.
	 * 
	 * @param Objeto
	 *            cliente com os dados advindos de algum elemento externo
	 * 
	 */
	private void loadClienteToPanel(Cliente c) {
		if (c != null) {
			System.out.println("Carregando cliente selecionado para edicao");
			this.tfCPF.setText(c.getCpf());
			this.tfID.setText(Integer.toString(c.getId()));
			this.tfNome.setText(c.getNome());
			this.tfTelefone.setText(c.getTelefone());
		}
	}

	/**
	 * Listener de eventos de mouse exclusivo para o botao bSalvar (para salvar
	 * clientes).
	 */
	class SalvarClienteListener extends MouseAdapter {

		public void mouseClicked(MouseEvent arg0) {
			try {
				Cliente cliente = loadClienteFromPanel();
				System.out.println(cliente);
				/*
				 * c) Salvar o cliente no banco de dados.
				 */
			} catch (GlobalcodeException e) {
				e.printStackTrace();
			}

		}
	}

	/*
	 * d) Crie um novo listener chamado NovoClienteListener conforme definido na
	 * apostila. Esse listener vai servir para que, ao clicar no botao "Novo", a
	 * tela seja limpa.
	 */

	/*
	 * e) Crie um novo listener chamado CarregarClienteListener conforme
	 * definido na apostila. Esse listener vai servir para que, quando
	 * selecionarmos um cliente no combo de clientes, os dados do cliente
	 * selecionado sejam apresentados na tela.
	 */

}