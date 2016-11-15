 import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prestamo {
    private int numeroPrestemo;
    private Socio socioResponsable;
    private int valorPrestamos;
    private int cuotasPago;
    private String fechaAutorizacion;
    private String fechaDesembolse;
    private String fechasConsignaciones;
    
    public Prestamo(){
        fechasConsignaciones = "";
    }
    public Prestamo(int numeroPrestemo, Socio socioResponsable, int valorPrestamos, int cuotasPago, String fechaAutorizacion) {
        fechasConsignaciones = "";
        this.numeroPrestemo = numeroPrestemo;
        this.socioResponsable = socioResponsable;
        this.valorPrestamos = valorPrestamos;
        this.cuotasPago = cuotasPago;
        this.fechaAutorizacion = fechaAutorizacion;
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

    public String getFechasConsignaciones() {
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

    public Calendar convertirStringCalendar(String fecha){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            cal.setTime(sdf.parse(fecha));
        } catch (ParseException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cal;
    }
    
    public void setFechaDesembolse() {
                
        Calendar cal = convertirStringCalendar(fechaAutorizacion);
        cal.add(Calendar.MONTH,7);
        int anyo = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH)+1;
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        
        fechaDesembolse = String.valueOf(anyo)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
    }

    public int calcularFechasConsignaciones(Calendar fecha, String fechas, int cuotas, int num){
        if(cuotas==0){
            return 1;
        }
        else{
            fecha.add(Calendar.DAY_OF_MONTH,30);
            int anyo = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH)+1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
            fechasConsignaciones = fechasConsignaciones+num+": "+String.valueOf(anyo)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia)+"\n";
            
            cuotas--;
            num++;
            calcularFechasConsignaciones(fecha,fechas,cuotas,num);
        }
        return 0;
    }
    
    public boolean fechaAutorizacionValida(String fecha){
        boolean valida;
        
        Calendar cal = convertirStringCalendar(fecha);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        if(1 <=dia && dia<= 20){
            valida = true;
        }
        else{
            valida = false;
        }
        return valida;
    }
    
    public void setFechasConsignaciones() {
        Calendar cal = convertirStringCalendar(fechaDesembolse);
        String fechas = "";
        fechasConsignaciones = "";
        calcularFechasConsignaciones(cal,fechas,cuotasPago,1);
    }
}
