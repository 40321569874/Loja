/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

/**
 *
 * @author Rodrigo
 */
import DTO.ConsultorDTO;
import DAO.consultorDAO;
import java.util.List;

public class consultorBO {

    public boolean inserir(ConsultorDTO consultorDTO){
        if (existe(consultorDTO) != true) {
            consultorDAO consultorDAO = new consultorDAO();
            return consultorDAO.inserir(consultorDTO);
        }
        return false;
    }

    public boolean alterar(ConsultorDTO consultorDTO){
        consultorDAO consultorDAO = new consultorDAO();
        return consultorDAO.alterar(consultorDTO);
    }

    public boolean excluir(ConsultorDTO consultorDTO){
        consultorDAO consultorDAO = new consultorDAO();
        return consultorDAO.excluir(consultorDTO);
    }

    

    

    public boolean existe(ConsultorDTO consultorDTO){
        consultorDAO consultorDAO = new consultorDAO();
        return consultorDAO.existe(consultorDTO);
    }

    

}