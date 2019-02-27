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
public class Retail extends Eslabon {
    private ArrayList<ProductoVenta> productosVenta;
    private ArrayList<Producto> productos;

    public Retail(String nombre, String descripcion, String direccion) {
        super(nombre, descripcion, direccion);
        this.productos = new ArrayList<>();
        this.productosVenta = new ArrayList<>();
    }
    
    public boolean addProducto (Producto prod, double precio, String codigo){
        ProductoVenta prodV = (ProductoVenta)prod;
        prodV.setCodigo(codigo);
        prodV.setPrecio(precio);
        return productosVenta.add(prodV);
    }

    @Override
    public boolean comprar(Eslabon esl, String mP, int cantidad) {
        ArrayList<MateriaPrima> compras = esl.vender(esl, mP, cantidad);
        for (MateriaPrima m : compras){
            Producto p = (Producto)m;
            productos.add(p);
        }
        return true;
    }

    @Override
    public ArrayList<MateriaPrima> vender(Eslabon esl, String mP, int cantidad) {
        return null;
    }
    
    
    
}
