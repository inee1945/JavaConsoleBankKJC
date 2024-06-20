package banking;

import java.io.Serializable;
import java.util.Objects;

public class HighCreditAccount extends Account implements Serializable {
	private String creditRating;
	private int rate;

	public HighCreditAccount(String accountNumber, String name, int balance,int rate, String creditRating) {
		super(accountNumber, name, balance);
		this.creditRating = creditRating;
		this.rate = rate;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public int hashCode() {
		int hashNum = Objects.hash(super.getAccountNumber());
		return hashNum;
	}

	@Override
	public boolean equals(Object obj) {
		Account acc = (Account) obj;
		if (acc.getAccountNumber().equals(this.getAccountNumber())) {
			return true;
		} else {
			return false;
		}
	}

}
