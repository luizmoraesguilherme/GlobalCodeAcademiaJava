/*
 * @author Globalcode 
 *
 * TesteRecuperacao.java
 *
 */

package br.com.globalcode.teste;

import br.com.globalcode.model.Cliente;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class TesteRecuperacao {
    

    public static void main(String[] args) {
        
        String cpf = "11232404-6";
        String nomeArquivo = "Cliente" + cpf + ".ser";
        
        try (FileInputStream leitor = new FileInputStream(nomeArquivo);){
            
            
            Cliente clienteRecuperado = null;
            
            /* 
             * Inserir o codigo de leitura a partir deste ponto 
             *
             */
        


            
            
            System.out.println("cliente recuperado: " + clienteRecuperado);
            
            
        } catch (IOException e) {
            System.out.println("Erro na operacao de I/O");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("A classe dos clientes nao foi localizada");
            e.printStackTrace();
        }         
    }
    
}
