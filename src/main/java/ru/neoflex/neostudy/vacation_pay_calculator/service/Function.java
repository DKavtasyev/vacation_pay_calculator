package ru.neoflex.neostudy.vacation_pay_calculator.service;

import ru.neoflex.neostudy.vacation_pay_calculator.entity.Data;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Result;

public interface Function
{
	Result execute(Data data);
}
