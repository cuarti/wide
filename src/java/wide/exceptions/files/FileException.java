
package wide.exceptions.files;

import java.io.File;
import java.io.IOException;

/**
 * Classe que representa una excepcio de fitxer.
 * @author cuarti
 */
public class FileException extends Exception {

    /**
     * Atribut que fa referencia al fitxer que ha provocat la excepcio.
     */
    private File invalidFile;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Constructor de la excepcio FileException.
     * Es passa un missatge per defecte.
     */
    public FileException() {
        super("There was a problem with the file.");
    }

    /**
     * Constructor de la excepcio FileException.
     * @param message fa referencia al missatge de la excepcio.
     */
    public FileException(String message) {
        super(message);
    }
    
    /**
     * Constructor de la excepcio FileException.
     * @param invalidFile fa referencia al fitxer que ha provocat la excepcio.
     * @param message fa referencia al missatge de la excepcio.
     */
    public FileException(File invalidFile, String message) {
        super(message);
        this.invalidFile = invalidFile;
    }
    
    /**
     * Constructor de la excepcio FileException.
     * @param invalidFile fa referencia al fitxer que ha provocat la excepcio.
     * @throws IOException si hi ha hagut una excepcio de lectura de la ruta del fitxer.
     */
    public FileException(File invalidFile) throws IOException {
        super("There was a problem with the file " + invalidFile.getCanonicalPath() + ".");
        this.invalidFile = invalidFile;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters & Setters ">
    /**
     * Mètode accessor del atribut invalidFile.
     * @return retorna el fitxer que ha provocat la excepcio.
     */
    public File getInvalidFile() {
        return invalidFile;
    }
    //</editor-fold>
    
}
