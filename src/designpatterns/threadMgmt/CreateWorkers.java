package designpatterns.threadMgmt;

import designpatterns.util.FileProcessor;
import designpatterns.store.ObjectPool;
import designpatterns.store.Results;

public class CreateWorkers {
	// this class has the method startWokers(...)
	FileProcessor fp;
	Results res;
	ObjectPool ob;
	
	Thread [] threads;
	public CreateWorkers(FileProcessor fileprocessor, Results results,ObjectPool obj){
		fp = fileprocessor;
		res = results;
		ob=obj;
		
	}
	public void startWorkers(int NUM_THREADS){
		
		threads = new Thread[NUM_THREADS];
		
		for(int i=0;i<NUM_THREADS;i++){
			threads[i]=new Thread(new WorkerThread(fp,res,ob));
			threads[i].start();
		}
		
		for(int i=0;i<NUM_THREADS;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(threads[0].getName());
		
	}
}
