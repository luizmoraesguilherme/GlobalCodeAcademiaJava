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
public class TestePanelCadastroClientes extends JFrame {

    public TestePanelCadastroClientes(String titulo) {
        super(titulo);
        // Indica que quando a janela for fechada, a execucao da classe
        // sera finalizada, caso contrario, a classe continuara na memoria
        // depois que a janela for fechada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.getContentPane().add(new PanelCadastroClientes());
            super.setSize(300, 250);
            this.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Mensagem de Erro", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestePanelCadastroClientes gf = new TestePanelCadastroClientes("Teste Panel Cadastro Clientes");
        gf.setVisible(true);
    }
}
