/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;

/**
 *
 * @author garfi
 */
public interface ITallaDAO {
    
    Document dtoToEntity(TallaDTO dto);
    
    TallaDTO entityToDTO(Document doc);
    
    Talla guardarTalla(Talla talla) throws MongoException;

    Talla buscarPorId(String idTalla) throws MongoException;
    
}
