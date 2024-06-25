
import java.util.Scanner;

public class Account{
    //class variable
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;


    //Class Constructor
    Account(String cName, String cID){
        customerName=cName;
        customerID=cID;
    }

    //function for Depositing money
    void deposit(int amount){
        if(amount!=0){
            balance+=amount;
            previousTransaction=amount;
        }
    }

    //function for Withdrawing money
    void  Withdraw(int amount){
        if(amount!=0){
            balance-=amount;
            previousTransaction=-amount;
        }
    }

    //function showing the previous transaction
    void getpreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited: "+ previousTransaction);
        } else if(previousTransaction<0){
            System.out.println("Withdrawed: "+ Math.abs(previousTransaction));
        }else{
            System.out.println("No Transaction Occured.");
        }
    }

    //function calculating interest of current funds after a number of years
    void calculatingInterest(int year){
        double interstRate = .0185;
        double newBalance = (balance * interstRate * year) + balance;
        System.out.println("The current interest rate is "+ (100* interstRate));
        System.out.println("After " + year + " years, your balance will be: " + newBalance);        

    }

    //function showing the main menu
    void showMenu(){
        char option = '\0';//null 
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: "+customerID);
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do { 
            System.out.println("");
            System.out.println("Enter an Option: ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option){
                //Case 'A' allows the user to check their account balance
                case 'A' :
                    System.out.println("=========================================");
                    System.out.println("Balance = Rs." + balance);
                    System.out.println("=========================================");
                    System.out.println("");
                    break;

                //Case 'B' allows the user to deposit money into their account using deposit function
                case 'B' :
                    System.out.println("Enter the amount to deposit: ");
                    int amount1=sc.nextInt();
                    deposit(amount1);
                    System.out.println("");
                    break;

               //Case 'c' allows the user to withdra money from their account using withdraw function
                case 'C' :
                    System.out.println("Enter the amount to be withdrawn: ");
                    int amount2=sc.nextInt();
                    deposit(amount2);
                    System.out.println("");
                    break;

                //Case 'D' allows the user to view their most recent transaction using getprevioustransaction function
                case 'D' :
                    System.out.println("=========================================");
                    getpreviousTransaction();
                    System.out.println("=========================================");
                    System.out.println("");
                    break;

                //Case 'E' allows the user to calculates the accured interest on the account after a number of years deposit
                case 'E' :
                    System.out.println("Enter how many years of accured interest: ");
                    int year= sc.nextInt();
                    calculatingInterest(year);
                    break;

                //Case 'F' allows the user to exit
                case 'F' :
                    System.out.println("=========================================");
                    break;

                // The default case let's the user know that they entered an invalid option
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D & E.");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for baanking with us!");
    }
}