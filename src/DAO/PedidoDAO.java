/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTO.PedidoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 111003605
 */
public class PedidoDAO {
    
    final String NOMEDOBANCO = "bancoloja";
    final String NOMEDATABELA = "pedido";

    public boolean inserir(PedidoDTO pedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "INSERT INTO " + NOMEDATABELA +" (codpedido,mespedido,mesentrega) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(pedidoDTO.getCodpedido()));
            ps.setString(2,pedidoDTO.getMespedido());
            ps.setString(4,pedidoDTO.getMesentrega());
          
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(PedidoDTO pedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET codpedido = ?, mespedido = ?, mesentrega = ?  WHERE codpedido = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(pedidoDTO.getCodpedido()));
            ps.setString(2,pedidoDTO.getMespedido());
            ps.setString(4,pedidoDTO.getMesentrega());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(PedidoDTO pedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE cli_cod = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pedidoDTO.getCodpedido());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    

    

    public boolean existe(PedidoDTO pedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cli_nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pedidoDTO.getCodpedido());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
        return false;
    }

    

    public List<PedidoDTO> montarLista(ResultSet rs) {
        List<PedidoDTO> listObj = new ArrayList<PedidoDTO>();
        try {
            while (rs.next()) {
                PedidoDTO obj = new PedidoDTO();
                obj.setCodpedido(rs.getInt(1));
                obj.setMesentrega(rs.getString(2));
                obj.setMespedido(rs.getString(3));
                
           
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}

    