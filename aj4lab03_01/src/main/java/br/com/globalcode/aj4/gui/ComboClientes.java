/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
package br.com.globalcode.aj4.gui;

import java.util.*;
import javax.swing.JComboBox;
import br.com.globalcode.aj4.dao.ClientesDAO;
import br.com.globalcode.aj4.dao.ClientesDB;
import br.com.globalcode.model.Cliente;
import br.com.globalcode.util.GlobalcodeException;

/**
 * @author Globalcode
 * 
 */
public class ComboClientes extends JComboBox {

    public ComboClientes() throws GlobalcodeException {
        this.reloadFromDatabase();
    }

    public void reloadFromDatabase() throws GlobalcodeException {
        ClientesDAO db = new ClientesDB();
        List<Cliente> clientes = db.getAllClientes();
        this.removeAllItems();
        for (int i = 0; i < clientes.size(); i++) {
            this.addItem(clientes.get(i));
        }
    }
}
