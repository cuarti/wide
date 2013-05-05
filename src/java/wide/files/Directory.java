
package wide.files;

import wide.files.exceptions.NotDirectoryFileException;
import java.io.File;

/**
 * Classe que fa referencia a un directori.
 * @author cuarti
 */
public class Directory extends File implements FileInterface{

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Mètode constructor de la classe Directory.
     * @param parent fa referencia a la ruta del directori pare.
     * @param child fa referencia al nom del directori.
     */
    public Directory(String parent, String child) {
        super(parent, child);
    }

    /**
     * Mètode constructor de la classe Directory.
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori.
     */
    public Directory(File parent, String child) {
        super(parent, child);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters & Setters ">
    /**
     * Mètode accessor del atribut name.
     * @return fa referencia al nom del directori.
     */
    @Override
    public String getName() {
        return super.getName();
    }
    //</editor-fold>

    /**
     * Mètode que renombra un direcotri.
     * @param newName fa referencia al nou nom del directori.
     * @throws NotFileTypeException si el fitxer no es un directori.
     */
    @Override
    public void renameTo(String newName) throws NotDirectoryFileException {
        if(!isDirectory()) throw new NotDirectoryFileException();
        super.renameTo(new File(getParent(), newName));
    }

    /**
     * Mètode que mou un directori.
     * @param newPath fa referencia a la nova ruta del fitxer.
     * @throws NotFileTypeException si el fitxer no es un directori.
     */
    @Override
    public void moveTo(String newPath) throws NotDirectoryFileException {
        if(!isDirectory()) throw new NotDirectoryFileException();
        super.renameTo(new File(newPath, getName()));
    }
    
}
