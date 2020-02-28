/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.Scanner;

/**
 *
 * @authores:
 * Cesar Alejandro Matias Angeles
 */
public class LyA1 {

    static boolean analizarNuevoArchivo = true;

    /**
     * Clase que contiene el método main para inicial la ejecución del autómata, controla los pasos para la lectura
     * del archivo de texto y el analisis de la cadena por el autómata, también controla si se requiere analizar
     * otro archivo o finalizar el programa.
     * @param args
     */
    public static void main(String[] args) {

        while (analizarNuevoArchivo) {
            Automata au = new Automata();
            LectorArchivo la = new LectorArchivo(au);
            Analizador a = new Analizador(au);
            Scanner entrada = new Scanner(System.in);

            if (la.rutaArchivo()) {
                la.leerArchivo();
            }

            if (a.analizar(la.getCadena())) {
                System.out.println("Cadena Aceptada\n");
            } else {
                System.out.println("Cadena Rechazada\n");
            }

            System.out.println("Desea analizar otro archivo\n"
                    + "1 = si\n"
                    + "2 = no");
            String opcion = entrada.next();
            if (opcion.equals("1")) {
                analizarNuevoArchivo = true;
            } else {
                analizarNuevoArchivo = false;
            }

        }

    }

}
