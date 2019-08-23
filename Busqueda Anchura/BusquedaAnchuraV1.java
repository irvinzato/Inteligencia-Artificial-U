/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaanchurav1;

/**
 *
 * @author Irving
 */
import java.util.LinkedList;

public class BusquedaAnchuraV1 {

    static final int opciones = 37;

    public static void main(String[] args) {

        String inicio = "Constitucion"; //lugar donde estoy
        int numeroEstacion = 0;      // se debe colocar el numero del nodo donde esta la estacion inicial
        String fin = "Coyuya";       // lugar donde quiero llegar
        String aux;
        String padreAux;
        String result;
        aux = inicio;
        NodosEstacion[] rutas = new NodosEstacion[opciones];   //opciones que puedo tener en el traslado
        NodosEstacion auxiliarRuta;
        NodosEstacion auxiliarResult;
        LinkedList<NodosEstacion> visitados = new LinkedList<NodosEstacion>();
        LinkedList<String> rutaGuardada = new LinkedList<String>();

        //Rutas posibles de la linea del metro
        rutas[0] = new NodosEstacion("Constitucion", "", 1);
        rutas[1] = new NodosEstacion("Constitucion", "Uam", 1);
        rutas[2] = new NodosEstacion("Uam", "Constitucion", 1);
        rutas[3] = new NodosEstacion("Uam", "Cerro", 1);
        rutas[4] = new NodosEstacion("Cerro", "Uam", 1);
        rutas[5] = new NodosEstacion("Cerro", "Iztapalapa", 1);
        rutas[6] = new NodosEstacion("Iztapalapa", "Cerro", 1);
        rutas[7] = new NodosEstacion("Iztapalapa", "Atlalilco", 1);
        rutas[8] = new NodosEstacion("Atlalilco", "Iztapalapa", 1);
        rutas[9] = new NodosEstacion("Atlalilco", "Escuadron", 1);
        rutas[10] = new NodosEstacion("Escuadron", "Atlalilco", 1);
        rutas[11] = new NodosEstacion("Escuadron", "Aculco", 1);
        rutas[12] = new NodosEstacion("Aculco", "Escuadron", 1);
        rutas[13] = new NodosEstacion("Aculco", "Apatlaco", 1);
        rutas[14] = new NodosEstacion("Apatlaco", "Aculco", 1);
        rutas[15] = new NodosEstacion("Apatlaco", "Iztacalco", 1);
        rutas[16] = new NodosEstacion("Iztacalco", "Apatlaco", 1);
        rutas[17] = new NodosEstacion("Iztacalco", "Coyuya", 1);
        rutas[18] = new NodosEstacion("Coyuya", "Iztacalco", 1);
        rutas[19] = new NodosEstacion("Coyuya", "SantaAnita", 1);
        rutas[20] = new NodosEstacion("SantaAnita", "Coyuya", 1);
        rutas[21] = new NodosEstacion("SantaAnita", "LaViga", 1);
        rutas[22] = new NodosEstacion("LaViga", "SantaAnita", 1);
        rutas[23] = new NodosEstacion("LaViga", "Chabacano", 1);
        rutas[24] = new NodosEstacion("Chabacano", "LaViga", 1);
        rutas[25] = new NodosEstacion("Chabacano", "Obrera", 1);
        rutas[26] = new NodosEstacion("Obrera", "Chabacano", 1);
        rutas[27] = new NodosEstacion("Obrera", "Doctores", 1);
        rutas[28] = new NodosEstacion("Doctores", "Obrera", 1);
        rutas[29] = new NodosEstacion("Doctores", "SaltoDelAgua", 1);
        rutas[30] = new NodosEstacion("SaltoDelAgua", "Doctores", 1);
        rutas[31] = new NodosEstacion("SaltoDelAgua", "SanJuanDelLetran", 1);
        rutas[32] = new NodosEstacion("SanJuanDelLetran", "SaltoDelAgua", 1);
        rutas[33] = new NodosEstacion("SanJuanDelLetran", "BellasArtes", 1);
        rutas[34] = new NodosEstacion("BellasArtes", "SanJuanDelLetran", 1);
        rutas[35] = new NodosEstacion("BellasArtes", "Garibaldi", 1);
        rutas[36] = new NodosEstacion("Garibaldi", "BellasArtes", 1);

        // visitados.add(rutas[numeroEstacion]); //Se añade la primer opcion del metro
        //rutaGuardada.add(inicio);
        while (aux != fin) { //comprobacion de mi inicio y mi final
            // datos de la primer ruta en nuestra cola

            System.out.println("--------------------------------");
            for (int i = 0; i < opciones; i++) {  // comparamos todos los nodos
                if (aux == rutas[i].gethijo()) { // aremos el recorrido en anchura con este if y for
                    visitados.add(rutas[i]);
                    System.out.println("Añadi en la Lista -> " + rutas[i].getpadre() + " con hijo "
                            + rutas[i].gethijo());
                }
            }
            System.out.println("--------------------------------");
            if (revisarLista(aux, rutaGuardada)) { //guardara la mejor ruta
                rutaGuardada.add(aux);
                //auxiliarResult = rutaGuardada.getFirst();
                System.out.println("Guarde en la ruta: " + aux);
            } else;
            // System.out.println("LLevo almacenado en padre Aux -> " + padreAux);
            //  visitados.remove();
            auxiliarRuta = visitados.getFirst();
            aux = auxiliarRuta.getpadre();
            System.out.println("El aux es  " + aux);
            visitados.remove();

        }
        System.out.println("El tamaño de la lista visitados es " + visitados.size());
        System.out.println("El tamaño de la lista rutaGuardada es " + rutaGuardada.size());
        System.out.println("|||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||");
        System.out.println("La mejor ruta es:");
        for (String var : rutaGuardada) {
            System.out.println("--- " + var);
        }
        System.out.println("Y llegaste a tu destino: " + aux);
        System.out.println("|||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||");

    }

    public static boolean revisarLista(String aux, LinkedList<String> rutaGuardada) {
        for (String var : rutaGuardada) {
            if (var == aux) {  //revisa si rutaGuardada aun no almacena al padre de la ruta
                return false;
            } else;
        }
        return true;
    }
}
