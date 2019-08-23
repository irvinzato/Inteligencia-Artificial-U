
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;
import java.lang.Thread;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Desfragmentacion extends JFrame implements ActionListener {

    private JButton[][] Casilla; // matriz q se mostrará
    private Object[][][] Tablero; // color,fila,columna

    private JButton JButton1; // desfragmentacion
    private JButton JButton2; // nueva desfragmentacion
    private JButton JButton3; // salir
    private JPanel PanelMatriz;
    private Color[] colores;
    Font fuente;
    LinkedList<Object[][][]> Lt;

    static Random r = new Random();
    JMenuBar menu;
    JMenu juego;
    private JMenuItem nueva_desf;
    private JMenuItem salir;
    private Color[] colores1;
    LinkedList<Object[][][]> resultado = new LinkedList<>();
    //private int [] coordenadas;

    int conty, contr, conto, contg, contb, contw;

    public int[][] coordenadas = new int[160][2];

    public void Cola_de_Coordenadas(int renglon, int columna) {
        for (int n = 0; n < 160; n++) {
            coordenadas[n][0] = renglon;
            coordenadas[n][1] = columna;
        }
    }

    public Desfragmentacion() {
        Tablero = new Object[2][15][30];
        colores1 = new Color[]{Color.YELLOW, Color.RED, Color.ORANGE, Color.GRAY, Color.BLUE, Color.WHITE};
        fuente = new Font("Courier New", Font.BOLD, 12);
        menu = new JMenuBar();
        juego = new JMenu("Juego");
        nueva_desf = new JMenuItem("Nueva Desfragmentación");
        salir = new JMenuItem("salir");
        Casilla = new JButton[15][30];
        PanelMatriz = new JPanel();
        JButton1 = new JButton("Descifrado");
        JButton2 = new JButton("Nueva Desfragmentacion");
        JButton3 = new JButton("Salir");
        Lt = new LinkedList<Object[][][]>();
        inicia_componentes();
    }

    public void inicia_componentes() {
        setLayout(null);
        // Inicializacion de menu
        setJMenuBar(menu);
        menu.add(juego);

        nueva_desf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eve) {

                inicia_Matriz();

                // TODO Auto-generated method stub
            }
        });
        juego.add(nueva_desf);

        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);

            }
        });
        juego.add(salir);

        JButton1.setFont(fuente);
        JButton1.addActionListener(this);

        JButton2.setFont(fuente);
        JButton2.addActionListener(this);

        JButton3.setFont(fuente);
        JButton3.addActionListener(this);

        JButton1.setBounds(10, 380, 150, 25);
        JButton2.setBounds(280, 380, 200, 25);
        JButton3.setBounds(600, 380, 150, 25);

        PanelMatriz.setFont(fuente);
        PanelMatriz.setBorder(BorderFactory.createTitledBorder("Desfragmentador de Disco"));
        PanelMatriz.setBounds(1, 1, 805, 355);
        PanelMatriz.setLayout(new GridLayout(15, 30));
        int rn;
        conty = 0;
        contr = 0;
        conto = 0;
        contg = 0;
        contb = 0;
        contw = 0;
        //Cola_de_Coordenadas obj;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                Casilla[i][j] = new JButton("");
                rn = r.nextInt() % 6;
                while (rn < 0) {
                    rn = r.nextInt() % 6;
                }
                System.out.println(rn);

                switch (rn) {
                    case 0:
                        Casilla[i][j].setText(String.valueOf(++conty));
                        Tablero[0][i][j] = conty;
                        break;
                    case 1:
                        Casilla[i][j].setText(String.valueOf(++contr));
                        Tablero[0][i][j] = contr;
                        break;
                    case 2:
                        Casilla[i][j].setText(String.valueOf(++conto));
                        Tablero[0][i][j] = conto;
                        break;
                    case 3:
                        Casilla[i][j].setText(String.valueOf(++contg));
                        Tablero[0][i][j] = contg;
                        break;
                    case 4:
                        Casilla[i][j].setText(String.valueOf(++contb));
                        Tablero[0][i][j] = contb;
                        break;
                    case 5:
                        ++contw;
                        Casilla[i][j].setText("");
                        break;
                }
                Color colors = colores1[rn];
                Tablero[1][i][j] = colors;
                //Cola_de_Coordenadas(i, j);

                Casilla[i][j].setBorder(new javax.swing.border.LineBorder(Color.CYAN));
                Casilla[i][j].addActionListener(this);
                Casilla[i][j].setFont(fuente);
                Casilla[i][j].setBackground(colors);
                PanelMatriz.add(Casilla[i][j]);
            }
        }
        PanelMatriz.updateUI();
        PanelMatriz.setVisible(true);
        getContentPane().add(PanelMatriz);
        getContentPane().add(JButton1);
        getContentPane().add(JButton2);
        getContentPane().add(JButton3);
        fuente = new Font("Courier New", Font.BOLD, 14);

        // contenedor.add(PanelMatriz, BorderLayout.CENTER);
        setSize(850, 500);
        setLocationRelativeTo(null);
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        nueva_desf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
    }

    public void inicia_Matriz() {
        int rn;
        conty = 0;
        contr = 0;
        conto = 0;
        contg = 0;
        contb = 0;
        contw = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                // Casilla[i][j] = new JButton("");
                rn = r.nextInt() % 6;
                while (rn < 0) {
                    rn = r.nextInt() % 6;
                }
                System.out.println(rn);

                switch (rn) {
                    case 0:
                        Casilla[i][j].setText(String.valueOf(++conty));
                        Tablero[0][i][j] = conty;
                        break;
                    case 1:
                        Casilla[i][j].setText(String.valueOf(++contr));
                        Tablero[0][i][j] = contr;
                        break;
                    case 2:
                        Casilla[i][j].setText(String.valueOf(++conto));
                        Tablero[0][i][j] = conto;
                        break;
                    case 3:
                        Casilla[i][j].setText(String.valueOf(++contg));
                        Tablero[0][i][j] = contg;
                        break;
                    case 4:
                        Casilla[i][j].setText(String.valueOf(++contb));
                        Tablero[0][i][j] = contb;
                        break;
                    case 5:
                        ++contw;
                        Casilla[i][j].setText("");
                        break;
                }
                Color colors = colores1[rn];
                Tablero[1][i][j] = colors;
                //Cola_de_Coordenadas(i, j); 

                Casilla[i][j].setBorder(new javax.swing.border.LineBorder(Color.CYAN));
                Casilla[i][j].addActionListener(this);
                Casilla[i][j].setFont(fuente);
                Casilla[i][j].setBackground(colors);
                // PanelMatriz.add(Casilla[i][j]);
            }
        }
        //System.out.println("Suma: " + (contb + contg + conto + contr + contw + conty));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == JButton1) {
            busqueda();
            int tamaño = Lt.size();
            int l = 0;
            while (l < tamaño) {
                desplegarTablero(Lt.get(l));
                l++;
            }
        }
        if (e.getSource() == JButton2) {
            inicia_Matriz();

        }
        if (e.getSource() == JButton3) {
            System.exit(0);

        }

    }

    public void busqueda() {

        int[] c = new int[6];
        c[0] = conty;
        c[1] = contr;
        c[2] = conto;
        c[3] = contg;
        c[4] = contb;
        c[5] = contw;

        int cont1 = 0, cont2 = 0;
        int i_Digito = 0;
        Object aux_C, aux_D;
        int aux_s1 = 0, r = 0;
        Object[][][] TB = new Object[2][15][30];
        // iniciamos los indices de la matriz en 0
        System.err.println("Desfragmentador");
        for (int i_Color = 0; i_Color < 5; i_Color++) {
            aux_s1 = c[r];
            System.out.println("Nuevo Color");
            do {
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 30; j++) {
                        if (colores1[i_Color] == Tablero[1][i][j]) {

                            //System.out.println("entro con el color" + colores1[i_Color]+" "+aux++); 
                            //"Encontro color " + Tablero[1][i][j].toString() + "En la posicion: " + i + " " + j);
                            if ((i_Digito + 1) == (int) Tablero[0][i][j]) {
                                i_Digito++;

                                System.out.println("Encontro digito " + Tablero[0][i][j].toString() + "En la posicion: " + i
                                        + " " + j);
                                aux_C = Tablero[1][cont1][cont2];
                                aux_D = Tablero[0][cont1][cont2];
                                Tablero[0][cont1][cont2] = Tablero[0][i][j];
                                Tablero[1][cont1][cont2] = Tablero[1][i][j];
                                Tablero[0][i][j] = aux_D;
                                Tablero[1][i][j] = aux_C;

                                for (int g = 0; g < 15; g++) {
                                    System.arraycopy(Tablero[0][g], 0, TB[0][g], 0, 30);
                                    System.arraycopy(Tablero[1][g], 0, TB[1][g], 0, 30);
                                }
                                Lt.add(TB);
                                if (cont2 == 29) {
                                    cont1++;
                                    cont2 = 0;
                                } else {
                                    cont2++;
                                }
                                aux_s1--;
                            }

                        }
                    }

                }
            } while (aux_s1 > 0);

            i_Digito = 0;
            aux_C = null;
            aux_D = null;
            r++;

        }

        /* for (int i = 0; i < 15; i++) {
                  
				for (int j = 0; j < 30; j++) {
                                    
                                  System.out.println( TB[0][i][j]+", "+TB[1][i][j]);
                                }
                               System.out.println("\n");
                                }*/
    }

    public void desplegarTablero(Object[][][] T_P) {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                //Syste0m.out.print(T_P[0][i][j] + " ");
                if ((Color) T_P[1][i][j] == Color.WHITE) {
                    Casilla[i][j].setText(String.valueOf(" "));
                    Casilla[i][j].setBackground((Color) T_P[1][i][j]);
                    Casilla[i][j].setForeground(Color.BLACK);

                } else {
                    Casilla[i][j].setText(String.valueOf(T_P[0][i][j]));
                    Casilla[i][j].setBackground((Color) T_P[1][i][j]);
                    Casilla[i][j].setForeground(Color.BLACK);
                }
            }
            //System.out.println("");
        }
    }

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Desfragmentacion().setVisible(true);
        });
    }

}
