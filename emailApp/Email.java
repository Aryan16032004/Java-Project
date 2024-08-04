package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength=10;
    private String department;
    private int mailboxCapacity=500;
    private String alternateEmail;
    private String companySuffix= "gmail.com";

    public Email(String fname,String lname){
        firstName=fname;
        lastName=lname;

        department=setDepartment();

        password=randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: "+password);

        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;

    }

    private String setDepartment(){
        System.out.println("New Worker: "+firstName);
        System.out.print("Enter the department code: \n1 forSales \n2 for Development \n3 for Accounting \n0 for none\n");
        Scanner sc=new Scanner(System.in);
        int depChoice=sc.nextInt();
        if(depChoice==1){
            return "sales";
        }
        else if(depChoice==2){
            return "dev";
        }
        else if(depChoice==3){
            return "acct";
        }
        else{
            return "";
        }
    }

    private String randomPassword(int length){
         String passwordSet="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@#$!&";
         char[] password=new char[length];
         for(int i=0;i<length;i++){
             int rand=(int)(Math.random()*passwordSet.length());
             password[i]=passwordSet.charAt(rand);
         }
         return  new String(password);
    }

    public void setMailBoxCapacity(int capacity){
        mailboxCapacity=capacity;
    }

    public void setAlternateEmail(String altemail){
        alternateEmail=altemail;
    }

    public void changePassword(String password){
        this.password=password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: "+firstName+" "+lastName+
                "\nCompany Email: "+email+
                "\nMailbox Capacity: "+mailboxCapacity+" mb";
    }
}
