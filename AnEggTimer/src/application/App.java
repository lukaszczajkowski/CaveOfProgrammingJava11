package application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

class Starter implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Timer is running");
	}
}

class Alert implements Runnable {
	
	@Override
	public void run() {
		JOptionPane.showMessageDialog(null, "Egg cooked!");
	}
	
}

public class App {

	public static void main(String[] args) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		executor.scheduleAtFixedRate(new Starter(), 0, 10L, TimeUnit.SECONDS);
		executor.scheduleAtFixedRate(new Alert(), 30L, 30L, TimeUnit.SECONDS);
	}

}
