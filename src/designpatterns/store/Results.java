package designpatterns.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results implements StdoutDisplayInterface {
	
	private List<ArrayList<String>> studentRec;
	private ArrayList<ArrayList<String>> studentRecOrig;
    
	//output String array studentAlot
    private ArrayList<ArrayList<String>> studentAlot;
    
    //private List<Boolean> student_updated;
    private int [] student_updated;
    private String [] student_firstUpdated;
    //array to store total preference count for each student
    private int [] totalPrefScore;
    
    //for calculating average preference score
    private int totalAllPrefScore;
    
    
    public Results(){
    	studentRec = Collections.synchronizedList(new ArrayList<ArrayList<String>>());
    	studentAlot = new ArrayList<ArrayList<String>>();
    	studentRecOrig = new ArrayList<ArrayList<String>>();
    	//student_updated = new ArrayList<Boolean>();
    	student_updated = new int[80];
    	student_firstUpdated = new String[80];
    	for(int i=0;i<80;i++){
    		student_firstUpdated[i] = "";
    		student_updated[i]=0;
    	}
    	//studentRec = new String[80][8];
	    //studentAlot = new String[80][7];
	    //studentRecOrig = new String[80][8];
	    totalPrefScore = new int[80];
	    totalAllPrefScore = 0;
    }
    
    public synchronized String get_studentRec(int i, int j){
    	return studentRec.get(i).get(j);
    }
    
    public synchronized void set_studentRec(int i, int j, String value){
    	studentRec.get(i).set(j,value);
    }
/*    
    public synchronized boolean isStudent_updated(int i){
    	return student_updated.get(i);
    }
    
    public synchronized void studentUpdate(int i){
    	System.out.println(student_updated);
    	student_updated.set(i,true);
    }
*/  
    
    //1st studentUpdate value check
    
    public synchronized void set_student_firstUpdated(int i, String value){
    	student_firstUpdated[i]=value;
    	System.out.println("student_firstUpdated["+i+"]:"+student_firstUpdated[i]+".");
    }
    
    public synchronized String get_student_firstUpdated(int i){
    	return student_firstUpdated[i];
    }
    
    
    //isUpdated check
    
    public synchronized int get_student_updated(int i){
    	return student_updated[i];
    }
    
    public synchronized void UpdateStudent(int i){
    	++student_updated[i];
    	System.out.println("student_updated["+i+"]: "+student_updated[i]);
    }
    
    
    public synchronized String get_studentAlot(int i, int j){
    	return studentAlot.get(i).get(j);
    }
    
    
    public synchronized void set_studentAlot(int i, int j, String value){
    	studentAlot.get(i).set(j,value);
    }

    public synchronized int getSizeRec(){
    	return studentRec.size();
    }
    
    
    public synchronized int get_totalAllPrefScore(){
    	return totalAllPrefScore;
    }
    
    public synchronized void set_totalAllPrefScore(int value){
    	totalAllPrefScore=value;
    }
    
    public synchronized void backup_studentRec(){
    	
		for(int i=0;i<studentRec.size();i++){
			studentRecOrig.add(new ArrayList<String>());
			for(int j=0;j<studentRec.get(i).size();j++){
				studentRecOrig.get(i).add(studentRec.get(i).get(j));
			}
		}

    }

    public synchronized void addNew_studentRec(String [] temp){
			studentRec.add(new ArrayList<String>());
			//student_updated.add(false);
			studentRecOrig.add(new ArrayList<String>());
			for(int j=0;j<temp.length;j++){
    			studentRec.get(studentRec.size()-1).add(temp[j]);
    			studentRecOrig.get(studentRecOrig.size()-1).add(temp[j]);
			}
    }

  //calculating total preference score of all 80 students
    public synchronized void avg_prefScore(){
        
 	    for(int i=0;i<studentAlot.size();i++)
 	    {
 	    	
 	    	studentAlot.get(i).add(String.valueOf(totalPrefScore[i]));
 	    	totalAllPrefScore = totalPrefScore[i]+totalAllPrefScore;
 	    }
	}
    
  //map subjects to students in final array according to preferences
    public synchronized void assign_courseNames(){
    	for(int i=0;i<studentRec.size();i++){
    		studentAlot.add(new ArrayList<String>());
    		studentAlot.get(i).add( studentRec.get(i).get(0));
    	}
    	
	    for(int k=1;k<6;k++){
		    for(int i=0;i<studentRec.size();i++){	    	
		    	for(int j=1;j<8;j++){
		    		if(Integer.parseInt(studentRec.get(i).get(j))==k){
		    			if(j==1) studentAlot.get(i).add("A");
		    			if(j==2) studentAlot.get(i).add("B");
		    			if(j==3) studentAlot.get(i).add("C");
		    			if(j==4) studentAlot.get(i).add("D");
		    			if(j==5) studentAlot.get(i).add("E");
		    			if(j==6) studentAlot.get(i).add("F");
		    			if(j==7) studentAlot.get(i).add("G");
		    		}
		    	}
		    }
	    }
    }
    
    // calculate total Preference Score for each student
    public synchronized void calc_totalPrefScore(){
        
        //initializing totalPrefScore
       for(int i=0;i<80;i++){
       	totalPrefScore[i]=0;
       }
       
       //check if students got any of their 1st 5 preferences and assign score accordingly.
       for(int i=0;i<studentRecOrig.size();i++){
       	    		
     		for(int j=1;j<studentRecOrig.get(i).size();j++){
     			
       		if(studentRecOrig.get(i).get(j).equals("1")){
       			if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
       				totalPrefScore[i]=totalPrefScore[i]+1;
       			}
       		}
       		else{
     				
     				if(studentRecOrig.get(i).get(j).equals("2")){
     					if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
   	    				totalPrefScore[i]=totalPrefScore[i]+2;
   	    			}
     				}
   		    	else{
   		    		
   		    		if(studentRecOrig.get(i).get(j).equals("3")){
   		    			if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
   		    				totalPrefScore[i]=totalPrefScore[i]+3;
   		    			}
   		    		}
   		    		else{
   		    			if(studentRecOrig.get(i).get(j).equals("4")){
   		    				if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
   			    				totalPrefScore[i]=totalPrefScore[i]+4;
   			    			}
   		    			}
   		    			else{
       		    			if(studentRecOrig.get(i).get(j).equals("5")){
       		    				if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
       			    				totalPrefScore[i]=totalPrefScore[i]+5;
       			    			}
       		    			}
       		    			else{
           		    			if(studentRecOrig.get(i).get(j).equals("6")){
           		    				if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
           			    				totalPrefScore[i]=totalPrefScore[i]+6;
           			    			}
           		    			}
           		    			else{
               		    			if(studentRecOrig.get(i).get(j).equals("7")){
               		    				if((studentRec.get(i).get(j)).equals("1") || (studentRec.get(i).get(j)).equals("2") || (studentRec.get(i).get(j)).equals("3") || (studentRec.get(i).get(j)).equals("4") || (studentRec.get(i).get(j)).equals("5")){
               			    				totalPrefScore[i]=totalPrefScore[i]+7;
               			    			}
               		    			}
           		    			}
       		    			}
   		    			}
   		    		}	
   		    		
   		    	}
       		}
       	}
       		
       }
	   } 
    
    
    
    // appropriate method to save prime number to the data structure

    public void writeScheduleToScreen() {
	// ..
    }
	
	public void writeScheduleToFile() {
	// ..
    }
}
