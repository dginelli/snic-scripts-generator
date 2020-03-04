package it.unimib.disco.snic_scripts_generator.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import it.unimib.disco.snic_scripts_generator.util.SnicScriptParametersCommander;

/**
 * This class generates the script files according to the values passed as parameters.
 */
public class ScriptGenerator {
	
	private static final String MAIN_SCRIPT_FILE = "main.sh";
	private static final String SCRIPT_FOLDER_NAME = "jobs";
	private static final String SCRIPT_BASE_FILE_NAME = "script-";
	
	private SnicScriptParametersCommander snicScriptParametersCommander;
	
	public ScriptGenerator(SnicScriptParametersCommander snicScriptParametersCommander) {
		this.snicScriptParametersCommander = snicScriptParametersCommander;
	}
	
	private String getTime() {
		String days = "0";
		
		if (snicScriptParametersCommander.getDays() != null) {
			days = String.valueOf(snicScriptParametersCommander.getDays());
		}
		
		String hours = "00";
		
		if (snicScriptParametersCommander.getHours() != null) {
			hours = String.format("%02d", snicScriptParametersCommander.getHours());
		}
		
		String minutes = "00";
		
		if (snicScriptParametersCommander.getMinutes() != null) {
			minutes = String.format("%02d", snicScriptParametersCommander.getMinutes());
		}
		
		String seconds = "00";
		
		if (snicScriptParametersCommander.getSeconds() != null) {
			seconds = String.format("%02d", snicScriptParametersCommander.getSeconds());
		}
		
		return days + "-" + hours + ":" + minutes + ":" + seconds;
	}
	
	public void writeScriptFile() {
		Charset utf8 = StandardCharsets.UTF_8;
		
		Writer mainFile = null;
		Writer scriptFileWriter = null;
		
		String commandsFile = this.snicScriptParametersCommander.getCommandsFile();
		String outputDirectory = this.snicScriptParametersCommander.getOutputDirectory();
		String account = this.snicScriptParametersCommander.getAccount();
		String time = getTime();
		
		try {
			FileInputStream fileInputStream = new FileInputStream(commandsFile);
			Scanner scanner = new Scanner(fileInputStream);
			
			Files.createDirectories(Paths.get(outputDirectory + File.separator + SCRIPT_FOLDER_NAME));
			
			mainFile = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(outputDirectory + File.separator + MAIN_SCRIPT_FILE), true), utf8));

			mainFile.write("#!/bin/bash\n\n");
			
			int count = 1;
			
			while(scanner.hasNextLine()) {
				
				String command = scanner.nextLine();
				
				scriptFileWriter = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(
								new File(outputDirectory + File.separator + SCRIPT_FOLDER_NAME + File.separator 
										+ SCRIPT_BASE_FILE_NAME + count + ".sh")), utf8));
	        	
				scriptFileWriter.write("#!/bin/bash\n\n");
				scriptFileWriter.write("#SBATCH -A " + account + "n\n");
				scriptFileWriter.write("#SBATCH --time=" + time + "\n\n");
				
				mainFile.write("sbatch " + "jobs/" + SCRIPT_BASE_FILE_NAME + count + ".sh" + "\n");
				
				scriptFileWriter.write("srun " + command);
				mainFile.flush();
				scriptFileWriter.flush();
				scriptFileWriter.close();
				
				count++;
			}
			mainFile.close();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
