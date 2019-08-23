/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinashillclimbing;

import java.util.LinkedList;

/**
 *
 * @author Irving
 */
public class ReinasHillClimbing {

    static final int N = 10;
    static final int NumIteraciones = 200;
    static LinkedList<Coordenadas> repetidos;

    public static void main(String[] args) {

        long[] z = new long[1];                          //se guardara la semilla y el numero aleatorio generado
        //long TInicio, TFin, tiempo;                   //determinar el tiempo
        int c;
        int iteraciones = 0;
        int[][] tablero = new int[N][N];
        int[][] tableroSolucion = new int[N][N];
        int[][] tableroCostos = new int[N][N];

        InicializarTablero(tableroCostos);          //tablero de costos con ceros
        SolInicial(tablero);                        //solucion inicial
        tableroSolucion = tablero.clone();            //clonar el tablero inicial
        c = funcionObjetivo(tablero);
        z[0] = 2;                                     //valor de la semilla
        System.out.println("La matriz inicial es la siguiente:");
        imprimeTablero(tablero);

        //genero las soluciones vecinas 
        while (c > 0 && iteraciones < NumIteraciones) {
            // TInicio = System.currentTimeMillis();
            Soluciones_Vecinas(tableroSolucion, tableroCostos, c);
            generar_Nueva_sol(tableroCostos, tablero, z);
            //  TFin=System.currentTimeMillis();
            //  tiempo=TFin-TInicio;
            c = funcionObjetivo(tablero);
            iteraciones++;
            //  System.out.println( iteraciones + "\t"+ c );
        }
        System.out.println("La matriz de costo es la siguiente:");
        imprimeTablero(tableroCostos);
        System.out.println("La solucion obtenida para un tablero de " + N + "x" + N + " es la siguiente:");
        imprimeTablero(tableroSolucion);
        System.out.println("el costo es -> " + c);

    }

    public static void SolInicial(int[][] tablero) {
        int ale;
        long[] z = new long[1];
        z[0] = 2;
        InicializarTablero(tablero);
        GenerarAleatorio p;
        p = new GenerarAleatorio();
        for (int i = 0; i < N; i++) {
            ale = GenerarAleatorio.Random01h(z, N - 1);
            tablero[ale][i] = 1;
        }
    }

    public static void InicializarTablero(int[][] tablero) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public static int funcionObjetivo(int[][] tablero) {

        int costo = 0;
        //imprime_Matriz(tablero);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[j][i] == 1) {
                    for (int k = 0; k < N; k++) {
                        if (tablero[j][k] == 1 && k != i) {
                            costo++;
                        } else;
                    }
                }
            }
        }
        // System.out.println("costo en los renglones"+ costo);
        costo = costo + Diagonal_Izquierda(tablero);
        //System.out.println("costo en la diaginal izquierda"+ Diagonal_Izquierda(tablero));
        costo = costo + Diagonal_Derecha(tablero);
        // System.out.println("costo en la diagonal derecha"+Diagonal_Derecha(tablero));
        return costo;
    }

    private static int Diagonal_Izquierda(int[][] tablero) {
        int auxcosto = 0;
        int aux;
        int aux2 = 0;

        for (int k = 3; k < (2 * N - 1); k++) {
            aux = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i + j + 2) == k && tablero[i][j] == 1) {
                        if (aux2 > 0) {
                            aux++;
                        } else {
                            aux2 = 1;
                        }
                    }
                }
            }
            if (aux >= 1) {
                auxcosto = auxcosto + aux;
            } else;
            aux2 = 0;
        }
        return auxcosto * 2;
    }

    private static int Diagonal_Derecha(int[][] tablero) {

        int auxcosto = 0;
        int aux;
        int aux2 = 0;

        for (int k = 1 - N; k < (N - 1); k++) {
            aux = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i - j) == k && tablero[i][j] == 1) {
                        if (aux2 > 0) {
                            aux++;
                        } else {
                            aux2 = 1;
                        }
                    }
                }
            }
            if (aux >= 1) {
                auxcosto = auxcosto + aux;
            } else;
            aux2 = 0;
        }
        return auxcosto * 2;
    }

    private static void Soluciones_Vecinas(int[][] tableroSolucion, int[][] tableroCostos, int c) {

        int auxrenglon = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tableroSolucion[j][i] == 0) {
                    for (int k = 0; k < N; k++) {
                        if (k == j) {                                       //Colocamos un 1 en nueva posicion
                            tableroSolucion[k][i] = 1;
                        } else if (tableroSolucion[k][i] == 1) {           //Si hay un 1 ahora ponemos un 0 
                            auxrenglon = k;
                            tableroSolucion[k][i] = 0;
                        } else {
                            tableroSolucion[k][i] = 0;
                        }
                    }
                    tableroCostos[j][i] = funcionObjetivo(tableroSolucion);         //Evaluamos el uevo tablero para saber su costo
                    //System.out.println("el costo es "+ tableroCostos[j][i]);
                    tableroSolucion[auxrenglon][i] = 1;
                    tableroSolucion[j][i] = 0;

                } else {
                    tableroCostos[j][i] = -1;
                }
            }
        }
    }

    static void imprimeTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " " + " ");
            }
            System.out.println("");
        }
    }

    public static void generar_Nueva_sol(int[][] tableroCostos, int[][] tablero, long[] z) {

        repetidos = new LinkedList<>();
        int auxrep = 0, fila = 0, columna = 0, indice = 0;
        int auxmenor = 1000;
        for (int i = 0; i < N; i++) {                                       //Se revisa tola la tabla de costos para encontrar el costo mas pequeño
            for (int j = 0; j < N; j++) {
                if (j == 0 && i == 0) {
                    auxmenor = tableroCostos[i][j];                         //El primer costo sera el mas pequeño hasta que empiece a comparar
                } else if (auxmenor > tableroCostos[i][j] && tableroCostos[i][j] != -1) {       //Si es -1 ya encontro el costo mas chico
                    auxmenor = tableroCostos[i][j];
                    fila = i;
                    columna = j;
                    auxrep = 1;
                    repetidos.clear();
                    Coordenadas aux = new Coordenadas(j, i);                    //Se almacena la coordenada del unico valor menor
                    repetidos.addFirst(aux);
                } else if (auxmenor == tableroCostos[i][j]) {                //Si se repite el menor costo se almacenan todos los repetidos para elegir uno al azar
                    auxrep++;
                    Coordenadas aux = new Coordenadas(j, i);                 //Se guardan sus coordenadas
                    repetidos.addFirst(aux);
                }
            }
        }

        if (auxrep == 1) {                                                  //Cuando solo hubo un costo menor
            actualizartablero(tablero, columna, fila);
        } else {                                                            //Cuando hay mas de un menor costo repetidos
            if (repetidos.size() == 2) {
                indice = (int) (Math.random() * repetidos.size());
            } else {
                indice = GenerarAleatorio.Random01h(z, auxrep - 1);
            }
            Coordenadas aux;
            aux = repetidos.get(indice);
            columna = aux.getcolumna();
            fila = aux.getfila();
            actualizartablero(tablero, columna, fila);
        }
        repetidos.clear();
        //imprime_Matriz(tablero);
    }

    private static void actualizartablero(int[][] tablero, int columna, int fila) {
        int k;
        for (k = 0; k < N; k++) {
            if (fila == k) {
                tablero[k][columna] = 1;
            } else {
                tablero[k][columna] = 0;
            }
        }
    }
} //Fin de la clase
