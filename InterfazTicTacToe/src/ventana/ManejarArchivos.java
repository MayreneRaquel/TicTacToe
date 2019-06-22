
package ventana;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 * @author Mayrene
 */
public class ManejarArchivos {
    
    public String[][] usuarios;
    public File archivo;
    public FileWriter baseDatos;
    public PrintWriter linea;
        
    /**
     * Constructor.
     */
    public ManejarArchivos() {
        usuarios = new String[10][10]; 
        archivo = new File("Base Datos");
    }
    
    public void crearArchivo() {        
        String nombreUsuario = "";
        if(!archivo.exists()) {
            try {
                archivo.createNewFile();
                nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
                baseDatos = new FileWriter(archivo, true);
                linea = new PrintWriter(baseDatos);
                
                // Escribir en el archivo
                linea.println(nombreUsuario);
                linea.close();
                baseDatos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } 
        else {
            try {
                nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
                baseDatos = new FileWriter(archivo, true);
                linea = new PrintWriter(baseDatos);
                
                // Escribir en el archivo
                linea.println(nombreUsuario);
                linea.close();
                baseDatos.close();
            }
            catch (IOException e) { 
                e.printStackTrace();
            }
        }
    }
}
