import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Timers {
	
	Timer t;
	Timer tE;
	Timer car;
	CharacterCar car2;
	private int counter=0;
	private int counter2=0;
	private JLabel timerFinished;
	private JLabel timerEnding;
	private JLabel cars;
	
	public Timers(CharacterCar car2,JLabel cars,JLabel timerEnding,JLabel timerFinished) {
		
		this.timerFinished=timerFinished;
		this.timerEnding=timerEnding;
		this.cars=cars;
		this.car2=car2;
	}
	
	
	public void timer(JLabel timerFinished) {
		
	this.timerFinished=timerFinished;
	
	t = new Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {	    	  
        	  
        	  	System.out.println(counter);
        	  	counter++;
        	  	
        	  	if(counter==10) {
        	  		t.stop();
        	  		timerFinished.setText("True");
        	  		counter=0;
        	  		
        	  	}
        	  	  	
          }
       }
			
			); t.start();        	  		
				
}
	
	
	public void timerE(JLabel timerEnding) {
		
		this.timerEnding=timerEnding;
		
		if(this.timerEnding.getText().equals("False")) {
			
		tE = new Timer(1000, new ActionListener() {
	          public void actionPerformed(ActionEvent e) {	    	  
	        	  
	        	  System.out.println(counter2);
	        	  	counter2++;
	        	  	
	        	  	if(counter2==6) {
	        	  		tE.stop();
	        	  		timerEnding.setText("True");
	        	  		counter2=0;
	        	  		
	        	  	}
	        	  	  	
	          }
	       }
				
				); tE.start();   this.timerEnding.setText("True");     	  		
					
	}
		
	}
	
	
	public void timerCar(CharacterCar car2,JLabel cars,JLabel timerEnding) {
		this.cars=cars;
		this.car2=car2;
		this.timerEnding=timerEnding;
		
		car = new Timer(3,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(car2.getPositionX()==-439) {
					
					car2.setPositionX(800);
					
				}
				
				
				car2.setPositionX(car2.getPositionX()-1);
				
				
				if(timerEnding.getText().equals("True")) {
					
					car.stop();
				}
				
			}	
			
		});car.start();  this.cars.setText("True");
		
		
	}
	
	
	



}
