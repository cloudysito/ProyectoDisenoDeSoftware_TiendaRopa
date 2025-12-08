/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import GUICapacitacion.GUIClientesAgresivosAislar;
import GUICapacitacion.GUIClientesAgresivosDocumentacion;
import GUICapacitacion.GUIClientesAgresivosEmpatiaYDisculpa;
import GUICapacitacion.GUIClientesAgresivosEscucharActivamente;
import GUICapacitacion.GUIClientesAgresivosEstableceLimites;
import GUICapacitacion.GUIClientesAgresivosMantenerCalma;
import GUICapacitacion.GUIEmergenciaMedicaAplicarPrimerosAuxilios;
import GUICapacitacion.GUIEmergenciaMedicaAsignarTareas;
import GUICapacitacion.GUIEmergenciaMedicaAsistenciaLlegada;
import GUICapacitacion.GUIEmergenciaMedicaGararantizaSeguridad;
import GUICapacitacion.GUIEmergenciaMedicaLlamarEmergencias;
import GUICapacitacion.GUIEmergenciaMedicaPostEmergencia;
import GUICapacitacion.GUIGuiaAgregarPrenda1;
import GUICapacitacion.GUIGuiaAgregarPrenda2;
import GUICapacitacion.GUIGuiaAgregarPrenda3;
import GUICapacitacion.GUIGuiaAgregarPrenda4;
import GUICapacitacion.GUIGuiaDevolverPrenda1;
import GUICapacitacion.GUIGuiaDevolverPrenda2;
import GUICapacitacion.GUIGuiaDevolverPrenda3;
import GUICapacitacion.GUIGuiaDevolverPrenda4;
import GUICapacitacion.GUIMenuGuia;
import GUICapacitacion.GUIRobosOAmenazasActivarAlarmaSilenciosa;
import GUICapacitacion.GUIRobosOAmenazasCooperar;
import GUICapacitacion.GUIRobosOAmenazasEntrevista;
import GUICapacitacion.GUIRobosOAmenazasNoTocarNada;
import GUICapacitacion.GUIRobosOAmenazasObservarDiscretamente;
import GUICapacitacion.GUIRobosOAmenazasPostIncidente;
import GUICapacitacion.GUIRobosOAmenazasSeguridadTodo;
import GUICapacitacion.GUIVerCapacitaciones;
import GuiaInteractivaEmpleado.Fachada.FachadaGuiaInteractivaEmpleado;
import GuiaInteractivaEmpleado.Interfaz.IGuiaInteractivaEmpleado;
import com.mycompany.dto_negocio.CapacitacionDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;
import javax.swing.JFrame;

/**
 *
 * @author riosr
 */
public class ControlGuiaInteractivaEmpleado {
    private static ControlGuiaInteractivaEmpleado instancia;
    private static IGuiaInteractivaEmpleado guiaInteractiva;
    
    public  static synchronized ControlGuiaInteractivaEmpleado getIntase(){
        if(instancia == null){
            instancia = new ControlGuiaInteractivaEmpleado();
            guiaInteractiva = new FachadaGuiaInteractivaEmpleado();
        }
        return instancia;
    }
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarGUIVerCapacitaciones(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIVerCapacitaciones guia = new GUIVerCapacitaciones(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIMenuGuia(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIMenuGuia guia = new GUIMenuGuia(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosAislar(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosAislar guia = new GUIClientesAgresivosAislar(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosDocumentacion(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosDocumentacion guia = new GUIClientesAgresivosDocumentacion(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosEmpatiaYDisculpa(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosEmpatiaYDisculpa guia = new GUIClientesAgresivosEmpatiaYDisculpa(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosEscucharActivamente(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosEscucharActivamente guia= new GUIClientesAgresivosEscucharActivamente(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosEstableceLimites(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosEstableceLimites guia = new GUIClientesAgresivosEstableceLimites(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosMantenerCalma(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosMantenerCalma guia = new GUIClientesAgresivosMantenerCalma(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaAplicarPrimerosAuxilios(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaAplicarPrimerosAuxilios guia = new GUIEmergenciaMedicaAplicarPrimerosAuxilios(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaAsignarTareas(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaAsignarTareas guia = new GUIEmergenciaMedicaAsignarTareas(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaAsistenciaLlegada(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaAsistenciaLlegada guia = new GUIEmergenciaMedicaAsistenciaLlegada(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaGararantizaSeguridad(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaGararantizaSeguridad guia = new GUIEmergenciaMedicaGararantizaSeguridad(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaLlamarEmergencias(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaLlamarEmergencias guia = new GUIEmergenciaMedicaLlamarEmergencias(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaPostEmergencia(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaPostEmergencia guia = new GUIEmergenciaMedicaPostEmergencia(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasActivarAlarmaSilenciosa(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasActivarAlarmaSilenciosa guia = new GUIRobosOAmenazasActivarAlarmaSilenciosa(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasCooperar(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasCooperar guia = new GUIRobosOAmenazasCooperar(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasEntrevista(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasEntrevista guia = new GUIRobosOAmenazasEntrevista(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasNoTocarNada(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasNoTocarNada guia = new GUIRobosOAmenazasNoTocarNada(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasObservarDiscretamente(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasObservarDiscretamente guia = new GUIRobosOAmenazasObservarDiscretamente(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasPostIncidente(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasPostIncidente guia = new GUIRobosOAmenazasPostIncidente(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasSeguridadTodo(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasSeguridadTodo guia = new GUIRobosOAmenazasSeguridadTodo(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda1(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda1 guia = new GUIGuiaAgregarPrenda1(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda2(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda2 guia = new GUIGuiaAgregarPrenda2(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda3(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda3 guia = new GUIGuiaAgregarPrenda3(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda4(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda4 guia = new GUIGuiaAgregarPrenda4(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda1(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda1 guia = new GUIGuiaDevolverPrenda1(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda2(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda2 guia = new GUIGuiaDevolverPrenda2(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda3(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda3 guia = new GUIGuiaDevolverPrenda3(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda4(JFrame frameActual, EmpleadoDTO empleado, CapacitacionDTO capacitacion) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda4 guia = new GUIGuiaDevolverPrenda4(empleado, capacitacion);
        guia.setVisible(true);
    }
    
    
    
    public static IGuiaInteractivaEmpleado getGuiaInteractiva() {
        return guiaInteractiva;
    }
}
