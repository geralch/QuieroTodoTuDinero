import java.awt.*;
import java.util.*;

public class Prestamo {
    private int numeroPrestemo;
    private Socio socioResponsable;
    private int valorPrestamos;
    private int cuotasPago;
    private String fechaAutorizacion;
    private String fechaDesembolse;
    private ArrayList<String> fechasConsignaciones;
    
    public Prestamo(){
        
    }
    public Prestamo(int numeroPrestemo, Socio socioResponsable, int valorPrestamos, int cuotasPago, String fechaAutorizacion, String fechaDesembolse, ArrayList<String> fechasConsignaciones) {
        this.numeroPrestemo = numeroPrestemo;
        this.socioResponsable = socioResponsable;
        this.valorPrestamos = valorPrestamos;
        this.cuotasPago = cuotasPago;
        this.fechaAutorizacion = fechaAutorizacion;
        this.fechaDesembolse = fechaDesembolse;
        this.fechasConsignaciones = fechasConsignaciones;
    }
    
    public int getNumeroPrestemo() {
        return numeroPrestemo;
    }

    public Socio getSocioResponsable() {
        return socioResponsable;
    }

    public int getValorPrestamos() {
        return valorPrestamos;
    }

    public int getCuotasPago() {
        return cuotasPago;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public String getFechaDesembolse() {
        return fechaDesembolse;
    }

    public ArrayList<String> getFechasConsignaciones() {
        return fechasConsignaciones;
    }

    public void setNumeroPrestemo(int numeroPrestemo) {
        this.numeroPrestemo = numeroPrestemo;
    }

    public void setSocioResponsable(Socio socioResponsable) {
        this.socioResponsable = socioResponsable;
    }

    public void setValorPrestamos(int valorPrestamos) {
        this.valorPrestamos = valorPrestamos;
    }

    public void setCuotasPago(int cuotasPago) {
        this.cuotasPago = cuotasPago;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public void setFechaDesembolse(String fechaDesembolse) {
        this.fechaDesembolse = fechaDesembolse;
    }

    public void setFechasConsignaciones(ArrayList<String> fechasConsignaciones) {
        this.fechasConsignaciones = fechasConsignaciones;
    }
    
    
}
