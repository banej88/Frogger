import java.awt.Component;
import java.awt.Graphics;
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
	Timer menu;
	Timer title;
	CharacterCar car2;
	CharacterFrog frogMain;
	MenuObjects mo;
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
	private int timerTitle=0;
	
	//Naming is not great, need to fix that.
	
	public Timers(MenuObjects mo,JLabel frogJump,CharacterFrog frogMain,CharacterCar car2,JLabel cars,JLabel timerEnding,JLabel timerFinished,Component component) {
		
		this.timerFinished=timerFinished;
		this.timerEnding=timerEnding;
		this.cars=cars;
		this.car2=car2;
		this.frogMain=frogMain;
		this.frogJump=frogJump;
		this.mo=mo;
		
	}
	
	
	
	public void timer(JLabel timerFinished) {
		
	this.timerFinished=timerFinished;
	
	t = new Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {	    	  
        	  
        	  	
        	  	counter++;
        	  	//System.out.println(counter);
        	  	if(counter==30) {
        	  		
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
	        	  	
	        	  	if(counter2==1) {
	        	  		tE.stop();
	        	  		timerEnding.setText("True");
	        	  		counter2=0;
	        	  		component.repaint();
	        	  		
	        	  		
	        	  	}
	        	  	
	        	  	//System.out.println(counter2);
	        	  	  	
	          }
	       }
				
				); tE.start();   this.timerEnding.setText("True");     	  		
					
	}
		
	}
	
	
	public void timerCar(CharacterCar car2,JLabel cars,JLabel timerEnding,Component component) {
		this.cars=cars;
		this.car2=car2;
		this.timerEnding=timerEnding;
		this.component=component;
		
		car = new Timer(3,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(car2.getPositionX()<=-439) {
					
					car2.setPositionX(1600);
					
				}
				
				
				
			//	if(timerCar==5) {
				//car.setDelay(3);
				//}
				
				timerCar++;
				car2.setPositionX(car2.getPositionX()-3);
						
				if(timerEnding.getText().equals("True")) {
					
				
					car.stop();
					timerCar=0;
					
				}
				component.repaint();
				
			}	
			
		});car.start();  this.cars.setText("True");
		
		
	}
	
	
	public void timerAnimations(CharacterCar car2,JLabel cars,JLabel timerEnding,Component component) {
		
		this.car2=car2;
		this.cars=cars;
		this.timerEnding=timerEnding;
		this.component=component;
		
		animations = new Timer(180,new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
							
				car2.setFrame(counterCarFrame);
					
				counterCarFrame++;
						
				if(counterCarFrame==5) {
					
					counterCarFrame=0;
				}
				component.repaint();
			}
						
		});animations.start();
			
	}
	
	
	public void timerBackground(JLabel cars,Component component) {
		this.cars=cars;
		this.component=component;
		
		background = new Timer(120, new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				
				
				
				car2.setFrameBackround(counterBackgroundFrame);
					
				counterBackgroundFrame++;
				
				
				if(counterBackgroundFrame==5) {
					//background.setDelay(120);
					
					counterBackgroundFrame=0;
				}
				component.repaint();
				
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
	
	public void titleTimer(MenuObjects mo,Component component) {
		
		this.mo=mo;
		this.component=component;
		
		title = new Timer(200, new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {
					
					
					mo.setFrame(timerTitle);
					component.repaint();
					timerTitle++;
					
					
					if(timerTitle==5) {
						
						
						title.stop();
						timerTitle=0;
						
					}
					
					
					
				}
			
			
			
		});title.start();
				
		
	}
	
	


}
