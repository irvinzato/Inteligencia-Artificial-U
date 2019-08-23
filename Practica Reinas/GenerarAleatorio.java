/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicareinas;

/**
 *
 * @author Irving
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GenerarAleatorio {
    //semilllas

    static final long M = (long) Math.pow(2, 31) - 1;
    static final double A = 314159269;
    static final double C = 453806245;
    static int n = 100;
    //imprimir en txt
    static File f;
    static FileWriter w;
    static BufferedWriter bw;
    static PrintWriter wr;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        f = new File("C:\\Users\\Pablo Alexis\\Desktop\\prueba3.txt");
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            long[] z = new long[1];
            z[0] = 1;
            double r;
            for (int i = 0; i <= 1000; i++) {

                r = Random01(z, wr, n);

                System.out.println(z[0]);
                wr.println("el valor de zn%m" + " " + r);
            }

            wr.close();

        } catch (IOException e) {
        }

        // TODO code application logic here
    }

    public static double Random01(long[] z, PrintWriter wr, int n) {
        //System.out.println(m);
        int a;
        double ale;
        wr.println("el valor de Zn es " + z[0]);

        double z1;
        z1 = (A * z[0]) + C;
        z1 = z1 % M;
        //System.out.println(z1);
        z[0] = (long) z1;
        //System.out.println(z[0]);
        ale = z1 / M;
        System.out.println(ale);
        a = (int) (ale * n);
        System.out.println(a);
        if (a == n) {
            a = n - 1;
        } else;
        return a;

    }

    public static int Random01h(long[] z, int n) {
        //System.out.println(m);
        int a;
        double ale;

        double z1;
        z1 = (A * z[0]) + C;
        z1 = z1 % M;
        //System.out.println(z1);
        z[0] = (long) z1;
        //System.out.println(z[0]);
        ale = z1 / M;
        // System.out.println(ale);
        a = (int) (ale * n);
        //System.out.println(a);
        if (a == n) {
            a = n - 1;
        } else;
        return a;

    }

}
