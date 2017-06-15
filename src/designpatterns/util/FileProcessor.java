package designpatterns.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileProcessor {
	private Scanner x;
	String ip_file, op_file;
	File file;
	
	public FileProcessor(String inputfile, String outputfile){
		ip_file = inputfile;
		op_file = outputfile;
		try {
			x = new Scanner(new File(ip_file)).useDelimiter("\\s\\n");
			
			file = new File(op_file);
			if(!file.exists()) {
				file.createNewFile();
			}
			file.setWritable(true);
		} catch(Exception e) {
			System.out.println("could not find file");
		}	
	}
	
	public synchronized String readFromFile() {
		if(x.hasNext()) 		
	          return x.nextLine();
	    return null;
	}
}
