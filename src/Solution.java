import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.temporal.ChronoField.*;

public class Solution {

	// SORRY this is a skeleton FIRST NOT FAST APPROACH JUST FOR GETTING test RESULTS!!!!!!
	// FURTHER IMPROVEMENTS MUST BE MADE!!!
	// lack of time and exceptions... Sorrry

	final DateTimeFormatter formatter =
			new DateTimeFormatterBuilder()
					.appendPattern("yyyy-MM-dd")
					.toFormatter();

//			new DateTimeFormatterBuilder()
//					.appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
//					.appendLiteral('-')
//					.appendValue(MONTH_OF_YEAR, 2)
//					.appendLiteral('-')
//					.appendValue(DAY_OF_MONTH, 2)
//					.toFormatter(); // WORKS


//			new DateTimeFormatterBuilder()
//					//.parseCaseInsensitive()
//					.append(ISO_LOCAL_DATE)
////					.optionalStart()
////					.appendOffsetId()
//					.toFormatter();

//			new DateTimeFormatterBuilder()
//			.appendPattern("yyyy-mm-dd") //, E, hh:mm a
//			.parseDefaulting(ChronoField.YEAR, 2020)
//			.toFormatter();

			//DateTimeFormatter.ofPattern("yyyy-mm-dd", Locale.US);

	//DateTimeFormatter.ISO_DATE; // WORKS

	class MonthPay {
		int total;
		int card;
		int cardCount;
	}


	public int solution(int[] A, String[] D) {

		MonthPay[] monthPays = new MonthPay[12];
		for (int m = 0; m < 12 ; m++)
			monthPays[m] = new MonthPay();

		int amount = 0;
		for (int i = 0; i < A.length; i++) {
			LocalDate date = LocalDate.parse(D[i], formatter); //ISO_LOCAL_DATE
			int month = date.getMonthValue() - 1;
			amount += A[i];
			monthPays[month].total += A[i];
			if (A[i]<0) {
				monthPays[month].card += A[i];
				monthPays[month].cardCount++;
			}
		}

		for (int m = 0; m < 12 ; m++) {
			int mFee = 5;
			if (monthPays[m].card <= -100 && monthPays[m].cardCount >=3)
				mFee = 0;
			amount -= mFee;
		}

		return amount;
	}


//	public int solution(int[] A, String[] D) {
//
//		int amount = 0;
//		for (int m = 1; m <= 12 ; m++) {
//			int payCount = 0;
//			int payAmount = 0;
//			for (int i = 0; i < A.length; i++) {
//				LocalDate date = LocalDate.parse(D[i], formatter); //ISO_LOCAL_DATE
//				if (date.getMonthValue() == m) {
//					amount += A[i];
//					if (A[i]<0) {
//						payAmount += A[i];
//						payCount++;
//					}
//				}
//			}
//			int mFee = 5;
//			if (payAmount <= -100 && payCount >=3)
//				mFee = 0;
//			amount -= mFee;
//		}
//
//		return amount;
//	}
}


