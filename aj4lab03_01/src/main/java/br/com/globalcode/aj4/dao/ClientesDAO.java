/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * Esta e uma interface que especifica metodos para obtencao e armazenamento de clientes,
 * nao importando onde estes objetos serao persistidos, ex: arquivo, collections, 
 * banco de dados, etc...
 * 
 */
package br.com.globalcode.aj4.dao;

import br.com.globalcode.model.Cliente;
import br.com.globalcode.util.GlobalcodeException;
import java.util.List;

/**
 * @author Globalcode
 * 
 */
public interface ClientesDAO {

    /**
     * @param cliente
     *            Cliente a ser inserido na fonte de dados em questao
     * @throws GlobalcodeException
     */
    public abstract void salvar(Cliente cliente) throws GlobalcodeException;

    /**
     * @param CPF
     *            do Cliente a ser excluido da fonte de dados em questao
     * @throws GlobalcodeException
     */
    public abstract void excluir(String cpf) throws GlobalcodeException;

    /**
     * @return java.util.List contendo todos os clientes contidos na fonte da dados em questao
     * @throws GlobalcodeException
     */
    public abstract List<Cliente> getAllClientes() throws GlobalcodeException;

    /**
     * @param String
     *            CPF do cliente a ser pesquisado no "banco de dados"
     * @return Cliente
     * @throws GlobalcodeException
     */
    public abstract Cliente getClienteByCPF(String cpf) throws GlobalcodeException;
}