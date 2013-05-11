
package wide.utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import wide.exceptions.files.NotDirectoryFileException;
import wide.exceptions.files.NotExistingFileException;
import wide.model.files.Directory;
import wide.model.files.FileBuilder;

/**
 *
 * @author cuarti
 */
public class FilesUtilities {
    
    private static final String rootPath = "/home/cuarti/NetBeansProjects/wide/web/userFiles";
    private static final File rootFile = new File(rootPath);
    
    private static FileBuilder builder = FileBuilder.newInstance();
    
    private FilesUtilities() {
    }
    
    public static FilesUtilities newInstance() {
        return new FilesUtilities();
    }
    
    public File createProject(Long id) throws NotDirectoryFileException, 
            SecurityException, IOException {
        try { 
            return builder.createNewDirectory(rootFile, id.toString());  
        } catch (NotExistingFileException ex) { 
            rootFile.mkdir();
            createProject(id); 
        }        
        return null;
    }
    
    public File getProject(Long id) throws NotDirectoryFileException, 
            SecurityException, IOException {
        try {
            return builder.getDirectory(rootFile, id.toString());
        } catch (NotExistingFileException ex) {
            createProject(id);
        }
        return null;
    }
}
