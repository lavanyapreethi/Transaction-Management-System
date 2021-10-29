package entities;

public class BankAccount {
	private String name;
	private int age;
	private String gender;
	private String bank;
	private String cardNumber;
	private int creditLimit;
	
	public BankAccount(String name, int age, String gender, String bank, String cardNumber, int creditlimit) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.bank = bank;
		this.cardNumber = cardNumber;
		this.creditLimit = creditlimit;
	}
	
	public BankAccount() {
		
	}

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s",getBank(),getAge(),getGender());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumberString(String cardNumberString) {
		this.cardNumber = cardNumberString;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}


}
