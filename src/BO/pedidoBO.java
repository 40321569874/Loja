/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

/**
 *
 * @author Rodrigo
 */
import DTO.PedidoDTO;
import DAO.PedidoDAO;
import java.util.List;

public class pedidoBO {
    public boolean inserir(PedidoDTO pedidoDTO){
        if (existe(pedidoDTO) != true) {
            PedidoDAO pedidoDAO = new PedidoDAO();
            return pedidoDAO.inserir(pedidoDTO);
        }
        return false;
    }
    public boolean alterar(PedidoDTO pedidoDTO){
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.alterar(pedidoDTO);
    }
    public boolean excluir(PedidoDTO pedidoDTO){
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.excluir(pedidoDTO);
    }
   
   
    public boolean existe(PedidoDTO pedidoDTO){
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.existe(pedidoDTO);
    }
   
}