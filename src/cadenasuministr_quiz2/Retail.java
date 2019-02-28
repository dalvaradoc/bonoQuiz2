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
    
    public boolean addProducto (String prodName, double precio, String codigo, String fechaCompra){
        for (Producto p : productos){
            if (p.getNombre().equals(prodName)){
                ProductoVenta prodV = new ProductoVenta(p, precio, codigo);
                prodV.setFecha(prodV.getFecha() + "," + fechaCompra);
                prodV.setProcedencia(prodV.getProcedencia() + "," + this.getNombre());
                return productosVenta.add(prodV);
            }
        }
        return false;
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
    
    public ProductoVenta venderProducto (String nombrePV){
        for (ProductoVenta pv : productosVenta){
            if (pv.getNombre().equals(nombrePV)){
                return pv;
            }
        }
        return null;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<ProductoVenta> getProductosVenta() {
        return productosVenta;
    }
    
    public String getInfoProductosVenta () {
        String info = "";
        ArrayList<String> nombresM = new ArrayList<>();
        for (ProductoVenta pvi : productosVenta){
            if (nombresM.contains(pvi.getNombre())){
                continue;
            }
            int c = 0;
            nombresM.add(pvi.getNombre());
            for (ProductoVenta pvj : productosVenta){
                if (pvj.getNombre().equals(pvi.getNombre())){
                    c++;
                }
            }
            info += pvi.getNombre() + ": " + c + "\r\n";
        }
        return info;
    }
}
