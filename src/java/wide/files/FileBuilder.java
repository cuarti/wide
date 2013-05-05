
package wide.files;

import java.io.File;
import java.io.IOException;
import wide.files.exceptions.NotExistingFileException;
import wide.files.exceptions.NotDirectoryFileException;
import wide.files.exceptions.NotNormalFileException;

/**
 * Classe que fa referencia a un constructor de fitxers.
 * @author cuarti
 */
public abstract class FileBuilder {
    
    /**
     * Mètode factoria per a la instanciacio del objecte FileBuilder.
     * @return retorna un objecte FileBuilder.
     */
    public static FileBuilder newInstance() {
        return new FileBuilderImpl();
    }
    
    /**
     * Mètode factoria per a la instanciació d'un fitxer existent.
     * @param parent fa refencia a la ruta del directori pare.
     * @param child fa referencia al nom del fitxer a obtenir.
     * @return retorna el fitxer obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotNormalFileException si el fitxer a obtenir existeix pero no es un fitxer normal.
     * @throws SecurityException si el fitxer a obtenir no te privilegis d'escriptura o de lectura.
     */
    public abstract File getFile(String parent, String child)
            throws NotExistingFileException, NotNormalFileException, SecurityException;
    
    /**
     * Mètode factoria per a la instanciació d'un fitxer existent.
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori a obtenir.
     * @return retorna el fitxer obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotNormalFileException si el fitxer a obtenir existeix pero no es un fitxer normal.
     * @throws SecurityException si el fitxer a obtenir no te privilegis d'escriptrua o de lectura.
     */
    public abstract File getFile(File parent, String child)
            throws NotExistingFileException, NotNormalFileException, SecurityException;
    
    /**
     * Mètode factoria per a la instanciació i creació d'un nou fitxer.
     * @param parent fa referencia a la ruta del directori pare.
     * @param child fa referencia al nom del fitxer a crear.
     * @return retorna el fitxer creat.
     * @throws NotExistingFileException si el fitxer pare no existeix.
     * @throws NotDirectoryFileException si el fitxer pare existeix pero no es un directori.
     * @throws SecurityException si el fitxer pare no te privilegis d¡escriptura o de lectura.
     * @throws IOException si hi ha hagut una excepcio de lectura/escriptrua al crear el fitxer.
     */
    public abstract File createNewFile(String parent, String child)
            throws NotExistingFileException, NotDirectoryFileException,
            SecurityException, IOException;
    
    /**
     * Mètode factoria per a la instanciació i creació d'un nou fitxer.
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del fitxer a crear.
     * @return retorna el fitxer creat.
     * @throws NotExistingFileException si el fitxer pare no existeix.
     * @throws NotDirectoryFileException si el fitxer pare existeix pero no es un directori.
     * @throws SecurityException si el fitxer pare no te privilegis d¡escriptura o de lectura.
     * @throws IOException si hi ha hagut una excepcio de lectura/escriptrua al crear el fitxer.
     */
    public abstract File createNewFile(File parent, String child)
            throws NotExistingFileException, NotDirectoryFileException,
            SecurityException, IOException;

    /**
     * Mètode factoria per a la instanciació d'un directori existent.
     * @param parent fa referencia a la ruta del directori pare.
     * @param child fa referencia al nom del directori a obtenir.
     * @return retorna el directori obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotDirectoryFileException si el fitxer a obtenir existeix pero no es un directori.
     * @throws SecurityException si el fitxer a obtenir no te privilegis d'escriptura o de lectura.
     */
    public abstract File getDirectory(String parent, String child) 
            throws NotExistingFileException, NotDirectoryFileException, SecurityException;
    
    /**
     * Mètode factoria per a la instanciació d'un directori existent.
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori a obtenir.
     * @return retorna el directori obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotDirectoryFileException si el fitxer a obtenir existeix pero no es un directori.
     * @throws SecurityException si el fitxer a obtenir no te privilegis d'escriptura o de lectura.
     */
    public abstract File getDirectory(File parent, String child) 
            throws NotExistingFileException, NotDirectoryFileException, SecurityException;
      
    /**
     * Mètode factoria per a la instanciació i creació d'un nou directori.
     * @param parent fa referencia a la ruta del directori pare.
     * @param child fa referencia al nom del directori a crear.
     * @return retorna el directori creat.
     * @throws NotExistingFileException si el fitxer pare no existeix.
     * @throws NotDirectoryFileException si el fitxer pare existeix pero no es un directori.
     * @throws SecurityException si el fitxer pare no te privilegis d'escriptura o de lectura.
     * @throws IOException si hi ha hagut una excepcio de lectura/escriptura al crear el fitxer.
     */
    public abstract File createNewDirectory(String parent, String child)
            throws NotExistingFileException, NotDirectoryFileException, 
            SecurityException, IOException;
    
    /**
     * Mètode factoria per a la instanciació i creació d'un nou directori.
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori a crear.
     * @return retorna el directori creat.
     * @throws NotExistingFileException si el fitxer pare no existeix.
     * @throws NotDirectoryFileException si el fitxer pare existeix pero no es un directori.
     * @throws SecurityException si el fitxer pare no te privilegis d'escriptura o de lectura.
     * @throws IOException si hi ha hagut una excepcio de lectura/escriptura al crear el fitxer.
     */
    public abstract File createNewDirectory(File parent, String child) 
            throws NotExistingFileException, NotDirectoryFileException, 
            SecurityException, IOException;
    
}
