package cs545.mum.validator;

import org.springframework.stereotype.Service;

import cs545.mum.domain.Calculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	public Integer getSum(Calculator calc) {

		calc.setSum(calc.getAdd1() + calc.getAdd2());
		return 1;

	}

	public Integer getProd(Calculator calc) {
		calc.setProduct(calc.getMult1() * calc.getMult2());
		return 1;

	}

}
