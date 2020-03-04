package it.unimib.disco.snic_scripts_generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import it.unimib.disco.snic_scripts_generator.util.SnicScriptParametersCommander;

public class AppTest {
    
	@Test
	public void testCommandsShortVersion() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
    		"-a", "accountValue", 
    		"-d", "1",
    		"-h", "2",
    		"-m", "3",
    		"-s", "4",
    		"-c", "commandsFileValue",
    		"-o", "outputDirectoryValue"
    	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);

    	assertEquals("accountValue", snicScriptParametersCommander.getAccount());
    	assertEquals(1, snicScriptParametersCommander.getDays().intValue());
    	assertEquals(2, snicScriptParametersCommander.getHours().intValue());
    	assertEquals(3, snicScriptParametersCommander.getMinutes().intValue());
    	assertEquals(4, snicScriptParametersCommander.getSeconds().intValue());
    	assertEquals("commandsFileValue", snicScriptParametersCommander.getCommandsFile());
    	assertEquals("outputDirectoryValue", snicScriptParametersCommander.getOutputDirectory());
    }
	
	@Test
	public void testCommandsLongVersion() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "2",
        		"--minutes", "3",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);

    	assertEquals("accountValue", snicScriptParametersCommander.getAccount());
    	assertEquals(1, snicScriptParametersCommander.getDays().intValue());
    	assertEquals(2, snicScriptParametersCommander.getHours().intValue());
    	assertEquals(3, snicScriptParametersCommander.getMinutes().intValue());
    	assertEquals(4, snicScriptParametersCommander.getSeconds().intValue());
    	assertEquals("commandsFileValue", snicScriptParametersCommander.getCommandsFile());
    	assertEquals("outputDirectoryValue", snicScriptParametersCommander.getOutputDirectory());
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsDaysParameterExceedUpperLimit() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "8",
        		"--hours", "2",
        		"--minutes", "3",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsDaysParameterNegativeValue() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "-1",
        		"--hours", "2",
        		"--minutes", "3",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsHoursParameterExceedUpperLimit() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "24",
        		"--minutes", "3",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsHoursParameterNegativeValue() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "-2",
        		"--minutes", "3",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsMinutesParameterExceedUpperLimit() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "0",
        		"--hours", "1",
        		"--minutes", "60",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsMinutesParameterNegativeValue() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "2",
        		"--minutes", "-2",
        		"--seconds", "4",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsSecondsParameterExceedUpperLimit() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "0",
        		"--hours", "1",
        		"--minutes", "60",
        		"--seconds", "61",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsSecondsParameterNegativeValue() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "2",
        		"--minutes", "3",
        		"--seconds", "-1",
        		"--commandsFile", "commandsFileValue",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsMissingCommandsFile() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "2",
        		"--minutes", "3",
        		"--seconds", "1",
        		"--outputDirectory", "outputDirectoryValue"
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
	
	@Test(expected = ParameterException.class)
	public void testCommandsMissingOutputDirectory() {
    	SnicScriptParametersCommander snicScriptParametersCommander = new SnicScriptParametersCommander();
    	String[] args = {
        		"--account", "accountValue", 
        		"--days", "1",
        		"--hours", "2",
        		"--minutes", "3",
        		"--seconds", "1",
        		"--commandsFile", "commandsFileValue",
        	};
    	
    	JCommander.newBuilder().addObject(snicScriptParametersCommander).build().parse(args);
    }
}
