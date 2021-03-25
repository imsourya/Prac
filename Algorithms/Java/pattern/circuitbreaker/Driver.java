package duega.pattern.circuitbreaker;

import java.util.Random;
import java.util.Set;

class ProcessMessage implements Runnable {
	final static int MAX_PROCESS = 40; 
	@Override
	public void run() {
		
		if(Thread.activeCount()-1 < MAX_PROCESS) {
			try {
				System.out.println("Hey Thread "+Thread.currentThread().getId()+" | Now wait");
				Thread.sleep(3000);
				System.out.println("Exiting "+Thread.currentThread().getId());
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}else {
			System.out.println("Can Not process Message, Outflow!!!"+(Thread.activeCount()-1));      // Circuit Opening
		}
	}
}

public class Driver {
	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		
		System.out.println(Thread.activeCount());
		System.out.println(Thread.currentThread().getId());
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		
		for (Thread thread : threads) {
			System.out.println("--->"+thread.getId()+" name="+thread.getName()+"  group"+thread.getThreadGroup().getName());
		}
		System.out.println("--------------------------------------");
		
		Random rand = new Random();
		
		int value = rand.nextInt()%100;
		
		value = 40;
		
		System.out.println("Number of Message"+value);
		
		for(int i=0; i<value; i++) {
			Thread t1 = new Thread(new ProcessMessage());
			t1.start();
		}
		
		System.out.println("count="+Thread.getAllStackTraces().size());
	}
}
