package com.gojek.parkinglot.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashish_Payal
 *
 */
public class CommandParser {

	/**
	 * @param fileName
	 * @return List of Commands from file
	 */
	public List<String> parseFileInput(String fileName) {
		
	  List<String> commands = new ArrayList<String>();
	  Path path = Paths.get(fileName);
      try {
    	  commands = Files.readAllLines(path);
    	 
		} catch (IOException e) {
			e.printStackTrace();
		}
      return commands;
	}

}
