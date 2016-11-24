/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

/**
 *
 * @author Rodrigo
 */
import DTO.ClienteDTO;
import DAO.ClienteDAO;
import java.util.List;

public class ClienteBO {
    public boolean inserir(ClienteDTO clienteDTO){
        if (existe(clienteDTO) != true) {
            ClienteDAO clienteDAO = new ClienteDAO();
            return clienteDAO.inserir(clienteDTO);
        }
        return false;
    }
    public boolean alterar(ClienteDTO clienteDTO){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.alterar(clienteDTO);
    }
    public boolean excluir(ClienteDTO clienteDTO){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.excluir(clienteDTO);
    }
    
   
    public boolean existe(ClienteDTO clienteDTO){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.existe(clienteDTO);
    }
   
}