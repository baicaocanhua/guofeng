package com.mai.guofeng.model;

public class Student {
    private int sid;
    @Column(name="maimai")
    private String sname;
    @Column(name="maimai-sex")
    private String sex;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name="maimai-age")

    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(int sid, String sname, String sex, int age){
        this.sid=sid;
        this.sname=sname;
        this.sex=sex;
        this.age=age;
    }
    public Student(){}
}
