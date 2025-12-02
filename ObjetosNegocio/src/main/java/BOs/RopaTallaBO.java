/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.RopaTallaDAO;
import Interfaces.IRopaTallaDAO;
import com.mycompany.dto_negocio.BuscarPrendaDTO;
import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.ArrayList;
import java.util.List;
import mappers.RopaTallaMapper;
import objetosnegocio.dominioPojo.RopaTalla;

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

    public static RopaTallaBO getInstance() {
        if (instance == null) {
            instance = new RopaTallaBO();
        }
        return instance;
    }

    //BO guardar 
    public RopaTallaDTO guardar(RopaTallaDTO ropaTallaDTO) throws BOException {
        try {
            RopaTalla ropaTalla = RopaTallaMapper.toEntity(ropaTallaDTO);

            RopaTalla ropaTallaGuardar = ropaTallaDAO.guardar(ropaTalla);

            return RopaTallaMapper.toDTO(ropaTallaGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar empleado", e);
        }
    }

    //BO buscar por id ropaTalla
    public RopaTallaDTO buscarPorId(String id) throws BOException {
        try {

            return RopaTallaMapper.toDTO(ropaTallaDAO.buscarPorId(id));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }

    //BO buscar por codigo ropaTalla
    public RopaTallaDTO buscarPorCodigo(String codigo) throws BOException {
        try {

            return RopaTallaMapper.toDTO(ropaTallaDAO.buscarPorCodigo(codigo));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
    public List<RopaTallaDTO> buscarProductos(String texto) throws BOException {
        try {

            List<RopaTalla> resultados = ropaTallaDAO.buscarPorFiltro(texto);

            List<RopaTallaDTO> listaDTO = new ArrayList<>();
            for (RopaTalla rt : resultados) {
                listaDTO.add(RopaTallaMapper.toDTO(rt));
            }
            return listaDTO;
            
        } catch (DAOException e) {
            throw new BOException("Error en la búsqueda", e);
        }
    }
    
    //BO buscar todo ropaTalla
    public List<RopaTallaDTO> buscarTodos() throws BOException {
        try {

            List<RopaTalla> listaRopaTalla = ropaTallaDAO.buscarTodos();

            List<RopaTallaDTO> listaDTO = new ArrayList<>();

            for (RopaTalla rt : listaRopaTalla) {
                listaDTO.add(RopaTallaMapper.toDTO(rt));
            }

            return listaDTO;

        } catch (DAOException e) {
            throw new BOException("Error al obtener el inventario completo", e);
        }
    }
    public DetalleVentaDTO reducirStock(DetalleVentaDTO ropaTallaDTO){
    try {
           
            ropaTallaDAO.reducirStock(ropaTallaDTO.getRopaTalla().getIdRopaTalla(), ropaTallaDTO.getCantidadVendida());
            return ropaTallaDTO;

        } catch (DAOException e) {
            throw new BOException("Error al obtener el inventario completo", e);
        }
    
    }
    
    public RopaTallaDTO buscarPorFiltro(BuscarPrendaDTO buscarPrendaDTO){
     try {
           RopaTalla ropaTalla = ropaTallaDAO.buscarPorFiltroAproximado(
                                    buscarPrendaDTO.getTemporada(),
                                    buscarPrendaDTO.getMaterial(), 
                                    buscarPrendaDTO.getMarca(), 
                                    buscarPrendaDTO.getPrecio(), 
                                    buscarPrendaDTO.getNombreTalla());
           return RopaTallaMapper.toDTO(ropaTalla);

        } catch (DAOException e) {
            throw new BOException("Error al obtener el inventario completo", e);
        }
    }
}
