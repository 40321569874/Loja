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
import DTO.ClienteDTO;

/**
 *
 * @author 111003605
 */
public class ClienteDAO {
    
    final String NOMEDOBANCO = "bancoloja";
    final String NOMEDATABELA = "cliente";

    
    public boolean inserir(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "INSERT INTO " + NOMEDATABELA +" (codCliente,rg,nome,endereco,telefone) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,String.valueOf(clienteDTO.getCodCliente()));
             ps.setString(1,String.valueOf(clienteDTO.getRg()));
            ps.setString(3,clienteDTO.getNome());
            ps.setString(4,clienteDTO.getEndereco());
            ps.setString(5,String.valueOf(clienteDTO.getTelefone()));
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

    public boolean alterar(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET codCliente = ?, rg = ?, nome = ?, endereco = ?, telefone = ? WHERE codCliente = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(clienteDTO.getCodCliente()));
            ps.setString(2,String.valueOf(clienteDTO.getRg()));
            ps.setString(3,clienteDTO.getNome());
            ps.setString(4,clienteDTO.getEndereco());
            ps.setString(5,String.valueOf(clienteDTO.getTelefone()));
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

    public boolean excluir(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE cli_cod = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clienteDTO.getCodCliente());
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

   

   

    public boolean existe(ClienteDTO clienteDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE codCliente = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,String.valueOf(clienteDTO.getCodCliente()));
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

    

    public List<ClienteDTO> montarLista(ResultSet rs) {
        List<ClienteDTO> listObj = new ArrayList<ClienteDTO>();
        try {
            while (rs.next()) {
                ClienteDTO obj = new ClienteDTO();
                obj.setCodCliente(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setRg(Integer.parseInt(rs.getString(3)));
                obj.setEndereco(rs.getString(4));
                obj.setTelefone(Integer.parseInt(rs.getString(5)));
           
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
