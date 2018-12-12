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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.globalcode.aj4.gui.eventos.EventosMouseListener;
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
		pCadastroCliente = montaPanelCadastroCliente();
		pBotoesCadastro = montaPanelBotoesCadastro();
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

		// Faca aqui a associacao do botao bSalvar com um listener da classe
		// EventosMouseListener

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
}