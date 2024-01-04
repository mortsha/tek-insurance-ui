package tek.insurance.app.utilities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtility {
	private final static DateTimeFormatter formatterTodayDate = DateTimeFormatter.ofPattern("MMMM d, yyyy");

	public static String todaysDate() {
		LocalDate localDate = toLocalDate();
		return localDate.format(formatterTodayDate);
	}

	public static String incrementDate(int days) {
		LocalDate localDate = toLocalDate().plusDays(days);
		return localDate.format(formatterTodayDate);
	}

	private static LocalDate toLocalDate() {
		return Instant.now().atZone(ZoneId.of("America/New_York")).toLocalDate();
	}

}
