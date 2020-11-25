import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Gui implements Runnable{
	
	
	private JFrame frame;
	CharacterFrog frog = new CharacterFrog(500,670,0);
	CharacterCar car = new CharacterCar(1600,500,0,2000,300,0);
	MenuObjects mo = new MenuObjects();
	Logs log = new Logs(1600,260,1600,165);
	Logs log2 = new Logs(1600,260,1600,165);
	Boxes bx = new Boxes();
	private JLabel startGame=new JLabel("False");
	private JLabel timer = new JLabel("Timer");
	private JLabel stop = new JLabel("Start");
	private JLabel timerFinished = new JLabel("False");
	private JLabel timerEnding = new JLabel("False");
	private JLabel frogJump = new JLabel("False");
	private JLabel endChange = new JLabel("False");
	
	public void run() {
		
		frame = new JFrame("Frogger");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1024,768));							
		
		
		createComponent(frame.getContentPane());
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
			
		//
	}
	
	
	public void createComponent(Container container) {
			
				//
		
				DrawingBoard db = new DrawingBoard(frogJump,car,timerEnding,timerFinished,stop,timer,bx,startGame,mo,frame,frog,log,log2,endChange);
			
				container.add(db);
				KeyListeners kl = new KeyListeners(frogJump,stop,startGame,bx,frame,frog,db);
				frame.addKeyListener(kl);
				MouseEvent e = new MouseEvent(startGame,frog,db);
				frame.addMouseListener(e);
				
		
		
	}

}
