package ru.neoflex.neostudy.vacation_pay_calculator.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result
{
	public Result(double vacationPay)
	{
		this.vacationPay = vacationPay;
	}
	
	private double vacationPay;
	private String message;
	private Exception e;
}
