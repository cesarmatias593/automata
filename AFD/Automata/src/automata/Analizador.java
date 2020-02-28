/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @authores:
 * Cesar Alejandro Matias Angeles
 */
public class Analizador {
    
    static String cadena;
    static Automata afd;
    static int simbolo_analizado;
    
    /**
     *
     * @param au Objeto que contiene a la clase automata creado en la clase LyA1.
     */
    public Analizador(Automata au) {
        cadena = "1010";
        simbolo_analizado = -1;
        afd = au;
        
    }
    
    /**
     *
     * @param w Cadena a analizar por el autómata
     * @return Valor booleano que indica si se alcanzó un estado final para que sea valida la cadena
     */
    public boolean analizar(String w) {
        cadena = w;
        int q = afd.getQ0();
        char s;
        int ls;
        try {
            s = siguiente_simbolo();
            while (true) {                
                ls = afd.getAlpha().indexOf("" + s);
                if (ls == -1) error(102);
                q = afd.getMte(q, ls);
                if(q == -1) error(101);
                s = siguiente_simbolo();
                
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Fin de cadena");
        }
        System.out.println(""+ q);
        return afd.getF().contains(q);
    }
    
    /**
     *  Determina cual es el siguiente simbolo a analizar de la cadena
     * 
     */
    char siguiente_simbolo() throws IndexOutOfBoundsException {
        simbolo_analizado ++;
        return cadena.charAt(simbolo_analizado);
    }
    
    /**
     *
     * @param i Es el tipo de error que se genero (entero).
     */
    public void error(int i){
        switch(i){
            case 101: System.out.println("Error simbolo o estado no");
            break;
            case 102: System.out.println("Error simbolo no declarado");
            break;
        }
    }
    
    
    
}
