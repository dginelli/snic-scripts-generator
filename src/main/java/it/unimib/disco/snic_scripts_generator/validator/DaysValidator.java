package it.unimib.disco.snic_scripts_generator.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Validator of the value associated with the parameter --days, -d.
 */
public class DaysValidator implements IParameterValidator {

	public void validate(String name, String value) throws ParameterException {
		try {
			int days = Integer.parseInt(value);
			
			if (days < 0 || days > 7) {
			      throw new ParameterException("Parameter " + name + " should be positive and less than 7 (found " + value +")");
			}
			
		} catch(NumberFormatException e) {
			throw new ParameterException("Parameter " + name + " must be an integer (found " + value +")");
		}
	}
}
