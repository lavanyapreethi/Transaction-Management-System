import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entities.BankAccount;
import entities.BankDAO;
import entities.Transaction;

public class Main {
	public static void main(String[] args) throws ParseException {
		File file1 = new File("bankaccount.txt");
		File file2 = new File("banktransactions.txt");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		BankDAO bdo = new BankDAO();
		BufferedReader br = null;
		List<BankAccount> accList = new ArrayList<BankAccount>();
		List<Transaction> tList = new ArrayList<Transaction>();
		try {
			FileReader fr1 = new FileReader(file1);
			br = new BufferedReader(fr1);

			br.readLine();
			String line = "", line2 = "";
			while ((line = br.readLine()) != null) {
				line2 = line;
				String[] val = line2.split(",");
				int age = Integer.parseInt(val[1]);
				int limit = Integer.parseInt(val[5]);
				BankAccount acc = new BankAccount(val[0], age, val[2], val[3], val[4], limit);
				accList.add(acc);
			}

			FileReader fr2 = new FileReader(file2);
			br = new BufferedReader(fr2);
			br.readLine();
			while ((line = br.readLine()) != null) {
				line2 = line;
				String[] val = line2.split(",");
				Date d1 = new Date();
				d1 = sdf.parse(val[1]);
				int amount = Integer.parseInt(val[2]);
				Transaction trans = new Transaction(val[0], d1, amount);
				tList.add(trans);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + file1.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + file1.toString());
		}

		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				// File was probably never opened
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the customer");
		String custname = sc.next();
		bdo.getTransactions(accList, tList, custname);
		
	}
}
