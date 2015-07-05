package util;

import java.util.Comparator;

import entities.Request;

public class RequestComparator implements Comparator<Request> {

	public int compare(Request request1, Request request2) {
		String date1 = request1.getDate().toString();
		String date2 = request2.getDate().toString();

		String status1 = request1.getStatus();
		String status2 = request2.getStatus();

		if (date1 != null && date2 != null && status1 != null && status2 != null) {
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
