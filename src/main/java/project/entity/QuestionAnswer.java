package project.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Punjasin on 5/15/2015.
 */
@Entity
public class QuestionAnswer {
    @Id
            @GeneratedValue
            Long id;
String name;
    boolean New;
    String answer;

    public QuestionAnswer(Long id,String name) {
        this.id=id;
        this.name = name;
        New = true;
    }

    public QuestionAnswer(String name) {
        this.name = name;
        New = true;

    }
    public QuestionAnswer(String name, boolean aNew, String answer) {
        this.name = name;
        New = aNew;
        this.answer = answer;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionAnswer that = (QuestionAnswer) o;

        if (New != that.New) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(answer != null ? !answer.equals(that.answer) : that.answer != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (New ? 1 : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }

    public QuestionAnswer() {
        this.New= true;
    }

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

    public boolean isNew() {
        return New;
    }

    public void setNew(boolean aNew) {
        New = aNew;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
