package entities;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Transaction implements Comparator<Transaction>{
	private String cardNumber;
	private Date transactionDate;
	private int amount;
	
	public Transaction() {
		
	}
	
	public Transaction(String cardNumber, Date transactionDate, int amount) {
		super();
		this.cardNumber = cardNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(getTransactionDate());
		return String.format("%-15s%-15s\n",date,getAmount());
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int compare(Transaction o1, Transaction o2) {
	        return o1.getTransactionDate().compareTo(o2.getTransactionDate());
	}
	
}
