/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Persistencia.Interfaces.ITallaDAO;
/**
 *
 * @author riosr
 */
public class TallaBO {
    
    private static TallaBO instance; 
    
    private ITallaDAO tallaDAO;

    public TallaBO() {
        this.tallaDAO = new TallaDAO();
    }
    
    public static TallaBO getInstance(){
        if(instance == null){
            instance = new TallaBO();
        }
        return instance;
    }
    
}
