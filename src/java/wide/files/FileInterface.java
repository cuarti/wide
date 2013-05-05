
package wide.files;

import wide.files.exceptions.NotFileTypeException;

/**
 * Interficie que fa referencia a un fitxer(fitxer o carpeta)
 * Component del patro Composite
 * @author cuarti
 */
public interface FileInterface {
    
    /**
     * Mètode accessor del atribut name.
     * @return retorna el nom, sense extensio(si en te), del fitxer.
     */
    public String getName();
    
    /**
     * Mètode que renombra un fitxer.
     * @param newName fa referencia al nou nom(sense extensio) del fitxer.
     * @throws NotFileTypeException si el tipus de fitxer no es el requerit.
     */
    public void renameTo(String newName) throws NotFileTypeException;
    
    /**
     * Mètode que mou un fitxer.
     * @param newPath fa referencia a la nova ruta del fitxer.
     * @throws NotFileTypeException si el tipus de fitxer no es el requerit.
     */
    public void moveTo(String newPath) throws NotFileTypeException;
    
}
