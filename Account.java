import java.util.*;

class Account{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
    ArrayDeque<Integer> st=new ArrayDeque<>();

    Account(String cname,String cid){
        customerName=cname;
        customerId=cid;
    }

    void deposit(int amount){
        if(amount!=0){
            balance+=amount;
            previousTransaction=amount;
            st.push(previousTransaction);
        }
    }

    void withdraw(int amount){
        if (amount!=0 && amount<=balance){
            balance-=amount;
            previousTransaction=-amount;
            st.push(previousTransaction);
            System.out.println("Remaing Balnce: "+balance);
        }
        else{
            System.out.println("Withdraw Not Possible");
            System.out.println("Remaing Balance: "+balance);
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction<0){
            System.out.println("Withdrwan: "+Math.abs(previousTransaction));
        }
        else{
            System.out.println("No Transaction Occurred");
        }
    }

    void getAllTransactionHistory(){
        while(!st.isEmpty()){
            int value=st.pop();
            if(value>0){
                System.out.println("Deposited: "+value);
            }
            else if(value<0){
                System.out.println("Withdrwan: "+Math.abs(value));
            }
        }
    }

    void calculateInterest(int years){
        double interestrate=0.06;
        double newBalance=(balance*interestrate*years)+balance;
        System.out.println("The current interest rate is: "+interestrate*100);
        System.out.println("After "+years+" years,your new balance is: "+newBalance);
    }

    void showMenu(){
        char option='\0';
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName+"!");
        System.out.println("Your ID is: "+customerId);
        System.out.println();
        System.out.println("What would you like to do");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");;
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. View All Transaction History");
        System.out.println("G. Exit");

        do{
            System.out.println();
            System.out.println("Enter an option: ");
            char option1=sc.next().charAt(0);
            option=Character.toUpperCase(option1);
            System.out.println();

            switch (option){
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = ₹"+ balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit");
                    int amount=sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdrwa: ");
                    int amount2=sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accquires interest");
                    int years=sc.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("==============================");
                    getAllTransactionHistory();
                    System.out.println("==============================");
                    System.out.println();
                case 'G':
                    System.out.println("==============================");
                    break;
                default:
                    System.out.println("Error: Invalid Option. Please enter A,B,C,D,E,F");
                    break;
            }
        }while (option!='G');
        System.out.println("Thank you for banking with us");
    }

    public static class FirstBank {
        public static void main(String[] args) {
            Account aryan =new Account("Aryan","A000001");
            aryan.showMenu();
        }
    }
}