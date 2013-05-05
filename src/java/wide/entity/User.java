
package wide.entity;

import java.util.List;

/**
 * Classe que fa referencia a un usuari
 * @author cuarti
 */
public class User implements Follower, Following {
    
    private int id;
    private String name;
    private String mail;
    private String password;
    private List<Project> projects;
    private List<Following> followingList;
    private List<Follower> followersList;

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    public User() {
    }
    
    public User(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public User(String name, String mail, String password, List<Project> projects, 
            List<Following> followingList, List<Follower> followersList) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.projects = projects;
        this.followingList = followingList;
        this.followersList = followersList;
    }

    public User(int id, String name, String mail, String password, List<Project> projects, 
            List<Following> followingList, List<Follower> followersList) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.projects = projects;
        this.followingList = followingList;
        this.followersList = followersList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Getters & Setters ">
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", mail=" + mail + 
                ", password=" + password + ", projects=" + projects + 
                ", followingList=" + followingList + ", followersList=" + followersList + '}';
    }
    
}
