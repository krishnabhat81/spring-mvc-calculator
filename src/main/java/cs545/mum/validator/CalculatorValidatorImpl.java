package cs545.mum.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cs545.mum.domain.Calculator;

@Component
public class CalculatorValidatorImpl implements CalculatorValidator {
	
	public List<String> validate(Object  object ) {
		List<String> errors = new ArrayList<String>();
		
		Calculator calc = (Calculator) object;
		Integer num1 = calc.getAdd1();
		Integer num2=calc.getAdd2();
		Integer mult1=calc.getMult1();
		Integer mult2=calc.getMult2();
		if (num1==null) {
			errors.add("Add1 must not be blank");
		}
		if (num2==null) {
			errors.add("Add1 must not be blank");
		}
		if (mult1==null) {
			errors.add("Mult1 must not be blank");
		}
		if (mult2==null) {
			errors.add("Mult2 must not be blank");
		}
		
		return errors;
	}
}
