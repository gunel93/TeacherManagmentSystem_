package teacherManagementSystem.service;

import teacherManagementSystem.entity.Teacher;

public class StoreTeacher {

    private Teacher[] t;

    public Teacher[] getT(){
        return t;
    }

    public void setT(Teacher[] t){
        this.t = t;
    }
}
