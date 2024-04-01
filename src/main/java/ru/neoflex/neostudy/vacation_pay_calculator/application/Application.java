package ru.neoflex.neostudy.vacation_pay_calculator.application;

import org.springframework.stereotype.Component;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Data;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Result;
import ru.neoflex.neostudy.vacation_pay_calculator.service.Function;

@Component
//@Scope("prototype")
public class Application
{
	private final Function function;
	
	public Application(Function function)
	{
		this.function = function;
	}
	
	public Result run(Data data)
	{
		return function.execute(data);
	}
}
