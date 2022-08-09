package teacherManagementSystem.service;

import teacherManagementSystem.entity.Student;

import java.io.Serializable;

public class StoreStudent implements Serializable {

    private Student[] t;


    public Student[] getT(){
        return t;
    }

    public void setT(Student[] t){
        this.t = t;
    }
}
