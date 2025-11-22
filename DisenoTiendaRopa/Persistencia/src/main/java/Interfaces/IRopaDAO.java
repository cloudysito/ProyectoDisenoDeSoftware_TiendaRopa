/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;


/**
 *
 * @author garfi
 */
public interface IRopaDAO {
    
    Document dtoToEntity(RopaDTO dto);
    
    RopaDTO entityToDTO(Document doc);

    Ropa guardarRopa(Ropa ropa) throws MongoException;

    Ropa buscarPorCodigoBarras(String codigoBarras) throws MongoException;
    
}
