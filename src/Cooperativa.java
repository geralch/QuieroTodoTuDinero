import java.awt.*;
import java.util.*;

public class Cooperativa {
    private double valorMaximoPrestamos;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Socio> socios;
    
    public Cooperativa(){
        prestamos = new ArrayList();
        socios = new ArrayList();
    }
    
    public Cooperativa(double valorMaximoPrestamos, ArrayList<Prestamo> prestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
        this.prestamos = prestamos;
    }

    public void setValorMaximoPrestamos(double valorMaximoPrestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
    }

    public double getValorMaximoPrestamos() {
        return valorMaximoPrestamos;
    }

    public void anyadirPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public Prestamo cosultarPrestamo(int idPrestamo) {
        
        Prestamo prestamo = new Prestamo();
        for(int i=0; i<prestamos.size(); i++){
            if(idPrestamo==prestamos.get(i).getNumeroPrestemo()){
                prestamo = prestamos.get(i);
            }
        }
        return prestamo;
    }
    
    public ArrayList<Socio> getSocios() {
        return socios;
    }
    
    public void anyadirSocios(Socio socio) {
        Socio socioAux = socio;
        socios.add(socioAux);
    }
    
    public void eliminarSocio(Socio socio){
        
        int idSocio = Integer.parseInt(socio.getDi());
        
        for(int i=0; i<socios.size(); i++){
            if(idSocio==Integer.parseInt(socios.get(i).getDi())){
                socios.remove(i);
            }
        }
    }
    
    public Socio cosultarSocio(int idSocio) {
        
        Socio socio = new Socio();
        for(int i=0; i<socios.size(); i++){
            if(idSocio==Integer.parseInt(socios.get(i).getDi())){
                socio = socios.get(i);
            }
        }
        return socio;
    }    
    
    public boolean socioExiste(int idSocio){
        
        boolean socioEsta = false;
        for(int i=0; i<socios.size(); i++){
            if(idSocio==Integer.parseInt(socios.get(i).getDi())){
                socioEsta = true;
            }
        }
        return socioEsta;
    }    
}

