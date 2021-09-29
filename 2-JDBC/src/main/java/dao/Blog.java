package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class Blog {

    private int id;
    private String blogName;

    public Blog() {
    }

    public Blog(int id, String blogName) {
        this.id = id;
        this.blogName = blogName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }
}
