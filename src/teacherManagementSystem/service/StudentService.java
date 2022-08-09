package teacherManagementSystem.service;

import teacherManagementSystem.entity.Student;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class StudentService{

    public static Student[] students = new Student[1000];
    public int lastIndex = 0;



    public void addStudent(Student student){
        students[lastIndex] = student;
        student.setId(++lastIndex);

    }

    public void remove (Student student){
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getId() == student.getId()){
                students[i] = null;
                break;
            }
        }
    }

    public Student findById(int id){
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].getId() == id){
                return students[i];
            }
        }
        return null;
    }


    public void requireFieldsandAdd() {
        Student student = new Student();

        System.out.println("Enter student name: ");
        student.setName(new Scanner(System.in).nextLine());

        System.out.println("Enter student surname: ");
        student.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Enter student age: ");
        student.setAge(new Scanner(System.in).nextInt());

        System.out.println("Enter student gpa");
        student.setGpa(new Scanner(System.in).nextDouble());

        System.out.println("Enter student scholarship");
        student.setScholarship(new Scanner(System.in).nextDouble());

        addStudent(student);
        System.out.println("Student successfuly registered");
        System.out.println(student);

    }

    public void requireIdandRemove(){
        System.out.println("Enter student id: ");
        int id = new Scanner(System.in).nextInt();
        Student s = findById(id);
        if(s!=null){
            remove(s);
            System.out.println("Student successfuly deleted!");
            System.out.println(s);
        }else {
            System.out.println("There is no such element");
        }
    }

    public void showAll(){
        for(int i = 0; i < students.length; i++){
            if(students[i] == null) continue;
            System.out.println(students[i].toString());
        }
    }

    public void findByNameAndSurname(){
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter surname");
        String surname = new Scanner(System.in).nextLine();

        Student foundStudent = null;
        for(int i = 0; i < students.length; i++){
            if(students[i] == null) continue;
            if(students[i].getName().equalsIgnoreCase(name) &&
                    students[i].getSurname().equalsIgnoreCase(surname)){
                foundStudent = students[i];
                break;
            }
        }
        if(foundStudent == null){
            System.out.println("There is no such student");
        }else {
            System.out.println(foundStudent);
        }
    }
    public void requireFieldsAndUpdate(){
        System.out.println("Enter student id: ");
        int id = new Scanner(System.in).nextInt();

        Student s = findById(id);
        if(s == null){
            System.out.println("No such element");
            return;
        }
        System.out.println("Enter field name: ");
        String fieldName = new Scanner(System.in).nextLine();

        System.out.println("Enter field value");
        String value = new Scanner(System.in).nextLine();

        if(fieldName.equalsIgnoreCase("age"))
        {
            s.setAge(Integer.parseInt(value));
        }
        if(fieldName.equalsIgnoreCase("name")){
            s.setName(value);
        }
        if(fieldName.equalsIgnoreCase("surname")){
            s.setSurname(value);
        }
        if(fieldName.equalsIgnoreCase("gpa")){
            s.setGpa(Double.parseDouble(value));
        }if(fieldName.equalsIgnoreCase("scholarship")){
            s.setScholarship(Double.parseDouble(value));
        }
    }
    public void publishScholarships(){
        for(int i = 0; i < students.length; i++){
            Student s = students[i];
            if(s==null) continue;
            if(s.getGpa() > 8) s.setScholarship(500);
            else if(s.getGpa() > 6) s.setScholarship(200);
            else if(s.getGpa() >= 4.5) s.setScholarship(100);
            }
        }

    public static void writeIntoFile(StoreStudent t)throws Exception{
        try {
            File file = new File("files/myObjects.txt");
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            new Student();
            o.writeObject(t);
            o.close();
            f.close();

        }catch (Exception e){

        }
    }

    public StoreStudent readFromFile(){
        try {
            FileInputStream fi = new FileInputStream(new File("files/myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            StoreStudent pr1 = (StoreStudent) oi.readObject();
            oi.close();
            fi.close();

            return pr1;
        }catch (Exception e){
            StoreStudent s = new StoreStudent();
            s.setT(students);
            return s;
         }
      }
   }





