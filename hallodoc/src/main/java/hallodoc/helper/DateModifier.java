package hallodoc.helper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

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
		
		public String getDate(int day, String month, int year) {

			String firstLetterofMonth = month.substring(0, 1);
			String month1 = month.substring(1, 3).toLowerCase();
			String fulllMonth = firstLetterofMonth + month1;

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM");
			TemporalAccessor temporalAccessor = dateTimeFormatter.parse(fulllMonth);
			String monthString = String.format("%02d", temporalAccessor.get(ChronoField.MONTH_OF_YEAR));
			String date = String.valueOf(String.format("%02d", day)) + "-" + monthString + "-" + String.valueOf(year);

			return date;

		}
		
	}


