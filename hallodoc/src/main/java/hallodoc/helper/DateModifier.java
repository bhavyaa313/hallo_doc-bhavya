package hallodoc.helper;
import java.time.LocalDate;

public class DateModifier {


	
		
		public String getMonth(LocalDate date) {
			
			return date.getMonth().toString();
		}
		
		public int getDay(LocalDate date) {
			return date.getDayOfMonth();
		}
		public int getYear(LocalDate date) {
			return date.getYear();
		}
	}


