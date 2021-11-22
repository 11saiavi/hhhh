package com.SpringMvc.withDb.Model;


import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long studentId;

    @Column(name= "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "section")
    private String section;

    public Student() {
    }



    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getSection() {
        return section;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString(){
        return "Student [ Id = "+ studentId + "Name "+ name + "Age "+ age + "Section" + section +" ]";
    }
}
