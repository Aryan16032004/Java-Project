package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {


        System.out.print("Enter the number of new students to enroll: ");
        Scanner sc=new Scanner(System.in);
        int numOfStudents=sc.nextInt();
        Student[] students=new Student[numOfStudents];

        for(int i=0;i<numOfStudents;i++){
            students[i] =new Student();
            students[i].enroll();
            students[i].payTution();
            System.out.println();
        }

        for(int i=0;i<numOfStudents;i++){
            students[i].showInfo();
            System.out.println();
            
        }
    }
}
