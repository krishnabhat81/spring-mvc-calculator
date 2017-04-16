package cs545.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs545.mum.domain.Calculator;
import cs545.mum.validator.CalculatorService;
import cs545.mum.validator.CalculatorValidator;

@Controller
public class CalculatorController {
	@Autowired
	CalculatorValidator calcValidator;
	@Autowired
	CalculatorService calcService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = { "/calculator" })
	public String calculator() {
		return "calculator";
	}

	@RequestMapping(value = "/submit")
	public String saveProduct(Calculator calculator, RedirectAttributes redirectAttributes) {
		List<String> errors = calcValidator.validate(calculator);

		if (errors.isEmpty()) {
			calcService.getSum(calculator);
			calcService.getProd(calculator);
			
			redirectAttributes.addAttribute("welcome", "Welcome");
			redirectAttributes.addFlashAttribute("calc", calculator);
			return "redirect:result";
		} else {
			redirectAttributes.addAttribute("errors", errors);
			redirectAttributes.addAttribute("form", calculator);
			return "error";
		}
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(Model model) {
		return "result";
	}
}
