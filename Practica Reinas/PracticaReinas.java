/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicareinas;

import java.util.LinkedList;

/**
 *
 * @author Irving
 */
public class PracticaReinas {

    static final int N = 4;
    static final int NumIteraciones = 100;
    static LinkedList<Cordenadas> repetidos = new LinkedList<Cordenadas>();

    public static void main(String[] args) {
        int i, j, c;
        int iteraciones = 0;
        int[][] tablero = new int[N][N];            //tablero con Reinas al azar
        int[][] tableroCosto = new int[N][N];       //tablero de costos

        SolInicial(tablero);
        llenarTableroCostos(tableroCosto);
        System.out.println("El tablero inicial es");
        imprimirTablero(tablero);
        c = funcionObjetivo(tablero);            //calcula los costos de choques entre reinas
        System.out.println("El costo de la solucion inicial es: " + c);

        //Soluciones_Vecinas(tablero, tableroCosto);
        while (c > 0 && iteraciones < NumIteraciones) {
            System.out.println("--------------------------------------");
            soluciones_vecinas_modif(tablero, tableroCosto);
            generar_Nueva_solucion(tablero, tableroCosto);
            c = funcionObjetivo(tablero);
            iteraciones++;
            System.out.println("--------------------------------------");
        }
        System.out.println("La solucion encontrada es la siguiente");
        imprimirTablero(tablero);
        System.out.println("Con un costo de --> " + c);

    }

    public static void SolInicial(int[][] tablero) {
        int i, j;
        long[] z = new long[1];
        z[0] = 2;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                tablero[i][j] = 0;
            }
        }
        GenerarAleatorio p;
        p = new GenerarAleatorio();
        for (i = 0; i < N; i++) {
            j = GenerarAleatorio.Random01h(z, N - 1);
            tablero[j][i] = 1;
        }

    }

    private static void imprimirTablero(int[][] tablero) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j]);
                System.out.print("  ");
            }

            System.out.println("");
        }
    }

    public static int funcionObjetivo(int[][] tablero) {
        int i, j, k;
        int costo = 0;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (tablero[j][i] == 1) {
                    for (k = 0; k < N; k++) {                //revisa si hay choques entre reinas en las horizontales 
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
        int k, i, j;

        for (k = 3; k < (2 * N - 1); k++) {
            aux = 0;
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
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
        int k, i, j;

        for (k = 1 - N; k < (N - 1); k++) {
            aux = 0;
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
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

    private static void llenarTableroCostos(int[][] tableroCosto) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tableroCosto[i][j] = 0;
            }
        }
    }

    private static void Soluciones_Vecinas(int[][] tablero, int[][] tableroCosto) {

        int columna = 0;                   //usada para poner las columnas en 0 del trablero original
        int costoAux;
        while (columna < N) {
            for (int baj = 0; baj < N; baj++) {
                tablero[baj][columna] = 0;
            }
            /* for (int i = 0; i < N; i++) {
              for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j]);
              }

            System.out.println("");
              }   */
            for (int p = 0; p < N; p++) {
                tablero[p][columna] = 1;                       //ponemos en 1 la primer posicion
                costoAux = funcionObjetivo(tablero);
                tableroCosto[p][columna] = costoAux;
                tablero[p][columna] = 0;                       //regresamos en 0 la posicion calculada para continuar con la siguiente
            }

            SolInicial(tablero);                               //volvemos a poner el tablero como estaba
            columna++;
        }

        System.out.println("El Tablero con costos es el siguiente");
        imprimirTablero(tableroCosto);

    }   //fin del metodo soluciones vecinas

    private static void generar_Nueva_solucion(int[][] tablero, int[][] tableroCosto) {
        int auxrepetidos = 0;
        int menor = 1000;
        int renglon = 0, columna = 0;
        long[] z = new long[1];
        z[0] = 2;
        int ale;
        Cordenadas auxCor;

        for (int i = 0; i < N; i++) {      //recorrido de la tablaCosto
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    menor = tableroCosto[i][j];
                } else if (menor > tableroCosto[i][j]) {   //actualizar el menor si aparece uno mas pequeño
                    menor = tableroCosto[i][j];
                    renglon = i;
                    columna = j;
                    auxrepetidos = 1;
                } else if (menor == tableroCosto[i][j]) {  //guardar coordenadas de los menores repetidos

                    repetidos.add(new Cordenadas(i, j));
                    auxrepetidos++;
                }

            }  //for j
        } //for i

        if (auxrepetidos == 1) {
            actualizarTablero(tablero, renglon, columna);
        } else {
            //GenerarAleatorio r;
            //r=new GenerarAleatorio();
            int numero1 = (int) (Math.random() * auxrepetidos + 1); //seleccion de numero aleatorio

            /*   ale=GenerarAleatorio.Random01h(z,auxrepetidos-1);
             renglon=repetidos.get(ale).getrenglon();
             columna=repetidos.get(ale).getcolumna();       */
            actualizarTablero(tablero, renglon, columna);
            System.out.println("Se ha repetido " + menor + " estas veces " + auxrepetidos);
        }
    }

    private static void actualizarTablero(int[][] tablero, int renglon, int columna) {

        for (int r = 0; r < N; r++) {
            if (renglon == r) {
                tablero[r][columna] = 1;
            } else {
                tablero[r][columna] = 0;
            }
        }
        System.out.println("El Tablero nuevo es el siguiente");
        imprimirTablero(tablero);
    }

    private static void soluciones_vecinas_modif(int[][] tablero, int[][] tableroCosto) {
        int columna = 0;                   //usada para poner las columnas en 0 del trablero original
        int costoAux;
        int auxrenglon = 0;
        int auxcolumna = 0;

        while (columna < N) {
            for (int x = 0; x < N; x++) {   //se recorre la columna para guardar la cordenada del 1 que tenga

                if (tablero[x][columna] == 1) {
                    auxrenglon = x;
                    auxcolumna = columna;
                }
            }
            for (int baj = 0; baj < N; baj++) {   //se coloca en 0 toda la columna
                tablero[baj][columna] = 0;
            }
            /* for (int i = 0; i < N; i++) {
              for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j]);
              }

            System.out.println("");
              }   */

            for (int p = 0; p < N; p++) {
                tablero[p][columna] = 1;                       //ponemos en 1 la primer posicion
                costoAux = funcionObjetivo(tablero);
                tableroCosto[p][columna] = costoAux;
                tablero[p][columna] = 0;                       //regresamos en 0 la posicion calculada para continuar con la siguiente
            }

            // SolInicial(tablero);                               //correcion del tablero
            tablero[auxrenglon][auxcolumna] = 1;        //regresar el 1 donde estaba
            columna++;
        }

        System.out.println("El Tablero con costos es el siguiente");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tableroCosto[i][j] + " ");
            }

            System.out.println("");
        }

    }   //fin del metodo soluciones vecinas
}
