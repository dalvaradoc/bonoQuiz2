/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasuministr_quiz2;

/**
 *
 * @author Estudiante
 */
public class Producto extends MateriaPrima {
    
    private int numeroLote;
    
    public Producto(String nombre, String fecha, String procedencia, int numeroLote) {
        super(nombre, fecha, procedencia);
        this.numeroLote = numeroLote;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }
    
    
    
}
