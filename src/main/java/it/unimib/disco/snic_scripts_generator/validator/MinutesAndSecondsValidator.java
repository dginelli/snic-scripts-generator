package it.unimib.disco.snic_scripts_generator.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Validator of the value associated with the parameter --minutes, -m, and --seconds, -s.
 */
public class MinutesAndSecondsValidator implements IParameterValidator {

	public void validate(String name, String value) throws ParameterException {
		try {
			int hours = Integer.parseInt(value);
			
			if (hours < 0 || hours > 59) {
			      throw new ParameterException("Parameter " + name + " should be positive and less than 59 (found " + value +")");
			}
			
		} catch(NumberFormatException e) {
			throw new ParameterException("Parameter " + name + " must be an integer (found " + value +")");
		}	
	}
}
