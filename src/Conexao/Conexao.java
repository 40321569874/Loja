/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexao;

/**
 *
 * @author Rodrigo
 */
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

    public static Connection conectar(String bancoloja) {
    	try {
    	    Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + bancoloja;
            return DriverManager.getConnection(url,"root","");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
