package ru.neoflex.neostudy.vacation_pay_calculator.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacationData implements Data
{
	@NotNull(message = "Поле не может быть пустым")
	private LocalDate firstDay;
	@NotNull(message = "Поле не может быть пустым")
	private LocalDate lastDay;
	@Min(value = 0, message = "Средняя зарплата не может быть меньше нуля")
	@Max(value = Integer.MAX_VALUE, message = "Вы ввели слишком большую среднюю зарплату")
	private Integer avgSalary;
}
