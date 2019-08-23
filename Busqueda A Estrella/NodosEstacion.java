/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaaestrella;

/**
 *
 * @author Satellite
 */
public class NodosEstacion {
    String padre, hijo;
    int costo;
    int costoFn;
    
    public NodosEstacion(String padre, String hijo, int costo, int costoFn){
        
        this.padre = padre;
        this.hijo = hijo;
        this.costo = costo;
        this.costoFn = costoFn;
    }
    
    public String getpadre(){
        return padre;
    }
    
    public String gethijo(){
        return hijo;
    }
        
    public int getcosto(){
        return costo;
    }
    
    public int getcostoFn(){
        return costoFn;
    }
    
    public void setcostoFn(int costoFn){
       this.costoFn=costoFn;
     }
}
