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
public class ProductoVenta extends Producto{
    
    private double precio;
    private String codigo;

    public ProductoVenta (Producto prod, double precio, String codigo){
        super(prod.getNombre(), prod.getFecha(),prod.getProcedencia(), prod.getNumeroLote());
        this.precio = precio;
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}
