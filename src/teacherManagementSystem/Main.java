package teacherManagementSystem;

import teacherManagementSystem.entity.Student;
import teacherManagementSystem.service.StoreStudent;
import teacherManagementSystem.service.StudentService;
import teacherManagementSystem.service.TeacherService;

import java.util.Scanner;

public class Main {

    private static StudentService studentService = new StudentService();
    private static TeacherService teacherService = new TeacherService();

    public static void main(String[] args) throws Exception {
        StoreStudent s = studentService.readFromFile();
        StudentService.students = s.getT();



        while (true){
          System.out.println("Select operation: \n" +
                  "1.Register student: \n" +
                  "2.Delete student\n" +
                  "3.Show all students\n" +
                  "4.Find student by name and surname\n" +"" +
                  "5.Update student\n"+"" +
                  "6.Publish scholarships\n"+

                  "7.Register teacher: \n" +
                  "8.Delete teacher\n" +
                  "9.Show all teachers\n" +
                  "10.Find teacher by name and surname\n"+
                  "11.Update teacher"
          );

          Menu_Choice menu = Menu_Choice.getByValue(new Scanner(System.in).nextInt());

          if(menu == Menu_Choice.REGISTER){
              studentService.requireFieldsandAdd();
          }else if(menu == Menu_Choice.DELETE){
              studentService.requireIdandRemove();
          }else if(menu == Menu_Choice.SHOW_ALL){
               studentService.showAll();
          } else if(menu == Menu_Choice.FIND){
              studentService.findByNameAndSurname();
          }else if(menu == Menu_Choice.UPDATE){
              studentService.requireFieldsAndUpdate();
          }else if(menu == Menu_Choice.PUBLISH){
              studentService.publishScholarships();
          }else if(menu == Menu_Choice.REGISTER_TEACHER){
              teacherService.requireFieldsAndAdd();
          }else if(menu == Menu_Choice.DELETE_TEACHER){
              teacherService.requireIdAndRemove();
          }else if(menu == Menu_Choice.SHOW_ALL_TEACHERS){
              teacherService.showAll();
          }
          else if(menu == Menu_Choice.FIND_TEACHERS){
              teacherService.findByNameAndSurname();
          }else if(menu == Menu_Choice.UPDATE_TEACHERS){
              teacherService.requireFieldsAndUpdate();
          }
          else {
              System.out.println("Invalid operation!");
           }
            s.setT(StudentService.students);
           StudentService.writeIntoFile(s);
         }
    }
}
