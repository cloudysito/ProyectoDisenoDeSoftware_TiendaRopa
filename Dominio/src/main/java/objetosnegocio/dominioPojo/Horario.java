/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class Horario {
        
    private ObjectId id;
    private List<DiaHorario> dias = new ArrayList<>();

    public Horario() {
    }

    public Horario(ObjectId id) {
        this.id = id;
    }

    public void setDias(List<DiaHorario> dias) {
        this.dias = dias;
    }

    public void agregarDia(DiaHorario diaHorario) {
        dias.add(diaHorario);
    }

    public List<DiaHorario> getDias() {
        return dias;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
