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
public class MateriaPrima {
    private String nombre;
    private String fecha;
    private String procedencia;

    public MateriaPrima(String nombre, String fecha, String procedencia) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.procedencia = procedencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
    
    
}
