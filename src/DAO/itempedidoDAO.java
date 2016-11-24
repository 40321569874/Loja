/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DTO.itempedidoDTO;
/**
 *
 * @author 111003605
 */
public class itempedidoDAO {
    
    final String NOMEDOBANCO = "bancoloja";
    final String NOMEDATABELA = "itempedido";

    public boolean inserir(itempedidoDTO itempedidoDTO) {
        try {
            
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "INSERT INTO " + NOMEDATABELA +" (coditem,tipo,descricao) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,itempedidoDTO.getCoditem());
            ps.setString(2,itempedidoDTO.getTipo());
            ps.setString(3,itempedidoDTO.getDescricao());
           
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

    public boolean alterar(itempedidoDTO itempedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET coditem = ?, tipo = ?,descricao = ? WHERE coditem = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(itempedidoDTO.getCoditem()));
            ps.setString(2,itempedidoDTO.getTipo());
            ps.setString(3,itempedidoDTO.getDescricao());
          
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

    public boolean excluir(itempedidoDTO itempedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE coditem = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, itempedidoDTO.getCoditem());
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

   

   
    public boolean existe(itempedidoDTO itempedidoDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cli_nome = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,String.valueOf(itempedidoDTO.getCoditem()));
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

   

    public List<itempedidoDTO> montarLista(ResultSet rs) {
        List<itempedidoDTO> listObj = new ArrayList<itempedidoDTO>();
        try {
            while (rs.next()) {
                itempedidoDTO obj = new itempedidoDTO();
                obj.setCoditem(rs.getInt(1));
                obj.setTipo(rs.getString(2));
                obj.setDescricao(rs.getString(3));
               
           
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
