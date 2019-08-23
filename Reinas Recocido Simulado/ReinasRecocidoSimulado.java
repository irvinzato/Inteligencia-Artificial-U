/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinasrecocidosimulado;

/**
 *
 * @author Irving
 */
public class ReinasRecocidoSimulado {

    static final int N = 6;
    static final int NumIteraciones = 200;
    static final double E = 2.7182818284590452354;

    public static void main(String[] args) {

        double temperaturaInicial = 5;
        double temperaturaFinal = 0.0001;
        double alfa = 0.9;
        int renglon, columna;
        int mejorCosto;
        int costoVecina;
        int costoOptimo;
        int iteraciones = 0;
        int[][] tablero = new int[N][N];            //tablero con Reinas al azar
        int[][] tableroCosto = new int[N][N];       //tablero de costos
        int[][] mejorTablero = new int[N][N];       //mejor solucion encontrada
        SolInicial(tablero);
        llenarTablero(tableroCosto);
        llenarTablero(mejorTablero);

        System.out.println("--------------------------------------");
        imprimirTablero(tablero);
        mejorCosto = funcionObjetivo(tablero);            //calcula los costos de choques entre reinas
        System.out.println("El costo de la solucion inicial es: " + mejorCosto);
        costoOptimo = mejorCosto;

        //Soluciones_Vecinas(tablero, tableroCosto);
        while (temperaturaInicial > temperaturaFinal) {   //condiciones de recocido simulado
            for (int i = 0; i < NumIteraciones; i++) {
                renglon = (int) (Math.random() * N); //seleccion de numero aleatorio entre 0 y N
                columna = (int) (Math.random() * N); //seleccion de numero aleatorio entre 0 y N
                //System.out.println("renglon= " + renglon + " columna= " +columna);
                generar_Vecino(renglon, columna, tablero);
                costoVecina = funcionObjetivo(tablero);            //calcula los costos de la solucion vecina
                //System.out.println("El costo de la solucion vecina es: " + costoVecina);
                if (costoVecina < costoOptimo) {
                    System.out.println("--------------------------------------");
                    System.out.println("Encontre un mejor tablero");
                    mejorSolucion(tablero, mejorTablero);
                    imprimirTablero(mejorTablero);
                    costoOptimo = costoVecina;
                    System.out.println("Tiene un costo de -> " + costoOptimo);
                }
                if (costoVecina < mejorCosto) {
                    mejorCosto = costoVecina;

                } else {//Metropolis
                    metropolis(mejorCosto, costoVecina, temperaturaInicial, renglon, columna, tablero);
                }

            }  //fin del for
            temperaturaInicial = alfa * temperaturaInicial;
        }  //fin del while

        System.out.println("--------------------------------------");
        System.out.println("La mejor solucion es la siguiente");
        imprimirTablero(mejorTablero);
        System.out.println("Con un costo de --> " + costoOptimo);
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

    private static void llenarTablero(int[][] tableroCosto) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tableroCosto[i][j] = 0;
            }
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

    private static void generar_Vecino(int renglon, int columna, int[][] tablero) {
        int auxRenglon = 0;
        int auxColumna = 0;
        for (int baj = 0; baj < N; baj++) {
            if (tablero[baj][columna] == 1) {    //recuperamos las cordenadas donde teniamos el 1
                auxRenglon = baj;
                auxColumna = columna;
                tablero[baj][columna] = 0;
            }
            tablero[baj][columna] = 0;
        }
        tablero[renglon][columna] = 1;        //ponemos el 1 en las celdas aleatorias
        /*   for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j]);
            }

            System.out.println(""); 
        }*/
    }

    private static void metropolis(int mejorCosto, int costoVecina, double temperaturaInicial, int renglon, int columna, int[][] tablero) {
        int aleatorio = (int) (Math.random() * 1);       //aleatorio entre 0 y 1
        double potencia = Math.pow(E, ((-costoVecina - mejorCosto) / temperaturaInicial));
        // System.out.println("El valor de potencia es: " + potencia);
        if (potencia > aleatorio) {
            mejorCosto = costoVecina;
        } else {  //quitar lo puesto y recuperar lo borrado
            for (int baj = 0; baj < N; baj++) {
                tablero[baj][columna] = 0;
            }
            tablero[renglon][columna] = 1;
        }
        // System.out.println("regrese al tablero que se tenia");
    }

    private static void mejorSolucion(int[][] tablero, int[][] mejorTablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mejorTablero[i][j] = tablero[i][j];
            }
        }
    }
}//fin de la clase
