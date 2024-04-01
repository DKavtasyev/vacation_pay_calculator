package ru.neoflex.neostudy.vacation_pay_calculator.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.VacationData;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
@SuppressWarnings("ALL")
public class VacationDataValidator implements Validator
{
	
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return VacationData.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors)
	{
		VacationData vacationData = (VacationData) target;
		LocalDate firstDay = vacationData.getFirstDay();
		LocalDate lastDay = vacationData.getLastDay();
		
		if (firstDay.isAfter(lastDay))
			errors.rejectValue("lastDay", "", "Дата окончания отпуска должна быть позже даты начала отпуска!");
		else if (ChronoUnit.DAYS.between(firstDay, lastDay) > 31)
			errors.rejectValue("lastDay", "", "Длительность отпуска не может быть больше 31 дня. Обратитесь к администратору.");
	}
}
