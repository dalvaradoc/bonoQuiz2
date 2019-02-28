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
public class Farmer extends Eslabon{
    
    private ArrayList <MateriaPrima> materiaPrima;
    
    public Farmer(String nombre, String descripcion, String direccion) {
        super(nombre, descripcion, direccion);
        this.materiaPrima = new ArrayList<>();
    }
    
    public boolean addMateriaPrima (String nombreC, String fechaC){
        return materiaPrima.add(new MateriaPrima(nombreC, fechaC, this.getNombre()));
    }

    @Override
    public boolean comprar(Eslabon esl, String mP, int cantidad) {
        return true;
    }

    @Override
    public ArrayList<MateriaPrima> vender(Eslabon esl, String mP, int cantidad) {
        int c = 0;
        ArrayList<MateriaPrima> paraVender = new ArrayList<>();
        ArrayList<MateriaPrima> clone = new ArrayList<>(materiaPrima);
        for (MateriaPrima m : materiaPrima){
            if (m.getNombre().equals(mP)){
                paraVender.add(m);
                clone.remove(m);
                c++;
            }
            if (c == cantidad){
                this.registro.add(new RegistroVenta(mP, esl, c));
                this.materiaPrima = clone;
                return paraVender;
            }
        }
        this.registro.add(new RegistroVenta(mP, esl, c));
        this.materiaPrima = clone;
        return paraVender;
    }

    public String getInfoMateriaPrima () {
        String info = "";
        ArrayList<String> nombresM = new ArrayList<>();
        for (MateriaPrima m : materiaPrima){
            if (nombresM.contains(m.getNombre())){
                continue;
            }
            int c = 0;
            nombresM.add(m.getNombre());
            for (MateriaPrima mN : materiaPrima){
                if (mN.getNombre().equals(m.getNombre())){
                    c++;
                }
            }
            info += m.getNombre() + ": " + c + "\r\n";
        }
        return info;
    }
    
}
