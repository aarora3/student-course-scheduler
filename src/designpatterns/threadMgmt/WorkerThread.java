package designpatterns.threadMgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import designpatterns.util.FileProcessor;
import designpatterns.store.ObjectPool;
import designpatterns.store.Results;

public class WorkerThread implements Runnable {
	
    // STATIC VARIABLES DECLARATION
    
	FileProcessor fp;
	Results res;
	ObjectPool objInst;
	String token1;

	//if a subject has preference count>60,swap it with subject with least preference count for any student record
    public synchronized void swap_courses(){
    	
        while(objInst.check_courseSeatsAvail(0) || objInst.check_courseSeatsAvail(1) || objInst.check_courseSeatsAvail(2) || objInst.check_courseSeatsAvail(3) || objInst.check_courseSeatsAvail(4) || objInst.check_courseSeatsAvail(5) || objInst.check_courseSeatsAvail(6))
        {
        //	System.out.println("in swap courses while");

        //check A
        	int replacedChoice=5;
        	int studentRecSize = res.getSizeRec();

        	if(objInst.check_courseSeatsAvail(0)){
  		    	
  		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
  		    			
  		    	//	System.out.println("swap in A, size:"+studentRecSize+" student num: "+res.get_studentRec(i,0)+" "+objInst.get_courseSeats(0)+" "+objInst.get_courseSeats(1)+" "+objInst.get_courseSeats(2)+" "+objInst.get_courseSeats(3)+" "+objInst.get_courseSeats(4)+" "+objInst.get_courseSeats(5)+" "+objInst.get_courseSeats(6));
  		    		
	  		    		if(Integer.parseInt(res.get_studentRec(i,1))==replacedChoice){
	  		    		//	System.out.println("In if A"+ replacedChoice);

	  		    			if(objInst.get_courseSeats(1)==Math.max(Math.max(objInst.get_courseSeats(1),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			
		  		    			if(( res.get_studentRec(i,2).equals("6"))||( res.get_studentRec(i,2).equals("7"))){
		  		    				
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
		  		    					String temp = res.get_studentRec(i,2);
			  			    			
			  			    			if(res.get_student_firstUpdated(i)==null)
			  	    	    				res.set_student_firstUpdated(i,temp);
			  	    	    			else
			  	    	    				res.UpdateStudent(i);
			  	    	    			
			  			    			res.set_studentRec(i,2,res.get_studentRec(i,1));
			  			    			res.set_studentRec(i,1,temp);
			  	    	    			objInst.borrow_courseSeats(1);
			  	    	    			objInst.return_courseSeats(0);		  	    	    			
			  	    	    			break;
		  		    				}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(2)==Math.max(Math.max(objInst.get_courseSeats(1),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,3).equals("6"))||( res.get_studentRec(i,3).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,3);
			  		    				res.set_studentRec(i,3,res.get_studentRec(i,1));
			  		    				res.set_studentRec(i,1,temp);
			  		    				objInst.borrow_courseSeats(2);
			  		    				objInst.return_courseSeats(0);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(3)==Math.max(Math.max(objInst.get_courseSeats(1),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,4).equals("6"))||( res.get_studentRec(i,4).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,4);
			  		    				res.set_studentRec(i,4,res.get_studentRec(i,1));
			  	    	    			res.set_studentRec(i,1,temp);
			  	    	    			objInst.borrow_courseSeats(3);
			  	    	    			objInst.return_courseSeats(0);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(4)==Math.max(Math.max(objInst.get_courseSeats(1),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,5).equals("6"))||( res.get_studentRec(i,5).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,5);
			  		    				res.set_studentRec(i,5,res.get_studentRec(i,1));
			  		    				res.set_studentRec(i,1,temp);
			  	    	    			objInst.borrow_courseSeats(4);
			  	    	    			objInst.return_courseSeats(0);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(5)==Math.max(Math.max(objInst.get_courseSeats(1),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,6).equals("6"))||( res.get_studentRec(i,6).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,6);
			  		    				res.set_studentRec(i,6,res.get_studentRec(i,1));
			  	    	    			res.set_studentRec(i,1,temp);
			  	    	    			objInst.borrow_courseSeats(5);
			  	    	    			objInst.return_courseSeats(0);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(6)==Math.max(Math.max(objInst.get_courseSeats(1),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,7).equals("6"))||( res.get_studentRec(i,7).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,7);
			  		    				res.set_studentRec(i,7,res.get_studentRec(i,1));
			  	    	    			res.set_studentRec(i,1,temp);
			  	    	    			objInst.borrow_courseSeats(6);
			  	    	    			objInst.return_courseSeats(0);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
	  		    		}
	  		    	//	System.out.println("inA before if: i: "+ i+"studentRecSize: " +studentRecSize);
	  		    		if(i==(studentRecSize-1)){
	  		    			replacedChoice--;
	  		    			i=0;
	  		    		}
  		    		
  		
  			    }
  		    
  			    
  		    }
  		    
        //check B
  		  replacedChoice=5;
		    if(objInst.check_courseSeatsAvail(1)){
		    	
		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
		    		
			    		if(Integer.parseInt(res.get_studentRec(i,2))==replacedChoice){
			    	
		  		    		if(objInst.get_courseSeats(0)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			
		  		    			if(( res.get_studentRec(i,1).equals("6"))||( res.get_studentRec(i,1).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  			    			String temp = res.get_studentRec(i,1);
			  			    			res.set_studentRec(i,1,res.get_studentRec(i,2));
			  			    			res.set_studentRec(i,2,temp);
			  	    	    			objInst.borrow_courseSeats(0);
			  	    	    			objInst.return_courseSeats(1);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(2)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,3).equals("6"))||( res.get_studentRec(i,3).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,3);
			  		    				res.set_studentRec(i,3,res.get_studentRec(i,2));
			  		    				res.set_studentRec(i,2,temp);
			  		    				objInst.borrow_courseSeats(2);
			  		    				objInst.return_courseSeats(1);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(3)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,4).equals("6"))||( res.get_studentRec(i,4).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,4);
			  		    				res.set_studentRec(i,4,res.get_studentRec(i,2));
			  		    				res.set_studentRec(i,2,temp);
			  	    	    			objInst.borrow_courseSeats(3);
			  	    	    			objInst.return_courseSeats(1);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(4)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,5).equals("6"))||( res.get_studentRec(i,5).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,5);
			  		    				res.set_studentRec(i,5,res.get_studentRec(i,2));
			  		    				res.set_studentRec(i,2,temp);
			  	    	    			objInst.borrow_courseSeats(4);
			  	    	    			objInst.return_courseSeats(1);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(5)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,6).equals("6"))||( res.get_studentRec(i,6).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,6);
			  		    				res.set_studentRec(i,6,res.get_studentRec(i,2));
			  		    				res.set_studentRec(i,2,temp);
			  	    	    			objInst.borrow_courseSeats(5);
			  	    	    			objInst.return_courseSeats(1);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(6)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(2)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,7).equals("6"))||( res.get_studentRec(i,7).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,7);
			  		    				res.set_studentRec(i,7,res.get_studentRec(i,2));
			  		    				res.set_studentRec(i,2,temp);
			  	    	    			objInst.borrow_courseSeats(6);
			  	    	    			objInst.return_courseSeats(1);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
			    		}
			    		if(i==(studentRecSize-1)){
			    			replacedChoice--;
			    			i=0;
			    		}
		    		
		
			    }
		    
			    
		    }
  		    
        //check C
		    replacedChoice=5;
		    if(objInst.check_courseSeatsAvail(2)){
		    	
		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
		    		
			    		if(Integer.parseInt(res.get_studentRec(i,3))==replacedChoice){
			    	
		  		    		if(objInst.get_courseSeats(0)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			
		  		    			if(( res.get_studentRec(i,1).equals("6"))||( res.get_studentRec(i,1).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,1);
			  			    			res.set_studentRec(i,1,res.get_studentRec(i,3));
			  			    			res.set_studentRec(i,3,temp);
			  	    	    			objInst.borrow_courseSeats(0);
			  	    	    			objInst.return_courseSeats(2);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(1)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,2).equals("6"))||( res.get_studentRec(i,2).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,2);
			  		    				res.set_studentRec(i,2,res.get_studentRec(i,3));
			  		    				res.set_studentRec(i,3,temp);
			  		    				objInst.borrow_courseSeats(1);
			  		    				objInst.return_courseSeats(2);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(3)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,4).equals("6"))||( res.get_studentRec(i,4).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,4);
			  		    				res.set_studentRec(i,4,res.get_studentRec(i,3));
			  		    				res.set_studentRec(i,3,temp);
			  	    	    			objInst.borrow_courseSeats(3);
			  	    	    			objInst.return_courseSeats(2);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(4)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,5).equals("6"))||( res.get_studentRec(i,5).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,5);
			  		    				res.set_studentRec(i,5,res.get_studentRec(i,3));
			  		    				res.set_studentRec(i,3,temp);
			  	    	    			objInst.borrow_courseSeats(4);
			  	    	    			objInst.return_courseSeats(2);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(5)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,6).equals("6"))||( res.get_studentRec(i,6).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,6);
			  		    				res.set_studentRec(i,6,res.get_studentRec(i,3));
			  		    				res.set_studentRec(i,3,temp);
			  	    	    			objInst.borrow_courseSeats(5);
			  	    	    			objInst.return_courseSeats(2);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(6)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(3),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,7).equals("6"))||( res.get_studentRec(i,7).equals("7"))){	
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,7);
			  		    				res.set_studentRec(i,7,res.get_studentRec(i,3));
			  		    				res.set_studentRec(i,3,temp);
			  	    	    			objInst.borrow_courseSeats(6);
			  	    	    			objInst.return_courseSeats(2);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
			    		}
			    		if(i==(studentRecSize-1)){
			    			replacedChoice--;
			    			i=0;
			    		}
		    		
		
			    }
		    
			    
		    }
  		    
        //check D
		    replacedChoice=5;
		    if(objInst.check_courseSeatsAvail(3)){
		    	
		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
		    		
			    		if(Integer.parseInt(res.get_studentRec(i,4))==replacedChoice){
			    	
		  		    		if(objInst.get_courseSeats(0)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			
		  		    			if(( res.get_studentRec(i,1).equals("6"))||( res.get_studentRec(i,1).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  			    			String temp = res.get_studentRec(i,1);
			  			    			res.set_studentRec(i,1,res.get_studentRec(i,4));
			  			    			res.set_studentRec(i,4,temp);
			  	    	    			objInst.borrow_courseSeats(0);
			  	    	    			objInst.return_courseSeats(3);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(1)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,2).equals("6"))||( res.get_studentRec(i,2).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,2);
			  		    				res.set_studentRec(i,2,res.get_studentRec(i,4));
			  		    				res.set_studentRec(i,4,temp);
			  		    				objInst.borrow_courseSeats(1);
			  		    				objInst.return_courseSeats(3);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(2)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,3).equals("6"))||( res.get_studentRec(i,3).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,3);
			  		    				res.set_studentRec(i,3,res.get_studentRec(i,4));
			  		    				res.set_studentRec(i,4,temp);
			  	    	    			objInst.borrow_courseSeats(2);
			  	    	    			objInst.return_courseSeats(3);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(4)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,5).equals("6"))||( res.get_studentRec(i,5).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,5);
			  		    				res.set_studentRec(i,5,res.get_studentRec(i,4));
			  		    				res.set_studentRec(i,4,temp);
			  	    	    			objInst.borrow_courseSeats(4);
			  	    	    			objInst.return_courseSeats(3);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(5)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,6).equals("6"))||( res.get_studentRec(i,6).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,6);
			  		    				res.set_studentRec(i,6,res.get_studentRec(i,4));
			  		    				res.set_studentRec(i,4,temp);
			  	    	    			objInst.borrow_courseSeats(5);
			  	    	    			objInst.return_courseSeats(3);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(6)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(4)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,7).equals("6"))||( res.get_studentRec(i,7).equals("7"))){	
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,7);
			  		    				res.set_studentRec(i,7,res.get_studentRec(i,4));
			  		    				res.set_studentRec(i,4,temp);
			  	    	    			objInst.borrow_courseSeats(6);
			  	    	    			objInst.return_courseSeats(3);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
			    		}
			    		if(i==(studentRecSize-1)){
			    			replacedChoice--;
			    			i=0;
			    		}
		    		
		
			    }
		    
			    
		    }
        
       //check E
		    replacedChoice=5;
		    if(objInst.check_courseSeatsAvail(4)){
		    	
		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
		    
			    		if(Integer.parseInt(res.get_studentRec(i,5))==replacedChoice){
			    	
		  		    		if(objInst.get_courseSeats(0)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			
		  		    			if(( res.get_studentRec(i,1).equals("6"))||( res.get_studentRec(i,1).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  			    			String temp = res.get_studentRec(i,1);
			  			    			res.set_studentRec(i,1,res.get_studentRec(i,5));
			  			    			res.set_studentRec(i,5,temp);
			  	    	    			objInst.borrow_courseSeats(0);
			  	    	    			objInst.return_courseSeats(4);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(1)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,2).equals("6"))||( res.get_studentRec(i,2).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,2);
			  		    				res.set_studentRec(i,2,res.get_studentRec(i,5));
			  		    				res.set_studentRec(i,5,temp);
			  		    				objInst.borrow_courseSeats(1);
			  		    				objInst.return_courseSeats(4);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(2)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,3).equals("6"))||( res.get_studentRec(i,3).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{	
			  		    				String temp = res.get_studentRec(i,3);
			  		    				res.set_studentRec(i,3,res.get_studentRec(i,5));
			  		    				res.set_studentRec(i,5,temp);
			  	    	    			objInst.borrow_courseSeats(2);
			  	    	    			objInst.return_courseSeats(4);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(3)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,4).equals("6"))||( res.get_studentRec(i,4).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,4);
			  		    				res.set_studentRec(i,4,res.get_studentRec(i,5));
			  		    				res.set_studentRec(i,5,temp);
			  	    	    			objInst.borrow_courseSeats(3);
			  	    	    			objInst.return_courseSeats(4);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(5)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,6).equals("6"))||( res.get_studentRec(i,6).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,6);
			  		    				res.set_studentRec(i,6,res.get_studentRec(i,5));
			  		    				res.set_studentRec(i,5,temp);
			  	    	    			objInst.borrow_courseSeats(5);
			  	    	    			objInst.return_courseSeats(4);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(6)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(5),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,7).equals("6"))||( res.get_studentRec(i,7).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,7);
			  		    				res.set_studentRec(i,7,res.get_studentRec(i,5));
			  		    				res.set_studentRec(i,5,temp);
			  	    	    			objInst.borrow_courseSeats(6);
			  	    	    			objInst.return_courseSeats(4);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
			    		}
			    		if(i==(studentRecSize-1)){
			    			replacedChoice--;
			    			i=0;
			    		}
		    		
		
			    }
		    
			    
		    }
        
        
       //check F
        
		    replacedChoice=5;
		    if(objInst.check_courseSeatsAvail(5)){
		    	
		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
		    		
			    		if(Integer.parseInt(res.get_studentRec(i,6))==replacedChoice){
			    	
		  		    		if(objInst.get_courseSeats(0)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(6))))){
		  		    			
		  		    			if(( res.get_studentRec(i,1).equals("6"))||( res.get_studentRec(i,1).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  			    			String temp = res.get_studentRec(i,1);
			  			    			res.set_studentRec(i,1,res.get_studentRec(i,6));
			  			    			res.set_studentRec(i,6,temp);
			  	    	    			objInst.borrow_courseSeats(0);
			  	    	    			objInst.return_courseSeats(5);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(1)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,2).equals("6"))||( res.get_studentRec(i,2).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,2);
			  		    				res.set_studentRec(i,2,res.get_studentRec(i,6));
			  		    				res.set_studentRec(i,6,temp);
			  		    				objInst.borrow_courseSeats(1);
			  		    				objInst.return_courseSeats(5);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(2)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,3).equals("6"))||( res.get_studentRec(i,3).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,3);
			  		    				res.set_studentRec(i,3,res.get_studentRec(i,6));
			  		    				res.set_studentRec(i,6,temp);
			  	    	    			objInst.borrow_courseSeats(2);
			  	    	    			objInst.return_courseSeats(5);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(3)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,4).equals("6"))||( res.get_studentRec(i,4).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,4);
			  		    				res.set_studentRec(i,4,res.get_studentRec(i,6));
			  		    				res.set_studentRec(i,6,temp);
			  	    	    			objInst.borrow_courseSeats(3);
			  	    	    			objInst.return_courseSeats(5);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(4)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,5).equals("6"))||( res.get_studentRec(i,5).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,5);
			  		    				res.set_studentRec(i,5,res.get_studentRec(i,6));
			  		    				res.set_studentRec(i,6,temp);
			  	    	    			objInst.borrow_courseSeats(4);
			  	    	    			objInst.return_courseSeats(5);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(6)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(6))))){
		  		    			if(( res.get_studentRec(i,7).equals("6"))||( res.get_studentRec(i,7).equals("7"))){	
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,7);
			  		    				res.set_studentRec(i,7,res.get_studentRec(i,6));
			  		    				res.set_studentRec(i,6,temp);
			  	    	    			objInst.borrow_courseSeats(6);
			  	    	    			objInst.return_courseSeats(5);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
			    		}
			    		if(i==(studentRecSize-1)){
			    			replacedChoice--;
			    			i=0;
			    		}
		    		
		
			    }
		    
			    
		    }
        
        
       //check G
		    
		    replacedChoice=5;
		    if(objInst.check_courseSeatsAvail(6)){
		    	
		    	for(int i=0;i<studentRecSize && replacedChoice>0;i++){
		    		
		    		
		    		
			    		if(Integer.parseInt(res.get_studentRec(i,7))==replacedChoice){
			    	
		  		    		if(objInst.get_courseSeats(0)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(5))))){
		  		    			
		  		    			if(( res.get_studentRec(i,1).equals("6"))||( res.get_studentRec(i,1).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  			    			String temp = res.get_studentRec(i,1);
			  			    			res.set_studentRec(i,1,res.get_studentRec(i,7));
			  			    			res.set_studentRec(i,7,temp);
			  	    	    			objInst.borrow_courseSeats(0);
			  	    	    			objInst.return_courseSeats(6);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(1)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(5))))){
		  		    			if(( res.get_studentRec(i,2).equals("6"))||( res.get_studentRec(i,2).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,2);
			  		    				res.set_studentRec(i,2,res.get_studentRec(i,7));
			  		    				res.set_studentRec(i,7,temp);
			  		    				objInst.borrow_courseSeats(1);
			  		    				objInst.return_courseSeats(6);
			  		    				res.set_student_firstUpdated(i,temp);
			  		    				res.UpdateStudent(i);
			  		    				break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(2)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(5))))){
		  		    			if(( res.get_studentRec(i,3).equals("6"))||( res.get_studentRec(i,3).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,3);
			  		    				res.set_studentRec(i,3,res.get_studentRec(i,7));
			  		    				res.set_studentRec(i,7,temp);
			  	    	    			objInst.borrow_courseSeats(2);
			  	    	    			objInst.return_courseSeats(6);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(3)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(5))))){
		  		    			if(( res.get_studentRec(i,4).equals("6"))||( res.get_studentRec(i,4).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,4);
			  		    				res.set_studentRec(i,4,res.get_studentRec(i,7));
			  		    				res.set_studentRec(i,7,temp);
			  	    	    			objInst.borrow_courseSeats(3);
			  	    	    			objInst.return_courseSeats(6);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(4)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(5))))){
		  		    			if(( res.get_studentRec(i,5).equals("6"))||( res.get_studentRec(i,5).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,5);
			  		    				res.set_studentRec(i,5,res.get_studentRec(i,7));
			  		    				res.set_studentRec(i,7,temp);
			  	    	    			objInst.borrow_courseSeats(4);
			  	    	    			objInst.return_courseSeats(6);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		if(objInst.get_courseSeats(5)==Math.max(Math.max(objInst.get_courseSeats(0),objInst.get_courseSeats(1)), Math.max(Math.max(objInst.get_courseSeats(2),objInst.get_courseSeats(3)),Math.max(objInst.get_courseSeats(4),objInst.get_courseSeats(5))))){
		  		    			if(( res.get_studentRec(i,6).equals("6"))||( res.get_studentRec(i,6).equals("7"))){
		  		    				if((!res.get_student_firstUpdated(i).equals(res.get_studentRec(i,2)))&&res.get_student_updated(i)<2)
			  			    		{
			  		    				String temp = res.get_studentRec(i,6);
			  		    				res.set_studentRec(i,6,res.get_studentRec(i,7));
			  		    				res.set_studentRec(i,7,temp);
			  	    	    			objInst.borrow_courseSeats(5);
			  	    	    			objInst.return_courseSeats(6);
			  	    	    			res.set_student_firstUpdated(i,temp);
			  	    	    			res.UpdateStudent(i);
			  	    	    			break;
			  			    		}
		  		    			}
		  		    		}
		  		    		
			    		}
			    		if(i==(studentRecSize-1)){
			    			replacedChoice--;
			    			i=0;
			    		}
		    		
		
			    }
		    
			    
		    
		    }
		    
        }
     }
    
    

     
    
    
     
    
    
      
    
	  
    public WorkerThread(FileProcessor fileprocessor, Results results, ObjectPool ob){
    	  fp = fileprocessor;
    	  res = results;
    	  objInst= ob;
      }
   
/*	public synchronized void read_input(){
    		token1 = fp.readFromFile();
    		if(token1!=null){    			
    			System.out.println(token1);
   				res.addNew_studentRec(token1);	
    		}
	}
*/	
	public void run() {
			System.out.println("Worker thread!");
		    token1="";
		    token1 = fp.readFromFile();
		    while(token1!=null){
	    		if(token1!=null){	    			
	    			//System.out.println(token1);
	    			String [] temp = token1.split("\\s+");
	    			for(int i=1;i<temp.length;i++){
	    				if(Integer.parseInt(temp[i])<6)
	    					objInst.borrow_courseSeats(i-1);
	    			}
	    			res.addNew_studentRec(temp);	
	    		}
 	        //to swap courses where more than 10 students have the course as 1st, 2nd or 3rd objInst.get_courseSeats(4)rence.
	        swap_courses();
/*	    		
	    	System.out.println("\n\nget_courseSeats(0): "+objInst.get_courseSeats(0));
	    	System.out.println("get_courseSeats(1): "+objInst.get_courseSeats(1));
	    	System.out.println("get_courseSeats(2): "+objInst.get_courseSeats(2));
	    	System.out.println("get_courseSeats(3): "+objInst.get_courseSeats(3));
	    	System.out.println("get_courseSeats(4): "+objInst.get_courseSeats(4));
	    	System.out.println("get_courseSeats(5): "+objInst.get_courseSeats(5));
	    	System.out.println("get_courseSeats(6): "+objInst.get_courseSeats(6));
*/	    	
	    	
	        token1 = fp.readFromFile();

		 }
	           
	     
	  	    
	  	}
		    
		    
	    
}
