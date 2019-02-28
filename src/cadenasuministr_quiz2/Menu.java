/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasuministr_quiz2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class Menu {
    
    Sistema sistema;

    public Menu(Sistema sistema) throws FileNotFoundException {
        this.sistema = sistema;
        
        System.out.println("Este es el menu para poder visualizar mejor el \n"
                + "funcionamiento del programa. Inicialmente hay una granja, \n"
                + "un fabricante, una distribuidora y un minorista, cada uno \n"
                + "ya cuenta con materia prima/productos. El menu permite \n"
                + "ver y/o editar la informacion de algun eslabon, permite \n"
                + "añadir y/o eliminar eslabones y permite comprar \n"
                + "un producto de un minorista y observar su trazabilidad.\n "
                + "*La opcion 1 permite ver como se mantiene la trazabilidad en"
                + " un producto \"Pan\" \n");
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean ciclo = true;
        while (ciclo){
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Comprar un producto");
            System.out.println("2. Editar Granjas");
            System.out.println("3. Editar Fabricantes");
            System.out.println("4. Editar Distribuidoras");
            System.out.println("5. Editar Minoristas");
            System.out.println("6. Añadir Eslabon.");
            System.out.println("7. Eliminar Eslabon.");
            System.out.println("8. Guardar");
            System.out.println("0. Cerrar");
            
            opc = sc.nextInt();
            
            System.out.println("----------------- ");
            
            String none = "";
            
            switch (opc){
                case 1:
                    System.out.println("Seleccione desde cual minorista va a comprar");
                    int opcRetail;
                    
                    for (int i = 0; i < sistema.getMinoristas().size(); i++){
                        System.out.println(Integer.toString(i+1) + ". " +
                                sistema.getMinoristas().get(i).getNombre());
                    }
                    
                    opcRetail = sc.nextInt();
                    
                    Retail minoristaC = sistema.getMinoristas().get(opcRetail-1);
                    System.out.println(minoristaC.getNombre());
                    System.out.println("Seleccione cual producto desea comprar");
                    for (int i = 0; i < minoristaC.getProductosVenta().size(); i++){
                        System.out.println(Integer.toString(i+1) + ". " +
                                minoristaC.getProductosVenta().get(i).getNombre() +
                                " " + minoristaC.getProductosVenta().get(i).getPrecio() +
                                " pesos");
                    }
                    
                    opcRetail = sc.nextInt();
                    ProductoVenta pv = minoristaC.getProductosVenta().get(opcRetail-1);
                    System.out.println("Esta es la informacion del producto que compro:");
                    System.out.println("Nombre del producto: " + pv.getNombre());
                    System.out.println("Fecha de ingreso al minorista: " + pv.getFecha().split(",")[2]);
                    System.out.println("Precio del producto: " + pv.getPrecio());
                    System.out.println("Codigo del producto: " + pv.getCodigo());
                    System.out.println("Distribuidor: " + pv.getProcedencia().split(",")[1]);
                    System.out.println("Fecha de ingreso al distribuidor: " + pv.getFecha().split(",")[1]);
                    System.out.println("Fabricado en: " + pv.getProcedencia().split(",")[0]);
                    System.out.println("Fecha de ingreso al fabricador: " + pv.getFecha().split(",")[0]);
                    System.out.println("Materia prima usada: ");
                    for (MateriaPrima mPV : pv.getMateriaPrima()){
                        System.out.println("Nombre: " + mPV.getNombre());
                        System.out.println("Fecha de creacion/recoleccion: " + mPV.getFecha());
                        System.out.println("Creado/Recolectado en: " + mPV.getProcedencia());
                    }
                    
                    break;
                case 2:
                    boolean cicloG = true;
                    int opcG;
                    while (cicloG){
                    System.out.println("Seleccione una granja");
                        for (int i = 0; i < sistema.getGranjas().size(); i++){
                            System.out.println(Integer.toString(i+1) + ". " + 
                                    sistema.getGranjas().get(i).getNombre());
                        }
                        System.out.println("0. Volver");
                        opcG = sc.nextInt();
                        System.out.println("----------------- ");
                        if (opcG < 0 || opcG > sistema.getGranjas().size()){
                            System.out.println("El numero que ingreso no es valido");
                        }
                        if (opcG == 0){
                            cicloG = false;
                        } else {
                            Farmer granja = sistema.getGranjas().get(opcG-1);
                            int opcG2;
                            boolean cicloG2 = true;
                            while (cicloG2){
                                System.out.println(granja.getNombre());
                                System.out.println("1. Ver Materia Prima");
                                System.out.println("2. Añadir Materia Prima");
                                System.out.println("0. Volver");
                                opcG2 = sc.nextInt();
                                System.out.println("----------------- ");
                                switch (opcG2){
                                    case 1:
                                        System.out.println("Materia prima: ");
                                        System.out.println(granja.getInfoMateriaPrima());
                                        break;
                                    case 2:
                                        none = sc.nextLine();
                                        System.out.println("Ingrese el nombre de la Materia Prima:");
                                        String nombreM = sc.nextLine();
                                        System.out.println("Ingrese la fecha en la que se consigio:");
                                        String fechaM = sc.nextLine();
                                        granja.addMateriaPrima(nombreM, fechaM);
                                        break;
                                    case 0:
                                        cicloG2 = false;
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    boolean cicloF = true;
                    int opcF;
                    while (cicloF){
                    System.out.println("Seleccione un Fabricante");
                        for (int i = 0; i < sistema.getFabricantes().size(); i++){
                            System.out.println(Integer.toString(i+1) + ". " + 
                                    sistema.getFabricantes().get(i).getNombre());
                        }
                        System.out.println("0. Volver");
                        opcF = sc.nextInt();
                        System.out.println("----------------- ");
                        if (opcF < 0 || opcF > sistema.getFabricantes().size()){
                            System.out.println("El numero que ingreso no es valido");
                        }
                        if (opcF == 0){
                            cicloF = false;
                        } else {
                            Manufacturer fabricante = sistema.getFabricantes().get(opcF-1);
                            int opcF2;
                            boolean cicloF2 = true;
                            while (cicloF2){
                                System.out.println(fabricante.getNombre());
                                System.out.println("1. Ver Productos");
                                System.out.println("2. Añadir Producto");
                                System.out.println("0. Volver");
                                opcF2 = sc.nextInt();
                                System.out.println("----------------- ");
                                switch (opcF2){
                                    case 1:
                                        System.out.println("Productos: ");
                                        System.out.println(fabricante.getInfoProductos());
                                        break;
                                    case 2:
                                        none = sc.nextLine();
                                        System.out.println("Ingrese el nombre del Producto:");
                                        String nombreP = sc.nextLine();
                                        System.out.println("Ingrese la fecha en la que se consigio:");
                                        String fechaP = sc.nextLine();         
                                        System.out.println("Ingrese el numero del lote del producto");
                                        int numeroLote = sc.nextInt();
                                        int opcF3;
                                        boolean cicloF3 = true;
                                        while (cicloF3){
                                            System.out.println("Seleccione una opcion: ");
                                            System.out.println("1. Añadir materia prima al producto");
                                            System.out.println("0. Terminar y añadir producto a la fabrica");
                                            opcF3 = sc.nextInt();
                                            System.out.println("----------------- ");
                                            if (opcF3 == 0){
                                                cicloF3 = false;
                                                continue;
                                            }
                                            
                                            int opcFG;
                                            boolean cicloFG = true;
                                            while (cicloFG){
                                                System.out.println("Seleccione una granja para comprar materia prima");
                                                for (int i = 0; i < sistema.getGranjas().size(); i++){
                                                    System.out.println(Integer.toString(i+1) + ". " + 
                                                            sistema.getGranjas().get(i).getNombre());
                                                }
                                                System.out.println("0. Volver");
                                                opcFG = sc.nextInt();
                                                System.out.println("----------------- ");
                                                if (opcFG < 0 || opcFG > sistema.getGranjas().size()){
                                                    System.out.println("El numero que ingreso no es valido");
                                                }
                                                if (opcFG == 0){
                                                    cicloFG = false;
                                                } else {
                                                    Farmer granja = sistema.getGranjas().get(opcFG-1);
                                                    System.out.println("La materia prima que puede comprar");
                                                    System.out.println(granja.getInfoMateriaPrima());
                                                    System.out.println("Escriba el nombre de la materia prima que quiere comprar");
                                                    none = sc.nextLine();
                                                    String nombreMP = sc.nextLine();
                                                    System.out.println("Escriba la cantidad que va a comprar");
                                                    int cantidadMP = sc.nextInt();
                                                    fabricante.comprar(granja, nombreMP, cantidadMP);
                                                }
                                            }
                                            
                                            fabricante.addProducto(nombreP, fechaP, numeroLote);
                                        }
                                        break;
                                    case 0:
                                        cicloF2 = false;
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 4:
                   boolean cicloD = true;
                    int opcD;
                    while (cicloD){
                    System.out.println("Seleccione un Distribuidor");
                        for (int i = 0; i < sistema.getDistribuidores().size(); i++){
                            System.out.println(Integer.toString(i+1) + ". " + 
                                    sistema.getDistribuidores().get(i).getNombre());
                        }
                        System.out.println("0. Volver");
                        opcD = sc.nextInt();
                        System.out.println("----------------- ");
                        if (opcD < 0 || opcD > sistema.getDistribuidores().size()){
                            System.out.println("El numero que ingreso no es valido");
                        }
                        if (opcD == 0){
                            cicloD = false;
                        } else {
                            DistributionCenter distribuidor = sistema.getDistribuidores().get(opcD-1);
                            int opcD2;
                            boolean cicloD2 = true;
                            while (cicloD2){
                                System.out.println(distribuidor.getNombre());
                                System.out.println("1. Ver Productos");
                                System.out.println("2. Añadir Producto");
                                System.out.println("0. Volver");
                                opcD2 = sc.nextInt();
                                System.out.println("----------------- ");
                                switch (opcD2){
                                    case 1:
                                        System.out.println("Productos: ");
                                        System.out.println(distribuidor.getInfoProductos());
                                        break;
                                    case 2:
                                        none = sc.nextLine();
                                        int opcD3;
                                        boolean cicloD3 = true;
                                        while (cicloD3){
                                            System.out.println("Seleccione una opcion: ");
                                            System.out.println("1. Comprar un producto de un fabricante");
                                            System.out.println("0. Terminar y añadir producto al distribuidor");
                                            opcD3 = sc.nextInt();
                                            System.out.println("----------------- ");
                                            if (opcD3 == 0){
                                                cicloD3 = false;
                                                continue;
                                            }
                                            
                                            int opcDF;
                                            boolean cicloDF = true;
                                            while (cicloDF){
                                                System.out.println("Seleccione un fabricante para comprar productos");
                                                for (int i = 0; i < sistema.getFabricantes().size(); i++){
                                                    System.out.println(Integer.toString(i+1) + ". " + 
                                                            sistema.getFabricantes().get(i).getNombre());
                                                }
                                                System.out.println("0. Volver");
                                                opcDF = sc.nextInt();
                                                System.out.println("----------------- ");
                                                if (opcDF < 0 || opcDF > sistema.getFabricantes().size()){
                                                    System.out.println("El numero que ingreso no es valido");
                                                }
                                                if (opcDF == 0){
                                                    cicloDF = false;
                                                } else {
                                                    Manufacturer fabricante = sistema.getFabricantes().get(opcDF-1);
                                                    System.out.println("Los objetos que puede comprar");
                                                    System.out.println(fabricante.getInfoProductos());
                                                    System.out.println("Escriba el nombre del producto");
                                                    none = sc.nextLine();
                                                    String nombreP = sc.nextLine();
                                                    System.out.println("Escriba la cantidad que va a comprar");
                                                    int cantidadP = sc.nextInt();
                                                    System.out.println("Escriba la fecha en la que lo compro.");
                                                    String fechaCompra = sc.nextLine();
                                                    distribuidor.comprar(fabricante, nombreP, cantidadP);
                                                    distribuidor.addProducto(nombreP, fechaCompra);
                                                }
                                            }
                                        }
                                        break;
                                    case 0:
                                        cicloD2 = false;
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    boolean cicloR = true;
                    int opcR;
                    while (cicloR){
                    System.out.println("Seleccione un Minorista");
                        for (int i = 0; i < sistema.getMinoristas().size(); i++){
                            System.out.println(Integer.toString(i+1) + ". " + 
                                    sistema.getMinoristas().get(i).getNombre());
                        }
                        System.out.println("0. Volver");
                        opcR = sc.nextInt();
                        System.out.println("----------------- ");
                        if (opcR < 0 || opcR > sistema.getMinoristas().size()){
                            System.out.println("El numero que ingreso no es valido");
                        }
                        if (opcR == 0){
                            cicloR = false;
                        } else {
                            Retail minorista = sistema.getMinoristas().get(opcR-1);
                            int opcR2;
                            boolean cicloR2 = true;
                            while (cicloR2){
                                System.out.println(minorista.getNombre());
                                System.out.println("1. Ver Productos");
                                System.out.println("2. Añadir Producto");
                                System.out.println("0. Volver");
                                opcR2 = sc.nextInt();
                                System.out.println("----------------- ");
                                switch (opcR2){
                                    case 1:
                                        System.out.println("Productos: ");
                                        System.out.println(minorista.getInfoProductosVenta());
                                        break;
                                    case 2:
                                        none = sc.nextLine();
                                        int opcR3;
                                        boolean cicloR3 = true;
                                        while (cicloR3){
                                            System.out.println("Seleccione una opcion: ");
                                            System.out.println("1. Comprar un producto a un distribuidor");
                                            System.out.println("0. Terminar y añadir producto al minorista");
                                            opcR3 = sc.nextInt();
                                            System.out.println("----------------- ");
                                            if (opcR3 == 0){
                                                cicloR3 = false;
                                                continue;
                                            }
                                            
                                            int opcRD;
                                            boolean cicloRD = true;
                                            while (cicloRD){
                                                System.out.println("Seleccione un distribuidor para comprar productos");
                                                for (int i = 0; i < sistema.getDistribuidores().size(); i++){
                                                    System.out.println(Integer.toString(i+1) + ". " + 
                                                            sistema.getDistribuidores().get(i).getNombre());
                                                }
                                                System.out.println("0. Volver");
                                                opcRD = sc.nextInt();
                                                System.out.println("----------------- ");
                                                if (opcRD < 0 || opcRD > sistema.getDistribuidores().size()){
                                                    System.out.println("El numero que ingreso no es valido");
                                                }
                                                if (opcRD == 0){
                                                    cicloRD = false;
                                                } else {
                                                    DistributionCenter distribuidor = sistema.getDistribuidores().get(opcRD-1);
                                                    System.out.println("Los objetos que puede comprar");
                                                    System.out.println(distribuidor.getInfoProductos());
                                                    System.out.println("Escriba el nombre del producto");
                                                    none = sc.nextLine();
                                                    String nombrePV = sc.nextLine();
                                                    System.out.println("Escriba la cantidad que va a comprar");
                                                    int cantidadPV = sc.nextInt();
                                                    minorista.comprar(distribuidor, nombrePV, cantidadPV);
                                                    System.out.println("Ingrese el precio del producto");
                                                    double precioP = Double.parseDouble(sc.nextLine());
                                                    System.out.println("Ingrese el codigo del producto");
                                                    String codigoP = sc.nextLine();
                                                    System.out.println("Ingrese la fecha en que compro el producto");
                                                    String fechaC = sc.nextLine();
                                                    minorista.addProducto(nombrePV, precioP, codigoP, fechaC);
                                                }
                                            }
                                        }
                                        break;
                                    case 0:
                                        cicloR2 = false;
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    int opcE1;
                    System.out.println("Seleccione que tipo de Eslabon desea crear:");
                    System.out.println("1. Granja");
                    System.out.println("2. Fabricante");
                    System.out.println("3. Distribuidor");
                    System.out.println("4. Minorista");
                    opcE1 = sc.nextInt();
                    none = sc.nextLine();
                    String tipoe = "";
                    switch (opcE1){
                        case 1:
                            tipoe = "Farmer";
                            break;
                        case 2:
                            tipoe = "Manufacturer";
                            break;
                        case 3:
                            tipoe = "DistributionCenter";
                            break;
                        case 4:
                            tipoe = "Retail";
                            break;
                    }
                    System.out.println("Ingrese el nombre del eslabon");
                    String eNombre = sc.nextLine();
                    System.out.println("Ingrese la descripcion");
                    String eDesc = sc.nextLine();
                    System.out.println("Ingrese la direccion");
                    String eDir = sc.nextLine();
                    sistema.addEslabon(tipoe, eNombre, eDesc, eDir);
                    break;
                case 7:
                    int opcE2;
                    System.out.println("Seleccione que tipo de eslabon desea eliminar");
                    System.out.println("1. Granja");
                    System.out.println("2. Fabricante");
                    System.out.println("3. Distribuidor");
                    System.out.println("4. Minorista");
                    opcE2 = sc.nextInt();
                    none = sc.nextLine();
                    String tipoe2 = "";
                    System.out.println("Seleccione cual eslabon desea eliminar");
                    int opcE22;
                    switch (opcE2){
                        case 1:
                            tipoe2 = "Farmer";
                            for (int i = 0; i < sistema.getGranjas().size(); i++){
                                System.out.println(Integer.toString(i+1) + ". " +
                                sistema.getGranjas().get(i).getNombre());
                            }
                            opcE22 = sc.nextInt();
                            if (opcE22 < 0 || opcE22 > sistema.getGranjas().size()){
                                System.out.println("Ingreso un dato no valido");
                                break;
                            }
                            sistema.deleteEslabon(tipoe2, sistema.getGranjas().get(opcE22-1).getNombre());
                            break;
                        case 2:
                            tipoe2 = "Manufacturer";
                            for (int i = 0; i < sistema.getFabricantes().size(); i++){
                                System.out.println(Integer.toString(i+1) + ". " +
                                sistema.getFabricantes().get(i).getNombre());
                            }
                            opcE22 = sc.nextInt();
                            if (opcE22 < 0 || opcE22 > sistema.getFabricantes().size()){
                                System.out.println("Ingreso un dato no valido");
                                break;
                            }
                            sistema.deleteEslabon(tipoe2, sistema.getFabricantes().get(opcE22-1).getNombre());
                            break;
                        case 3:
                            tipoe2 = "DistributionCenter";
                            for (int i = 0; i < sistema.getDistribuidores().size(); i++){
                                System.out.println(Integer.toString(i+1) + ". " +
                                sistema.getDistribuidores().get(i).getNombre());
                            }
                            opcE22 = sc.nextInt();
                            if (opcE22 < 0 || opcE22 > sistema.getDistribuidores().size()){
                                System.out.println("Ingreso un dato no valido");
                                break;
                            }
                            sistema.deleteEslabon(tipoe2, sistema.getDistribuidores().get(opcE22-1).getNombre());
                            break;
                        case 4:
                            tipoe2 = "Retail";
                            for (int i = 0; i < sistema.getMinoristas().size(); i++){
                                System.out.println(Integer.toString(i+1) + ". " +
                                sistema.getMinoristas().get(i).getNombre());
                            }
                            opcE22 = sc.nextInt();
                            if (opcE22 < 0 || opcE22 > sistema.getMinoristas().size()){
                                System.out.println("Ingreso un dato no valido");
                                break;
                            }
                            sistema.deleteEslabon(tipoe2, sistema.getMinoristas().get(opcE22-1).getNombre());
                            break;
                    }
                    break;
                case 8:
                    sistema.guardarTrazabilidad();
                    break;
                case 0:
                    ciclo = false;
                    break;
            }
            System.out.println("----------------- ");
        }
    }
    
}
