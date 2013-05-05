
package wide.files.exceptions;

import java.io.File;
import java.io.IOException;

/**
 * Classe que representa una excepcio de no ser el tipus de fitxer requerit.
 * @author cuarti
 */
public class NotFileTypeException extends FileException {

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Constructor de la excepcio NotFileTypeException.
     * Es passa un missatge per defecte.
     */
    public NotFileTypeException() {
        super("The file is not the file type required.");
    }
    
    /**
     * Constructor de la excepcio NotFileTypeException.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotFileTypeException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepcio NotFileTypeException.
     * @param invalidFile fa referencia al fitxer de tipus no requerit.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotFileTypeException(File invalidFile, String message) {
        super(invalidFile, message);
    }

    /**
     * Constructor de la excepcio NotFileTypeException.
     * @param invalidFile fa referencia al fitxer de tipus no requerit.
     * @throws IOException si hi ha hagut una excepcio de lectura de la ruta del fitxer.
     */
    public NotFileTypeException(File invalidFile) throws IOException {
        super(invalidFile, "The file " + invalidFile.getCanonicalPath() + " is not the file type required.");
    }
    //</editor-fold>
}
