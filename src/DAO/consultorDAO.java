/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTO.ClienteDTO;
import DTO.ConsultorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 111003605
 */
public class consultorDAO {
    
    final String NOMEDOBANCO = "bancoloja";
    final String NOMEDATABELA = "Consultor";

    
    public boolean inserir(ConsultorDTO consultorDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "INSERT INTO " + NOMEDATABELA +" (id,funcao,salario,nome,endereco) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(consultorDTO.getId()));
            ps.setString(2,consultorDTO.getFuncao());
            ps.setString(3,Integer.toString(consultorDTO.getSalario()));
            ps.setString(4,consultorDTO.getNome());
            ps.setString(5,consultorDTO.getEndereco());
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

    public boolean alterar(ConsultorDTO consultorDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "UPDATE " + NOMEDATABELA +
            " SET funcao = ?, nome = ?, salario = ?, endereco = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Integer.toString(consultorDTO.getId()));
            ps.setString(2,consultorDTO.getFuncao());
            ps.setString(3,consultorDTO.getNome());
            ps.setString(4,Integer.toString(consultorDTO.getSalario()));
            ps.setString(5,consultorDTO.getEndereco());
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

    public boolean excluir(ConsultorDTO consultorDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, consultorDTO.getId());
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

    
   

    public boolean existe(ConsultorDTO consultorDTO) {
        try {
            Connection conn = Conexao.conectar(NOMEDOBANCO);
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,(consultorDTO.getId()));
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

   

    public List<ConsultorDTO> montarLista(ResultSet rs) {
        List<ConsultorDTO> listObj = new ArrayList<ConsultorDTO>();
        try {
            while (rs.next()) {
               ConsultorDTO obj = new ConsultorDTO();
                obj.setId(rs.getInt(1));
                obj.setNome(rs.getString(2));
                obj.setSalario(rs.getInt(3));
                obj.setFuncao(rs.getString(4));
                obj.setEndereco(rs.getString(5));
           
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
