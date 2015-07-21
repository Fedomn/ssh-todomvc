package com.fedomn.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
	private String name;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "SALARY")
    private Float salary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "zbbs")
    private Set<Fj> fjSet = new HashSet<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Date birthday, String sex, Float salary) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Set<Fj> getFjSet() {
        return fjSet;
    }

    public void setFjSet(Set<Fj> fjSet) {
        this.fjSet = fjSet;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", fjSet=" + fjSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (fjSet != null ? !fjSet.equals(user.fjSet) : user.fjSet != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (salary != null ? !salary.equals(user.salary) : user.salary != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (fjSet != null ? fjSet.hashCode() : 0);
        return result;
    }
}
