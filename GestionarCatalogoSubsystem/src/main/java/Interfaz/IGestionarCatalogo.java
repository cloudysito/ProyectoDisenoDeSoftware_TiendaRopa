/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.List;

/**
 *
 * @author garfi
 */
public interface IGestionarCatalogo {

    public boolean agregarRopa(RopaTallaDTO producto);

    public boolean editarRopa(RopaDTO ropa);

    public boolean eliminarRopa(RopaDTO ropa);

    public RopaDTO buscarRopaPorId(String id);
    
    public List<RopaTallaDTO> buscarPorFiltro(String texto);

    public List<RopaTallaDTO> obtenerInventarioCompleto();

    public List<RopaDTO> buscarRopaPorNombre(String nombreArticulo);

}
