package wide.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import wide.model.Project;
import wide.model.Tag;
import wide.model.User;

/**
 *
 * @author cuarti
 */
public class ProjectServiceORM implements ProjectService {

    protected EntityManager em;

    public ProjectServiceORM(EntityManager em) {
        this.em = em;
    }

    @Override
    public Project createProject(String title, User user) {
        Project project = new Project(title, user);
        em.persist(project);
        return project;
    }
    
    @Override
    public Project updateProject(Project project) {
        em.persist(project);
        return project;
    }

    @Override
    public void removeProject(Long id) {
        Project project = findProjectById(id);
        if (project != null) {
            em.remove(project);
        }
    }

    @Override
    public Project findProjectById(Long id) {
        return em.find(Project.class, id);
    }

    /*No functiona*/
    @Override
    public Project findProjectByTitle(String title, String username) {
        try {
            TypedQuery<Project> query = em.createQuery("SELECT p from Project p " +
                    "WHERE p.title = ?1 AND p.user.name = ?2", Project.class);
            return query.setParameter(1, title).setParameter(2, username).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    /*Aun no implementado*/
    @Override
    public List<Project> findProjectByTags(List<Tag> tags) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Project> findAllProjects() {
        TypedQuery<Project> query = em.createQuery("SELECT p Project User p", Project.class);
        return query.getResultList();
    }
}
