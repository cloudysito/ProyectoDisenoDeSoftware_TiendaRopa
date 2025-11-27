/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

/**
 *
 * @author riosr
 */
public class RopaTallaBO {
    private static RopaTallaBO instance; 
    
    private IRopaTallaDAO ropaTallaDAO;

    public RopaTallaBO() {
        this.ropaTallaDAO = new RopaTallaDAO();
    }
    
    public static RopaTallaBO getInstance(){
        if(instance == null){
            instance = new RopaTallaBO();
        }
        return instance;
    }
    
}
