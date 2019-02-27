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
public class DistributionCenter extends Eslabon {
    
    ArrayList<Producto> productos;
    
    public DistributionCenter(String nombre, String descripcion, String direccion) {
        super(nombre, descripcion, direccion);
        productos = new ArrayList<>();
    }
    
    public boolean addProducto (Producto productoM){
        return productos.add(productoM);
    }

    @Override
    public boolean comprar(Eslabon esl, String mP, int cantidad) {
        ArrayList<MateriaPrima> compras = esl.vender(this, mP, cantidad);
        for (MateriaPrima m : compras){
            Producto p = (Producto)m;
            this.productos.add(p);
        }
        return true;
    }

    @Override
    public ArrayList<MateriaPrima> vender(Eslabon esl, String mP, int cantidad) {
        int c = 0;
        ArrayList<MateriaPrima> paraVender = new ArrayList<>();
        for (Producto p : productos){
            if (p.getNombre().equals(mP)){
                paraVender.add(p);
                this.productos.remove(p);
                c++;
            }
            if (c == cantidad){
                this.registro.add(new RegistroVenta(mP, esl, c));
                return paraVender;
            }
        }
        this.registro.add(new RegistroVenta(mP, esl, c));
        return paraVender;
    }
    
    
}
