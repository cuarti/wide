
package wide.model.files;

import java.io.File;
import wide.exceptions.files.NotNormalFileException;

/**
 * Classe que fa referencia a un fitxer.
 * @author cuarti
 */
public class FileMod extends File implements FileInterface {

    /**
     * Atribut que fa referencia al nom(sense extensio) del fitxer.
     */
    public String name;
    
    /**
     * Atribut que fa referencia a la extensio(sense el punt) del fitxer.
     */
    public String extension;

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Mètode constructor de la classe FileMod.
     * @param parent fa referencia a la ruta del fitxer pare.
     * @param child fa referencia al nom del fitxer.
     */
    public FileMod(String parent, String child) {
        super(parent, child);
    }

    /**
     * Mètode constructor de la classe FileMod.
     * @param parent fa referencia al fitxer pare.
     * @param child fa referencia al nom del fitxer.
     */
    public FileMod(File parent, String child) {
        super(parent, child);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters & Setters ">
    /**
     * Mètode accessor del atribut name.
     * @return retorna el nom sense extensió del fitxer.
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Mètode que retorna el nom d'un fitxer.
     * @param absoluteName fa referencia al nom complert del fitxer.
     * @return retorna el nom sense extensió del fitxer.
     */
    public String getName(String absoluteName) {
        
        int lastDot = absoluteName.lastIndexOf(".");
        
        if(lastDot == -1) {
            return absoluteName;
        }  
        return absoluteName.substring(0, lastDot);
    }

    /**
     * Mètode accessor del atribut extension.
     * @return retorna la extensió(sense el punt) del fitxer.
     */
    public String getExtension() {
        return extension;
    }
    
    /**
     * Mètode que retorna la extensió d'un fitxer.
     * @param absoluteName fa referencia al nom complert del fitxer.
     * @return retorna la extensió(sense el punt) del fitxer.
     */
    public String getExtension(String absoluteName) {
        
        int lastDot = absoluteName.lastIndexOf(".");
        
        if(lastDot == -1) {
            return null;
        }
        return absoluteName.substring(lastDot);
    }

    /**
     * Mètode que retorna el nom complert del fitxer.
     * @return retorna el nom complert del fitxer(nom + . + extensió).
     */
    public String getAbsoluteName() {
        
        if(extension == null || extension.equals("")) {
            return name;
        }
        return name + "." + extension;
    }
    
    /**
     * Mètode que retorna el nom complert del fitxer.
     * @param newName fa referencia al nou nom del fitxer.
     * @return retorna el nom complert del fitxer(nom + . + extensió).
     */
    public String getAbsoluteName(String newName) {
        
        if(extension == null || extension.equals("")) {
            return name;
        }
        return newName + "." + extension;
    }
    //</editor-fold>

    /**
     * Mètode que renombra un fitxer.
     * @param newName fa referencia al nou nom(sense extensio) del fitxer.
     * @throws NotFileTypeException si el fitxer no es un fitxer normal.
     */
    @Override
    public void renameTo(String newName) throws NotNormalFileException {
        if(!isFile()) throw new NotNormalFileException();
        super.renameTo(new File(getParent(), getAbsoluteName(newName)));
    }
    
    /**
     * Mètode que mou un fitxer.
     * @param newPath fa referencia a la nova ruta del fitxer.
     * @throws NotFileTypeException si el fitxer no es un fitxer normal.
     */
    @Override
    public void moveTo(String newPath) throws NotNormalFileException {
        if(!isFile()) throw new NotNormalFileException();
        super.renameTo(new File(newPath, getAbsoluteName()));
    }
}
