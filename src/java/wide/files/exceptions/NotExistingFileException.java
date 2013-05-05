
package wide.files.exceptions;

import java.io.File;
import java.io.IOException;

/**
 * Classe que representa una excepcio que el fitxer no existeix.
 * @author cuarti
 */
public class NotExistingFileException extends FileException {

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Constructor de la excepcio NotExistingFileException.
     * Es passa un missatge per defecte.
     */
    public NotExistingFileException() {
        super("The file doesn't exist.");
    }

    /**
     * Constructor de la excepcio NotExistingFileException.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotExistingFileException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepcio NotExistingFileException.
     * @param invalidFile fa referencia al fitxer no existent.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotExistingFileException(File invalidFile, String message) {
        super(invalidFile, message);
    }

    /**
     * Constructor de la excepcio NotExistingFileException.
     * @param invalidFile fa referencia al fitxer no existent.
     * @throws IOException si hi ha hagut una excepcio de lectura de la ruta del fitxer.
     */
    public NotExistingFileException(File invalidFile) throws IOException {
        super(invalidFile, "The file " + invalidFile.getCanonicalPath() + " doesn't exist.");
    }
    //</editor-fold>
}
