package ru.neoflex.neostudy.vacation_pay_calculator.repository;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class Holidays
{
	public static final Set<LocalDate> holidays = new HashSet<>();
	
	static
	{
		holidays.add(LocalDate.of(2024, Month.JANUARY, 1));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 2));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 3));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 4));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 5));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 6));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 7));
		holidays.add(LocalDate.of(2024, Month.JANUARY, 8));
		holidays.add(LocalDate.of(2024, Month.FEBRUARY, 23));
		holidays.add(LocalDate.of(2024, Month.MARCH, 8));
		holidays.add(LocalDate.of(2024, Month.MAY, 1));
		holidays.add(LocalDate.of(2024, Month.MAY, 9));
		holidays.add(LocalDate.of(2024, Month.JUNE, 12));
		holidays.add(LocalDate.of(2024, Month.NOVEMBER, 4));
	}
}
