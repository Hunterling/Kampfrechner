package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.WriteFile;

class TestWriteFile {

	@Test
	void simpleStarTest() {
		WriteFile writer = new WriteFile();
		writer.write("D:\\testDB","filename.txt");
	
		
	}

}
