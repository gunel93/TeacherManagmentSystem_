package teacherManagementSystem.service;


import teacherManagementSystem.entity.Student;
import teacherManagementSystem.entity.Teacher;

import java.util.Scanner;

public class TeacherService {

    private static Teacher[] teachers = new Teacher[1000];
    private int lastIndex = 0;




    public void addTeacher(Teacher teacher){
        teachers[lastIndex] = teacher;
        teacher.setId(++lastIndex);
    }


    public void remove(Teacher teacher){
        for(int i = 0; i < teachers.length; i++){
            if(teachers[i] != null && teachers[i].getId() == teacher.getId()){
                teachers[i] = null;
                break;
            }
        }
    }
    public Teacher findById(int id){
        for(int i = 0; i < teachers.length; i++){
            if(teachers[i] != null && teachers[i].getId() == id){
                return teachers[i];
            }
        }
        return null;
    }
    public void requireFieldsAndAdd(){
        Teacher teacher = new Teacher();

        System.out.println("Enter teacher name: ");
        teacher.setName(new Scanner(System.in).nextLine());

        System.out.println("Enter teacher surname: ");
        teacher.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Enter teacher age: ");
        teacher.setAge(new Scanner(System.in).nextInt());

        System.out.println("Enter teacher salary: ");
        teacher.setSalary(new Scanner(System.in).nextDouble());

        System.out.println("Enter teacher chair");
        teacher.setChair(new Scanner(System.in).nextLine());

        addTeacher(teacher);

        System.out.println("Teacher successfuly added");
        System.out.println(teacher);

    }

    public void requireIdAndRemove(){
        System.out.println("Enter teacher id");
        int id = new Scanner(System.in).nextInt();
        Teacher t = findById(id);

        if(t != null){
            remove(t);
            System.out.println("Teacher successfuly deleted");
            System.out.println(t);
        }else {
            System.out.println("There is no such teacher");
        }
    }
    public void showAll(){
        for(int i = 0; i < teachers.length; i++){
            if(teachers[i] == null) continue;
            System.out.println(teachers[i].toString());

        }
    }
    public void findByNameAndSurname(){
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter surname: ");
        String surname = new Scanner(System.in).nextLine();

        Teacher foundTeacher = null;
        for(int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) continue;
            if (teachers[i].getName().equalsIgnoreCase(name) &&
                    teachers[i].getSurname().equalsIgnoreCase(surname)) {
                foundTeacher = teachers[i];
                break;
            }
        }
            if(foundTeacher == null){
                System.out.println("There is no such teacher");
            }else {
                System.out.println(foundTeacher);
            }
       }
       public void requireFieldsAndUpdate(){
           System.out.println("Enter teacher id: ");
           int id = new Scanner(System.in).nextInt();

           Teacher t = findById(id);
           if(t == null){
               System.out.println("There is no such teacher");
               return;
           }
           System.out.println("Enter field name: ");
           String fieldName = new Scanner(System.in).nextLine();

           System.out.println("Enter field value: ");
           String fieldValue = new Scanner(System.in).next();

           if(fieldName.equalsIgnoreCase("name")){
               t.setName(fieldValue);
           }
           if(fieldName.equalsIgnoreCase("surname")){
               t.setSurname(fieldName);
           }
           if(fieldName.equalsIgnoreCase("age")){
               t.setAge(Integer.parseInt(fieldValue));
           }
           if(fieldName.equalsIgnoreCase("salary")){
               t.setSalary(Double.parseDouble(fieldValue));
           }
           if(fieldName.equalsIgnoreCase("cahir")){
               t.setChair(fieldValue);
           }
       }
}
