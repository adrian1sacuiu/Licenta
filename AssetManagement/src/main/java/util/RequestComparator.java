package util;

import java.util.Comparator;
import java.util.Date;

import entities.Request;

public class RequestComparator implements Comparator<Request> {

	public int compare(Request request1, Request request2) {
		Date startDateDate1 = request1.getDate();
		Date startDateDate2 = request2.getDate();
		String status1 = request1.getStatus();
		String status2 = request2.getStatus();
		
		if (startDateDate1 != null && startDateDate2 != null && status1 != null && status2 != null) {		
		String date1 = startDateDate1.toString();
		String date2 = startDateDate2.toString();
		
			if (status1.equals(status2)) {
				return date1.compareTo(date2);

			} else if (status1.equals("New")) {
				return -1;

			} else if (status2.equals("New")) {
				return 1;

			} else if (status1.equals("Done")) {
				return -1;

			} else if (status2.equals("Done")) {
				return 1;

			} else if (status1.equals("Rejected")) {
				return -1;

			}

			return 1;
			
		} else {
			return -1;
		}

	}

}
