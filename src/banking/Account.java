package banking;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable{
	private String accountNumber;
	private String name;
	private int balance;

	//입출금
	Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	//계좌 개설
	Account(String accountNumber, String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
