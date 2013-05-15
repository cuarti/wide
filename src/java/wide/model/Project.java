package wide.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import wide.model.files.Directory;

@Entity
public class Project implements Following, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description; //max size = 255 (by MySQL)
    private String logo; //nombre de la imagen. Posibilidad de usar un objeto Image
    @ManyToMany(mappedBy = "projects")
    private List<User> users;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    private Date lastModification;
    private List<String> images; //nombre de las imagenes. Posibilidad de usar un objeto Image
    private List<Tag> tags;
    private List<Follower> followers;

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Project() {
    }


    public Project(String title, User user) {
        this.title = title;
        users = new ArrayList<>();
        users.add(user);
        createdDate = new Date();
        lastModification = createdDate;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters & Setters ">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public List<Follower> getFollowers() {
        return followers;
    }

    @Override
    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    } 
    //</editor-fold>
    
    @Override
    public boolean equals(Object obj) {
        if (id == ((Project) obj).getId()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", title=" + title + 
                ", description=" + description +  ", logo=" + logo + 
                ", users=" + users + ", createdDate=" + createdDate + 
                ", lastModification=" + lastModification + ", images=" + images + 
                ", tags=" + tags + ", followers=" + followers + '}';
    }
}
