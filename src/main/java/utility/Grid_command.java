package utility;

import java.io.IOException;

import org.testng.annotations.Test;


//***** Below is code to execute the shell script file (placed at particular location)which has commands to start a node and hub  ****

public class Grid_command {

	
	
	@Test
	public void cmdd() throws IOException, Exception {
		Runtime.getRuntime().exec("/Users/maypanwa/Documents/Home/TRY/mayankhost.command");
		Runtime.getRuntime().exec("//Users/maypanwa/Documents/Home/TRY/mayanknode.command");
		Thread.sleep(5000);
	}
}
