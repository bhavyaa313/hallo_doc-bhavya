package hallodoc.dto.enums;

public enum StatusEnum {

	UNASSIGNED, ACCEPTED, MDENROUTE, MDONSITE, CONCLUDE, CANCELLED, CANCELLEDBYPATIENT, CLOSED, UNPAID, CLEAR;
	
	public static String getNameById(int id) {
	    for (StatusEnum value : values()) {
	      if (value.ordinal() == id) {
	        return value.name();
	      }
	    }
	    throw new IllegalArgumentException("Invalid ID: " + id); // Handle invalid ID
	  }
	
}
