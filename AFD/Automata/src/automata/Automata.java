/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;

/**
 *
 * @authores:
 * Cesar Alejandro Matias Angeles
 */
public class Automata {

    private int Q;
    private String alpha;
    private int q0;
    //Todo cambiar cadena de estados finales por arreglo o lista
    private ArrayList<Integer> F = new ArrayList<>();;
    //private String F;
    private int mte [][];
    
    public Automata (){
    
    }

    
    /**
     *
     * @return Número de estados del autómata
     */

    public int getQ() {
        return Q;
    }

    /**
     *
     * @return Alfabeto con el que trabajará el autómata.
     */
    public String getAlpha() {
        return alpha;
    }

    /**
     *
     * @return Estado inicial en el que se encuentra el autómata.
     */
    public int getQ0() {
        return q0;
    }

    /**
     *
     * @return Estado o estados finales del autómata.
     */
    public ArrayList<Integer> getF() {
        return F;
    }

    /**
     *
     * @param q Estado actual en el que se encuentra el autómata.
     * @param s Indice en el que se encuentra el simbolo extraido de la cadena leida del archivo.
     * @return Retorna el nuevo estado en el que se encontrara el autómata, o retorna -1 de no haberse declarado un simbolo.
     */
    public int getMte(int q, int s) {
        if(q < Q && s<alpha.length()){
            return  mte[q][s];
            
        }else {
            return -1;
        }
        
        
        
    }
    
    
    /**
     *
     * @param Q
     */
    public void setQ(int Q) {
        this.Q = Q;
    }

    /**
     *
     * @param alpha
     */
    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    /**
     *
     * @param q0
     */
    public void setQ0(int q0) {
        this.q0 = q0;
    }

    /**
     *
     * @param F
     */
    public void setF(int F) {
        this.F.add(F);
    }

    /**
     *
     * @param mte
     */
    public void setMte(int[][] mte) {
        this.mte = mte;
    }

    
    
}
