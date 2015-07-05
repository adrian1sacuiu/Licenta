package util;

import java.util.Comparator;
import java.util.Date;

import entities.Transaction;

public class TransactionComparator implements Comparator<Transaction> {

	public int compare(Transaction transaction1, Transaction transaction2) {
		Date startDateDate1 = transaction1.getStartDate();
		Date startDateDate2 = transaction1.getStartDate();
		String status1 = transaction1.getStatus();
		String status2 = transaction2.getStatus();
		
		if (startDateDate1 != null && startDateDate2 != null && status1 != null && status2 != null) {		
		String startDate1 = startDateDate1.toString();
		String startDate2 = startDateDate2.toString();
		
			if (status1.equals(status2)) {
				return startDate1.compareTo(startDate2);

			} else if (status1.equals("Pending")) {
				return -1;

			} else if (status2.equals("Pending")) {
				return 1;

			} else if (status1.equals("Success")) {
				return -1;

			} else if (status2.equals("Success")) {
				return 1;

			} else if (status1.equals("Declined")) {
				return -1;

			}

			return 1;
			
		} else {
			return -1;
		}
	}

}
