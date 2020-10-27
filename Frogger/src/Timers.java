import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Timers {
	
	Timer t;
	Timer tE;
	private int counter=0;
	private int counter2=0;
	private JLabel timerFinished;
	private JLabel timerEnding;
	
	public Timers(JLabel timerEnding,JLabel timerFinished) {
		
		this.timerFinished=timerFinished;
		this.timerEnding=timerEnding;
		
	}
	
	
	public void timer(JLabel timerFinished) {
		
	this.timerFinished=timerFinished;
	
	t = new Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {	    	  
        	  
        	  	System.out.println(counter);
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
	
	
	



}
