import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/*Clase que se encarga de mostrar la ventana principal del proyecto*/
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JPanel panelPrestamos;
    private JTextField tfNombreCompleto;
    private JComboBox cbTD;
    private JTextField tfCedulaCiudadania;
    private JTextField  tfCiudadExpTD;
    private JTextField tfFechaNacimiento;
    private JTextField tfEmpresa;
    private JTextField tfCargoDesempenyado;
    private JTextField tfFechaIngreso;
    private JComboBox cdEstadoCivil;
    private JComboBox cdNiveldeEstudios;
    private JCheckBox cbCasaApartamente;
    private JTextField tfDireccion;
    private JTextField tfTelefono;
    private JTextField tfCelular;
    private JTextField tfBarrio;
    private JTextField tfCiudad;
    private JTextField tfIngresosMensuales;
    private JTextField tfEgresosMensuales;
    private DefaultTableModel modeloTabla;
    private JTable tablaFamiliares;
    private JButton botonAgregarHijo;
    private JPanel panelSocios;
    private JPanel panelFormularios;
    private JPanel panelEFSocios;
    private JPanel panelEFSociosR;
    private JPanel panelBotonesSocios;
    private JButton botonSocioNuevo;
    private JButton botonSocioEditar;
    private JButton botonSocioConsultar;
    private JButton botonSocioEliminar;
    private JButton botonPrestamoNuevo;
    private JButton botonPrestamoEditar;
    private JButton botonPrestamoConsultar;
    private JButton botonPrestamoEliminar;
    
    private SimpleDateFormat formatoFechas;
    private List nuevoSocio;
    private ArrayList<Persona> relacionesNuevoSocio;
    private JButton buttonCrearSocio;
    
    private JScrollPane scrollPane;
    
    /*Constructor de la clase*/
    public VentanaPrincipal(){
        
        formatoFechas = new SimpleDateFormat("yyy-MM-dd");
          
    }
    
    /*Metodo que se encarga de mostrar la ventana y organizar sus componentes*/
    public void mostrarVentana(){
        
        this.setTitle(".: Quiero Todo tu Dinero :.");
        this.setSize(1050,690); 
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        contenedor = this.getContentPane();
        contenedor.setLayout(new FlowLayout());
       
        panelFormularios = new JPanel(new FlowLayout());
        panelFormularios.setBorder(BorderFactory.createTitledBorder("Formulario"));
        Dimension dimension = new Dimension();
        dimension.setSize(1050, 580);
        panelFormularios.setPreferredSize(dimension);
        
        espacioSocios();
        espacioPrestamos();
        contenedor.add(panelFormularios);
        //espacioFormatoSocios();
        this.setVisible(true);
    }
        
    private void espacioFormatoSocios(){
        
        
        panelEFSocios = new JPanel(new GridLayout(18,2,0,0));
        panelEFSocios.setBorder(BorderFactory.createTitledBorder("Campos Socio"));
        Dimension dimension = new Dimension();
        dimension.setSize(500, 500);
        panelEFSocios.setPreferredSize(dimension);
        
        panelEFSociosR = new JPanel(new FlowLayout());
        panelEFSociosR.setBorder(BorderFactory.createTitledBorder("Familiares"));
        panelEFSociosR.setPreferredSize(dimension);
                
        tfNombreCompleto = new JTextField("");
        String[] stringTD = {"CC","Pasaporte","CE"};
        cbTD = new JComboBox(stringTD);
        cbTD.setSelectedIndex(0);
        cbTD.addActionListener(this);
        
        tfCedulaCiudadania = new JTextField("");
        tfCiudadExpTD = new JTextField("");
        tfFechaNacimiento = new JTextField("yyyy-mm-dd");
        tfEmpresa = new JTextField("");
        tfCargoDesempenyado = new JTextField("");
        tfFechaIngreso = new JTextField("yyyy-mm-dd");
        
        String[] stringEC = {"Casado","Soltero","Viudo","Union Libre"};
        cdEstadoCivil = new JComboBox(stringEC);
        cdEstadoCivil.setSelectedIndex(0);
        cdEstadoCivil.addActionListener(this);
        
        String[] stringNE = {"Bachiller","Universitario","Maestria","Doctorado"};
        cdNiveldeEstudios = new JComboBox(stringNE);
        cdNiveldeEstudios.setSelectedIndex(0);
        cdNiveldeEstudios.addActionListener(this);
        
        cbCasaApartamente = new JCheckBox("");
        tfDireccion = new JTextField("");
        tfTelefono = new JTextField("");
        tfCelular = new JTextField("");
        tfBarrio = new JTextField("");
        tfCiudad = new JTextField("");
        tfIngresosMensuales = new JTextField("");
        tfEgresosMensuales = new JTextField("");
               
        botonAgregarHijo = new JButton("Agregar Hijo/a");
        botonAgregarHijo.addActionListener(this);
        
        botonSocioEditar = new JButton("Editar");
        botonSocioEditar.addActionListener(this);
        
        buttonCrearSocio = new JButton("Agregar Socio");
        buttonCrearSocio.addActionListener(this);
        
        botonSocioEliminar = new JButton("Eliminar");
        botonSocioEliminar.addActionListener(this);
        
        panelEFSocios.add(new JLabel("Nombre Completo: "),0,0);
        panelEFSocios.add(tfNombreCompleto,0,1);
        panelEFSocios.add(new JLabel("TD: "),0,2);
        panelEFSocios.add(cbTD,0,3);
        panelEFSocios.add(new JLabel("Numero de Documento: "),0,4);
        panelEFSocios.add(tfCedulaCiudadania,0,5);
        panelEFSocios.add(new JLabel("Expedido en: "),0,6);
        panelEFSocios.add(tfCiudadExpTD,0,7);
        panelEFSocios.add(new JLabel("Fecha de Nacimiento: "),0,8);
        panelEFSocios.add(tfFechaNacimiento,0,9);
        panelEFSocios.add(new JLabel("Empresa en la que Labora: "),0,10);
        panelEFSocios.add(tfEmpresa,0,11);
        panelEFSocios.add(new JLabel("Cargo Desempeñado: "),0,12);
        panelEFSocios.add(tfCargoDesempenyado,0,13);
        panelEFSocios.add(new JLabel("Fecha de Ingreso: "),0,14);
        panelEFSocios.add(tfFechaIngreso,0,15);
        panelEFSocios.add(new JLabel("Estado Civil: "),0,16);
        panelEFSocios.add(cdEstadoCivil,0,17);
        panelEFSocios.add(new JLabel("Nivel de Estudios: "),0,18);
        panelEFSocios.add(cdNiveldeEstudios,0,19);
        panelEFSocios.add(new JLabel("Poses Casa / Apartemento propio?: "),0,20);
        panelEFSocios.add(cbCasaApartamente,0,21);
        panelEFSocios.add(new JLabel("Direccion: "),0,22);
        panelEFSocios.add(tfDireccion,0,23);
        panelEFSocios.add(new JLabel("Telefono: "),0,24);
        panelEFSocios.add(tfTelefono,0,25);
        panelEFSocios.add(new JLabel("Celular: "),0,26);
        panelEFSocios.add(tfCelular,0,27);
        panelEFSocios.add(new JLabel("Barrio: "),0,28);
        panelEFSocios.add(tfBarrio,0,29);
        panelEFSocios.add(new JLabel("Ciudad: "),0,30);
        panelEFSocios.add(tfCiudad,0,31);
        panelEFSocios.add(new JLabel("Ingresos Mensuales: "),0,32);
        panelEFSocios.add(tfIngresosMensuales,0,33);
        panelEFSocios.add(new JLabel("Egresos Mensuales: "),0,34);
        panelEFSocios.add(tfEgresosMensuales,0,35);

        modeloTabla = new DefaultTableModel(); 
        tablaFamiliares = new JTable(modeloTabla);

        modeloTabla.addColumn("Relacion"); 
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha Nacimiento"); 
        modeloTabla.addColumn("TD"); 
        modeloTabla.addColumn("Numero D"); 
        
        modeloTabla.addRow(new Object[]{"Padre","","","",""});
        modeloTabla.addRow(new Object[]{"Madre","","","",""});
        modeloTabla.addRow(new Object[]{"Conyugue","","","",""});
        panelEFSociosR.add(tablaFamiliares.getTableHeader(), BorderLayout.PAGE_START);
        panelEFSociosR.add(tablaFamiliares, BorderLayout.CENTER);
        
        panelEFSociosR.add(botonAgregarHijo);
        
        panelBotonesSocios = new JPanel();
        
        panelFormularios.add(panelEFSocios);
        panelFormularios.add(panelEFSociosR);
        panelFormularios.add(panelBotonesSocios);
    }
    
    private void espacioSocios(){
        panelSocios = new JPanel(new FlowLayout());
        panelSocios.setBorder(BorderFactory.createTitledBorder("Socios"));
        Dimension dimension = new Dimension();
        dimension.setSize(400, 70);
        panelSocios.setPreferredSize(dimension);
        
        botonSocioNuevo = new JButton("Nuevo");
        botonSocioNuevo.addActionListener(this);

        botonSocioConsultar = new JButton("Consultar");
        botonSocioConsultar.addActionListener(this);

        panelSocios.add(botonSocioNuevo);
        panelSocios.add(botonSocioConsultar);
       
        contenedor.add(panelSocios);
    }
    
    /*Metodo que se encarga de crear el componente del arbol en la ventana*/
    private void espacioPrestamos(){
        panelPrestamos = new JPanel(new FlowLayout());
        panelPrestamos.setBorder(BorderFactory.createTitledBorder("Prestamos")); 
        Dimension dimension = new Dimension();
        dimension.setSize(400, 70);
        panelPrestamos.setPreferredSize(dimension);
        
        botonPrestamoNuevo = new JButton("Nuevo");
        botonPrestamoNuevo.addActionListener(this);
        
        botonPrestamoEditar = new JButton("Editar");
        botonPrestamoEditar.addActionListener(this);
        
        botonPrestamoConsultar = new JButton("Consultar");
        botonPrestamoConsultar.addActionListener(this);
        
        botonPrestamoEliminar = new JButton("Eliminar");
        botonPrestamoEliminar.addActionListener(this);
        
        panelPrestamos.add(botonPrestamoNuevo);
        panelPrestamos.add(botonPrestamoEditar);
        panelPrestamos.add(botonPrestamoConsultar);
        panelPrestamos.add(botonPrestamoEliminar);
        
        contenedor.add(panelPrestamos);        
        
    }
    
    
    private void tomarInformacionFormularioSocios() throws ParseException{
        
        nuevoSocio = new List();
        relacionesNuevoSocio = new ArrayList();
        
        String nombre = tfNombreCompleto.getText();
        String td = cbTD.getSelectedItem().toString();
        String documento = tfCedulaCiudadania.getText();
        String ciudadExp = tfCiudadExpTD.getText();
        Date fechaNacimiento = formatoFechas.parse(tfFechaNacimiento.getText());         
        String empresa = tfEmpresa.getText();
        String cargo = tfCargoDesempenyado.getText();
        Date fechaIngreso = formatoFechas.parse(tfFechaIngreso.getText());  
        String nivelEstudio = cdNiveldeEstudios.getSelectedItem().toString();
        String estadoCivil = cdEstadoCivil.getSelectedItem().toString();
        boolean casaApartamento = cbCasaApartamente.isSelected();
        String direccion = tfDireccion.getText();
        String telefono = tfTelefono.getText();
        String celular = tfCelular.getText();
        String barrio = tfBarrio.getText();
        String ciudad = tfCiudad.getText();
        String ingresosMesuales = tfIngresosMensuales.getText();
        String egresosMensuales = tfEgresosMensuales.getText();
          
    }
    
    private boolean verificarDatos(){
        boolean verificacion = false;
        System.out.print("entra aqui a verificar");
        if(tfNombreCompleto.getText().equals("") || tfCedulaCiudadania.getText().equals("") || 
                tfDireccion.getText().equals("") || tfTelefono.getText().equals("") || tfCelular.getText().equals("")){
            verificacion = false;
            System.out.print("entra aqui verificacion true");
        }
        else{
            verificacion = true;
            System.out.print("entra aqui verificacion falso");
        }
        
        return verificacion;
    }
    
    private void obtenerDatosSocio(int tipoform){
        
        //nuevoSocio = new List();
        relacionesNuevoSocio = new ArrayList();
        
        String conyugueNombre = modeloTabla.getValueAt(0, 1).toString();
        String conyugueFecha = modeloTabla.getValueAt(0, 2).toString();  
        String conyugueTD = modeloTabla.getValueAt(0, 3).toString();
        String conyugueDocumento = modeloTabla.getValueAt(0, 4).toString();
        
        String madreNombre = modeloTabla.getValueAt(1, 1).toString();
        String madreFecha = modeloTabla.getValueAt(1, 2).toString();
        String madreTD = modeloTabla.getValueAt(1, 3).toString();
        String madreDocumento = modeloTabla.getValueAt(1, 4).toString();
        
        String padreNombre = modeloTabla.getValueAt(2, 1).toString();
        String padreFecha = modeloTabla.getValueAt(2, 2).toString();
        String padreTD = modeloTabla.getValueAt(2, 3).toString();
        String padreDocumento = modeloTabla.getValueAt(2, 4).toString();
        
        String nombre, td, documento, ciudadExp, fechaNacimiento, empresa, cargo, fechaIngreso, nivelEstudio, estadoCivil,direccion, barrio, ciudad = "";
        int telefono, celular = 0;
        double ingresosMensuales, egresosMensuales = 0.0;
        
        nombre = tfNombreCompleto.getText();
        td = cbTD.getSelectedItem().toString();
        documento = tfCedulaCiudadania.getText();
        ciudadExp = tfCiudadExpTD.getText();
        fechaNacimiento = tfFechaNacimiento.getText();         
        empresa = tfEmpresa.getText();
        cargo = tfCargoDesempenyado.getText();
        fechaIngreso = tfFechaIngreso.getText();  
        nivelEstudio = cdNiveldeEstudios.getSelectedItem().toString();
        estadoCivil = cdEstadoCivil.getSelectedItem().toString();
        boolean casaApartamento = cbCasaApartamente.isSelected();
        direccion = tfDireccion.getText();
        telefono = Integer.parseInt(tfTelefono.getText());
        celular = Integer.parseInt(tfCelular.getText());
        barrio = tfBarrio.getText();
        ciudad = tfCiudad.getText();
        ingresosMensuales = Double.parseDouble(tfIngresosMensuales.getText());
        egresosMensuales = Double.parseDouble(tfEgresosMensuales.getText());
        
        if(tipoform==1){
            Persona conyugueSocio = new Persona(conyugueNombre,conyugueDocumento,conyugueTD,conyugueFecha);
            Persona madreSocio = new Persona(madreNombre,madreDocumento,madreTD,madreFecha);
            Persona padreSocio = new Persona(madreNombre,madreDocumento,madreTD,madreFecha);
        
            int numeroHijos = modeloTabla.getRowCount();

            ArrayList<Persona> hijos = new ArrayList();

            for(int i=4; i<numeroHijos; i++){
                String hijoNombre = modeloTabla.getValueAt(i, 1).toString();
                String hijoFecha = modeloTabla.getValueAt(i, 2).toString();
                String hijoTD = modeloTabla.getValueAt(i, 3).toString();
                String hijoDocumento = modeloTabla.getValueAt(i, 4).toString();
                Persona hijoNuevo = new Persona(hijoNombre,hijoDocumento,hijoTD,hijoFecha);
                hijos.add(hijoNuevo);
            }   
            Socio nuevoSocio = new Socio(nombre,documento,td,fechaNacimiento,ciudadExp,empresa,cargo,fechaIngreso,nivelEstudio,casaApartamento,direccion,telefono,celular,barrio,ciudad,
                ingresosMensuales,ingresosMensuales,estadoCivil,conyugueSocio,madreSocio,padreSocio,hijos);
        }
        else{
            
        
        }
        
    
    }
    
    /*MEtodo heredado de Action Listener que establece las acciones que se hace 
     al hacer click en algunos elementos de la pantalla*/
    @Override
    public void actionPerformed(ActionEvent e) {
                
        if(e.getSource()==botonSocioNuevo){
            panelFormularios.removeAll();
            espacioFormatoSocios();
            panelBotonesSocios.add(buttonCrearSocio);
            panelFormularios.updateUI();
        }
        
        if(e.getSource()==botonSocioEditar){
            
        }
        
        if(e.getSource()==botonSocioConsultar){
            JOptionPane.showInputDialog(null,"Que socio desea consultar?");
            panelFormularios.removeAll();
            espacioFormatoSocios();
            panelBotonesSocios.add(botonSocioEditar);
            panelBotonesSocios.add(botonSocioEliminar);
            panelFormularios.updateUI();
        }
        
        if(e.getSource()==botonSocioEliminar){
        }
        
        if(e.getSource()==botonAgregarHijo){
            //panelFormularios.removeAll();
            modeloTabla.addRow(new Object[]{"Hijo/a","","","",""});
            panelFormularios.updateUI();
        }
        
        if(e.getSource()==buttonCrearSocio){
            if(verificarDatos()){
                panelFormularios.removeAll();
                obtenerDatosSocio(1);
                panelFormularios.updateUI();
                JOptionPane.showMessageDialog(null,"Socio Agregado con Exito");
            }
            else{
                JOptionPane.showMessageDialog(null,"Estos Datos son necesarios: Nombre Completo, Numero Documento, Direccion, Telefono, Celular","Campos Obligatorios",JOptionPane.WARNING_MESSAGE);
            }
            
        }
               
    }
    
    /*Metodo main que inicializa la aplicacion*/
    public static void main(String args[]){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.mostrarVentana();
    }
}