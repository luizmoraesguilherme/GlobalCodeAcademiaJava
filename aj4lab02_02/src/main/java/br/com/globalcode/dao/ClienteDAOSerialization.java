/*
 * Globalcode - "The Developers Company"
 *
 * Academia do Java
 *
 *
 */
package br.com.globalcode.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import br.com.globalcode.beans.Cliente;
import br.com.globalcode.util.GlobalcodeException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClienteDAOSerialization implements ClienteDAO {

    public void salvar(Cliente cliente) throws GlobalcodeException {
        String nomeArquivo = "Cliente" + cliente.getCpf() + ".ser";

        if (cliente.getId() == 0) {
            // definicao de id por sorteio
            cliente.setId(1 + (int) (999999 * Math.random()));
        }

        try (FileOutputStream fos = new FileOutputStream(nomeArquivo);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cliente);
        } catch (FileNotFoundException e) {
            throw new GlobalcodeException(e, "Arquivo Inexistente!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void excluir(String cpf) throws GlobalcodeException {
        Path p = Paths.get("Cliente" + cpf + ".ser");
        if (Files.exists(p)) {
            try {
                Files.delete(p);
            } catch (IOException ex) {
                String msg = "Impossivel remover o arquivo " + p.getFileName()
                        + " - deve estar sendo utilizado por outro processo";
                throw new GlobalcodeException(msg);
            }
        } else {
            throw new GlobalcodeException("Cliente não encontrado com cpf = " + cpf);
        }
    }

    public List<Cliente> getAllClientes() throws GlobalcodeException {

        // este objeto representa o diretorio de trabalho atual
        Path diretorioAtual = Paths.get(".");
        System.out.println("diretorio atual:"
                + diretorioAtual.toAbsolutePath());

        List<Cliente> todosClientes = new ArrayList<>();

        /*
         * Inicialize o filtro de acordo com o padrão pedido na apostila
         * 
         */
        String filtro = null;

        try (DirectoryStream<Path> arquivosFiltrados
                = Files.newDirectoryStream(diretorioAtual)) {

            // montagem da lista de clientes recuperados do sistema de arquivos
            for (Path caminho : arquivosFiltrados) {
                String nomeArquivo = caminho.getFileName().toString();
                /*
                 * Observacao: Como a palavra cliente tem 7 caracteres e a extensao
                 * (.ser) ocupa 4 caracteres podemos utilizar o seguinte comando
                 * para obtermos somente o cpf, eliminando o inicio (Cliente) e o
                 * fim (.ser) String cpf = umArquivo.substring(7,umArquivo.length()
                 * -4 );
                 */
                String cpf = nomeArquivo.substring(7, nomeArquivo.length() - 4);
                Cliente umCliente = getClienteByCPF(cpf);
                todosClientes.add(umCliente);
            }
        } catch (IOException e) {
            throw new GlobalcodeException("Erro na leitura dos clientes");
        }

        return todosClientes;

    }

    public Cliente getClienteByCPF(String cpf) throws GlobalcodeException {
        String nomeArquivo = "Cliente" + cpf + ".ser";
        Cliente c = null;
        try (FileInputStream fis = new FileInputStream(nomeArquivo);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            c = (Cliente) ois.readObject();
        } catch (IOException e) {
            throw new GlobalcodeException(e,
                    "Erro ao executar operacao de leitura");
        } catch (ClassNotFoundException e) {
            throw new GlobalcodeException(e,
                    "Erro ao localizar a classe Cliente.class");
        }
        return c;
    }
}
