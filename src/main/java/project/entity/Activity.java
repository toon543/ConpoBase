package project.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Activity implements Comparable{
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    String type;

    @OneToMany(fetch= FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Activity(){

    };

    public Activity(Long id,String name, String description, String type,Image image) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.id = id;
        this.getImages().add(image);
    }

    public Activity(Long id,String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Activity)o).getId());
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;

        Activity activity = (Activity) o;

        if (getId() != null ? !getId().equals(activity.getId()) : activity.getId() != null) return false;
        if (getName() != null ? !getName().equals(activity.getName()) : activity.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(activity.getDescription()) : activity.getDescription() != null)
            return false;
        if (getType() != null ? !getType().equals(activity.getType()) : activity.getType() != null)
            return false;
        return !(getImages() != null ? !getImages().equals(activity.getImages()) : activity.getImages() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
        return result;
    }
}
