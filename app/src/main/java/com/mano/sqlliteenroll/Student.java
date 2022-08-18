package com.mano.sqlliteenroll;

import androidx.annotation.NonNull;

public class Student {
    private int id;
    private String name;
    private int s_class;
    private boolean isRegular;

    public Student(int id, String name, int s_class, boolean isRegular) {
        this.id = id;
        this.name = name;
        this.s_class = s_class;
        this.isRegular = isRegular;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getS_class() {
        return s_class;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setS_class(int s_class) {
        this.s_class = s_class;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", s_class=" + s_class +
                ", isRegular=" + isRegular +
                '}';
    }

}
