package designpatterns.driver;


import designpatterns.util.FileProcessor;
//import designpatterns.ObjectPool;
import designpatterns.util.Logger;
import designpatterns.threadMgmt.CreateWorkers;
import designpatterns.store.ObjectPool;
import designpatterns.store.Results;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	static int NUM_THREADS;
    static int DEBUG_VALUE;
    
    
	public static void main(String args[]) throws IOException	{  
    //COMMAND LINE ARGUMENTS CHECK

	  //validating command line arguments    
	    if(args.length != 4){
	      System.out.println("\nWrong number of command line arguments (see run instructions), terminating program.\n");
	      System.exit(0);
	    }
	    
	    //Validating NUM_THREADS
	    if(Integer.parseInt(args[2])>=1 && Integer.parseInt(args[2])<=3){
	      NUM_THREADS=Integer.parseInt(args[2]);
	    }
	    else{
	      System.out.println("\nIncorrect value of NUM_THREADS (3rd command line argument), terminating program.\n");
	      System.exit(0);
	    }
	    
	    //VALIDATING DEBUG_VALUE
	    if(Integer.parseInt(args[2])>=0 && Integer.parseInt(args[3])<=4){
	      DEBUG_VALUE=Integer.parseInt(args[3]);
	    }
	    else{
	      System.out.println("\nIncorrect value of DEBUG_VALUE (4th command line argument), terminating program.\n");
	      System.exit(0);
	    }
	    
	   
    try {
    	//opening input file from 1st command line argument
    	FileProcessor fileprocessor = new FileProcessor(args[0],args[1]);
    	Results results = new Results();
    	ObjectPool ob= ObjectPool.getUniqueInstance();
        CreateWorkers createworkers = new CreateWorkers(fileprocessor,results,ob);
        createworkers.startWorkers(NUM_THREADS);
    	
  	   // inFile1.close();
        results.assign_courseNames();
        results.calc_totalPrefScore();
        results.avg_prefScore();
        
        //writing output file
  	    PrintWriter writer = new PrintWriter(args[1], "UTF-8");
  	    
  	    for(int i=0;i<results.getSizeRec();i++){
  	    	//results.set_studentAlot(i,0,results.get_studentRec(i,0));

  	    	for(int j=0;j<7;j++){
  	    		System.out.println("results.get_studentRec("+i+","+j+"): "+results.get_studentRec(i, j));
  	    		writer.print(results.get_studentAlot(i,j));
  	    		writer.print(" ");
  	    		
  	    	}
  	    	
  	    	writer.println("");
  	    }
  	    
        writer.println("");
  	    writer.print("Average Preference_score is: ");
  	    writer.print((double)(results.get_totalAllPrefScore())/80);
  	    System.out.println("File written check "+args[1]);
  	    writer.close();

  	    for(int i=0;i<7;i++){
  	    	System.out.println("course["+i+"] "+ob.get_courseSeats(i));
  	    }

        }
     catch(Exception fnfe){
    	 System.out.println("Output file not found.");
    	 fnfe.printStackTrace();
    	 System.exit(0);
     }
    
	}
}