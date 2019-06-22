
package ventana;

import javax.swing.JButton;

/**
 * @author Mayrene
 */
public class BotonMatriz extends JButton {
    private int fila;
    private int columna;

    public BotonMatriz(int row, int col) {
    this.fila = row;
    this.columna = col;
    }

    public int getFila() {
    return fila;
    }

    public int getColumna() {
    return columna;
    }
}
