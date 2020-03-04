package it.unimib.disco.snic_scripts_generator;

import com.beust.jcommander.JCommander;

import it.unimib.disco.snic_scripts_generator.util.SnicScriptParametersCommander;
import it.unimib.disco.snic_scripts_generator.writer.ScriptGenerator;

/**
 * This class is the main entry point for the script files generator.
 */
public class App {
	
	private static final String APP_NAME = "SNIC Scripts Generator";
	
	public static void main(String[] args) {
		
		SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
		
		JCommander jCommander = JCommander.newBuilder().addObject(snicScriptParametersCommander).build();
		jCommander.setProgramName(APP_NAME);
		
		jCommander.parse(args);
		
		checkTimeParameters(snicScriptParametersCommander, jCommander);
		
		if (snicScriptParametersCommander.isHelp()) {
        	jCommander.usage();
        }
		
		ScriptGenerator scriptGenerator = new ScriptGenerator(snicScriptParametersCommander);
		scriptGenerator.writeScriptFile();
		
		System.out.println("Process ended");
    }
	
	private static void checkTimeParameters(SnicScriptParametersCommander snicScriptParametersCommander, JCommander jCommander) {
		if (snicScriptParametersCommander.getDays() == null && snicScriptParametersCommander.getHours() == null &&
			snicScriptParametersCommander.getMinutes() == null && snicScriptParametersCommander.getSeconds() == null) {
				
			System.err.println("Error: you have to specify at least one of these parameters: -d, -h, -m, -s");
			jCommander.usage();
			
			System.exit(-1);
		}
	}
}
