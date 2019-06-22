
package ventana;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author Mayrene
 */
public class Principal {
    
    public static void main(String[] args) throws IOException {
        
        ManejarArchivos m = new ManejarArchivos();
        m.crearArchivo();
        
        Ventana v = new Ventana(); // Crear ventana. 
        v.setVisible(true); // Hacer visible la ventana. 
        boolean jugar = true; 
        v.jugar(); 
        /*while(jugar == true) {
            v.jugar();   
            
            int replay = JOptionPane.showConfirmDialog(null, "Desea jugar otra vez?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION); 
            if(replay == JOptionPane.YES_OPTION) {
                //JOptionPane.showMessageDialog(null, "HELLO");  
                v.reiniciarJuego(); 
            }
            else {  
                System.exit(0);
            }
        } */
    }    
}
