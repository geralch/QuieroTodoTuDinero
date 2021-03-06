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
    private JPanel panelEFSocios;
    private JPanel panelEFSociosR;
    private JPanel panelBotonesSocios;
    private JPanel panelFormularios;
    private JPanel panelEFPrestamos;
    private JButton botonSocioNuevo;
    private JButton botonSocioEditar;
    private JButton botonSocioConsultar;
    private JButton botonSocioEliminar;
    private JButton botonPrestamoNuevo;
    private JButton botonPrestamoEditar;
    private JButton botonPrestamoConsultar;
    private JButton botonPrestamoEliminar;
    
    private JButton buttonCrearSocio;
    
    private Cooperativa cooperativa;
    private Socio socioConsultar;
    private Prestamo prestamoConsultar;
    
    private JScrollPane scrollPane;
    private JTextField tfDISocio;
    private JTextField tfValorPrestamo;
    private JTextField tfCuotas;
    private JTextField tfFechaAutorizacion;
    private JTextField tfFechaDesembolse;
    private JTextArea taFechaConsignaciones;
    private JTextField tfNumPrestamo;
    private JButton buttonCrearPrestamo;
    private JPanel panelBotonesPrestamo;
    private JButton buttonGenerarFechas;
    private Prestamo prestamoNuevo;
    private JPanel panelFechaConsignaciones;
    
    /*Constructor de la clase*/
    public VentanaPrincipal(){
        cooperativa = new Cooperativa();
    }
    
    /*Metodo que se encarga de mostrar la ventana y organizar sus componentes*/
    public void mostrarVentana(){
        
        this.setTitle(".: Quiero Todo tu Dinero :.");
        this.setSize(1070,700); 
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        contenedor = this.getContentPane();
        contenedor.setLayout(new FlowLayout());
       
        panelFormularios = new JPanel(new FlowLayout());
        panelFormularios.setBorder(BorderFactory.createTitledBorder("Formulario"));
        redimensionarPanel(1050,580,panelFormularios);
        
        espacioSocios();
        espacioPrestamos();
        contenedor.add(panelFormularios);
        this.setVisible(true);
    }
    
    private void redimensionarPanel(int w, int l, JPanel panel){
        Dimension dimension = new Dimension();
        dimension.setSize(w, l);
        panel.setPreferredSize(dimension);
    }
    
    public int buscarIndexComboBox(String texto, JComboBox combobox){
        
        int index = 0;
        for(int i=0; i<combobox.getItemCount(); i++){
            if(texto.equals(combobox.getItemAt(i).toString())){
                index = i;
            }
        }
        return index;
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
    
    private boolean verificarDatosSocio(){
        boolean verificacion = false;
        System.out.print("entra aqui a verificar");
        if(tfNombreCompleto.getText().equals("") || tfCedulaCiudadania.getText().equals("") || 
                tfDireccion.getText().equals("") || tfTelefono.getText().equals("") || tfCelular.getText().equals("")){
        }
        else{
            verificacion = true;
        }
        
        return verificacion;
    }

    private void obtenerDatosSocio(int tipoform, Socio socioConsultar){
               
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
        
        String nombre, td, documento, ciudadExp, fechaNacimiento, empresa, cargo, fechaIngreso, nivelEstudio, estadoCivil,direccion, barrio, ciudad, celular = "";
        int telefono = 0;
        int ingresosMensuales, egresosMensuales = 0;
        
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
        celular = tfCelular.getText();
        barrio = tfBarrio.getText();
        ciudad = tfCiudad.getText();
        ingresosMensuales = Integer.parseInt(tfIngresosMensuales.getText());
        egresosMensuales = Integer.parseInt(tfEgresosMensuales.getText());
        
        if(tipoform==1){
            Persona conyugueSocio = new Persona(conyugueNombre,conyugueDocumento,conyugueTD,conyugueFecha);
            Persona madreSocio = new Persona(madreNombre,madreDocumento,madreTD,madreFecha);
            Persona padreSocio = new Persona(madreNombre,madreDocumento,madreTD,madreFecha);
        
            int numeroHijos = modeloTabla.getRowCount();

            ArrayList<Persona> hijos = new ArrayList();

            for(int i=3; i<numeroHijos; i++){
                String hijoNombre = modeloTabla.getValueAt(i, 1).toString();
                String hijoFecha = modeloTabla.getValueAt(i, 2).toString();
                String hijoTD = modeloTabla.getValueAt(i, 3).toString();
                String hijoDocumento = modeloTabla.getValueAt(i, 4).toString();
                Persona hijoNuevo = new Persona(hijoNombre,hijoDocumento,hijoTD,hijoFecha);
                hijos.add(hijoNuevo);
            }   
            Socio nuevoSocio = new Socio(nombre,documento,td,fechaNacimiento,ciudadExp,empresa,cargo,fechaIngreso,nivelEstudio,casaApartamento,direccion,telefono,celular,barrio,ciudad,
                ingresosMensuales,egresosMensuales,estadoCivil,conyugueSocio,madreSocio,padreSocio,hijos);
            cooperativa.anyadirSocios(nuevoSocio);
        }
        else{
            socioConsultar.setNombreCompleto(nombre);
            socioConsultar.setDi(documento);
            socioConsultar.setTipoDI(td);
            socioConsultar.setFechaNacimiento(fechaNacimiento);
            socioConsultar.setLugarExpID(ciudadExp);
            socioConsultar.setNombreEmpresa(empresa);
            socioConsultar.setCargoEmpresa(cargo);
            socioConsultar.setFechaIngresoEmpresa(fechaIngreso);
            socioConsultar.setNivelEstudios(nivelEstudio);
            socioConsultar.setCasaAptPropio(casaApartamento);
            socioConsultar.setDireccionResidencia(direccion);
            socioConsultar.setTelefonoResidencia(telefono);
            socioConsultar.setCelular(celular);
            socioConsultar.setBarrioResidencia(barrio);
            socioConsultar.setCiudadResidencia(ciudad);
            socioConsultar.setIngresoMensual(ingresosMensuales);
            socioConsultar.setEgresoMensual(egresosMensuales);
            socioConsultar.setEstadoCivil(estadoCivil);
            
            socioConsultar.getConyugue().setNombreCompleto(conyugueNombre);
            socioConsultar.getConyugue().setDi(conyugueDocumento);
            socioConsultar.getConyugue().setTipoDI(conyugueTD);
            socioConsultar.getConyugue().setFechaNacimiento(conyugueFecha);
            
            socioConsultar.getMadre().setNombreCompleto(madreNombre);
            socioConsultar.getMadre().setDi(madreDocumento);
            socioConsultar.getMadre().setTipoDI(madreTD);
            socioConsultar.getMadre().setFechaNacimiento(madreFecha);
            
            socioConsultar.getPadre().setNombreCompleto(padreNombre);
            socioConsultar.getPadre().setDi(padreDocumento);
            socioConsultar.getPadre().setTipoDI(padreTD);
            socioConsultar.getPadre().setFechaNacimiento(padreFecha);
        
            int numeroHijos = socioConsultar.getHijos().size()+3;

            int j=0;
            for(int i=3; i<numeroHijos; i++){
                socioConsultar.getHijo(j).setNombreCompleto(modeloTabla.getValueAt(i, 1).toString());
                socioConsultar.getHijo(j).setFechaNacimiento(modeloTabla.getValueAt(i, 2).toString());
                socioConsultar.getHijo(j).setTipoDI(modeloTabla.getValueAt(i, 3).toString());
                socioConsultar.getHijo(j).setDi(modeloTabla.getValueAt(i, 4).toString());
                j++;
            }  
        }
    }
     
    public void ponerDatosSocioCampos(Socio socioConsultar){
        
        tfNombreCompleto.setText(socioConsultar.getNombreCompleto());
        cbTD.setSelectedIndex(buscarIndexComboBox(socioConsultar.getTipoDI(),cbTD));
        tfCedulaCiudadania.setText(socioConsultar.getDi());
        tfCiudadExpTD.setText(socioConsultar.getLugarExpID());
        tfFechaNacimiento.setText(socioConsultar.getFechaNacimiento());         
        tfEmpresa.setText(socioConsultar.getNombreEmpresa());
        tfCargoDesempenyado.setText(socioConsultar.getCargoEmpresa());
        tfFechaIngreso.setText(socioConsultar.getFechaIngresoEmpresa());  
        cdNiveldeEstudios.setSelectedIndex(buscarIndexComboBox(socioConsultar.getNivelEstudios(),cdNiveldeEstudios));
        cdEstadoCivil.setSelectedIndex(buscarIndexComboBox(socioConsultar.getEstadoCivil(),cdEstadoCivil));
        cbCasaApartamente.setSelected(socioConsultar.isCasaAptPropio());
        tfDireccion.setText(socioConsultar.getDireccionResidencia());
        tfTelefono.setText(String.valueOf(socioConsultar.getTelefonoResidencia()));
        tfCelular.setText(String.valueOf(socioConsultar.getCelular()));
        tfBarrio.setText(socioConsultar.getBarrioResidencia());
        tfCiudad.setText(socioConsultar.getCiudadResidencia());
        tfIngresosMensuales.setText(String.valueOf(socioConsultar.getIngresoMensual()));
        tfEgresosMensuales.setText(String.valueOf(socioConsultar.getEgresoMensual()));
        
        modeloTabla.setValueAt(socioConsultar.getConyugue().getNombreCompleto(), 0, 1);
        modeloTabla.setValueAt(socioConsultar.getConyugue().getFechaNacimiento(), 0, 2);
        modeloTabla.setValueAt(socioConsultar.getConyugue().getTipoDI(), 0, 3);
        modeloTabla.setValueAt(socioConsultar.getConyugue().getDi(), 0, 4);
        
        modeloTabla.setValueAt(socioConsultar.getMadre().getNombreCompleto(), 1, 1);
        modeloTabla.setValueAt(socioConsultar.getMadre().getFechaNacimiento(), 1, 2);
        modeloTabla.setValueAt(socioConsultar.getMadre().getTipoDI(), 1, 3);
        modeloTabla.setValueAt(socioConsultar.getMadre().getDi(), 1, 4);
        
        modeloTabla.setValueAt(socioConsultar.getPadre().getNombreCompleto(), 2, 1);
        modeloTabla.setValueAt(socioConsultar.getPadre().getFechaNacimiento(), 2, 2);
        modeloTabla.setValueAt(socioConsultar.getPadre().getTipoDI(), 2, 3);
        modeloTabla.setValueAt(socioConsultar.getPadre().getDi(), 2, 4);
        
        int j = 0;
        int numParaFor = socioConsultar.getHijos().size()+3;
        System.out.print(socioConsultar.getHijos().size());
        
        for(int i=3; i<numParaFor; i++){
                modeloTabla.addRow(new Object[]{"Hijo/a","","","",""});
                modeloTabla.setValueAt(socioConsultar.getHijo(j).getNombreCompleto(),i, 1);
                modeloTabla.setValueAt(socioConsultar.getHijo(j).getFechaNacimiento(),i, 2);
                modeloTabla.setValueAt(socioConsultar.getHijo(j).getTipoDI(),i, 3);
                modeloTabla.setValueAt(socioConsultar.getHijo(j).getDi(),i, 4);
                j++;
            }  
        
        panelFormularios.updateUI();
    }
    
    private void espacioPrestamos(){
        panelPrestamos = new JPanel(new FlowLayout());
        panelPrestamos.setBorder(BorderFactory.createTitledBorder("Prestamos")); 
        Dimension dimension = new Dimension();
        dimension.setSize(400, 70);
        panelPrestamos.setPreferredSize(dimension);
        
        botonPrestamoNuevo = new JButton("Nuevo");
        botonPrestamoNuevo.addActionListener(this);
        
        botonPrestamoConsultar = new JButton("Consultar");
        botonPrestamoConsultar.addActionListener(this);
             
        panelPrestamos.add(botonPrestamoNuevo);
        panelPrestamos.add(botonPrestamoConsultar);
        
        contenedor.add(panelPrestamos);   
    }
        
    private void espacioFormatoPrestamos(){
        panelEFPrestamos = new JPanel(new GridLayout(13,2,0,0));
        panelEFPrestamos.setBorder(BorderFactory.createTitledBorder("Campos Prestamo"));
        Dimension dimension = new Dimension();
        dimension.setSize(500, 400);
        panelEFPrestamos.setPreferredSize(dimension);
    
        tfNumPrestamo = new JTextField("");
        tfDISocio = new JTextField("");
        tfNumPrestamo.setEditable(false);
        tfValorPrestamo = new JTextField("");
        tfCuotas = new JTextField("");
        tfFechaAutorizacion = new JTextField("yyyy-mm-dd");
        tfFechaDesembolse = new JTextField("");

        panelEFPrestamos.add(new JLabel("Prestamo No: "),0,0);
        panelEFPrestamos.add(tfNumPrestamo,0,1);
        panelEFPrestamos.add(new JLabel("DI Socio: "),0,2);
        panelEFPrestamos.add(tfDISocio,0,3);
        panelEFPrestamos.add(new JLabel("Valor Prestamo: "),0,4);
        panelEFPrestamos.add(tfValorPrestamo,0,5);
        panelEFPrestamos.add(new JLabel("Numero Cuotas: "),0,6);
        panelEFPrestamos.add(tfCuotas,0,7);
        panelEFPrestamos.add(new JLabel("Fecha Autorizacion: "),0,8);
        panelEFPrestamos.add(tfFechaAutorizacion,0,9);
        panelEFPrestamos.add(new JLabel("Fecha Desembolse: "),0,10);
        panelEFPrestamos.add(tfFechaDesembolse,0,11);
        panelEFPrestamos.add(new JLabel("Fechas de Pago Cuotas: "),0,12);
        
        panelFechaConsignaciones = new JPanel();
        panelFechaConsignaciones.setBorder(BorderFactory.createTitledBorder(""));
        Dimension dimensionPFC = new Dimension();
        dimensionPFC.setSize(500, 100);
        panelFechaConsignaciones.setPreferredSize(dimensionPFC);
        
        taFechaConsignaciones = new JTextArea(6, 40);
        scrollPane = new JScrollPane(taFechaConsignaciones); 
        taFechaConsignaciones.setEditable(false);
        panelFechaConsignaciones.add(scrollPane);
        
        panelBotonesPrestamo = new JPanel();
        
        buttonCrearPrestamo = new JButton("Agregar Prestamo");
        buttonCrearPrestamo.addActionListener(this);
           
        botonPrestamoEditar = new JButton("Editar");
        botonPrestamoEditar.addActionListener(this);

        botonPrestamoEliminar = new JButton("Eliminar");
        botonPrestamoEliminar.addActionListener(this);
        
        panelFormularios.add(panelEFPrestamos);
        panelFormularios.add(panelFechaConsignaciones);
        panelFormularios.add(panelBotonesPrestamo);
    } 
    
    private void obtenerDatosPrestamo(int tipoform, Prestamo prestamoConsultar){
        
        int numeroPrestamo,valorPrestamo, cuotasPago, idSocio = 0;
        String fechaAutorizacion, fechaDesembolse, fechasConsignaciones = "";     
        
        numeroPrestamo = Integer.parseInt(tfNumPrestamo.getText());
        idSocio = Integer.parseInt(tfDISocio.getText());
        valorPrestamo = Integer.parseInt(tfValorPrestamo.getText());
        cuotasPago = Integer.parseInt(tfCuotas.getText());
        fechaAutorizacion = tfFechaAutorizacion.getText();
        
        if(fechaAutorizacionValida()){
            if(tipoform==1){
                if(cooperativa.socioExiste(idSocio)){
                    Socio socioPrestamo = new Socio();
                    socioPrestamo = cooperativa.cosultarSocio(idSocio);
                    prestamoNuevo = new Prestamo(numeroPrestamo,socioPrestamo, valorPrestamo,cuotasPago,fechaAutorizacion);
                    prestamoNuevo.setFechaDesembolse();
                    prestamoNuevo.setFechasConsignaciones();
                    fechaDesembolse = prestamoNuevo.getFechaDesembolse();
                    fechasConsignaciones = prestamoNuevo.getFechasConsignaciones();
                    cooperativa.anyadirPrestamo(prestamoNuevo);

                    tfFechaDesembolse.setText(fechaDesembolse);
                    taFechaConsignaciones.setText(fechasConsignaciones);
                    reciboPrestamo();
                }
                else{
                    JOptionPane.showMessageDialog(null,"El Socio no existe");
                }
            }
            else{
                prestamoConsultar.setValorPrestamos(valorPrestamo);
                prestamoConsultar.setCuotasPago(cuotasPago);
                prestamoConsultar.setFechaAutorizacion(fechaAutorizacion);
                prestamoConsultar.setFechaDesembolse();
                prestamoConsultar.setFechasConsignaciones();
                fechaDesembolse = prestamoNuevo.getFechaDesembolse();
                fechasConsignaciones = prestamoNuevo.getFechasConsignaciones();
            }
        }
        else{
             JOptionPane.showMessageDialog(null,"La Fecha de Autorizacion debe en los primeros 20 dias del mes","Fecha Autorizacion Incorrecta",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private boolean verificarDatosPrestamos(){
        boolean verificacion = false;
        if(tfDISocio.getText().equals("") || tfValorPrestamo.getText().equals("") || tfCuotas.getText().equals("") ){
        }
        else{
            
            verificacion = true;
        }
        
        return verificacion;
    }
    
    public boolean fechaAutorizacionValida(){
        boolean valida;
        String fechaAutorizacion = tfFechaAutorizacion.getText();
        if(new Prestamo().fechaAutorizacionValida(fechaAutorizacion)){
            valida = true;
        }
        else{
            valida = false;
        }
        
        return valida;
    }
    
    private void reciboPrestamo(){
        ArrayList<String> datos = new ArrayList();
        datos.add("Prestamo No: "+prestamoNuevo.getNumeroPrestemo());
        datos.add("\nSocio:\nDI: "+prestamoNuevo.getSocioResponsable().getDi()+" "+prestamoNuevo.getSocioResponsable().getTipoDI());
        datos.add("\nNombre: "+prestamoNuevo.getSocioResponsable().getNombreCompleto());
        datos.add("\nDireccion: "+prestamoNuevo.getSocioResponsable().getDireccionResidencia());
        datos.add( "\nTelefono: "+prestamoNuevo.getSocioResponsable().getTelefonoResidencia()+" Celular: "+prestamoNuevo.getSocioResponsable().getCelular());
        datos.add("\nValor Prestado: "+prestamoNuevo.getValorPrestamos());
        datos.add("\nFecha Autorizacion: "+prestamoNuevo.getFechaAutorizacion());
        datos.add("\nFecha Desembolzo: "+prestamoNuevo.getFechaDesembolse());
        
        String fechas = prestamoNuevo.getFechasConsignaciones();
        
        VentanaRecibo ventanaRecibo = new VentanaRecibo(datos,fechas);
    }
    
    private void ponerDatosPrestamoCampos(Prestamo prestamoConsultar){
        
        tfNumPrestamo.setText(String.valueOf(prestamoConsultar.getNumeroPrestemo()));
        tfDISocio.setText((prestamoConsultar.getSocioResponsable().getDi()));
        tfValorPrestamo.setText(String.valueOf(prestamoConsultar.getValorPrestamos()));
        tfCuotas.setText(String.valueOf(prestamoConsultar.getCuotasPago()));
        tfFechaAutorizacion.setText(prestamoConsultar.getFechaAutorizacion());
        tfFechaDesembolse.setText((prestamoConsultar.getFechaDesembolse()));
        taFechaConsignaciones.setText(prestamoConsultar.getFechasConsignaciones());
    }
    /*MEtodo heredado de Action Listener que establece las acciones que se hace 
     al hacer click en algunos elementos de la pantalla*/
    @Override
    public void actionPerformed(ActionEvent e) {
                
        if(e.getSource()==botonSocioNuevo){
            panelFormularios.removeAll();
            redimensionarPanel(1050,580,panelFormularios);
            espacioFormatoSocios();
            panelBotonesSocios.add(buttonCrearSocio);
            panelFormularios.updateUI();
        }
        
        if(e.getSource()==buttonCrearSocio){
            if(verificarDatosSocio()){
                panelFormularios.removeAll();
                obtenerDatosSocio(1,null);
                panelFormularios.updateUI();
                JOptionPane.showMessageDialog(null,"Socio Agregado con Exito");
            }
            else{
                JOptionPane.showMessageDialog(null,"Estos Datos son necesarios: Nombre Completo, Numero Documento, Direccion, Telefono, Celular","Campos Obligatorios",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        if(e.getSource()==botonSocioEditar){
            obtenerDatosSocio(2,socioConsultar);
            JOptionPane.showMessageDialog(null,"Socio Editado");
        }
        
        if(e.getSource()==botonSocioConsultar){
            int sociosConsultar = Integer.parseInt(JOptionPane.showInputDialog(null,"Que socio desea consultar?"));
            
            if(cooperativa.socioExiste(sociosConsultar)){
                socioConsultar = cooperativa.cosultarSocio(sociosConsultar);
                panelFormularios.removeAll();
                redimensionarPanel(1050,580,panelFormularios);
                espacioFormatoSocios();
                ponerDatosSocioCampos(socioConsultar);
                panelBotonesSocios.add(botonSocioEditar);
                panelBotonesSocios.add(botonSocioEliminar);
                panelFormularios.updateUI();
            }
            else{
                JOptionPane.showMessageDialog(null,"Socio No Existe");
            }
        }
        
        if(e.getSource()==botonSocioEliminar){
            panelFormularios.removeAll();
            cooperativa.eliminarSocio(socioConsultar);
            panelFormularios.updateUI();
            JOptionPane.showMessageDialog(null,"Socio Eliminado");
        }
        
        if(e.getSource()==botonAgregarHijo){
            modeloTabla.addRow(new Object[]{"Hijo/a","","","",""});
            panelFormularios.updateUI();
        }

        if(e.getSource()==botonPrestamoNuevo){
            panelFormularios.removeAll();
            redimensionarPanel(600,580,panelFormularios);            
            espacioFormatoPrestamos();
            tfNumPrestamo.setText(String.valueOf(cooperativa.getNumPrestamoActual()+1));
            panelBotonesPrestamo.add(buttonCrearPrestamo);
            panelFormularios.updateUI();
        }
        
        if(e.getSource()==buttonCrearPrestamo){
            
            if(verificarDatosPrestamos()){
                if(fechaAutorizacionValida()){
                    panelFormularios.removeAll();
                    obtenerDatosPrestamo(1,null);
                    panelFormularios.updateUI();
                }
                else{
                    JOptionPane.showMessageDialog(null,"La Fecha de Autorizacion debe en los primeros 20 dias del mes","Fecha Autorizacion Incorrecta",JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Estos Datos son necesarios: DI Socio, Valor Prestamo, Cuotas Prestamo","Campos Obligatorios",JOptionPane.WARNING_MESSAGE);
            }
            
        }
                
        if(e.getSource()==botonPrestamoConsultar){
            int prestamosConsultar = Integer.parseInt(JOptionPane.showInputDialog(null,"Que Prestamo desea consultar?"));
            
            if(cooperativa.prestamoExiste(prestamosConsultar)){
                prestamoConsultar = cooperativa.cosultarPrestamo(prestamosConsultar);
                panelFormularios.removeAll();
                redimensionarPanel(600,580,panelFormularios);
                espacioFormatoPrestamos();
                ponerDatosPrestamoCampos(prestamoConsultar);
                panelBotonesPrestamo.add(botonPrestamoEditar);
                panelBotonesPrestamo.add(botonPrestamoEliminar);
                panelFormularios.updateUI();
            }
            else{
                JOptionPane.showMessageDialog(null,"Prestamo No Existe");
            }
        }
        
        if(e.getSource()==botonPrestamoEditar){
            obtenerDatosPrestamo(2,prestamoConsultar);
            JOptionPane.showMessageDialog(null,"Prestamo Editado");
        }
        
        if(e.getSource()==botonPrestamoEliminar){
            panelFormularios.removeAll();
            cooperativa.eliminarPrestamo(prestamoConsultar);
            panelFormularios.updateUI();
            JOptionPane.showMessageDialog(null,"Prestamo Eliminado");
        }
    }
    
    /*Metodo main que inicializa la aplicacion*/
    public static void main(String args[]){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.mostrarVentana();
    }
}