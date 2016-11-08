import java.awt.*;
import java.util.*;

public class Prestamo {
    private int numeroPrestemo;
    private Socio socioResponsable;
    private double valorPrestamos;
    private int cuotasPago;
    private Date fechaAutorizacion;
    private Date fechaDesembolse;
    private ArrayList<Date> fechasConsignaciones;
    
    public Prestamo(){
        
    }
    public Prestamo(int numeroPrestemo, Socio socioResponsable, double valorPrestamos, int cuotasPago, Date fechaAutorizacion, Date fechaDesembolse, ArrayList<Date> fechasConsignaciones) {
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

    public double getValorPrestamos() {
        return valorPrestamos;
    }

    public int getCuotasPago() {
        return cuotasPago;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public Date getFechaDesembolse() {
        return fechaDesembolse;
    }

    public ArrayList<Date> getFechasConsignaciones() {
        return fechasConsignaciones;
    }

    public void setNumeroPrestemo(int numeroPrestemo) {
        this.numeroPrestemo = numeroPrestemo;
    }

    public void setSocioResponsable(Socio socioResponsable) {
        this.socioResponsable = socioResponsable;
    }

    public void setValorPrestamos(double valorPrestamos) {
        this.valorPrestamos = valorPrestamos;
    }

    public void setCuotasPago(int cuotasPago) {
        this.cuotasPago = cuotasPago;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public void setFechaDesembolse(Date fechaDesembolse) {
        this.fechaDesembolse = fechaDesembolse;
    }

    public void setFechasConsignaciones(ArrayList<Date> fechasConsignaciones) {
        this.fechasConsignaciones = fechasConsignaciones;
    }
    
    
}
