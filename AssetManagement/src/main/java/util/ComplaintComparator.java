package util;

import java.util.Comparator;

import entities.Complaint;

public class ComplaintComparator implements Comparator<Complaint> {

	public int compare(Complaint complaint1, Complaint complaint2) {
		String priority1 = complaint1.getPriority();
		String priority2 = complaint2.getPriority();

		String status1 = complaint1.getStatus();
		String status2 = complaint2.getStatus();

		if (priority1 != null && priority2 != null && status1 != null && status2 != null) {
			if (status1.equals(status2)) {
				if (priority1.equals(priority2)) {
					return 0;

				} else if (priority1.equals("High")) {
					return -1;

				} else if (priority2.equals("High")) {
					return 1;
				}

				else if (priority1.equals("Medium")) {
					return -1;

				} else {
					return 1;
				}

			} else if (status1.equals("New")) {
				return -1;
			}

			return 1;
			
		} else {
			return -1;
		}
	} 

}
