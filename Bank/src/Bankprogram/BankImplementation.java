package Bankprogram;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author User
 */
public class BankImplementation {
    public static void main(String[] args){
	// TODO Auto-generated method stub
    	BankImplementation obj=new BankImplementation();
	
	int choice;
		int flag=1; //flag for exit
		SavingsAccount savings;
        CurrentAccount current;
        do{
        //options
	    System.out.println("Enter the operation you want to perform:"
				+ "\n\n1. Add a new Account"
				+ "\n2. Deposit Amount"
				+ "\n3. Get Balance"
				+ "\n4. Withdraw Amount"
				+ "\n5. Transfer Amount"
				+ "\n6. Exit");
	    Scanner scanner=new Scanner(System.in);
	    choice = scanner.nextInt();
	    switch(choice){
            
	    //Add a new account  
        case 1:
            System.out.println("Choose your Account type:\n1. Savings Account\n2. Current Account");
            int choice2 = scanner.nextInt();
           
            System.out.println("Enter your account no.:");
            long accountNo=Long.parseLong(scanner.next());
            
            switch(choice2){
            
            case 1:
            	savings = new SavingsAccount();
            	savings.setAccountNo(accountNo);
            	obj.userDetails();
            	break;
            
            case 2:
            	current = new CurrentAccount();
                current.setAccountNo(accountNo);
                obj.userDetails();
            	break;
            	
            default:
            	System.out.println("Invalid Choice");
            }
            System.out.println("Details Added Successfully");
            break;
            
        //to deposit amount	
        case 2:
            System.out.println("Choose your Account type:\n1. Savings Account\n2. Current Account");
            int choice3 = scanner.nextInt();

            System.out.println("Enter your account no.:");
            long accountNoDeposit=Long.parseLong(scanner.next());
            
            System.out.println("Enter Amount to deposit:");
            Double depositAmount=scanner.nextDouble();
            switch(choice3){
            
            case 1:
            	savings = new SavingsAccount();
            	savings.setAccountNo(accountNoDeposit);
            	String str=savings.deposit(depositAmount,accountNoDeposit);
            	System.out.println(str);
            	break;
            
            case 2:
            	current = new CurrentAccount();
                current.setAccountNo(accountNoDeposit);
                String str2=current.deposit(depositAmount,accountNoDeposit);
                System.out.println(str2);
            	break;
            	
            default:
            	System.out.println("Invalid Choice");
            } 
            break;
            
        //to view balance	
        case 3:
            System.out.println("Choose your Account type:\n1. Savings Account\n2. Current Account");
            int choice4 = scanner.nextInt();

            System.out.println("Enter your account no.:");
            long accountNoBalance=Long.parseLong(scanner.next());
            
            switch(choice4){
            
            case 1:
            	savings = new SavingsAccount();
            	savings.setAccountNo(accountNoBalance);
            	String str3=savings.showBalance(accountNoBalance);
            	System.out.println(str3);
            	break;
            
            case 2:
            	current = new CurrentAccount();
                current.setAccountNo(accountNoBalance);
                String str4=current.showBalance(accountNoBalance);
        	System.out.println(str4);
            	break;
            	
            default:
            	System.out.println("Invalid Choice");
            }
            break;
        
        //to withdraw amount
        case 4:
            System.out.println("Choose your Account type:\n1. Savings Account\n2. Current Account");
            int choice5 = scanner.nextInt();

            System.out.println("Enter your account no.:");
            long accountNoWithdraw=Long.parseLong(scanner.next());
            
            System.out.println("Enter Amount to withdraw:");
            Double withdrawAmount=scanner.nextDouble();
            switch(choice5){
             
            case 1:
             	savings = new SavingsAccount();
                savings.setAccountNo(accountNoWithdraw);
                String str5=savings.withdrawal(withdrawAmount,accountNoWithdraw);
        	System.out.println(str5);
             	break;
             
            case 2:
             	current = new CurrentAccount();
                current.setAccountNo(accountNoWithdraw);
                String str6=current.withdrawal(withdrawAmount,accountNoWithdraw);
                System.out.println(str6);
             	break;
             	
             default:
             	System.out.println("Invalid Choice");
             }
        	
             break;
        
        //to transfer amount
        case 5:
            System.out.println("Choose your Account type:\n1. Savings Account\n2. Current Account");
            int choice6 = scanner.nextInt();
            
            System.out.println("Enter Account No you want to transfer amount from:");
            long accountNoSender=scanner.nextLong();
            
            System.out.println("Enter Account No you want to transfer amount to:");
            long accountNoReceiver=scanner.nextLong();
            
            System.out.println("Enter Amount you want to transfer:");
            Double transferAmount=scanner.nextDouble();
            
            Bank bank=new Bank();
            System.out.println("Enter the name of your Bank:");
            String bankName=scanner.next();
            bank.setBankName(bankName);
            
            //for same bank
            if((bank.getBankName()).equals("ICICI")){
            switch(choice6){
             
            case 1:
             	savings = new SavingsAccount();
             	savings.setAccountNo(accountNoSender);
             	savings.setAccountNo(accountNoReceiver);
                String str7=savings.transferAmount(accountNoSender,accountNoReceiver,transferAmount);
                System.out.println(str7);
             	break;
             
            case 2:
             	current = new CurrentAccount();
             	current.setAccountNo(accountNoSender);
            	current.setAccountNo(accountNoReceiver);
                String str8=current.transferAmount(accountNoSender,accountNoReceiver,transferAmount);
                System.out.println(str8);
             	break;
             	
             default:
             	System.out.println("Invalid Choice");
            }
            }else{//for different banks
            	
             System.out.println("Enter the IFSC code:");
             String ifscCode=scanner.next();
             bank.setIfscCode(ifscCode);
                
                
            switch(choice6){
             
            case 1:
             	savings = new SavingsAccount();
             	savings.setAccountNo(accountNoSender);
             	savings.setAccountNo(accountNoReceiver);
                String str7=savings.transferAmount(accountNoSender,accountNoReceiver,transferAmount);
                System.out.println(str7);
             	break;
             
            case 2:
             	current = new CurrentAccount();
             	current.setAccountNo(accountNoSender);
            	current.setAccountNo(accountNoReceiver);
                String str8=current.transferAmount(accountNoSender,accountNoReceiver,transferAmount);
                System.out.println(str8);
             	break;
             	
             default:
             	System.out.println("Invalid Choice");
            }
            }
            break;
        
        //exit condition
        case 6:
        	flag=0;
        	break;
        	
        default:
        	break;
		}
        }while(flag!=0);
     	
	}
    public void userDetails(){
    	Scanner scanner2=new Scanner(System.in);
        User user=new User();
            
  	    System.out.println("Enter UserName:");
  	    String userName=scanner2.next();
        user.setUserName(userName);

        System.out.println("Enter your FirstName:");
        String firstName=scanner2.next();
        user.setFirstName(firstName);
 		
        System.out.println("Enter your LastName:");
        String lastName=scanner2.next();
        user.setLastName(lastName);
 		
        System.out.println("Enter your Email:");
        String email=scanner2.next();
        user.setEmail(email);
 		    
        }
}

