
package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * @author Mayrene
 */
public class Ventana extends JFrame{
    
    public JPanel panel;
    public JLabel etiqueta;
    public JButton botonReiniciar;
    public JLabel[][] mejoresJugadores;
    public int jugadores;
    public int MAX_JUGADORES = 10;
    public BotonMatriz[][] matriz;
    public int FILAS = 3;
    public int COLUMNAS = 3;
    public int[] coordenadasBoton;
    
    /**
     * Constructor.
     */
    public Ventana() {
        this.setSize(500, 700); // Tamano de la ventana.
        panel = new JPanel();
        panel.setSize(500, 700);
        coordenadasBoton = new int[2];
        this.setTitle("Tic Tac Toe"); // Titulo de la ventana. 
        this.setLocationRelativeTo(null); // Posicion de la ventana en el centro. 
        UIManager.getDefaults().put("Button.disabledText", Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
    }
    
    /**
     * Metodo para iniciar juego
     */
    public void jugar() {
        iniciarComponentes();
    }
    
    /**
     * Metodo que inicia los componentes del panel.
     */
    private void iniciarComponentes() {
        panel.setLayout(null); // Desactivar diseno del panel. 
        //panel.setBackground(Color.darkGray); 
        this.getContentPane().add(panel); // Agregar el panel a la ventana.
        
        ponerEtiqueta();
        ponerMatriz();
        ponerBotonReset();
        ponerRachas();
        
        panel.setVisible(true); 
        panel.repaint();
    }
    
    /**
     * Metodo para poner el titulo de Tic Tac Toe.
     */
    private void ponerEtiqueta() { 
        etiqueta = new JLabel("Tic Tac Toe");
        etiqueta.setBounds(85, 5, 300, 80);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLUE);
        etiqueta.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        panel.add(etiqueta); // Agregar etiqueta al panel.
    }
    
    private void getCoordenadasBoton(BotonMatriz boton) {
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coordenadasBoton[0] = ((BotonMatriz) e.getSource()).getFila(); 
                coordenadasBoton[1] = ((BotonMatriz) e.getSource()).getColumna();
                System.out.print(coordenadasBoton[0]);
                System.out.print(coordenadasBoton[1]);
            }
        };
        boton.addActionListener(oyente);
    }
    
    /**
     * Metodo para crear la matriz de botones y ponerlos en la ventana.
     */
    private void ponerMatriz() {
        int x = 120;
        int y = 80;
        matriz = new BotonMatriz[FILAS][COLUMNAS];
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = new BotonMatriz(i, j);
                ponerX(matriz[i][j]);
                getCoordenadasBoton(matriz[i][j]);
                matriz[i][j].setBounds(x, y, 80, 80); 
                panel.add(matriz[i][j]); 
                x += 80;
            } 
            y += 80;
            x = 120;
        }
    }
    
    /**
     * Metodo para la jugada del usuario.
     * @param b 
     */ 
    private void ponerX(BotonMatriz boton) {
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton.setEnabled(false);
                boton.setText("X");
                boton.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
            }
        };
        boton.addActionListener(oyente);
    }
    
    /**
     * Metodo para poner en la interfaz la jugada de la computadora.
     * @param x
     * @param y 
     */
    private void ponerO(int x, int y) {
        matriz[x][y].setEnabled(false);
        matriz[x][y].setText("O");
        matriz[x][y].setFont(new Font("Comic Sans MS", Font.BOLD, 50));
    }
    
    /**
     * Metodo para poner el boton de reiniciar en la ventana. 
     */ 
    private void ponerBotonReset() { 
        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setFont(new Font("Comic Sans MS", Font.BOLD, 15)); 
        botonReiniciar.setBounds(200, 350, 100, 50);
        panel.add(botonReiniciar);
        
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        };
        botonReiniciar.addActionListener(oyente);
    }
    
    /**
     * Metodo para reiniciar juego.
     */
    public void reiniciarJuego() {
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < COLUMNAS; j++) {
                matriz[i][j].setText(" ");
                matriz[i][j].setEnabled(true);
            }
        }
    }
    
    /**
     * Metodo para poner las rachas de los mejores jugadores en la ventana. 
     */
    private void ponerRachas() {
        JLabel e = new JLabel("Mejores jugadores:");
        e.setBounds(100, 400, 300, 80);
        e.setHorizontalAlignment(SwingConstants.CENTER);
        e.setFont(new Font("Kristen ITC", Font.BOLD, 12));
        panel.add(e); // Agregar etiqueta al panel.
        
        jugadores = 0;
        mejoresJugadores = new JLabel[MAX_JUGADORES][2];
    }
    
    /**
     * Metodo para mostrar mensaje de que el usuario ha ganado.
     */
    private void ganaUsuario() {
        JOptionPane.showMessageDialog(this, "El jugador ha ganado!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Metodo para mostrar mensaje de que la compu ha ganado. 
     */
    private void ganaCompu() {
        JOptionPane.showMessageDialog(this, "La computadora ha ganado!", "Ganador", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Metodo para mostrar mensaje de empate.
     */
    private void empate() {
        JOptionPane.showMessageDialog(this, "Hay empate!", "Ganador", JOptionPane.INFORMATION_MESSAGE); 
    }
}