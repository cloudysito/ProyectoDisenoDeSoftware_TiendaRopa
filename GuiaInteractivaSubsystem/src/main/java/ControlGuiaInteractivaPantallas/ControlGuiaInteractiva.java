/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlGuiaInteractivaPantallas;

import GUIs.GUIClientesAgresivosAislar;
import GUIs.GUIClientesAgresivosDocumentacion;
import GUIs.GUIClientesAgresivosEmpatiaYDisculpa;
import GUIs.GUIClientesAgresivosEscucharActivamente;
import GUIs.GUIClientesAgresivosEstableceLimites;
import GUIs.GUIClientesAgresivosMantenerCalma;
import GUIs.GUIEmergenciaMedicaAplicarPrimerosAuxilios;
import GUIs.GUIEmergenciaMedicaAsignarTareas;
import GUIs.GUIEmergenciaMedicaAsistenciaLlegada;
import GUIs.GUIEmergenciaMedicaGararantizaSeguridad;
import GUIs.GUIEmergenciaMedicaLlamarEmergencias;
import GUIs.GUIEmergenciaMedicaPostEmergencia;
import GUIs.GUIGuiaAgregarPrenda1;
import GUIs.GUIGuiaAgregarPrenda2;
import GUIs.GUIGuiaAgregarPrenda3;
import GUIs.GUIGuiaAgregarPrenda4;
import GUIs.GUIGuiaDevolverPrenda1;
import GUIs.GUIGuiaDevolverPrenda2;
import GUIs.GUIGuiaDevolverPrenda3;
import GUIs.GUIGuiaDevolverPrenda4;
import GUIs.GUIMenuGuia;
import GUIs.GUIRobosOAmenazasActivarAlarmaSilenciosa;
import GUIs.GUIRobosOAmenazasCooperar;
import GUIs.GUIRobosOAmenazasEntrevista;
import GUIs.GUIRobosOAmenazasNoTocarNada;
import GUIs.GUIRobosOAmenazasObservarDiscretamente;
import GUIs.GUIRobosOAmenazasPostIncidente;
import GUIs.GUIRobosOAmenazasSeguridadTodo;
import GuiaInteractiva.Fachada.FachadaGuiaInteractiva;
import GuiaInteractiva.Interfaz.IGuiaInteractiva;
import com.mycompany.dto_negocio.CapacitacionDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;
import javax.swing.JFrame;

/**
 *
 * @author riosr
 */
public class ControlGuiaInteractiva {
    private static ControlGuiaInteractiva instancia;
    private static IGuiaInteractiva guiaInteractiva;
    
    public  static synchronized ControlGuiaInteractiva getIntase(){
        if(instancia == null){
            instancia = new ControlGuiaInteractiva();
            guiaInteractiva = new FachadaGuiaInteractiva();
        }
        return instancia;
    }
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarGUIMenuGuia(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIMenuGuia guia = new GUIMenuGuia();
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosAislar(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosAislar guia = new GUIClientesAgresivosAislar();
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosDocumentacion(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosDocumentacion guia = new GUIClientesAgresivosDocumentacion();
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosEmpatiaYDisculpa(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosEmpatiaYDisculpa guia = new GUIClientesAgresivosEmpatiaYDisculpa();
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosEscucharActivamente(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosEscucharActivamente guia= new GUIClientesAgresivosEscucharActivamente();
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosEstableceLimites(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosEstableceLimites guia = new GUIClientesAgresivosEstableceLimites();
        guia.setVisible(true);
    }
    
    public void navegarGUIClientesAgresivosMantenerCalma(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIClientesAgresivosMantenerCalma guia = new GUIClientesAgresivosMantenerCalma();
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaAplicarPrimerosAuxilios(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaAplicarPrimerosAuxilios guia = new GUIEmergenciaMedicaAplicarPrimerosAuxilios();
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaAsignarTareas(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaAsignarTareas guia = new GUIEmergenciaMedicaAsignarTareas();
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaAsistenciaLlegada(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaAsistenciaLlegada guia = new GUIEmergenciaMedicaAsistenciaLlegada();
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaGararantizaSeguridad(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaGararantizaSeguridad guia = new GUIEmergenciaMedicaGararantizaSeguridad();
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaLlamarEmergencias(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaLlamarEmergencias guia = new GUIEmergenciaMedicaLlamarEmergencias();
        guia.setVisible(true);
    }
    
    public void navegarGUIEmergenciaMedicaPostEmergencia(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIEmergenciaMedicaPostEmergencia guia = new GUIEmergenciaMedicaPostEmergencia();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasActivarAlarmaSilenciosa(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasActivarAlarmaSilenciosa guia = new GUIRobosOAmenazasActivarAlarmaSilenciosa();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasCooperar(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasCooperar guia = new GUIRobosOAmenazasCooperar();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasEntrevista(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasEntrevista guia = new GUIRobosOAmenazasEntrevista();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasNoTocarNada(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasNoTocarNada guia = new GUIRobosOAmenazasNoTocarNada();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasObservarDiscretamente(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasObservarDiscretamente guia = new GUIRobosOAmenazasObservarDiscretamente();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasPostIncidente(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasPostIncidente guia = new GUIRobosOAmenazasPostIncidente();
        guia.setVisible(true);
    }
    
    public void navegarGUIRobosOAmenazasSeguridadTodo(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRobosOAmenazasSeguridadTodo guia = new GUIRobosOAmenazasSeguridadTodo();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda1(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda1 guia = new GUIGuiaAgregarPrenda1();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda2(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda2 guia = new GUIGuiaAgregarPrenda2();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda3(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda3 guia = new GUIGuiaAgregarPrenda3();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaAgregarPrenda4(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaAgregarPrenda4 guia = new GUIGuiaAgregarPrenda4();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda1(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda1 guia = new GUIGuiaDevolverPrenda1();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda2(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda2 guia = new GUIGuiaDevolverPrenda2();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda3(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda3 guia = new GUIGuiaDevolverPrenda3();
        guia.setVisible(true);
    }
    
    public void navegarGUIGuiaDevolverPrenda4(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIGuiaDevolverPrenda4 guia = new GUIGuiaDevolverPrenda4();
        guia.setVisible(true);
    }
    
    public static IGuiaInteractiva getGuiaInteractiva() {
        return guiaInteractiva;
    }
}
