package it.unimib.disco.snic_scripts_generator.util;

import com.beust.jcommander.Parameter;

import it.unimib.disco.snic_scripts_generator.validator.DaysValidator;
import it.unimib.disco.snic_scripts_generator.validator.HoursValidator;
import it.unimib.disco.snic_scripts_generator.validator.MinutesAndSecondsValidator;

/**
 * This class contains all the parameters that can be specified using the program.
 */
public class SnicScriptParametersCommander {
	
	@Parameter(names={"--account", "-a"}, required = true,
			description = "It specifies the SNAC project ID formated as SNICYYYY-XX-ZZ.")
    private String account;
	
	@Parameter(names={"--days", "-d"}, description="The days that should be reserved for the job.",
			validateWith=DaysValidator.class)
	private Integer days;
	
	@Parameter(names={"--hours", "-h"}, description="The hours that should be reserved for the job.",
			validateWith=HoursValidator.class)
	private Integer hours;
	
	@Parameter(names={"--minutes", "-m"}, description="The minutes that should be reserved for the job.",
			validateWith=MinutesAndSecondsValidator.class)
	private Integer minutes;
	
	@Parameter(names={"--seconds", "-s"}, description="The seconds that should be reserved for the job.",
			validateWith=MinutesAndSecondsValidator.class)
	private Integer seconds;
	
	@Parameter(names={"--commandsFile", "-c"}, required = true,
			description = "The file with the commands that have to be executed.")
    private String commandsFile;	
	
	@Parameter(names={"--outputDirectory", "-o"}, required = true, 
			description = "The directory where to save the script files.")
    private String outputDirectory;
	
	@Parameter(names={"--help"}, help = true)
    private boolean help;

	public String getAccount() {
		return account;
	}

	public Integer getDays() {
		return days;
	}

	public Integer getHours() {
		return hours;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public Integer getSeconds() {
		return seconds;
	}
	
	public String getCommandsFile() {
		return commandsFile;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public boolean isHelp() {
		return help;
	}	
}
