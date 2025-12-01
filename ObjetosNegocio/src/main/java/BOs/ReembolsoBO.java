package BOs;

import Interfaces.IEmpleadoDAO;
import Interfaces.IReembolsoDAO;
import Interfaces.IRopaTallaDAO;
import Interfaces.ISistemaPagos;
import Interfaces.ITallaDAO;
import Interfaces.IVentaDAO;

import com.mycompany.dto_negocio.EmpleadoDTO;

import com.mycompany.dto_negocio.SolicitudReembolsoDTO; 
import com.mycompany.dto_negocio.VentaDTO;
import mappers.EmpleadoMapper;
import objetosnegocio.dominioPojo.Reembolso;

import mappers.ReembolsoMapper;
import objetosnegocio.dominioPojo.Empleado;

/**
 *
 * @author emiim
 */
public class ReembolsoBO {
    private static ReembolsoBO instance;

    private IRopaTallaDAO ropaTallaDAO;
    
    private IEmpleadoDAO empleadoDAO;
    private IVentaDAO ventaDAO;
    private IReembolsoDAO reembolsoDAO;
    private ISistemaPagos sistemaPagos;

    private ReembolsoBO() {
    }

    public void setDependencias(IEmpleadoDAO empleadoDAO, IVentaDAO ventaDAO, IRopaTallaDAO ropaTallaDAO, IReembolsoDAO devolucionDAO, ISistemaPagos sistemaPagos) {
        this.empleadoDAO = empleadoDAO;
        this.ventaDAO = ventaDAO;
        this.ropaTallaDAO = ropaTallaDAO;
        this.reembolsoDAO = devolucionDAO;
        this.sistemaPagos = sistemaPagos;
    }
    
    public ReembolsoBO(IRopaTallaDAO ropaTallaDAO, IEmpleadoDAO empleadoDAO, IVentaDAO ventaDAO, ITallaDAO tallaDAO, IReembolsoDAO reembolsoDAO, ISistemaPagos sistemaPagos) {
        this.ropaTallaDAO = ropaTallaDAO;
        this.empleadoDAO = empleadoDAO;
        this.ventaDAO = ventaDAO;
        this.reembolsoDAO = reembolsoDAO;
        this.sistemaPagos = sistemaPagos;
    }

    public static synchronized ReembolsoBO getInstance() {
        if (instance == null) {
            instance = new ReembolsoBO();
        }
        return instance;
    }
    
    public VentaDTO buscarVenta(String idVentaString) {
        try {
            if (!org.bson.types.ObjectId.isValid(idVentaString)) {
                return null;
            }
            objetosnegocio.dominioPojo.Venta venta = ventaDAO.buscarPorId(idVentaString);
            
            if (venta == null) return null;
            return mappers.VentaMapper.toDTO(venta);
            
        } catch (Exception e) {
            System.out.println("Error en BO: " + e.getMessage());
            return null;
        }
    }
    
    public boolean procesarReembolso(SolicitudReembolsoDTO solicitudDTO) {
        if (sistemaPagos == null || reembolsoDAO == null) {
            throw new RuntimeException("Dependencias del BO no inicializadas.");
        }
        Reembolso devolucionEntity = ReembolsoMapper.toEntity(solicitudDTO);

        boolean pagoExitoso = sistemaPagos.ejecutarReembolso(
            devolucionEntity.getTotalReembolsado(),
            devolucionEntity.getMetodoReembolso()
        );

        if (!pagoExitoso) {
            return false;
        }
        if (devolucionEntity.getDetalles() != null) {
            devolucionEntity.getDetalles().forEach(detalle -> {
                if (detalle.getRopaTalla() != null) {
                    ropaTallaDAO.actualizarStock(
                        detalle.getRopaTalla().getId(), 
                        detalle.getCantidadDevuelta()
                    );
                }
            });
        }
        reembolsoDAO.guardar(devolucionEntity);

        return true;
    }
    
    public EmpleadoDTO autenticar(String usuario, String contrasenia) {
        Empleado empleadoDominio = empleadoDAO.buscarPorCredenciales(usuario, contrasenia);
        return EmpleadoMapper.toDTO(empleadoDominio);
    }

    public boolean validarCantidades(SolicitudReembolsoDTO solicitud) {
        return true; 
    }
}
