import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class DrawingBoard extends JPanel{

					private JFrame frame;
					CharacterFrog frog;
					MenuObjects mo;
					CharacterCar car;
					private JLabel cars=new JLabel("False");
					Boxes bx;
					Image img=null;
					private Component component;
					JLabel gameStarted;
					MouseEvent e = new MouseEvent(gameStarted,frog,component);
					private boolean started=false;	
					Music music = new Music();
					Timer t2;
					private JLabel timer;
					private JLabel stop;
					private boolean gameEnded=false;
					private boolean introMusic=false;
					private boolean gameMusic=false;
					private JLabel timerFinished;
					private JLabel timerEnding;
					Timers t = new Timers(car,cars,timerEnding,timerFinished);
					
		
					
					public DrawingBoard(CharacterCar car,JLabel timerEnding,JLabel timerFinished,JLabel stop,JLabel timer,Boxes bx,JLabel gameStarted,MenuObjects mo,Component component,CharacterFrog frog) {
						
						
						super.setBackground(Color.BLACK);
						this.frog=frog;
						this.timer=timer;
						this.component=component;
						this.mo=mo;	
						this.gameStarted=gameStarted;
						this.bx=bx;
						this.stop=stop;
						this.timerFinished=timerFinished;
						this.timerEnding=timerEnding;
						this.car=car;
						
					}
							
		
					protected void paintComponent(Graphics g) {
						
					//paints main menu components and starts intro music	
					
					super.paintComponent(g);
					mo.draw(g);
						
					if(introMusic==false) {
					music.playIntroSong();
					introMusic=true;
					}
							
					
					// checking to see if gameStarted is set tu true so intro song can be stoped and to check if gameEnded so it can start timing the game
					
					if(gameStarted.getText().equals("True")) {
						
						music.stopIntroSong();
						
						
						
						if(gameEnded==false) {
							
							
							t.timer(timerFinished);
							
							gameEnded=true;
						}	
						
						//img = Toolkit.getDefaultToolkit().getImage("Background.gif");
						img = Toolkit.getDefaultToolkit().getImage("Background.gif");
						
						//super.paintComponent(g);
						g.drawImage(img, 0, 0, this);
						bx.draw(g);	
						started=true;
						
						//play is counter that starts playing song only once and it increases after song starts so no multiple instances of song is started
						
						if(gameMusic==false) {
						music.playGameSong();
						gameMusic=true;
						}
						frog.draw(g);
						
						}
					
					System.out.println(gameStarted.getText()+"   "+started);
					//draws character after enter is pressed on popup box after the game is started
					
					if(gameStarted.getText().equals("close") && started==true) {
						
						
						//super.paintComponent(g);
						
						stop.setText("Start");
						
						g.drawImage(img, 0, 0, this);
						
						frog.draw(g);
						car.draw(g);
						
						
						if(cars.getText().equals("False")) {
						t.timerCar(car,cars,timerEnding);
						}
					}
					component.repaint();
					
					// if timer first game timer is finished it will show up box with ending message
					
					
					if(this.timerFinished.getText().equals("True")) {
						
						bx.drawEnd(g);
						music.stopGameSong();
						stop.setText("Stop");
						t.timerE(timerEnding);
						
						// if second timer is done with countound on game ending screen it will revert values to orginial state
						
						if(!t.tE.isRunning()) {
							
							g.dispose();
							started=false;
							gameEnded=false;
							gameStarted.setText("False");
							timerFinished.setText("False");
							introMusic=false;
							gameMusic=false;
							gameEnded=false;
							timerEnding.setText("False");
							frog.setPositionX(500);
							frog.setPositionY(670);
							car.setPositionX(800);
							this.cars.setText("False");
							
						}
						
						
					      
						}
					
					//draws new frog position after key is pressed in KeyListener
					
					//if(gameStarted.getText().equals("jump")) {
						
						//super.paintComponent(g);
						
						//g.drawImage(img, 0, 0, this);
						//gameStarted.setText("close");
					    
	
						
					//}
					
					
					
					}






					
					
				    
				        
				    
	
}
