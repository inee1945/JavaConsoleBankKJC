package banking;

import java.io.Serializable;
import java.util.Objects;

public class NormalAccount extends Account implements Serializable {
	private int rate;

	public NormalAccount(String accountNumber, String name, int balance, int rate) {
		super(accountNumber, name, balance);
		this.rate = rate;
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
