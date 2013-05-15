
package wide.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que fa referencia a un usuari
 * @author cuarti
 */
@Entity
@Table(name="USERS")
public class User implements Follower, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String name;
    @Column(unique=true)
    private String mail;
    private String password;
    private String picture;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @ManyToMany
    private List<Project> projects;
    private List<Following> following;

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
        createdDate = new Date();
        projects = new ArrayList<>();
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public List<Following> getFollowing() {
        return following;
    }

    @Override
    public void setFollowing(List<Following> following) {
        this.following = following;
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
    
    public Project getProjectByTitle(String title) {
        for(Project project : projects) {
            if(title.equals(project.getTitle())) {
                return project;
            }
        }
        return null;
    }
    
    public void addProject(Project project) {
        projects.add(project);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", mail=" + mail + 
                ", password=" + password + ", picture=" + picture + 
                ", description=" + description + ", createdDate=" + createdDate + 
                ", projects=" + projects + ", following=" + following + '}';
    }   
    
}
