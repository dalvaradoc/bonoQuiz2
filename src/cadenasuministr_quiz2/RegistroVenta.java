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
    private MateriaPrima materiaPrima;
    private Eslabon eslabon;

    public RegistroVenta(MateriaPrima materiaPrima, Eslabon eslabon) {
        this.materiaPrima = materiaPrima;
        this.eslabon = eslabon;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public Eslabon getEslabon() {
        return eslabon;
    }    
    
}
