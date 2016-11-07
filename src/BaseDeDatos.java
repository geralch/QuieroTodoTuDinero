
import java.io.*;
import java.util.*;

/*Clase que gestiona la lectura del archivo con los datos del ambiente*/
public class BaseDeDatos {
    
    private ArrayList<ArrayList<String>> datos;
    private double valorMaximoPrestamos;

    public void setValorMaximoPrestamos(double valorMaximoPrestamos) {
        this.valorMaximoPrestamos = valorMaximoPrestamos;
    }

    public double getValorMaximoPrestamos() {
        return valorMaximoPrestamos;
    }
    /*Metodo que retorna un arreglo de arreglos de enteros con los datos del ambiente*/
    public ArrayList<ArrayList<String>> leerArchivo(String ruta, int registro){
        
        
        datos = new ArrayList(); 
        
        try{
            FileInputStream fstream = new FileInputStream(ruta);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));            
            
            int tamano = 0;
            
            if(registro==1){
                valorMaximoPrestamos = Double.parseDouble(br.readLine());
                tamano = Integer.parseInt(br.readLine());      
            }
            
            if(registro==2){
                tamano = Integer.parseInt(br.readLine());  
            }
                        
            for(int i=0; i<tamano; i++){
                StringTokenizer token = new StringTokenizer(br.readLine()); 
                ArrayList<String> fila = new ArrayList();
                for(int j=0; j<tamano; j++){
                    String dato = token.nextToken();
                    fila.add(dato);
                }
                datos.add(fila);
            }    
        }        
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        
        return datos;
    }
       
    /*Metodo que se encarga de escribir datos en un archivo*/
    public void escribirArchivo(ArrayList<ArrayList<Integer>> ternas, String ruta, int registro)
    {
        try{
            FileWriter fichero = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fichero);
            
            int tamano = 0;
            
            if(registro==1){
                pw.println(valorMaximoPrestamos);
                pw.println(ternas.size());    
            }
            
            if(registro==2){
                 pw.println(ternas.size());
            }
            
            for (int i = 0; i < ternas.size(); i++)
            {
                    pw.println(ternas.get(i));
            }
            fichero.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
