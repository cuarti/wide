
package wide.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe que fa referencia a un usuari
 * @author cuarti
 */
@Entity
@Table(name="USERS")
public class User implements Follower, Following, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String name;
    @Column(unique=true)
    private String mail;
    private String password;
    private String description;
    @ManyToMany
    private List<Project> projects;
    private List<Following> followingList;
    private List<Follower> followersList;

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    /**
     * Constructor classe User.
     * Constructor buit.
     */
    public User() {
    }
    
    /**
     * Constructor de la classe User.
     * Constructor de creació de nous usuaris.
     * @param name
     * @param mail
     * @param password 
     */
    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    /**
     * Constructor de la classe User.
     * Constructor amb tots els atributs.
     * @param id
     * @param name
     * @param mail
     * @param password
     * @param description
     * @param projects
     * @param followingList
     * @param followersList 
     */
    public User(Long id, String name, String mail, String password, String description, 
            List<Project> projects, List<Following> followingList, List<Follower> followersList) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.description = description;
        this.projects = projects;
        this.followingList = followingList;
        this.followersList = followersList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Getters & Setters ">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    @Override
    public List<Following> getFollowingList() {
        return followingList;
    }

    @Override
    public void setFollowingList(List<Following> followingList) {
        this.followingList = followingList;
    }

    @Override
    public List<Follower> getFollowersList() {
        return followersList;
    }

    @Override
    public void setFollowersList(List<Follower> followersList) {
        this.followersList = followersList;
    }
    //</editor-fold>
    
    public boolean hasProject(Long id) {
        
        for(Project project : projects) {
            if(id == project.getId()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasProject(String title) {
        
        for(Project project : projects) {
            if(title.equals(project.getTitle())) {
                return true;
            }
        }
        return false;
    }
    
    public void addProject(Project project) {
        projects.add(project);
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + 
                password + ", description=" + description + ", projects=" + projects + 
                ", followingList=" + followingList + ", followersList=" + followersList + '}';
    }
    
}
