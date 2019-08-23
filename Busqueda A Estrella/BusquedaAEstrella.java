/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaaestrella;

/**
 *
 * @author Irving
 */
import java.util.Hashtable;
import java.util.LinkedList;

public class BusquedaAEstrella {

    /**
     * @param args the command line arguments
     */
    static final int opciones = 46;

    public static void main(String[] args) {

        Hashtable<String, Integer> distancia = new Hashtable<String, Integer>(); //para la matriz con distancia
        distancia.put("Arad", 366);
        distancia.put("Bucarest", 0);
        distancia.put("Craiova", 160);
        distancia.put("Dobreta", 242);
        distancia.put("Efoire", 161);
        distancia.put("Fagaras", 176);
        distancia.put("Giurgiu", 77);
        distancia.put("Hirsova", 151);
        distancia.put("Iasi", 226);
        distancia.put("Lugoj", 244);
        distancia.put("Mehadia", 241);
        distancia.put("Neamt", 234);
        distancia.put("Oradea", 380);
        distancia.put("Pitesti", 100);
        distancia.put("RimmicuVilcea", 193);
        distancia.put("Sibiu", 253);
        distancia.put("Timisoara", 329);
        distancia.put("Urziceni", 80);
        distancia.put("Vaslui", 199);
        distancia.put("Zerind", 374);

        NodosEstacion[] rutas = new NodosEstacion[opciones];

        rutas[0] = new NodosEstacion("Oradea", "Zerind", 71, 0);
        rutas[1] = new NodosEstacion("Oradea", "Sibiu", 151, 0);
        rutas[2] = new NodosEstacion("Zerind", "Oradea", 71, 0);
        rutas[3] = new NodosEstacion("Zerind", "Arad", 75, 0);
        rutas[4] = new NodosEstacion("Arad", "Zerind", 75, 0);
        rutas[5] = new NodosEstacion("Arad", "Sibiu", 140, 0);
        rutas[6] = new NodosEstacion("Arad", "Timisoara", 118, 0);
        rutas[7] = new NodosEstacion("Timisoara", "Arad", 118, 0);
        rutas[8] = new NodosEstacion("Timisoara", "Lugoj", 111, 0);
        rutas[9] = new NodosEstacion("Sibiu", "Oradea", 151, 0);
        rutas[10] = new NodosEstacion("Sibiu", "Arad", 140, 0);
        rutas[11] = new NodosEstacion("Sibiu", "Fagaras", 99, 0);
        rutas[12] = new NodosEstacion("Sibiu", "RimmicuVilcea", 80, 0);
        rutas[13] = new NodosEstacion("Fagaras", "Bucarest", 211, 0);
        rutas[14] = new NodosEstacion("Fagaras", "Sibiu", 99, 0);
        rutas[15] = new NodosEstacion("RimmicuVilcea", "Sibiu", 80, 0);
        rutas[16] = new NodosEstacion("RimmicuVilcea", "Pitesti", 97, 0);
        rutas[17] = new NodosEstacion("RimmicuVilcea", "Craiova", 146, 0);
        rutas[18] = new NodosEstacion("Pitesti", "Bucarest", 101, 0);
        rutas[19] = new NodosEstacion("Pitesti", "RimmicuVilcea", 97, 0);
        rutas[20] = new NodosEstacion("Pitesti", "Craiova", 138, 0);
        rutas[21] = new NodosEstacion("Craiova", "Pitesti", 138, 0);
        rutas[22] = new NodosEstacion("Craiova", "RimmicuVilcea", 146, 0);
        rutas[23] = new NodosEstacion("Craiova", "Dobreta", 120, 0);
        rutas[24] = new NodosEstacion("Lugoj", "Timisoara", 111, 0);
        rutas[25] = new NodosEstacion("Lugoj", "Mehadia", 70, 0);
        rutas[26] = new NodosEstacion("Mehadia", "Lugoj", 70, 0);
        rutas[27] = new NodosEstacion("Mehadia", "Dobreta", 75, 0);
        rutas[28] = new NodosEstacion("Dobreta", "Mehadia", 75, 0);
        rutas[29] = new NodosEstacion("Dobreta", "Craiova", 120, 0);
        rutas[30] = new NodosEstacion("Bucarest", "Urziceni", 85, 0);
        rutas[31] = new NodosEstacion("Bucarest", "Giurgiu", 90, 0);
        rutas[32] = new NodosEstacion("Bucarest", "Fagaras", 211, 0);
        rutas[33] = new NodosEstacion("Bucarest", "Pitesti", 101, 0);
        rutas[34] = new NodosEstacion("Giurgiu", "Bucarest", 90, 0);
        rutas[35] = new NodosEstacion("Urziceni", "Vaslui", 142, 0);
        rutas[36] = new NodosEstacion("Urziceni", "Hirsova", 98, 0);
        rutas[37] = new NodosEstacion("Urziceni", "Bucarest", 85, 0);
        rutas[38] = new NodosEstacion("Hirsova", "Eforie", 86, 0);
        rutas[39] = new NodosEstacion("Hirsova", "Urziceni", 98, 0);
        rutas[40] = new NodosEstacion("Eforie", "Hirsova", 86, 0);
        rutas[41] = new NodosEstacion("Vaslui", "Iasi", 92, 0);
        rutas[42] = new NodosEstacion("Vaslui", "Urziceni", 142, 0);
        rutas[43] = new NodosEstacion("Iasi", "Neamt", 87, 0);
        rutas[44] = new NodosEstacion("Iasi", "Vaslui", 92, 0);
        rutas[45] = new NodosEstacion("Neamt", "Iasi", 87, 0);

        LinkedList<NodosEstacion> visitados = new LinkedList<NodosEstacion>();
        String inicio = "Arad";
        String fin = "Bucarest";
        int nodoMenorCosto = 0;     //pasa saber que nodo tomar
        int auxTabla = 0;           //para el valor de la estacion en la tabla
        int distanciaAcumulada = 0; //almacenara la distancia del nodo
        int distanciaNodo = 0;
        NodosEstacion aux;
        String auxInicio = inicio;

        System.out.println("Estas empezando tu viaje en -> " + inicio);
        while (auxInicio != fin) {

            System.out.println("---------------------------------------");
            for (int i = 0; i < opciones; i++) {

                if (auxInicio == rutas[i].getpadre()) {//auxInicio==rutas[i].getpadre()
                    // visitados.add(rutas[i]);
                    auxTabla = distancia.get(rutas[i].gethijo()); //recupera el costo del padre en la tabla
                    distanciaNodo = rutas[i].getcosto();        //distancia del nodo

                    rutas[i].setcostoFn(auxTabla + distanciaNodo + distanciaAcumulada);  //suma del valor de la tabla y la distancia recorrida al momento                      
                    nodoMenorCosto = rutas[i].getcostoFn();              //costo que tiene en f(n)
                    //  aux=rutas[i];  
                    //System.out.println("Por ahora el menor costo es de = " + nodoMenorCosto);
                }
                if (visitados.size() == 0 && auxInicio == rutas[i].getpadre()) {
                    visitados.add(rutas[i]);
                    System.out.println("La primer ruta en " + rutas[i].getpadre() + " es " + rutas[i].gethijo() + " con costo de -> " + rutas[i].getcostoFn());
                    // aux = visitados.getFirst();
                }
                if (visitados.size() != 0) {
                    aux = visitados.getFirst();
                    if (nodoMenorCosto < aux.getcostoFn()) { //problema
                        visitados.addFirst(rutas[i]);
                        System.out.println("Encontre una ruta con MENOR COSTO " + rutas[i].getpadre() + " es la estacion " + rutas[i].gethijo() + " con costo de -> " + rutas[i].getcostoFn());
                    } else;
                }

            }

            nodoMenorCosto = 0; //empezamos con un nuevo Nodo
            aux = visitados.getFirst();
            auxInicio = aux.gethijo();
            System.out.println("La estacion con menor costo es " + auxInicio + " y costo de " + aux.getcostoFn());
            distanciaAcumulada = aux.getcosto() + distanciaAcumulada;
            System.out.println("La distancia acumulada es " + distanciaAcumulada);
            System.out.println("Tu mejor opcione es dirigirte a " + auxInicio);
            visitados.clear(); //limpiamos de nuevo los nodos
        }

        System.out.println("LLegaste a tu destino " + fin);

        //     System.out.println("Lo que tiene distancia.get(Oradea) es " + distancia.get("Oradea"));
    }

}
