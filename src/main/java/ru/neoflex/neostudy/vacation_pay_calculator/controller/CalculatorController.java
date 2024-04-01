package ru.neoflex.neostudy.vacation_pay_calculator.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.neoflex.neostudy.vacation_pay_calculator.application.Application;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.Result;
import ru.neoflex.neostudy.vacation_pay_calculator.entity.VacationData;
import ru.neoflex.neostudy.vacation_pay_calculator.util.VacationDataValidator;

@Controller
public class CalculatorController
{
	private final Application application;
	private final VacationDataValidator vacationDataValidator;
	
	public CalculatorController(Application application, VacationDataValidator vacationDataValidator)
	{
		this.application = application;
		this.vacationDataValidator = vacationDataValidator;
	}
	
	@GetMapping("/")
	public String viewHomePage(@ModelAttribute("vacationData")VacationData vacationData)
	{
		return "calculator/index";
	}
	
	@PostMapping("/calculate")
	public String calculateVacationPay(@ModelAttribute("vacationData") @Valid VacationData vacationData,
									   BindingResult bindingResult,
									   Model model)
	{
		vacationDataValidator.validate(vacationData, bindingResult);
		
		if (bindingResult.hasErrors())
			return "calculator/index";
		Result result = application.run(vacationData);
		model.addAttribute("result", result);
		return "calculator/result";
	}
}
