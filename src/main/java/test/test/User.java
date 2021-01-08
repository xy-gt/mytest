package test.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/18 18:11
 */
public class User implements Serializable {

    private Integer id;
    private Integer id2;

    private String name;

    private String parentName;

    private List<User> child ;

    public User() {

    }

    public User(Integer id, String name, String parentName) {
        this.id = id;
        this.name = name;
        this.parentName = parentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<User> getChild() {
        return child;
    }

    public void setChild(List<User> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", child=" + child +
                '}';
    }
}
