package studentdatabaseapp;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class Student {

     private String firstName;
     private String lastName;
     private String gradeYear;
     private String courses=null;
     private int courseCount=0;
     private String studentID;
     private int tutionBalance=0;
     private static int costOfCourse=600;
     private static int id=1000;

     public Student(){
         Scanner sc=new Scanner(System.in);
         System.out.print("Enter student firstname: ");
         firstName=sc.nextLine();

         System.out.print("Enter student last name: ");
         lastName=sc.nextLine();

         System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
         gradeYear=sc.nextLine();

         setStudentID();
         System.out.println(firstName+" "+lastName+" "+gradeYear+" "+studentID);

     }

     private void setStudentID(){
         id++;
         studentID= gradeYear+""+id;
     }

     public void enroll(){
         do {
             System.out.print("Enter course to entroll (Q to quit): ");
             Scanner sc = new Scanner(System.in);
             String course = sc.nextLine();

             if (!course.equals("Q")) {
                 courseCount++;
                 if(courses==null){
                     courses =courseCount+". "+course;
                 }
                 else {
                     courses = courses + "\n" +courseCount+". "+ course;
                 }

                 tutionBalance = tutionBalance + costOfCourse;
             }else{
                 break;
             }
         }while(true);
         System.out.println("Enrolled in: "+courseCount+" courses");

     }

     public void viewBalance(){
         System.out.println("Tuition Balance is: ₹"+tutionBalance);
     }

     public void payTution(){
         viewBalance();
         Scanner sc=new Scanner(System.in);
         System.out.print("Enter the amount you want to pay: ");
         int payment=sc.nextInt();
         tutionBalance=tutionBalance-payment;
         System.out.println("Thankyou for your payment of: ₹"+payment);
         viewBalance();
     }

     public void showInfo(){
         System.out.println("Name: "+firstName+" "+lastName+"\nStudent ID: "+studentID+"\nGrade Level: "+gradeYear+"\nCourse Enrolled: \n"+courses+"\nBalance: "+tutionBalance);
     }
}
