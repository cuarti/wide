
package wide.database;

import java.util.List;
import wide.model.Project;
import wide.model.Tag;
import wide.model.User;

/**
 *
 * @author cuarti
 */
public interface ProjectService {
    
    public Project createProject(String title, User user);

    public void updateProject(Project project);
    
    public void removeProject(Long id);

    public Project findProjectById(Long id);

    public List<Project> findProjectsByTitle(String title);
    
    public List<Project> findProjectByTags(List<Tag> tags);

    public List<Project> findAllProjects();
    
}
