package ru.neoflex.neostudy.vacation_pay_calculator.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Result
{
	public Result(String vacationPay, LocalDate firstDay, LocalDate lastDay)
	{
		this.vacationPay = vacationPay;
		this.firstDay = firstDay;
		this.lastDay = lastDay;
	}
	
	private String vacationPay;
	private LocalDate firstDay;
	private LocalDate lastDay;
	private String message;
	private Exception e;
}
