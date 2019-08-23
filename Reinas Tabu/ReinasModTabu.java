/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinasmodtabu;

/**
 *
 * @author Irving
 */
import java.util.LinkedList;

public class ReinasModTabu {

    static final int N = 5;
    static final int Tabu = 7;
    static final int NumIteraciones = 200;
    static LinkedList<Coordenadas> repetidos;

    public static void main(String[] args) {

        long[] z = new long[1];//arreglo donde se guardara la semilla y el numero aleatorio generado
        int mejorcosto;
        int costoactual;
        int auxTabu = 0;
        int iteraciones = 0;
        int[][] tablero = new int[N][N];
        int[][] tableroC = new int[N][N];
        int[][] tableroCostos = new int[N][N];
        int[][] movimientosA_B = new int[N][2];
        int[][] tabu = new int[Tabu][2];
        int mejor_Costo, aux = 0;
        int[][] mejortablero = new int[N][N];
        Inicializa_Tablero(tableroCostos);//tablero de costos con ceros
        SolInicial(tablero);//solucion inicial
        costoactual = funcionObjetivo(tablero);//costo actual del tablero
        mejor_Costo = costoactual;
        copia_Matriz(mejortablero, tablero);
        System.out.println("El costo inicial es " + costoactual);
        z[0] = 2;//valor a la semilla
        System.out.println("Matriz inicial");
        imprime_Matriz(tablero);

        //se generan las soluciones vecinas 
        while (costoactual > 0 && NumIteraciones > aux) {

            modficaA_B(tablero, movimientosA_B);     //para subir y bajar la reina en cada columna
            costoactual = modifica_tablero(tablero, movimientosA_B, tabu, auxTabu);
            aux++;
            if (costoactual < mejor_Costo) {
                mejor_Costo = costoactual;
                copia_Matriz(mejortablero, tablero);
                System.out.println("La mejor matriz es la siguiente");
                imprime_Matriz(mejortablero);
                System.out.println("Con un costo de " + mejor_Costo);
                System.out.println("---------------------------------");
            }
        }
        System.out.println("||||||||||||||||||||||||||||||||");
        System.out.println("La mejor matriz es la siguiente");
        imprime_Matriz(mejortablero);
        System.out.println("Con un costo de " + mejor_Costo);
        System.out.println("||||||||||||||||||||||||||||||||");
    }

    public static void SolInicial(int[][] tablero) {
        int j;
        long[] z = new long[1];
        z[0] = 2;
        Inicializa_Tablero(tablero);
        GenerarAleatorio p;
        p = new GenerarAleatorio();
        for (int i = 0; i < N; i++) {
            j = GenerarAleatorio.Random01h(z, N - 1);
            tablero[j][i] = 1;
        }
    }

    public static void Inicializa_Tablero(int[][] tablero) {
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

    private static void Soluciones_Vecinas(int[][] tableroC, int[][] tableroCostos, int c) {

        int auxr = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tableroC[j][i] == 0) {
                    for (int k = 0; k < N; k++) {
                        if (k == j) {
                            tableroC[k][i] = 1;
                        } else if (tableroC[k][i] == 1) {
                            auxr = k;
                            //System.out.println("renglon" + auxr);
                            tableroC[k][i] = 0;
                        } else {
                            tableroC[k][i] = 0;
                        }
                    }
                    tableroCostos[j][i] = funcionObjetivo(tableroC);
                    //System.out.println("el costo es "+ tableroCostos[j][i]);
                    tableroC[auxr][i] = 1;
                    tableroC[j][i] = 0;

                } else {
                    tableroCostos[j][i] = -1;
                }
            }
        }
    }

    static void imprime_Matriz(int[][] matriz) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + " " + " ");
            }
            System.out.println("");
        }
    }

    public static void generar_Nueva_sol(int[][] tableroCostos, int[][] tablero, long[] z) {
        repetidos = new LinkedList<>();
        int auxrep = 0, fila = 0, columna = 0, indice = 0;
        int auxmenor = 1000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0 && i == 0) {
                    auxmenor = tableroCostos[i][j];
                } else if (auxmenor > tableroCostos[i][j] && tableroCostos[i][j] != -1) {
                    auxmenor = tableroCostos[i][j];
                    fila = i;
                    columna = j;
                    auxrep = 1;
                    repetidos.clear();
                    Coordenadas aux = new Coordenadas(j, i);

                    repetidos.addFirst(aux);

                } else if (auxmenor == tableroCostos[i][j]) {
                    auxrep++;
                    Coordenadas aux = new Coordenadas(j, i);
                    repetidos.addFirst(aux);
                    // System.out.println(aux.columna+""+aux.fila);
                }
            }
        }

        if (auxrep == 1) {
            //System.out.println("la columna es "+ columna +""+"la fila  es"+fila);
            actualizartablero(tablero, columna, fila);
        } else {

            if (repetidos.size() == 2) {
                indice = (int) (Math.random() * repetidos.size());
            } else {
                indice = GenerarAleatorio.Random01h(z, auxrep - 1);
            }

            //System.out.println("el numero aleatorio es"+indice+"el valor de la semilla es "+z[0]);
            //System.out.println("el tamano de la lista es"+repetidos.size());
            Coordenadas aux;
            aux = repetidos.get(indice);
            columna = aux.getcolumna();
            fila = aux.getfila();
            // System.out.println("entrando al else con columna  "+ columna +""+"la fila  es"+fila);
            actualizartablero(tablero, columna, fila);
        }
        repetidos.clear();
        //imprime_Matriz(tablero);
    }

    private static void actualizartablero(int[][] tablero, int columna, int fila) {
        // System.out.println("el valor de la columna es "+ fila);
        for (int k = 0; k < N; k++) {
            if (fila == k) {
                tablero[k][columna] = 1;
            } else {
                tablero[k][columna] = 0;
            }
        }
    }

    private static void modficaA_B(int[][] tablero, int[][] movimientosA_B) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[j][i] == 1) {
                    if (j > 0 && j < N - 1) {
                        actualizartablero(tablero, i, j - 1);//cambiamos el uno hacia arriba
                        //imprime_Matriz(tablero);
                        movimientosA_B[i][0] = funcionObjetivo(tablero);//escribimos el costo el la matriz de movimentos hacia ariiba 
                        actualizartablero(tablero, i, j);//regresamos al tablero original
                        // imprime_Matriz(tablero);
                        actualizartablero(tablero, i, j + 1);//modificamos el tablero con el uno pero hacia arriba 
                        // imprime_Matriz(tablero);
                        movimientosA_B[i][1] = funcionObjetivo(tablero);//escribimos su costo en la matriz de movimientos hacia abajo 
                        actualizartablero(tablero, i, j);//regresamos a la matriz original
                        //imprime_Matriz(tablero);

                    } else if (j == 0) {
                        movimientosA_B[i][0] = 100000;
                        actualizartablero(tablero, i, j + 1);//modificamos el tablero con el uno pero hacia arriba 
                        // imprime_Matriz(tablero);
                        movimientosA_B[i][1] = funcionObjetivo(tablero);//escribimos su costo en la matriz de movimientos hacia abajo 
                        actualizartablero(tablero, i, j);
                        // imprime_Matriz(tablero);

                    } else {

                        actualizartablero(tablero, i, j - 1);//modificamos el tablero con el uno pero hacia arriba 
                        // imprime_Matriz(tablero);
                        movimientosA_B[i][0] = funcionObjetivo(tablero);//escribimos su costo en la matriz de movimientos hacia abajo 
                        actualizartablero(tablero, i, j);
                        // imprime_Matriz(tablero);
                        movimientosA_B[i][1] = 1000000;
                    }
                } else;
            }
        }
        System.out.println("---------------------------------");
        System.out.println("La matriz TABU es la siguiente ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(movimientosA_B[i][j]);
            }
            System.out.println(" ");
        }
    }

    private static int modifica_tablero(int[][] tablero, int[][] movimientosA_B, int[][] tabu, int auxtabu) {
        int[] movimiento = new int[3];  //para guardar el renglon, columna y costo del tablero
        revisamovientosA_B(movimiento, movimientosA_B);
        //System.out.println("Los movimientos son en renglon " +movimiento[0] + " y columna " + movimiento[1]);
        while (actualizarfila(tablero, movimiento, tabu, auxtabu, movimientosA_B) == false) {
            revisamovientosA_B(movimiento, movimientosA_B);
        }

        return movimiento[2];//regresamos el costo del tablero modificado 
    }

    private static void revisamovientosA_B(int[] movimiento, int[][] movimientosA_B) {
        int menor = 1000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 0 && j == 0) {
                    menor = movimientosA_B[i][j];
                    movimiento[0] = i;    //fila
                    movimiento[1] = j;    //el cero representa arriba y el uno abajo
                    movimiento[2] = menor;
                } else if (menor > movimientosA_B[i][j]) {
                    menor = movimientosA_B[i][j];
                    movimiento[0] = i;    //fila
                    movimiento[1] = j;
                    movimiento[2] = menor;
                } else ;
            }
        }
        System.out.println("El costo menor es " + menor);
    }

    private static boolean actualizarfila(int[][] tablero, int[] movimiento, int[][] tabu, int auxtabu, int[][] movimientosA_B) {
        int[] aux = new int[2];
        int auxrenglon = 0;
        for (int i = 0; i < N; i++) {
            if (tablero[i][movimiento[0]] == 1) {

                if (movimiento[1] == 0) {

                    auxrenglon = i - 1;
                } else {
                    auxrenglon = i + 1;
                }
                aux[0] = auxrenglon;//guardo el renglon
                aux[1] = movimiento[0];//guardo la columna
                if (revisa_Tabu(aux, tabu)) { //verifico que no esta en tabu
                    tablero[auxrenglon][movimiento[0]] = 1;//modificamos el tablero
                    if (auxtabu == Tabu) {
                        auxtabu = 0;
                    } else;
                    tabu[auxtabu][0] = movimiento[0];//guardo columna
                    tabu[auxtabu][1] = i;//guardo renglon
                    tablero[i][movimiento[0]] = 0;
                    auxtabu++;
                    return true;//regreso true

                } else {
                    System.out.println("Ya es TABU");
                    System.out.println(movimiento[1] + " " + movimiento[0]);
                    movimientosA_B[movimiento[0]][movimiento[1]] = 100000;
                    return false;//regreso false
                }
            }
        }
        return true;
    }

    private static boolean revisa_Tabu(int[] aux, int[][] tabu) {      //revisa la matriz tabu para ver si ya esta o no
        for (int i = 0; i < Tabu; i++) {
            if (tabu[i][0] == aux[1] && tabu[i][1] == aux[0]) {
                return false;
            } else;
        }
        return true;
    }

    private static void copia_Matriz(int[][] mejortablero, int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mejortablero[i][j] = tablero[i][j];
            }
        }
    }
}
