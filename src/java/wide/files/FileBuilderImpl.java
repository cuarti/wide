package wide.files;

import java.io.File;
import java.io.IOException;
import wide.files.exceptions.NotDirectoryFileException;
import wide.files.exceptions.NotExistingFileException;
import wide.files.exceptions.NotNormalFileException;

public class FileBuilderImpl extends FileBuilder {

    /**
     * Mètode factoria per a la instanciació d'un fitxer existent.
     * @param parent fa refencia a la ruta del directori pare.
     * @param child fa referencia al nom del fitxer a obtenir.
     * @return retorna el fitxer obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotNormalFileException si el fitxer a obtenir existeix pero no es un fitxer normal.
     * @throws SecurityException si el fitxer a obtenir no te privilegis d'escriptura o de lectura.
     */
    @Override
    public File getFile(String parent, String child)
            throws NotExistingFileException, NotNormalFileException, SecurityException {

        return getFile(new File(parent), child);
    }

    /**
     * Mètode factoria per a la instanciació d'un fitxer existent.
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori a obtenir.
     * @return retorna el fitxer obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotNormalFileException si el fitxer a obtenir existeix pero no es un fitxer normal.
     * @throws SecurityException si el fitxer a obtenir no te privilegis d'escriptrua o de lectura.
     */
    @Override
    public File getFile(File parent, String child)
            throws NotExistingFileException, NotNormalFileException, SecurityException {

        FileMod file = new FileMod(parent, child);

        if (!file.exists()) {
            try {
                throw new NotExistingFileException(file);
            } catch (IOException ex) {
                throw new NotExistingFileException();
            }
        }

        if (!file.isFile()) {
            try {
                throw new NotNormalFileException(file);
            } catch (IOException ex) {
                throw new NotNormalFileException();
            }
        }

        if (!file.canRead() || !file.canWrite()) {
            throw new SecurityException();
        }

        return file;

    }

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
    @Override
    public File createNewFile(String parent, String child)
            throws NotExistingFileException, NotDirectoryFileException,
            SecurityException, IOException {

        return createNewFile(new File(parent), child);
    }

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
    @Override
    public File createNewFile(File parent, String child)
            throws NotExistingFileException, NotDirectoryFileException,
            SecurityException, IOException {

        if (!parent.exists()) {
            try {
                throw new NotExistingFileException(parent);
            } catch (IOException ex) {
                throw new NotExistingFileException();
            }
        }

        if (!parent.isDirectory()) {
            try {
                throw new NotDirectoryFileException(parent);
            } catch (IOException ex) {
                throw new NotDirectoryFileException();
            }
        }

        if (!parent.canRead() || !parent.canWrite()) {
            throw new SecurityException();
        }

        FileMod file = new FileMod(parent, child);

        file.createNewFile();

        return file;
    }

    /**
     * Mètode factoria per a la instanciació d'un directori existent.
     *
     * @param parent fa referencia a la ruta del directori pare.
     * @param child fa referencia al nom del directori a obtenir.
     * @return retorna el directori obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotDirectoryFileException si el fitxer a obtenir existeix pero no
     * es un directori.
     * @throws SecurityException si el fitxer a obtenir no te privilegis
     * d'escriptura o de lectura.
     */
    @Override
    public File getDirectory(String parent, String child)
            throws NotExistingFileException, NotDirectoryFileException, SecurityException {

        return getDirectory(new File(parent), child);
    }

    /**
     * Mètode factoria per a la instanciació d'un directori existent.
     *
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori a obtenir.
     * @return retorna el directori obtingut.
     * @throws NotExistingFileException si el fitxer a obtenir no existeix.
     * @throws NotDirectoryFileException si el fitxer a obtenir existeix pero no
     * es un directori.
     * @throws SecurityException si el fitxer a obtenir no te privilegis
     * d'escriptura o de lectura.
     */
    @Override
    public File getDirectory(File parent, String child)
            throws NotExistingFileException, NotDirectoryFileException, SecurityException {

        Directory directory = new Directory(parent, child);

        if (!directory.exists()) {
            try {
                throw new NotExistingFileException(directory);
            } catch (IOException ex) {
                throw new NotExistingFileException();
            }
        }

        if (!directory.isDirectory()) {
            try {
                throw new NotDirectoryFileException(directory);
            } catch (IOException ex) {
                throw new NotDirectoryFileException();
            }
        }

        if (!directory.canRead() || !directory.canWrite()) {
            throw new SecurityException();
        }

        return directory;
    }

    /**
     * Mètode factoria per a la instanciació i creació d'un nou directori.
     *
     * @param parent fa referencia a la ruta del directori pare.
     * @param child fa referencia al nom del directori a crear.
     * @return retorna el directori creat.
     * @throws NotExistingFileException si el fitxer pare no existeix.
     * @throws NotDirectoryFileException si el fitxer pare existeix pero no es
     * un directori.
     * @throws SecurityException si el fitxer pare no te privilegis d'escriptura
     * o de lectura.
     * @throws IOException si hi ha hagut una excepcio de lectura/escriptura al
     * crear el fitxer.
     */
    @Override
    public File createNewDirectory(String parent, String child)
            throws NotExistingFileException, NotDirectoryFileException,
            SecurityException, IOException {

        return createNewDirectory(new File(parent), child);
    }

    /**
     * Mètode factoria per a la instanciació i creació d'un nou directori.
     *
     * @param parent fa referencia al directori pare.
     * @param child fa referencia al nom del directori a crear.
     * @return retorna el directori creat.
     * @throws NotExistingFileException si el fitxer pare no existeix.
     * @throws NotDirectoryFileException si el fitxer pare existeix pero no es
     * un directori.
     * @throws SecurityException si el fitxer pare no te privilegis d'escriptura
     * o de lectura.
     * @throws IOException si hi ha hagut una excepcio de lectura/escriptura al
     * crear el fitxer.
     */
    @Override
    public File createNewDirectory(File parent, String child)
            throws NotExistingFileException, NotDirectoryFileException,
            SecurityException, IOException {

        if (!parent.exists()) {
            try {
                throw new NotExistingFileException(parent);
            } catch (IOException ex) {
                throw new NotExistingFileException();
            }
        }

        if (!parent.isDirectory()) {
            try {
                throw new NotDirectoryFileException(parent);
            } catch (IOException ex) {
                throw new NotDirectoryFileException();
            }
        }

        if (!parent.canRead() || !parent.canWrite()) {
            throw new SecurityException();
        }

        Directory directory = new Directory(parent, child);

        directory.mkdir();

        return directory;
    }
}
