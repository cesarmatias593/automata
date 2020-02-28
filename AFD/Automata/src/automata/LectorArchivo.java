/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @authores:
 * Cesar Alejandro Matias Angeles
 */
public class LectorArchivo extends Component {
    static Automata au;
    static FileReader fr;
    static String cadena = "";
    
    /**
     *
     * @param au Objeto que contiene a la clase automata creado en la clase LyA1.
     */
    public LectorArchivo(Automata au){
        this.au = au;
        
    }
    
    /**
     *
     * @return Valor de tipo booleano que indica si el archivo fue encontrado.
     */
    public boolean rutaArchivo() {

        boolean encontrado = false;

        try {
            JFileChooser file = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
            file.setFileFilter(filter);
            file.showOpenDialog(this);
            /**
             * abrimos el archivo seleccionado
             */
            File ruta = file.getSelectedFile();
            if (ruta != null) {
                fr = new FileReader(ruta);
                encontrado = true;
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        }
        return encontrado;
    }

    /**
     *Hace la lectura del archivo de texto y obtiene el número de estados, el abecedario, estado inicial, estado final ,
     * transición de estados y la cadena a analizar.
     */
    public void leerArchivo() {
        BufferedReader br = new BufferedReader(fr);
        String datos = null;
        int mte[][];
        try {
            
            au.setQ(Integer.parseInt(br.readLine())); //Se le otorga el valor a Q; número de estados
            
            au.setAlpha(br.readLine()); //Se le otorga el valor a alpha; al abecedario
          
            au.setQ0(Integer.parseInt(br.readLine())); //Se le otorga el valor a Q0; estado inicial
            
            au.setF(Integer.parseInt(br.readLine())); //Se le otorga el valor a F; estado final
            
            mte = new int[au.getQ()][au.getAlpha().length()];//Se inicializa el tamaño de la matriz de estados
            
            datos = br.readLine();
            
            for (int i = 0; i < au.getQ(); i++) {
                for (int j = 0; j < au.getAlpha().length(); j++) {
                    
                    mte[Integer.parseInt(""+datos.charAt(0))][Integer.parseInt(""+datos.charAt(1))] = Integer.parseInt(""+datos.charAt(3));
                    datos = br.readLine();
                    
                    if(datos.hashCode() == 0){//Si hay una linea en blanco se terminan los estados
                        break;
                    }
                }
                
            }
            au.setMte(mte);
            
            this.setCadena(br.readLine()); //Se obtiene la cadena(palabra).
            
            fr.close();
            br.close();
        } catch (IOException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
        
    }
    
    /**
     *
     * @return Cadena que fue leida del archivo de texto
     */
    public String getCadena() {
        return cadena;
    }

    /**
     *
     * @param cadena Recibe la cadena que fue leida del archivo de texto.
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
