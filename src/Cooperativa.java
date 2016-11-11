import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cooperativa {
    private double valorMaximoPrestamos;
    private ArrayList<Prestamo> prestamos;
    private int numPrestamoActual;
    private ArrayList<Socio> socios;
    
    public Cooperativa(){
        numPrestamoActual = 0;
        prestamos = new ArrayList();
        socios = new ArrayList();
        BD();
    }
    
    public void BD(){
        Persona persona1 = new Persona("","","","");
        
        Socio socio1 = new Socio("Luisa Perez Martinez","1144165987","CC","1987-01-22","Cali",
                "Bavaria S.A","Desarrolladora","2000-07-27","Doctorado",
                true,"Carrera 102 # 87-65",4875643,"3196482276","Pance","Cali",
                5000000,3000000,
                "Soltero",persona1,persona1,persona1,new ArrayList());
        Socio socio2 = new Socio("Leonardo Hernandez Santos","1177438563","CC","1985-09-23","Cali",
                "Familia S.A","Ingeniero Quimico","2000-05-30","Doctorado",
                true,"Calle 87 #109-45",8635487,"3207539642","Caney","Cali",
                10000000,5000000,
                "Casado",persona1,persona1,persona1,new ArrayList());
        socios.add(socio1);
        socios.add(socio2);
    }
        
    public Cooperativa(double valorMaximoPrestamos, ArrayList<Prestamo> prestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
        this.prestamos = prestamos;
        
        numPrestamoActual = 0;
        prestamos = new ArrayList();
        socios = new ArrayList();
    }

    public void setValorMaximoPrestamos(double valorMaximoPrestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
    }

    public double getValorMaximoPrestamos() {
        return valorMaximoPrestamos;
    }
    
    public void setNumPrestamoActual(int numPrestamoActual) {
        this.numPrestamoActual = numPrestamoActual;
    }

    public int getNumPrestamoActual() {
        return numPrestamoActual;
    }
   
    public void anyadirPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        numPrestamoActual++;
    }
    
    public void eliminarPrestamo(Prestamo prestamo){
        
        int idPrestamo = prestamo.getNumeroPrestemo();
        
        for(int i=0; i<prestamos.size(); i++){
            if(idPrestamo==prestamos.get(i).getNumeroPrestemo()){
                prestamos.remove(i);
            }
        }
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
    
    public boolean prestamoExiste(int idPrestamo){
        
        boolean prestamoEsta = false;
        for(int i=0; i<prestamos.size(); i++){
            if(idPrestamo==prestamos.get(i).getNumeroPrestemo()){
                prestamoEsta = true;
            }
        }
        return prestamoEsta;
    }   
    
}

