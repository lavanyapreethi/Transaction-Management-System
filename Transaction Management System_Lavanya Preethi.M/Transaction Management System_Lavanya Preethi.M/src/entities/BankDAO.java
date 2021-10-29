package entities;
import java.util.*;
public class BankDAO {
	public void getTransactions(List<BankAccount> accList,List<Transaction> tList,String cname) {
		BankAccount acc, acc1;
		Transaction tran;
		String bname = "";
		boolean visited[] = new boolean[tList.size()];
		for (int i = 0; i < tList.size(); i++) {
			visited[i] = false;
		}

		List<BankAccount> list = new ArrayList<BankAccount>();
		Map<String, List<BankAccount>> map = new HashMap<>();
		int flag = 0,fl=0;
		for (int i = 0; i < accList.size(); i++) {
			if (flag == 0) {

				if (visited[i] != true) {
					flag = 1;
					list = new ArrayList<BankAccount>();
					acc = accList.get(i);
					bname = acc.getBank();
					for (int j = i + 1; j < accList.size(); j++) {
						if (visited[j] != true) {
							acc1 = accList.get(j);
							if (bname.equals(acc1.getBank())) {
								list.add(acc1);
								visited[j] = true;
							}
						}
					}
					flag = 0;
				}
				map.put(bname, list);
			}
		}

		List<Transaction> trList = new ArrayList<Transaction>();
		int flagval=0;
		int first=0,sno=1;
		for (Map.Entry<String, List<BankAccount>> entry : map.entrySet()) {
			fl=0;
			String key = entry.getKey();
			List<BankAccount> value = entry.getValue();
			for (int i = 0; i < value.size(); i++) {
				BankAccount ba = value.get(i);
				String hname = ba.getName();
				if (cname.equals(hname)) {
					String cNo = ba.getCardNumber();
					trList = new ArrayList<Transaction>();
					for (int k = 0; k < tList.size(); k++) {
						Transaction tr = tList.get(k);
						if (cNo.equals(tr.getCardNumber())) {
							trList.add(tr);
						}
					}
					Collections.sort(trList, new Comparator<Transaction>() {
						@Override
						public int compare(final Transaction o1, Transaction o2) {
							return o1.getTransactionDate().compareTo(o2.getTransactionDate());
						}
					});
					for (Transaction tr : trList) {
						if(first==0)
						{	
							first=1;
							System.out.printf("%-5s %-15s%-15s%-15s%-15s%-15s%-15s\n", "Sno","Name", "Bank", "Age", "Gender", "TransactionDate", "Amount");
							
						}
						
						if(fl>0) {
							System.out.printf("%-5s %15s","","");
							System.out.print(ba);
							System.out.print(tr);
						}
						else {
							System.out.printf("%-5s %-15s",sno,ba.getName());
							System.out.print(ba);
							System.out.print(tr);
						}
						fl++;
					}
					sno++;
					flagval=1;
				}

			}
		}
		if(flagval==0) {
			System.out.println("No transactions are done by " + cname);
		}
	}
}
