import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class KeyListeners implements KeyListener{

	private Component component;
	CharacterFrog frog;
	MenuObjects mo;
	Logs log;
	Logs log2;
	private JFrame frame;
	Boxes bx;
	private JLabel gameStarted;
	Music m = new Music();
	private JLabel stop;
	private JLabel frogJump;
	CharacterCar car;
	private JLabel cars;
	private JLabel timerFinished;
	private JLabel timerEnding;
	private JLabel timeLeft;
	private JLabel newTimer;
	private JLabel endChange;
	Timers t = new Timers(timeLeft,mo,frogJump,frog,car,cars,timerEnding,timerFinished,component,newTimer,log,log2,endChange);
	private int frogStarted=0;
	
	public KeyListeners(JLabel frogJump,JLabel stop,JLabel gameStarted,Boxes bx,JFrame frame,CharacterFrog frog,Component component) {
		
		this.frog=frog;
		this.component=component;
		this.frame=frame;
		this.bx=bx;
		this.gameStarted=gameStarted;
		this.stop=stop;
		this.frogJump=frogJump;
		
		//
		
	}
	

	
	
	@Override
	public void keyPressed(KeyEvent e) {
					
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		

		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
			
			gameStarted.setText("close");
			frogStarted=1;
			component.repaint();
		}
		
		// using frogStarted so frog can't move while on message screen

		if(e.getKeyCode()==KeyEvent.VK_LEFT && stop.getText().equals("Start") && frogStarted==1) {
			
			if(frog.getPositionX()<5) {
					
			}
			
			else {
			
			//gameStarted.setText("jump");
			if(frogJump.getText().equals("False")) {
			t.timerFrog(frogJump, frog, component);
			}
			frogJump.setText("True");
			frog.move(-30, 0);	
			m.playJump();
			
		
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT && stop.getText().equals("Start") && frogStarted==1){
			
			
			if(frog.getPositionX()>960) {
				
			}else {
			
			//gameStarted.setText("jump");
			if(frogJump.getText().equals("False")) {
			t.timerFrog(frogJump, frog, component);
			}
			frogJump.setText("True");
			frog.move(30, 0);
			m.playJump();
			
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_UP && stop.getText().equals("Start") && frogStarted==1) {
			
			if(frog.getPostitionY()<5) {
				
			}else {
			
			//gameStarted.setText("jump");
			if(frogJump.getText().equals("False")) {
			t.timerFrog(frogJump, frog, component);
			}
			frogJump.setText("True");
			frog.move(0, -30);
			m.playJump();
			
			
			}
			
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN && stop.getText().equals("Start") && frogStarted==1) {
			
			if(frog.getPostitionY()>680) {
				
			}else {
			
			//gameStarted.setText("jump");
			if(frogJump.getText().equals("False")) {
			t.timerFrog(frogJump, frog, component);
			}
			frogJump.setText("True");
			frog.move(0, 30);
			m.playJump();
			
			}
		}

		
		
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	
	
	
					

}
