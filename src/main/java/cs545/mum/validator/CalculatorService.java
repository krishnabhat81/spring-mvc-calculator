package cs545.mum.validator;

import cs545.mum.domain.Calculator;

public interface CalculatorService {

	public Integer getSum(Calculator calc);

	public Integer getProd(Calculator calc);

}