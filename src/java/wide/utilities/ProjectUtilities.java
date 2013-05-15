package wide.utilities;

import java.util.ArrayList;
import java.util.List;
import wide.model.Project;
import wide.model.User;

public class ProjectUtilities {

    private ProjectUtilities() {
    }

    public static ProjectUtilities newInstance() {
        return new ProjectUtilities();
    }

    public List<Project> getRelationalProjects(Project project) {
        
        List<Project> resultProjects = new ArrayList<>();
        
        List<User> users = project.getUsers();
        for(User user : users) {
            List<Project> projects = user.getProjects();
            for(Project p : projects) {
                if(!p.equals(project)) {
                    resultProjects.add(p);
                }
            }
        }
        return resultProjects;
    }

    public List<Project> getRandomProjects(List<Project> projects, int size) {

        List<Project> resultProjects = new ArrayList<>();

        int i = 0;
        int pos;
        int length = projects.size();
        while (i < size) {
            pos = (int) (Math.random() * length);
            Project project = projects.get(pos);
            if (project != null) {
                resultProjects.add(project);
                projects.remove(pos);
                i++;
            }
        }
        return resultProjects;
    }
}
