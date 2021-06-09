package banking;
import java.sql.SQLException;
import banking.model.Account;
import banking.service.AccountService;
import banking.service.impl.AccountServiceImpl;

public class BankingSystem {
	
	public static void main(String[] args) throws SQLException {
		//initialize the service
		AccountService accountService = new AccountServiceImpl();
		
		//create account objects
		Account john = new Account("John","Doe",2900);
		Account kiros = new Account("Kiros","Hadgu",2300);
		Account amanuel = new Account("Amanuel","Goitom",3450);
		
		//insert into db
		System.out.println("Before Inserting to DB \n" + john + "\n"+ kiros + "\n "+ amanuel +"\n");
		accountService.createAccount(john);
		accountService.createAccount(kiros);
		accountService.createAccount(amanuel);
		
		System.out.println("After Insertion to DB \n" + john + "\n"+ kiros + "\n "+ amanuel);
		
		//deposit
		john = accountService.getAccountById(john.getAccount_no());
		amanuel = accountService.getAccountById(amanuel.getAccount_no());
		kiros = accountService.getAccountById(kiros.getAccount_no());

		accountService.deposit(john, 1000);
		accountService.deposit(kiros, 1000);
		accountService.deposit(amanuel, 1000);
	
		john = accountService.getAccountById(john.getAccount_no());
		amanuel = accountService.getAccountById(amanuel.getAccount_no());
		kiros = accountService.getAccountById(kiros.getAccount_no());

		System.out.println("After Deposit \n" + john + "\n"+ kiros + "\n "+ amanuel);
		
		//withdraw
		amanuel = accountService.getAccountById(amanuel.getAccount_no());
		accountService.withdraw(amanuel, 500);
		
		john = accountService.getAccountById(john.getAccount_no());
		amanuel = accountService.getAccountById(amanuel.getAccount_no());
		kiros = accountService.getAccountById(kiros.getAccount_no());

		System.out.println("After Withdraw \n" + amanuel);		
		
		
		accountService.transfer(john,kiros , 1000, "For macbook pro");
		
		john = accountService.getAccountById(john.getAccount_no());
		amanuel = accountService.getAccountById(amanuel.getAccount_no());
		kiros = accountService.getAccountById(kiros.getAccount_no());

		System.out.println("After Transfer \n " + john + "\n " + kiros);
				
		
	}
}
