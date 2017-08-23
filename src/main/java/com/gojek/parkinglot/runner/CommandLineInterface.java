package com.gojek.parkinglot.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.gojek.parkinglot.executor.CommandExecutor;
import com.gojek.parkinglot.parser.CommandParser;

/**
 * @author Ashish_Payal
 *
 */
public class CommandLineInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommandParser parser = new CommandParser();
		CommandExecutor executor = new CommandExecutor();
		
		switch (args.length) {
        case 0:
            System.out.println("Please enter 'quit' to quit");
            System.out.println("Input: ");
            // Interactive: command-line input/output
            while(true) {
                try {
                    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                    String inputString = bufferRead.readLine();
                    if (inputString.equalsIgnoreCase("quit")) {
                        break;
                    } else if ((inputString == null) || (inputString.isEmpty())) {
                        // Do nothing if input is null or empty
                    } else {
                        executor.execute(inputString.trim());
                    }
                } catch(IOException e) {
                    System.out.println("Error in reading the input from console. Please try again");
                    e.printStackTrace();
                }
            }
            break;
        case 1:
            // File input/output
            List<String>commands  = parser.parseFileInput(args[0]);
            for(String command: commands){
            	executor.execute(command);
            }
            break;
        default:
            System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
    }
	}
}
