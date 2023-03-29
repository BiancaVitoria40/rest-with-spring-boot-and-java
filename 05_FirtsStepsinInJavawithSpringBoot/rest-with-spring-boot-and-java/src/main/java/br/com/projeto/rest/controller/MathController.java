package br.com.projeto.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.rest.converters.NumberConverter;
import br.com.projeto.rest.exceptions.UnsupportedMathOperationException;
import br.com.projeto.rest.math.SimpleMath;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET) 
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		  if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			  throw new UnsupportedMathOperationException("Please set a numeric value");
		  }
	      return math.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/divisao/{numberOne}/{numberTwo}", method=RequestMethod.GET) 
	public Double divisao(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		  if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			  throw new UnsupportedMathOperationException("Please set a numeric value");
		  }
		  return math.divisao(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplica/{numberOne}/{numberTwo}", method=RequestMethod.GET) 
	public Double multiplica(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		  if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			  throw new UnsupportedMathOperationException("Please set a numeric value");
		  }
		  return math.multiplica(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	   
	}
	
	@RequestMapping(value = "/subtratic/{numberOne}/{numberTwo}", method=RequestMethod.GET) 
	public Double subtratic(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		  if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			  throw new UnsupportedMathOperationException("Please set a numeric value");
		  }
		  return math.subtratic(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}

	
}
