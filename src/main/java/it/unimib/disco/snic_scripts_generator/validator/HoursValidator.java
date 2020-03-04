package it.unimib.disco.snic_scripts_generator.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Validator of the value associated with the parameter --hours, -h.
 */
public class HoursValidator implements IParameterValidator {

	public void validate(String name, String value) throws ParameterException {
		try {
			int hours = Integer.parseInt(value);
			
			if (hours < 0 || hours > 23) {
			      throw new ParameterException("Parameter " + name + " should be positive and less than 24 (found " + value +")");
			}
			
		} catch(NumberFormatException e) {
			throw new ParameterException("Parameter " + name + " must be an integer (found " + value +")");
		}	
	}
}
