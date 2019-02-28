/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasuministr_quiz2;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Producto extends MateriaPrima {
    
    private int numeroLote;
    private ArrayList<MateriaPrima> materiaPrima;

    public Producto(int numeroLote, ArrayList<MateriaPrima> materiaPrima, String nombreP, String fechaP, String procedenciaP) {
        super(nombreP, fechaP, procedenciaP);
        this.numeroLote = numeroLote;
        this.materiaPrima = materiaPrima;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public ArrayList<MateriaPrima> getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(ArrayList<MateriaPrima> materiaPrima) {
        this.materiaPrima = materiaPrima;
    }   
    
    
}
