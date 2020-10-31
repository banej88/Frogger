import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Timers {
	
	Timer t;
	Timer tE;
	Timer car;
	Timer animations;
	Timer background;
	Timer frog;
	CharacterCar car2;
	CharacterFrog frogMain;
	private int counter=0;
	private int counter2=0;
	private JLabel timerFinished;
	private JLabel timerEnding;
	private JLabel cars;
	int counterCarFrame=0;
	int counterBackgroundFrame=0;
	int frogCounter=0;
	JLabel frogJump;
	Component component;
	private int timerCar=0;
	private int timerBackground=0;
	
	
	
	public Timers(JLabel frogJump,CharacterFrog frogMain,CharacterCar car2,JLabel cars,JLabel timerEnding,JLabel timerFinished,Component component) {
		
		this.timerFinished=timerFinished;
		this.timerEnding=timerEnding;
		this.cars=cars;
		this.car2=car2;
		this.frogMain=frogMain;
		this.frogJump=frogJump;
		
	}
	
	
	public void timer(JLabel timerFinished) {
		
	this.timerFinished=timerFinished;
	
	t = new Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {	    	  
        	  
        	  
        	  	counter++;
        	  	
        	  	if(counter==60) {
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
	        	  
	        	//  System.out.println(counter2);
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
		
		car = new Timer(1,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(car2.getPositionX()<=-439) {
					
					car2.setPositionX(1600);
					
				}
				
				
				
				if(timerCar==5) {
				car.setDelay(3);
				}
				
				timerCar++;
				car2.setPositionX(car2.getPositionX()-3);
				
				
				if(timerEnding.getText().equals("True")) {
					
				
					car.stop();
					timerCar=0;
					
				}
				
			}	
			
		});car.start();  this.cars.setText("True");
		
		
	}
	
	
	public void timerAnimations(CharacterCar car2,JLabel cars,JLabel timerEnding) {
		
		this.car2=car2;
		this.cars=cars;
		this.timerEnding=timerEnding;
		
		animations = new Timer(150,new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
							
				car2.setFrame(counterCarFrame);
					
				counterCarFrame++;
						
				if(counterCarFrame==5) {
					
					counterCarFrame=0;
				}
				
			}
						
		});animations.start();
			
	}
	
	
	public void timerBackground(JLabel cars) {
		this.cars=cars;
		
		
		background = new Timer(1, new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				
				
				
				car2.setFrameBackround(counterBackgroundFrame);
					
				counterBackgroundFrame++;
			
				
				if(counterBackgroundFrame==5) {
					background.setDelay(120);
					
					counterBackgroundFrame=0;
				}
				
			}			
		});background.start();
		
		
		
		
	}
	
	
	
	public void timerFrog(JLabel frogJump,CharacterFrog frogMain,Component component) {
		
		this.frogMain=frogMain;
		this.frogJump=frogJump;
		this.component=component;

		frog = new Timer(40, new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				frogMain.setFrame(frogCounter);
				
				//System.out.println(frogCounter);
				
				if(frogCounter==4) {
					
					frogJump.setText("False");
					frogCounter=0;
					frog.stop();
				}
				frogCounter++;
				
			}			
		});frog.start();
		
		
		
		
	}
	
	



}
