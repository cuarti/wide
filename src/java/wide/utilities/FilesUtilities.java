
package wide.utilities;

import java.io.File;
import java.io.IOException;
import wide.exceptions.files.NotDirectoryFileException;
import wide.exceptions.files.NotExistingFileException;
import wide.model.Project;
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
    
    public File createProjectDirectory(Project project) throws NotDirectoryFileException, 
            SecurityException, IOException {
        try { 
            return builder.createNewDirectory(rootFile, project.getId().toString());  
        } catch (NotExistingFileException ex) { 
            rootFile.mkdir();
            createProjectDirectory(project); 
        }        
        return null;
    }
    
    public File getProjectDirectory(Project project) throws NotDirectoryFileException, 
            SecurityException, IOException {
        try {
            return builder.getDirectory(rootFile, project.getId().toString());
        } catch (NotExistingFileException ex) {
            createProjectDirectory(project);
        }
        return null;
    }

    public static String getRootPath() {
        return rootPath;
    }

    public static File getRootFile() {
        return rootFile;
    }  
}
