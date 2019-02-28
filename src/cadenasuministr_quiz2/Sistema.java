/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasuministr_quiz2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Sistema {
    private ArrayList<Farmer> granjas;
    private ArrayList<Manufacturer> fabricantes;
    private ArrayList<DistributionCenter> distribuidores;
    private ArrayList<Retail> minoristas;
    
    private File savefile;

    public Sistema(String pathfile) throws IOException {
        this.granjas = new ArrayList<>();
        this.fabricantes = new ArrayList<>();
        this.distribuidores = new ArrayList<>();
        this.minoristas = new ArrayList<>();
        
        savefile = new File(pathfile);
        if (!savefile.exists()){
            savefile.createNewFile();
        }
    }
    
    public void guardarTrazabilidad () throws FileNotFoundException {
        PrintStream out = new PrintStream(savefile);
        String savetext = "";
        for (Retail r : minoristas){
            for (ProductoVenta pv : r.getProductosVenta()){
                savetext += pv.getNombre() + ",";
                savetext += pv.getPrecio() + ",";
                savetext += pv.getCodigo() + ",";
                savetext += pv.getNumeroLote() + ",";
                savetext += pv.getProcedencia() + ",";
                savetext += pv.getFecha() + ",";
                savetext += pv.getMateriaPrima().size() + ",";
                for (MateriaPrima m : pv.getMateriaPrima()){
                    savetext += m.getNombre() + ",";
                    savetext += m.getFecha() + ",";
                    savetext += m.getProcedencia() + ",";
                }
            }
            savetext += "\r\n";
        }
        out.println(savetext);
    }
    
    public boolean addEslabon (String tipo, String nombreEsl, String desc, String dir){
        switch (tipo){
            case "Farmer":
                Farmer nuevaG = new Farmer(nombreEsl, desc, dir);
                return granjas.add(nuevaG);
            case "Manufacturer":
                Manufacturer nuevaM = new Manufacturer(nombreEsl, desc, dir);
                return fabricantes.add(nuevaM);
            case "DistributionCenter":
                DistributionCenter nuevoDC = new DistributionCenter(nombreEsl, desc, dir);
                return distribuidores.add(nuevoDC);
            case "Retail":
                Retail nuevoR = new Retail(nombreEsl, desc, dir);
                return minoristas.add(nuevoR);
            default:
                return false;
        }
    }
    
    public boolean deleteEslabon (String tipo, String nombreEsl){
        switch (tipo){
            case "Farmer":
                for (Farmer f : granjas){
                    if (f.getNombre().equals(nombreEsl)){
                        return granjas.remove(f);
                    }
                }
            case "Manufacturer":
                for (Manufacturer m : fabricantes){
                    if (m.getNombre().equals(nombreEsl)){
                        return fabricantes.remove(m);
                    }
                }
            case "DistributionCenter":
                for (DistributionCenter dc : distribuidores){
                    if (dc.getNombre().equals(nombreEsl)){
                        return distribuidores.remove(dc);
                    }
                }
            case "Retail":
                for (Retail r : minoristas){
                    if (r.getNombre().equals(nombreEsl)){
                        return minoristas.remove(r);
                    }
                }
            default:
                return false;
        }
    }

    public ArrayList<Farmer> getGranjas() {
        return granjas;
    }

    public ArrayList<Manufacturer> getFabricantes() {
        return fabricantes;
    }

    public ArrayList<DistributionCenter> getDistribuidores() {
        return distribuidores;
    }

    public ArrayList<Retail> getMinoristas() {
        return minoristas;
    }
    
    
}
