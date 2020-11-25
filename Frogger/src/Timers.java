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
	Timer logs;
	Timer end;
	CharacterCar car2;
	Logs log;
	Logs log2;
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
	private int timerEnd=6;
	private JLabel timeLeft;
	private JLabel newTimer;
	private int logCounter=0;
	private JLabel endChange;
	
	//Naming is not great, need to fix that.
	
	public Timers(JLabel timeLeft,MenuObjects mo,JLabel frogJump,CharacterFrog frogMain,CharacterCar car2,JLabel cars,JLabel timerEnding,JLabel timerFinished,Component component,JLabel newTimer,Logs log,Logs log2,JLabel endChange) {
		
		this.timerFinished=timerFinished;
		this.timerEnding=timerEnding;
		this.cars=cars;
		this.car2=car2;
		this.frogMain=frogMain;
		this.frogJump=frogJump;
		this.mo=mo;
		this.timeLeft=timeLeft;
		this.newTimer=newTimer;
		this.log=log;
		this.log2=log2;
		this.endChange=endChange;
		//
	}
	
	public void timerLogs(Logs log,Component component,Logs log2) {
		
		this.log=log;
		this.log2=log2;
		this.component=component;
		
		
		logs = new Timer(30,new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(log.getLog01X()<=-100) {
					
					log.setLog01X(1600);
					
				}
				
				if(log.getLog02X()<=-100) {
					
					log.setLog02X(1600);
					
				}
				
				if(log2.getLog01X()<=-100) {
					
					log2.setLog01X(1600);
					
				}
				
				if(log2.getLog02X()<=-100) {
					
					log2.setLog02X(1600);
					
				}
				
				logCounter++;
				
				
				
				if(logCounter>130) {
					
					//System.out.println(logCounter);
					log2.setLog01X(log2.getLog01X()-4);
					log2.setLog02X(log2.getLog02X()-8);
					
				}
				
				
				log.setLog01X(log.getLog01X()-4);
				log.setLog02X(log.getLog02X()-8);
				
				component.repaint();
				
				
			}
			
			
		});logs.start();
		
		
	}
	
	public void timer(JLabel timerFinished,JLabel timeLeft,CharacterFrog frogMain,JLabel newTimer) {
		
	this.timerFinished=timerFinished;
	this.timeLeft=timeLeft;
	this.frogMain=frogMain;
	this.newTimer=newTimer;
	
	t = new Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {	    	  
        	  	
        	  //System.out.println(newTimer.getText());
        	  	
        	  if(newTimer.getText().equals("True")) {
        		  counter=0;
        		  logCounter=0;
        		  newTimer.setText("False");
        		  
        	  }
        	  	  	
        	  
        	  	timeLeft.setText(""+(29-counter));
        	  	counter++;
        	  	//System.out.println(counter);
        	  	if(counter==30) {
        	  		
        	  		t.stop();
        	  		counter=0;
        	  		timerFinished.setText("True");
        	  		logCounter=0;
        	  		
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
				
				if(car2.getTruckPositionX()<=-600) {
					
					car2.setTruckPositionX(1600);
					
				}
				
				
			//	if(timerCar==5) {
				//car.setDelay(3);
				//}
				
				timerCar++;
				car2.setPositionX(car2.getPositionX()-3);
				car2.setTruckPositionX(car2.getTruckPositionX()-3);
						
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
				car2.setFrameTruck(counterCarFrame);
					
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
		
		title = new Timer(100, new ActionListener() {
			
			
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
	
	
	
	
	public void endTimer(MenuObjects mo,Component component,JLabel endChange) {
		
		this.mo=mo;
		this.component=component;
		this.endChange=endChange;
		
		end = new Timer(100, new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {
					
					
					mo.setFrameEnd(timerEnd);
					//
					
					if(timerEnd==21) {
									
							end.stop();
							timerEnd=6;
							endChange.setText("False");
							
						
						
					}
					timerEnd++;
					component.repaint();	
					
				}
		
			
		});end.start();
				
		
	}
	
	
	
	
	
	


}
