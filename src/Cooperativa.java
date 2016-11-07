import java.awt.*;
import java.util.*;

public class Cooperativa {
    private double valorMaximoPrestamos;
    private ArrayList<Prestamo> prestamos;

    public Cooperativa(double valorMaximoPrestamos, ArrayList<Prestamo> prestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
        this.prestamos = prestamos;
    }

    public void setValorMaximoPrestamos(double valorMaximoPrestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public double getValorMaximoPrestamos() {
        return valorMaximoPrestamos;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    
}
