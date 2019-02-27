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
public class RegistroVenta {
    private String materiaPrima;
    private Eslabon eslabon;
    private int cantidad;

    public RegistroVenta(String materiaPrima, Eslabon eslabon, int cantidad) {
        this.materiaPrima = materiaPrima;
        this.eslabon = eslabon;
        this.cantidad = cantidad;
    }

    public String getMateriaPrima() {
        return materiaPrima;
    }

    public Eslabon getEslabon() {
        return eslabon;
    }    

    public int getCantidad() {
        return cantidad;
    }
    
    
    
}
