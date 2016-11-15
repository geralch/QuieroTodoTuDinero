import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaRecibo extends JFrame{
    private Container contenedor;
    private JPanel panelRecibo;
    private JTextArea texArea;
    private JScrollPane scrollPane;
    private JButton botonVolver;
    
    public VentanaRecibo(){}
    
    public VentanaRecibo(ArrayList<String> datos , String fechas){
        
    this.setTitle("Recibo");
        this.setSize(300,350); 
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        contenedor = this.getContentPane();
        contenedor.setLayout(new FlowLayout());
       
        panelRecibo = new JPanel(new FlowLayout());
        Dimension dimension = new Dimension();
        dimension.setSize(300, 350);
        panelRecibo.setPreferredSize(dimension);
        
        texArea = new JTextArea(6, 20);
        scrollPane = new JScrollPane(texArea); 
        texArea.setEditable(false);
        texArea.setText(fechas);
                
        panelRecibo.add(new Label(datos.get(0)));
        panelRecibo.add(new Label(datos.get(1)));
        panelRecibo.add(new Label(datos.get(2)));
        panelRecibo.add(new Label(datos.get(3)));
        panelRecibo.add(new Label(datos.get(4)));
        panelRecibo.add(new Label(datos.get(5)));
        panelRecibo.add(new Label(datos.get(6)));
        panelRecibo.add(new Label(datos.get(7)));
        panelRecibo.add(new Label("Fechas de Pago:"));
        panelRecibo.add(scrollPane);
        contenedor.add(panelRecibo);
        this.setVisible(true);    
    }
}

