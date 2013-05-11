
package wide.model;

import java.io.Serializable;
import java.util.ArrayList;
import wide.model.files.FileMod;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project implements Following, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToMany(mappedBy = "projects")
    private List<User> users;
    private List<FileMod> files;
    private List<String> images; //nombre de las imagenes. Posibilidad de usar un objeto Image
    private String description; //max size = 255 (by MySQL)
    private String logo; //nombre de la imagen. Posibilidad de usar un objeto Image
    private List<Tag> tags;
    private List<Follower> followersList;

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public Project() {
    }

    public Project(String title, User user) {
        this.title = title;
        
        users = new ArrayList<>();
        users.add(user);
    }
    
    public Project(String title, List<User> users, List<FileMod> files, List<String> images, 
            String description, String logo, List<Tag> tags, List<Follower> followersList) {
        this.title = title;
        this.users = users;
        this.files = files;
        this.images = images;
        this.description = description;
        this.logo = logo;
        this.tags = tags;
        this.followersList = followersList;
    }

    public Project(Long id, String title, List<User> users, List<FileMod> files, List<String> images, 
            String description, String logo, List<Tag> tags, List<Follower> followersList) {
        this.id = id;
        this.title = title;
        this.users = users;
        this.files = files;
        this.images = images;
        this.description = description;
        this.logo = logo;
        this.tags = tags;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<FileMod> getFiles() {
        return files;
    }

    public void setFiles(List<FileMod> files) {
        this.files = files;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
    
    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", title=" + title + ", users=" + users + ", files=" + 
                files + ", images=" + images + ", description=" + description + ", logo=" + 
                logo + ", tags=" + tags + ", followersList=" + followersList + '}';
    }
    
}
