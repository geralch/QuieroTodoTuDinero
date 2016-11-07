import java.awt.*;
import java.util.*;

public class Persona {
    private String nombreCompleto;
    private String di;
    private String tipoDI;
    private String fechaNacimiento;

    public Persona() {
    }
    
    public Persona(String nombreCompleto, String di, String tipoDI, String fechaNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.di = di;
        this.tipoDI = tipoDI;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public void setTipoDI(String tipoDI) {
        this.tipoDI = tipoDI;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDi() {
        return di;
    }

    public String getTipoDI() {
        return tipoDI;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}
