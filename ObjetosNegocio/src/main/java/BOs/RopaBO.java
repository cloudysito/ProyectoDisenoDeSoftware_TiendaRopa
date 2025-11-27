/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Implementaciones.RopaDAO;
import Interfaces.IRopaDAO;

/**
 *
 * @author riosr
 */
public class RopaBO {
    private static RopaBO instance; 
    
    private IRopaDAO ropaDAO;

    public RopaBO() {
        this.ropaDAO = new RopaDAO();
    }
    
    public static RopaBO getInstance(){
        if(instance == null){
            instance = new RopaBO();
        }
        return instance;
    }
    
}
