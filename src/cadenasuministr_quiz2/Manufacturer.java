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
public class Manufacturer extends Eslabon {
    
    ArrayList<Producto> productos;
    ArrayList<MateriaPrima> materiaPrima;
    
    public Manufacturer(String nombre, String descripcion, String direccion) {
        super(nombre, descripcion, direccion);
        this.productos = new ArrayList<>();
        this.materiaPrima = new ArrayList<>();
    }
    
    public boolean addProducto (String nombreP, String fechaP, int numeroLote) {
        return productos.add(new Producto(nombreP, fechaP, this.getNombre(), numeroLote));
    }

    @Override
    public boolean comprar(Eslabon esl, String mP, int cantidad) {
        ArrayList<MateriaPrima> compras = esl.vender(this, mP, cantidad);
        for (MateriaPrima m : compras){
            this.materiaPrima.add(m);
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
