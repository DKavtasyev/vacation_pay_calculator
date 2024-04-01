package ru.neoflex.neostudy.vacation_pay_calculator.service;

import org.springframework.stereotype.Component;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Data;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Result;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.VacationData;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
		
		int vacationDaysCount = (int) ChronoUnit.DAYS.between(firstDay, lastDay) + 1;	// Количество дней отпуска, включая крайние дни
		double avgDailyPay = avgSalary / 29.3;											// Среднедневной заработок
		double vacationPay = avgDailyPay * vacationDaysCount * 0.87;					// Отпускные, облагаемые подоходным доходом в размере 13 %
		
		return new Result(vacationPay);
	}
}
