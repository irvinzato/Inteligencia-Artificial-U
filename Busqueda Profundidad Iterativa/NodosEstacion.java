/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaprofundidaditerativa;

/**
 *
 * @author Satellite
 */
public class NodosEstacion {
    
    String padre, hijo;
    int costo;
    int nivel;
    
    public NodosEstacion(String padre, String hijo, int costo, int nivel){
        
        this.padre = padre;
        this.hijo = hijo;
        this.costo = costo;
        this.nivel = nivel;
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
    
    public int getnivel(){
        return nivel;
    }
    
    public void setnivel(int nivel){
       this.nivel=nivel;
     }
    
}
