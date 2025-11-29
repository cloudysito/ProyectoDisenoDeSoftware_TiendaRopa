/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

/**
 *
 * @author garfi
 */
public interface IGestionarCatalogo {
    
    public boolean agregarRopa(RopaDTO ropa);
    
    public boolean editarRopa(RopaDTO ropa);
    
    public boolean eliminarRopa(RopaDTO ropa);
    
    public RopaDTO buscarRopaPorId(String id);
    
    public List<RopaDTO> obtenerTodaLaRopa();
    
    public List<RopaDTO> buscarRopaPorNombre(String nombreArticulo);
    
}
