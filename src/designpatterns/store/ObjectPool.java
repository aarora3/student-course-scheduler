package designpatterns.store;

public class ObjectPool {
	private int [] courseSeats;
	static ObjectPool objInst;
	
	private ObjectPool(){
		courseSeats= new int [7];
		objInst=null;
		for(int i=0;i<7;i++){
			courseSeats[i]=60;
		}
	}
	
	public static ObjectPool getUniqueInstance(){
		if(objInst == null){
			objInst=new ObjectPool();
		}
		return objInst;
	}

	public synchronized int return_courseSeats(int i){
		return (++courseSeats[i]);
	}

	public synchronized boolean check_courseSeatsAvail(int i){
		return (courseSeats[i]<0);
	}
	
	public synchronized int get_courseSeats(int i){
		return courseSeats[i];
	}

	public synchronized int borrow_courseSeats(int i){
		return (--courseSeats[i]);
	}


}
