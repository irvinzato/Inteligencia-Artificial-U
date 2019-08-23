package sopa.de.letras;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sopa extends javax.swing.JFrame implements ActionListener {

    private long tiempoi;
    private long tiempof;
    private ArrayList<int[]> pila;
    String sopa[][];
    String clave[];
    JTextField sopa2[][];
    JPanel aux;
    private int columnas = 16;
    private int filas = 16;

    public Sopa() {
        this.columnas = 16;
        this.filas = 16;
        this.pila = new ArrayList();

        this.sopa = new String[][]{
            {"i", "j", "s", "i", "j", "a", "t", "a", "a", "d", "e", "u", "q", "s", "u", "b"},
            {"e", "k", "y", "c", "f", "s", "q", "c", "g", "b", "u", "w", "s", "ñ", "o", "p"},
            {"j", "i", "o", "g", "r", "n", "o", "i", "c", "a", "l", "u", "m", "i", "s", "r"},
            {"a", "a", "n", "w", "a", "e", "f", "g", "i", "e", "x", "i", "p", "h", "l", "o"},
            {"z", "b", "a", "t", "m", "k", "e", "o", "e", "e", "h", "i", "k", "d", "n", "l"},
            {"i", "n", "i", "o", "e", "p", "f", "l", "n", "u", "a", "p", "r", "a", "r", "o"},
            {"d", "a", "p", "ñ", "c", "l", "d", "l", "s", "k", "j", "a", "k", "t", "z", "g"},
            {"n", "r", "o", "b", "o", "t", "i", "c", "a", "a", "k", "e", "l", "a", "a", "w"},
            {"e", "v", "t", "l", "u", "p", "p", "g", "v", "c", "n", "r", "t", "r", "t", "m"},
            {"r", "k", "u", "r", "o", "a", "b", "a", "e", "v", "i", "a", "l", "i", "p", "o"},
            {"p", "m", "i", "n", "c", "r", "q", "d", "f", "n", "z", "t", "j", "i", "p", "e"},
            {"a", "n", "g", "m", "t", "e", "n", "y", "k", "s", "c", "j", "e", "f", "s", "x"},
            {"g", "d", "a", "d", "i", "n", "a", "m", "u", "h", "e", "i", "m", "n", "n", "p"},
            {"u", "n", "s", "b", "u", "z", "a", "s", "c", "i", "h", "p", "a", "r", "e", "y"},
            {"i", "p", "y", "o", "t", "n", "e", "i", "m", "a", "n", "o", "z", "a", "r", "g"},
            {"a", "c", "i", "t", "a", "m", "r", "o", "f", "n", "i", "o", "i", "b", "r", "t"}};

        this.clave = new String[]{"inteligencia", "pacman", "matrix", "aprendizaje", "juegos", "prolog", "simulacion",
            "skynet", "busqueda", "logica", "nexus", "deckard", "bioinformatica", "razonamiento",
            "genetica", "robotica", "turing", "jframe", "java", "humanidad", "lisp", "pong",
            "utopia", "atari"
        };

        initComponents();
        setLocationRelativeTo(null);
        setTitle("SOPA DE LETRAS");

        jPanel2.setLayout(new GridLayout(filas, columnas));

        this.sopa2 = new JTextField[filas][columnas];

        for (int i = 0; i < filas; i++) //llenado de la sopa
        {
            for (int j = 0; j < columnas; j++) {
                sopa2[i][j] = new JTextField(javax.swing.SwingConstants.CENTER);  //centra la letra
                sopa2[i][j].setBorder(new javax.swing.border.LineBorder(Color.DARK_GRAY, 1)); //color del borde
                sopa2[i][j].setFont(new java.awt.Font("Arial", Font.BOLD, 14));  //letra, tipo, tamaño
                sopa2[i][j].setText(sopa[i][j]);
                sopa2[i][j].setEnabled(false);
                jPanel2.add(sopa2[i][j]);
            }
        }
        boton.addActionListener((ActionListener) this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton) {

            //inteligencia
            //tiempoi=System.currentTimeMillis();
            //tiempof=System.currentTimeMillis();
            for (int i = 0; i < 12; i++) {
                sopa2[i + 2][i + 1].setBackground(Color.green);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //pacman
            for (int i = 0; i < 6; i++) {
                sopa2[8 + i][6 - i].setBackground(Color.GRAY);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //matrix
            for (int i = 0; i < 6; i++) {
                sopa2[8 - i][15 - i].setBackground(Color.CYAN);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //aprendizaje
            for (int i = 0; i < 11; i++) {
                sopa2[11 - i][0].setBackground(Color.GRAY);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //juegos
            for (int i = 0; i < 6; i++) {
                sopa2[6 - i][10 - i].setBackground(Color.GREEN);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //prolog
            for (int i = 0; i < 6; i++) {
                sopa2[1 + i][15].setBackground(Color.LIGHT_GRAY);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //simulacion
            for (int i = 0; i < 10; i++) {
                sopa2[2][14 - i].setBackground(Color.MAGENTA);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //skynet
            for (int i = 0; i < 6; i++) {
                sopa2[11][9 - i].setBackground(Color.ORANGE);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //busqueda
            for (int i = 0; i < 8; i++) {
                sopa2[0][15 - i].setBackground(Color.PINK);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //logica
            for (int i = 0; i < 6; i++) {
                sopa2[5 - i][7].setBackground(Color.RED);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //nexus
            for (int i = 0; i < 5; i++) {
                sopa2[5 - i][8 + i].setBackground(Color.YELLOW);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //deckard
            for (int i = 0; i < 7; i++) {
                sopa2[10 - i][7 + i].setBackground(Color.blue);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //bioinformatica
            for (int i = 0; i < 14; i++) {
                sopa2[15][13 - i].setBackground(Color.cyan);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //razonamiento
            for (int i = 0; i < 12; i++) {
                sopa2[14][14 - i].setBackground(Color.PINK);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //genetica
            for (int i = 0; i < 8; i++) {
                sopa2[14 - i][15 - i].setBackground(Color.gray);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //robotica
            for (int i = 0; i < 8; i++) {
                sopa2[7][1 + i].setBackground(Color.green);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //turing
            for (int i = 0; i < 6; i++) {
                sopa2[7 + i][5 - i].setBackground(Color.lightGray);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //jframe
            for (int i = 0; i < 6; i++) {
                sopa2[0 + i][4].setBackground(Color.magenta);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //java
            for (int i = 0; i < 4; i++) {
                sopa2[6 + i][10 - i].setBackground(Color.orange);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //humanidad
            for (int i = 0; i < 9; i++) {
                sopa2[12][9 - i].setBackground(Color.pink);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //lisp
            for (int i = 0; i < 4; i++) {
                sopa2[9 + i][12 + i].setBackground(Color.red);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //pong
            for (int i = 0; i < 4; i++) {
                sopa2[8 + i][5 - i].setBackground(Color.PINK);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //utopia
            for (int i = 0; i < 6; i++) {
                sopa2[9 - i][2].setBackground(Color.red);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");

            //atari
            for (int i = 0; i < 5; i++) {
                sopa2[5 + i][13].setBackground(Color.orange);
            }
            JOptionPane.showMessageDialog(jPanel1, "encontre palabra");
        }
    }

    public String buscar() {
//			if (pila.equals(palabra)) // Busca horizontalmente der  equals compara caracteres
//				return palabra + sopa2[] + sopa2[];

//			if (pila.equals(palabra)) // Buscar horizontalmente izq
//				return palabra + sopa2[] + sopa2[];
//			if (pila.equals(palabra)) // Buscar verticalmente abajo
//				return palabra + sopa2[] + sopa2[];
//			if (pila.equals(palabra)) // Buscar verticalmente arriba
//				return palabra + sopa2[] + sopa2[];
//			if (pila.equals(palabra)) 	// Buscar diagonal derecha arriba
//				return palabra + sopa2[] +  sopa2[];
//			if (pila.equals(palabra)) // Buscar diagonal izquierda arriba
//				return palabra + sopa2[] + sopa2[];
//			if (pila.equals(palabra)) // Buscar diagonal derecha abajo
//				return palabra + sopa2[]  + sopa2[];
//			if (pila.equals(palabra)) // Buscar diagonal izquierda abajo
//				return palabra + sopa2[] + sopa2[];
        return "";
    }

    public void almacenar(String palabra) {

        //   for(int i=0; i<filas; i++){
        //       for(int j=0; j<columnas; j++){
//           if(sopa2[i][j] == clave.charAt(0)){
        //         pila.add(sopa2[i][j]);
        //         }
        //     }
        //}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        boton = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numeros Clave");

        jLabel2.setText("Palabras");

        jLabel3.setText("inteligencia");

        jLabel4.setText("pacman");

        jLabel5.setText("matrix");

        jLabel6.setText("aprendizaje");

        jLabel7.setText("juegos");

        jLabel8.setText("prolog");

        jLabel9.setText("simulacion");

        jLabel10.setText("skynet");

        jLabel11.setText("busqueda");

        jLabel12.setText("logica");

        jLabel13.setText("Tiempo de Busqueda");

        jTextField1.setEditable(false);
        jTextField1.setText("                            ");
        jTextField1.setToolTipText("");

        jTextField2.setEditable(false);
        jTextField2.setText("                            ");
        jTextField2.setToolTipText("");

        jTextField3.setEditable(false);
        jTextField3.setText("                            ");
        jTextField3.setToolTipText("");

        jTextField4.setEditable(false);
        jTextField4.setText("                            ");
        jTextField4.setToolTipText("");

        jTextField5.setEditable(false);
        jTextField5.setText("                            ");
        jTextField5.setToolTipText("");

        jTextField6.setEditable(false);
        jTextField6.setText("                            ");
        jTextField6.setToolTipText("");

        jTextField7.setEditable(false);
        jTextField7.setText("                            ");
        jTextField7.setToolTipText("");

        jTextField8.setEditable(false);
        jTextField8.setText("                            ");
        jTextField8.setToolTipText("");

        jTextField9.setEditable(false);
        jTextField9.setText("                            ");
        jTextField9.setToolTipText("");

        jTextField10.setEditable(false);
        jTextField10.setText("                            ");
        jTextField10.setToolTipText("");

        jLabel14.setText("Palabras");

        jLabel15.setText("bioinformatica");

        jLabel16.setText("razonamiento");

        jLabel17.setText("genetica");

        jLabel18.setText("robotica");

        jLabel19.setText("turing");

        jLabel20.setText("jframe");

        jLabel21.setText("java");

        jLabel22.setText("humanidad");

        jLabel23.setText("lisp");

        jLabel24.setText("nexus");

        jLabel25.setText("deckard");

        jLabel26.setText("pong");

        jLabel27.setText("utopia");

        jLabel28.setText("atari");

        jTextField11.setEditable(false);
        jTextField11.setText("                            ");
        jTextField11.setToolTipText("");

        jTextField12.setEditable(false);
        jTextField12.setText("                            ");
        jTextField12.setToolTipText("");

        jLabel29.setText("Tiempo de Busqueda");

        jTextField13.setEditable(false);
        jTextField13.setText("                            ");
        jTextField13.setToolTipText("");

        jTextField14.setEditable(false);
        jTextField14.setText("                            ");
        jTextField14.setToolTipText("");

        jTextField15.setEditable(false);
        jTextField15.setText("                            ");
        jTextField15.setToolTipText("");

        jTextField16.setEditable(false);
        jTextField16.setText("                            ");
        jTextField16.setToolTipText("");

        jTextField17.setEditable(false);
        jTextField17.setText("                            ");
        jTextField17.setToolTipText("");

        jTextField18.setEditable(false);
        jTextField18.setText("                            ");
        jTextField18.setToolTipText("");

        jTextField19.setEditable(false);
        jTextField19.setText("                            ");
        jTextField19.setToolTipText("");

        jTextField20.setEditable(false);
        jTextField20.setText("                            ");
        jTextField20.setToolTipText("");

        jTextField21.setEditable(false);
        jTextField21.setText("                            ");
        jTextField21.setToolTipText("");

        jTextField22.setEditable(false);
        jTextField22.setText("                            ");
        jTextField22.setToolTipText("");

        jTextField23.setEditable(false);
        jTextField23.setText("                            ");
        jTextField23.setToolTipText("");

        jTextField24.setEditable(false);
        jTextField24.setText("                            ");
        jTextField24.setToolTipText("");

        jLabel30.setText("Tiempo total:");

        jTextField25.setEditable(false);
        jTextField25.setText("                            ");
        jTextField25.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel30)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        boton.setText("INICIAR EJECUCIÓN DEL PROGRAMA");

        jLabel31.setText("SOPA DE LETRAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sopa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

}
