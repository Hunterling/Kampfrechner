package database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {

	public void write(String destination, String name) {
		try {
			
			if(Files.exists(Paths.get(destination))){
				File myObj = new File(destination + "\\"+name);
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			}
			else
				System.out.println("The given path " + destination + " doesn't exist or could not be found!");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
