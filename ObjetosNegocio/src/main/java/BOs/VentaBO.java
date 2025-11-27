/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Implementaciones.VentaDAO;
import Interfaces.IVentaDAO;


/**
 *
 * @author riosr
 */
public class VentaBO {
    
    private static VentaBO instance; 
    
    private IVentaDAO ventaDAO;

    public VentaBO() {
        this.ventaDAO = new VentaDAO();
    }
    
    public static VentaBO getInstance(){
        if(instance == null){
            instance = new VentaBO();
        }
        return instance;
    }
    
    
    
    
}
