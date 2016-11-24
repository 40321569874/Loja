/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

/**
 *
 * @author Rodrigo
 */
import DTO.itempedidoDTO;
import DAO.itempedidoDAO;
import java.util.List;

public class itempedidoBO {
    public boolean inserir(itempedidoDTO itempedidoDTO){
        if (existe(itempedidoDTO) != true) {
            itempedidoDAO itemPedidoDAO = new itempedidoDAO();
            return itemPedidoDAO.inserir(itempedidoDTO);
        }
        return false;
    }
    public boolean alterar(itempedidoDTO itempedidoDTO){
        itempedidoDAO itemPedidoDAO = new itempedidoDAO();
        return itemPedidoDAO.alterar(itempedidoDTO);
    }
    public boolean excluir(itempedidoDTO itempedidoDTO){
       itempedidoDAO itemPedidoDAO = new itempedidoDAO();
        return itemPedidoDAO.excluir(itempedidoDTO);
    }
   
    
    public boolean existe(itempedidoDTO itempedidoDTO){
       itempedidoDAO itemPedidoDAO = new itempedidoDAO();
        return itemPedidoDAO.existe(itempedidoDTO);
    }
   
}