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
    
    private ArrayList <MateriaPrima> cultivos;
    
    public Farmer(String nombre, String descripcion, String direccion) {
        super(nombre, descripcion, direccion);
        this.cultivos = new ArrayList<>();
    }
    
    public boolean addCultivo (String nombreC, String fechaC){
        return cultivos.add(new MateriaPrima(nombreC, fechaC, this.getNombre()));
    }

    @Override
    public boolean comprar(Eslabon esl, String mP, int cantidad) {
        return true;
    }

    @Override
    public ArrayList<MateriaPrima> vender(Eslabon esl, String mP, int cantidad) {
        int c = 0;
        ArrayList<MateriaPrima> paraVender = new ArrayList<>();
        for (MateriaPrima m : cultivos){
            if (m.getNombre().equals(mP)){
                paraVender.add(m);
                this.cultivos.remove(m);
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
