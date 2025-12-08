/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.AdministradorDAO;
import Interfaces.IAdministradorDAO;
import com.mycompany.dto_negocio.AdministradorDTO;
import mappers.AdministradorMapper;

/**
 *
 * @author santi
 */
public class AdministradorBO {
    private static AdministradorBO instance;
    
    private IAdministradorDAO administradorDAO;
    
    public AdministradorBO(){
        this.administradorDAO = new  AdministradorDAO();
    }
    
    public static AdministradorBO getIntance(){
        if(instance == null){
         instance = new AdministradorBO();
        }
        return instance;
    }
    
    public AdministradorDTO iniciarSesion(String correo, String contrasenia) {
        try {

            return AdministradorMapper.toDTO(administradorDAO.iniciarSesion(correo, contrasenia));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por ", e);
        }
    }
}
