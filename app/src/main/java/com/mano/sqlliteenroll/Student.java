package com.mano.sqlliteenroll;

import androidx.annotation.NonNull;

public class Student {
    private String name;
    private String s_class;
    private boolean isRegular;

    public Student( String name, String s_class, boolean isRegular) {
        this.name = name;
        this.s_class = s_class;
        this.isRegular = isRegular;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getS_class() { return s_class;  }

    public boolean isRegular() {  return isRegular;  }

    public void setName(String name) {
        this.name = name;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", s_class=" + s_class +
                ", isRegular=" + isRegular +
                '}';
    }

}
