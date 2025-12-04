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
/**
 * Representa un horario compuesto por varios días con sus respectivos rangos horarios.
 */
public class Horario {

    /** Identificador único del horario. */
    private ObjectId id;

    /** Lista de días que conforman el horario. */
    private List<DiaHorario> dias = new ArrayList<>();

    /**
     * Constructor vacío requerido por frameworks de persistencia.
     */
    public Horario() {
    }

    /**
     * Constructor que inicializa el horario con un ID específico.
     *
     * @param id identificador único del horario
     */
    public Horario(ObjectId id) {
        this.id = id;
    }

    /**
     * Establece la lista completa de días del horario.
     *
     * @param dias lista de objetos {@link DiaHorario}
     */
    public void setDias(List<DiaHorario> dias) {
        this.dias = dias;
    }

    /**
     * Agrega un día al horario.
     *
     * @param diaHorario día con rangos horarios a agregar
     */
    public void agregarDia(DiaHorario diaHorario) {
        dias.add(diaHorario);
    }

    /**
     * Obtiene la lista de días registrados en el horario.
     *
     * @return lista de días
     */
    public List<DiaHorario> getDias() {
        return dias;
    }

    /**
     * Obtiene el ID del horario.
     *
     * @return identificador del horario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del horario.
     *
     * @param id nuevo identificador
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
}
