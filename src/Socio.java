import java.awt.*;
import java.util.*;

public class Socio extends Persona{
    
    private String lugarExpID;
    private String nombreEmpresa;
    private String cargoEmpresa;
    private String fechaIngresoEmpresa;
    private String nivelEstudios;
    private boolean casaAptPropio;
    private String direccionResidencia;
    private int telefonoResidencia;
    private int celular;
    private String barrioResidencia;
    private String ciudadResidencia;
    private double ingresoMensual;
    private double egresoMensual;
    private String estadoCivil;
    private Persona conyugue;
    private Persona madre;
    private Persona padre;
    private ArrayList<Persona> hijos;

    public Socio() {
    }

    public Socio(String nombreCompleto, String di, String tipoDI, String fechaNacimiento, String lugarExpID, String nombreEmpresa, String cargoEmpresa, String fechaIngresoEmpresa,
        String nivelEstudios, boolean casaAptPropio, String direccionResidencia, int telefonoResidencia, int celular,String barrioResidencia, String ciudadResidencia, double ingresoMensual, 
        double egresoMensual, String estadoCivil,  Persona conyugue, Persona madre, Persona padre, ArrayList<Persona> hijos) {
        super(nombreCompleto, di, tipoDI, fechaNacimiento);
        this.lugarExpID = lugarExpID;
        this.nombreEmpresa = nombreEmpresa;
        this.cargoEmpresa = cargoEmpresa;
        this.fechaIngresoEmpresa = fechaIngresoEmpresa;
        this.nivelEstudios = nivelEstudios;
        this.casaAptPropio = casaAptPropio;
        this.direccionResidencia = direccionResidencia;
        this.telefonoResidencia = telefonoResidencia;
        this.celular = celular;
        this.barrioResidencia = barrioResidencia;
        this.ciudadResidencia = ciudadResidencia;
        this.ingresoMensual = ingresoMensual;
        this.egresoMensual = egresoMensual;
        this.estadoCivil = estadoCivil;
        this.conyugue = conyugue;
        this.madre = madre;
        this.padre = padre;
        this.hijos = hijos;
        }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getCelular() {
        return celular;
    }

    public String getLugarExpID() {
        return lugarExpID;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public String getFechaIngresoEmpresa() {
        return fechaIngresoEmpresa;
    }

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public boolean isCasaAptPropio() {
        return casaAptPropio;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public int getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public String getBarrioResidencia() {
        return barrioResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public double getEgresoMensual() {
        return egresoMensual;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public Persona getConyugue() {
        return conyugue;
    }

    public Persona getMadre() {
        return madre;
    }

    public Persona getPadre() {
        return padre;
    }

    public ArrayList<Persona> getHijos() {
        return hijos;
    }

    public void setLugarExpID(String lugarExpID) {
        this.lugarExpID = lugarExpID;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setCargoEmpresa(String cargoEmpresa) {
        this.cargoEmpresa = cargoEmpresa;
    }

    public void setFechaIngresoEmpresa(String fechaIngresoEmpresa) {
        this.fechaIngresoEmpresa = fechaIngresoEmpresa;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public void setCasaAptPropio(boolean casaAptPropio) {
        this.casaAptPropio = casaAptPropio;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public void setTelefonoResidencia(int telefonoResidencia) {
    this.telefonoResidencia = telefonoResidencia;
    }

    public void setBarrioResidencia(String barrioResidencia) {
        this.barrioResidencia = barrioResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public void setIngresoMensual(double ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public void setEgresoMensual(double egresoMensual) {
        this.egresoMensual = egresoMensual;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setConyugue(Persona conyugue) {
        this.conyugue = conyugue;
    }

    public void setMadre(Persona madre) {
        this.madre = madre;
    }

    public void setPadre(Persona padre) {
        this.padre = padre;
    }

    public void setHijos(ArrayList<Persona> hijos) {
        this.hijos = hijos;
    }
    
    
}
