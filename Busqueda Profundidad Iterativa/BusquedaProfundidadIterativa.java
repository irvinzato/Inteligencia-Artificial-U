/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedaprofundidaditerativa;

/**
 *
 * @author Irving
 */
import java.util.LinkedList;

public class BusquedaProfundidadIterativa {

    /**
     * @param args the command line arguments
     */
    static final int opciones = 37;

    public static void main(String[] args) {
        String inicio = "Constitucion"; //lugar donde estoy
        String fin = "Escuadron";       // lugar donde quiero llegar
        int profundidad = -1;   // nos marcara el inicio de nuestra profundidad en el arbol
        boolean respuesta = false;
        NodosEstacion[] rutas = new NodosEstacion[opciones];   //opciones que puedo tener en el traslado
        NodosEstacion auxiliarRuta;
        NodosEstacion auxiliarResult;
        LinkedList<NodosEstacion> visitados = new LinkedList<NodosEstacion>();
        LinkedList<NodosEstacion> profmin = new LinkedList<NodosEstacion>();
        LinkedList<String> rutaGuardada = new LinkedList<String>();

        rutas[0] = new NodosEstacion("Constitucion", "Uam", 1, 0);
        rutas[1] = new NodosEstacion("Constitucion", "Uam", 1, 0);
        rutas[2] = new NodosEstacion("Uam", "Constitucion", 1, 0);
        rutas[3] = new NodosEstacion("Uam", "Cerro", 1, 0);
        rutas[4] = new NodosEstacion("Cerro", "Uam", 1, 0);
        rutas[5] = new NodosEstacion("Cerro", "Iztapalapa", 1, 0);
        rutas[6] = new NodosEstacion("Iztapalapa", "Cerro", 1, 0);
        rutas[7] = new NodosEstacion("Iztapalapa", "Atlalilco", 1, 0);
        rutas[8] = new NodosEstacion("Atlalilco", "Iztapalapa", 1, 0);
        rutas[9] = new NodosEstacion("Atlalilco", "Escuadron", 1, 0);
        rutas[10] = new NodosEstacion("Escuadron", "Atlalilco", 1, 0);
        rutas[11] = new NodosEstacion("Escuadron", "Aculco", 1, 0);
        rutas[12] = new NodosEstacion("Aculco", "Escuadron", 1, 0);
        rutas[13] = new NodosEstacion("Aculco", "Apatlaco", 1, 0);
        rutas[14] = new NodosEstacion("Apatlaco", "Aculco", 1, 0);
        rutas[15] = new NodosEstacion("Apatlaco", "Iztacalco", 1, 0);
        rutas[16] = new NodosEstacion("Iztacalco", "Apatlaco", 1, 0);
        rutas[17] = new NodosEstacion("Iztacalco", "Coyuya", 1, 0);
        rutas[18] = new NodosEstacion("Coyuya", "Iztacalco", 1, 0);
        rutas[19] = new NodosEstacion("Coyuya", "SantaAnita", 1, 0);
        rutas[20] = new NodosEstacion("SantaAnita", "Coyuya", 1, 0);
        rutas[21] = new NodosEstacion("SantaAnita", "LaViga", 1, 0);
        rutas[22] = new NodosEstacion("LaViga", "SantaAnita", 1, 0);
        rutas[23] = new NodosEstacion("LaViga", "Chabacano", 1, 0);
        rutas[24] = new NodosEstacion("Chabacano", "LaViga", 1, 0);
        rutas[25] = new NodosEstacion("Chabacano", "Obrera", 1, 0);
        rutas[26] = new NodosEstacion("Obrera", "Chabacano", 1, 0);
        rutas[27] = new NodosEstacion("Obrera", "Doctores", 1, 0);
        rutas[28] = new NodosEstacion("Doctores", "Obrera", 1, 0);
        rutas[29] = new NodosEstacion("Doctores", "SaltoDelAgua", 1, 0);
        rutas[30] = new NodosEstacion("SaltoDelAgua", "Doctores", 1, 0);
        rutas[31] = new NodosEstacion("SaltoDelAgua", "SanJuanDelLetran", 1, 0);
        rutas[32] = new NodosEstacion("SanJuanDelLetran", "SaltoDelAgua", 1, 0);
        rutas[33] = new NodosEstacion("SanJuanDelLetran", "BellasArtes", 1, 0);
        rutas[34] = new NodosEstacion("BellasArtes", "SanJuanDelLetran", 1, 0);
        rutas[35] = new NodosEstacion("BellasArtes", "Garibaldi", 1, 0);
        rutas[36] = new NodosEstacion("Garibaldi", "BellasArtes", 1, 0);

        do {
            profundidad = profundidad + 1; //aumentamos para la siguiente profundidad

            respuesta = BPI(inicio, fin, rutas, profundidad, visitados, profmin, rutaGuardada);

            System.out.println("-----------------------------------------------------");

        } while (respuesta != true);

        System.out.println("La ruta que necesitas tomar es:");
        for (String var : rutaGuardada) {
            System.out.println("--- " + var);
        }
        System.out.println("Y llegaste a tu destino: " + fin);

    }

    public static boolean BPI(String inicio, String fin, NodosEstacion[] rutas, int profundidad, LinkedList<NodosEstacion> visitados, LinkedList<NodosEstacion> profmin, LinkedList<String> rutaGuardada) {
        int nivel = 0; //siempre empezamos con un nivel en 0 
        String meta = "";
        meta = inicio;
        while (meta != fin) {
            //nivel=nivel+1;
            //System.out.println("Entre al while del metodo BPI");
            if (nivel < profundidad) {  //Si el nivel es mas chico seguimos expandiendo el arbol
                for (int i = 0; i < rutas.length; i++) {
                    if (meta == rutas[i].getpadre()) {
                        rutas[i].setnivel(nivel + 1); //modifica el nivel de la estacion
                        visitados.add(rutas[i]);  //añade en la lista las rutas
                        //System.out.println("El padre es: " +caminos[i].getpadre()+" Con hijo: " +caminos[i].gethijo());
                    }
                }
            } else if (visitados.size() == 0) {  //limpiamos todas las listas si no se encontro en este nivel el final
                visitados.clear();
                profmin.clear();
                return false;
            } else;
            NodosEstacion aux;
            aux = visitados.getLast();  //sacamos al ultimo de la lista
            if (revisar(aux.gethijo(), profmin)) {
                profmin.add(aux);
                System.out.println("EL padre es " + aux.getpadre() + " con hijo: " + aux.gethijo());
            } else;
            if (revisarLista(meta, rutaGuardada)) { //guardara la mejor ruta
                rutaGuardada.add(meta);
                //auxiliarResult = rutaGuardada.getFirst();
                //   System.out.println("Guarde en la ruta: " + meta);
            } else;
            meta = aux.gethijo();   //Ahora pasamos el hijo a una variable para seguir comparando
            nivel = aux.getnivel();
            visitados.remove(aux);
        }
        return true;
    }

    public static boolean revisar(String padre, LinkedList<NodosEstacion> profmin) {  //revisa que el padre no este en la segunda lista

        for (NodosEstacion pad : profmin) {
            if (pad.getpadre() == padre) {
                return false;
            }

        }
        return true;
    }

    public static boolean revisarLista(String meta, LinkedList<String> rutaGuardada) {
        for (String var : rutaGuardada) {
            if (var == meta) {  //revisa si rutaGuardada aun no almacena al padre de la ruta
                return false;
            } else;
        }
        return true;
    }

}
