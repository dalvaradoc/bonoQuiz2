/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasuministr_quiz2;

import java.io.IOException;

/**
 *
 * @author Estudiante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Sistema sistema = new Sistema("savefile.txt");
        
        //Añado los eslabones y materias primas / productos al sistema para mostrar el escenario simplificado
        //*Todo esto se puede hacer desde el menu, pero para tener objetos ya creados sin cargar desde un archivo .txt
        //vi necesario hacer toda esta parte*
        
        sistema.addEslabon("Farmer", "Granja X", "descripcion granja x", "direccion granja x");
        sistema.getGranjas().get(0).addMateriaPrima("Leche", "18/02/2019");
        sistema.getGranjas().get(0).addMateriaPrima("Leche", "18/02/2019");
        sistema.getGranjas().get(0).addMateriaPrima("Leche", "18/02/2019");
        sistema.getGranjas().get(0).addMateriaPrima("Leche", "18/02/2019");
        
        sistema.addEslabon("Farmer", "Granja Y", "descripcion granja y", "direccion granja y");
        sistema.getGranjas().get(1).addMateriaPrima("Harina", "26/02/2019");
        sistema.getGranjas().get(1).addMateriaPrima("Harina", "26/02/2019");
        sistema.getGranjas().get(1).addMateriaPrima("Harina", "26/02/2019");
        sistema.getGranjas().get(1).addMateriaPrima("Harina", "26/02/2019");
        
        sistema.addEslabon("Manufacturer", "Manufactura W", "descripcion manufactura w", "direccion manufactura w");
        sistema.getFabricantes().get(0).comprar(sistema.getGranjas().get(0), "Leche", 1);
        sistema.getFabricantes().get(0).comprar(sistema.getGranjas().get(1), "Harina", 1);
        sistema.getFabricantes().get(0).addProducto("Pan", "27/02/2019", 1);
        sistema.getFabricantes().get(0).comprar(sistema.getGranjas().get(0), "Leche", 1);
        sistema.getFabricantes().get(0).comprar(sistema.getGranjas().get(1), "Harina", 1);
        sistema.getFabricantes().get(0).addProducto("Pan", "27/02/2019", 2);
        
        sistema.addEslabon("DistributionCenter", "centro de distribucion", "descripcion", "direccion");
        sistema.getDistribuidores().get(0).comprar(sistema.getFabricantes().get(0), "Pan", 2);
        sistema.getDistribuidores().get(0).addProducto("Pan", "27/02/2019");
        
        sistema.addEslabon("Retail", "Retail R", "descripcion retail r", "direccion retail r");
        sistema.getMinoristas().get(0).comprar(sistema.getDistribuidores().get(0), "Pan", 1);
        sistema.getMinoristas().get(0).addProducto("Pan", 300, "00001", "28/02/2019");
        
        Menu menu = new Menu(sistema);
    }
    
}
