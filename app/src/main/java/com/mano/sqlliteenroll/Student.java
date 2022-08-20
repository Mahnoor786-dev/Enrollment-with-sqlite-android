package com.mano.sqlliteenroll;

import androidx.annotation.NonNull;

public class Student {
    private String name;
    private String stuClass;
    private boolean isRegular;

    public Student( String name, String s_class, boolean isRegular) {
        this.name = name;
        this.stuClass = s_class;
        this.isRegular = isRegular;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getStuClass() { return stuClass;  }

    public boolean isRegular() {  return isRegular;  }

    public void setName(String name) {
        this.name = name;
    }

    public void setS_class(String s_class) {
        this.stuClass = s_class;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", s_class=" + stuClass +
                ", isRegular=" + isRegular +
                '}';
    }

}
