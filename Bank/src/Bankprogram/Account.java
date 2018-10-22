/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bankprogram;

/**
 *
 * @author User
 */
abstract public class Account {
    
    private long accountNo;
	private double balance=2000;
	User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account(){}
     
	public Account(long accountNo, double balance, User user) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.user = user;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	abstract String deposit(double amount,long accountNo);
    abstract String withdrawal(double amount,long accountNo);
    abstract String showBalance(long accountNo);
    abstract String transferAmount(long accountNoSender,long accountNoReceiver,double transferAmount);
}
//SAVINGS ACCOUNT
class SavingsAccount extends Account{
		public SavingsAccount(){
		}
		
	String deposit(double depositAmount,long accountNo){
		accountNo=getAccountNo();
		if(depositAmount<49000){
			double totalAmount=getBalance()+depositAmount;
			setBalance(totalAmount);
			return ("Amount deposited Successfully. Your total balance is "+totalAmount);
		}else{
			return("you cannot deposit amount greater than 49,000");
		}
	}

	@Override
	String withdrawal(double withdrawAmount,long accountNo){
		accountNo=getAccountNo();
		//check for insufficient Balance
		double balance=getBalance();
		if(withdrawAmount>balance){
			return("Insufficient Balance. You cannot withdraw amount greater than your balance.");
		}
		if(withdrawAmount<10000){
			double totalAmount=getBalance()-withdrawAmount;
			setBalance(totalAmount);
			return ("Amount withdrawn Successfully. Your remaining balance is "+totalAmount);
		}else{
			return("you cannot withdraw amount greater than 10,000");
		}	
	}

    @Override
	String showBalance(long accountNo){
		return("Your balance is "+(getBalance()));
	}
         
	@Override
	String transferAmount(long accountNoSender,long accountNoReceiver,double transferAmount) {
		//check for insufficient Balance
		double balance=getBalance();
		if(transferAmount>balance){
			return("Insufficient Balance. You cannot withdraw amount greater than your balance.");
		}
		//sender's Account
		accountNoSender=getAccountNo();
		if(transferAmount<10000){
			double remainingBalanceSender=getBalance()-transferAmount;
			setBalance(remainingBalanceSender);
		}else{
			return("you cannot deposit amount greater than 49,000");
		}
		
		//receiver's Account
		accountNoReceiver=getAccountNo();
		if(transferAmount<49000){
			double remainingBalanceReceiver=getBalance()+transferAmount;
			setBalance(remainingBalanceReceiver);
			return ("Amount transferred Successfully.");
		}else{
			return("you cannot transfer amount greater than 10,000");
		}	
        }
}

//CURRENT ACCOUNT
class CurrentAccount extends Account{
	public CurrentAccount(){	
	}
	
	@Override
	String deposit(double depositAmount,long accountNo) {
		accountNo=getAccountNo();
		double totalAmount=getBalance()+depositAmount;
		setBalance(totalAmount);
		return ("Amount deposited Successfully. Your total balance is "+totalAmount);
	}

	@Override
	String withdrawal(double withdrawAmount,long accountNo) {
		accountNo=getAccountNo();
		// TODO Auto-generated method stub
		
		//check for insufficient Balance
		double balance=getBalance();
		if(withdrawAmount>balance){
			return("Insufficient Balance. You cannot withdraw amount greater than your balance.");
		}
		double totalAmount=getBalance()-withdrawAmount;
		setBalance(totalAmount);
		return ("Amount withdrawan Successfully. Your remaining balance is "+totalAmount);
	}
	
    @Override
	String showBalance(long accountNo){
		return("Your balance is "+(getBalance()));
	}
         
	@Override
	String transferAmount(long accountNoSender,long accountNoReceiver,double transferAmount) {
		// TODO Auto-generated method stub
		//check for insufficient Balance
		double balance=getBalance();
		if(transferAmount>balance){
			return("Insufficient Balance. You cannot withdraw amount greater than your balance.");
		}
		//sender's Account
		accountNoSender=getAccountNo();
		double remainingBalanceSender=getBalance()-transferAmount;
		setBalance(remainingBalanceSender);
		
		//receiver's Account
		accountNoReceiver=getAccountNo();
		double remainingBalanceReceiver=getBalance()+transferAmount;
		setBalance(remainingBalanceReceiver);
		
		return ("Amount transferred Successfully.");	
    }
}

