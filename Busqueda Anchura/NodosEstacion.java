/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaanchurav1;

/**
 *
 * @author Satellite
 */
public class NodosEstacion {
    
    String padre, hijo;
    int costo;
    
    public NodosEstacion(String padre, String hijo, int costo){
        
        this.padre = padre;
        this.hijo = hijo;
        this.costo = costo;
    
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
    
}
