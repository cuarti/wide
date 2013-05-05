
package wide.files.exceptions;

import java.io.File;
import java.io.IOException;

/**
 * Classe que representa una excepcio de no ser un fitxer normal.
 * @author cuarti
 */
public class NotNormalFileException extends NotFileTypeException {
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Constructor de la excepcio NotNormalFileException.
     * Es passa un missatge per defecte.
     */
    public NotNormalFileException() {
        super("The file is not a normal file.");
    }

    /**
     * Constructor de la excepcio NotNormalFileException.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotNormalFileException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepcio NotNormalFileException.
     * @param invalidFile fa referencia al fitxer que hauria de ser un fitxer normal pero no ho es.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotNormalFileException(File invalidFile, String message) {
        super(invalidFile, message);
    }

    /**
     * Constructor de la excepcio NotNormalFileException.
     * @param invalidFile fa referencia al fitxer que hauria de ser un fitxer normal pero no ho es.
     * @throws IOException si hi ha hagut una excepcio de lectura de la ruta del fitxer.
     */
    public NotNormalFileException(File invalidFile) throws IOException {
        super(invalidFile, "The file " + invalidFile.getCanonicalPath() + " is not a normal file.");
    }
    //</editor-fold>
    
}
