package ru.neoflex.neostudy.vacation_pay_calculator.service;

import org.springframework.stereotype.Component;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Data;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Result;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.VacationData;
import ru.neoflex.neostudy.vacation_pay_calculator.repository.Holidays;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static ru.neoflex.neostudy.vacation_pay_calculator.repository.Holidays.holidays;

@Component
public class Calculator implements Function
{
	
	@Override
	public Result execute(Data data)
	{
		VacationData vacationData;
		if (data instanceof VacationData)
			vacationData = (VacationData) data;
		else
			throw new IllegalArgumentException("Illegal type of data");
		
		int avgSalary = vacationData.getAvgSalary();
		LocalDate firstDay = vacationData.getFirstDay();
		LocalDate lastDay = vacationData.getLastDay();
		
		int vacationDaysCount = (int) ChronoUnit.DAYS.between(firstDay, lastDay) + 1;		// Количество дней отпуска, включая крайние дни
		double avgDailyPay = avgSalary / 29.3;												// Среднедневной заработок
		String vacationPay = String.format("%.2f", avgDailyPay * vacationDaysCount * 0.87);					// Отпускные, облагаемые подоходным доходом в размере 13 %
		
		Result result = new Result(vacationPay, firstDay, lastDay);
		
		for(LocalDate holiday : holidays)													// Для каждого праздника проверка, выпадает ли он на отпуск
		{
			if (holiday.isAfter(firstDay) && holiday.isBefore(lastDay))
			{
				lastDay = lastDay.plusDays(1);									// Если да, то праздник не входит в отпуск, а работник может выходить на день позже
				result.setLastDay(lastDay);													// Праздники не оплачиваются
				result.setMessage("Ваш отпуск продлён на количество " +
						"праздничных дней, выпадающих на период отпуска.");
			}
		}
		
		return result;
	}
}
