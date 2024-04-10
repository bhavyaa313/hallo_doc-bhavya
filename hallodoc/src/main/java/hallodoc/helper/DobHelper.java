package hallodoc.helper;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.springframework.stereotype.Service;

@Service
public class DobHelper {
	public String getWholeDate(int day,String month,int year) {
		String firstLetterString=month.substring(0,1);
		String monthStr=month.substring(1, 3).toLowerCase();
		String finalMonthString=firstLetterString+monthStr;
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM");
		TemporalAccessor temporalAccessor=dateTimeFormatter.parse(finalMonthString);
		String monthString=String.format("%02d", temporalAccessor.get(ChronoField.MONTH_OF_YEAR));
		String date=String.valueOf(String.format("%02d", day))+ "-" +monthString+ "-"+String.valueOf(year);
		
		return date;
		
	}

}
