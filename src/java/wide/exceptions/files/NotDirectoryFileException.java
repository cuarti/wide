
package wide.exceptions.files;

import java.io.File;
import java.io.IOException;

/**
 * Classe que representa una excepcio de no ser un directori.
 * @author cuarti
 */
public class NotDirectoryFileException extends NotFileTypeException {
    
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Constructor de la excepcio NotDirectoryFileException.
     * Es passa un missatge per defecte.
     */
    public NotDirectoryFileException() {
        super("The file is not a directory file.");
    }

    /**
     * Constructor de la excepcio NotDirectoryFileException.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotDirectoryFileException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepcio NotDirectoryFileException.
     * @param invalidFile fa referencia al fitxer que hauria de ser un directori pero no ho es.
     * @param message fa referencia al missatge de la excepcio.
     */
    public NotDirectoryFileException(File invalidFile, String message) {
        super(invalidFile, message);
    }

    /**
     * Constructor de la excepcio NotDirectoryFileException.
     * @param invalidFile fa referencia al fitxer que hauria de ser un directori pero no ho es.
     * @throws IOException si hi ha hagut una excepcio de lectura de la ruta del fitxer.
     */
    public NotDirectoryFileException(File invalidFile) throws IOException {
        super(invalidFile, "The file " + invalidFile.getCanonicalPath() + " is not a directory file.");
    }
    //</editor-fold>
    
}
