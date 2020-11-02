import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class DrawingBoard extends JPanel {

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
					private JLabel frogJump;
					private JLabel stop;
					private boolean gameEnded=false;
					private boolean introMusic=false;
					private boolean gameMusic=false;
					private JLabel timerFinished;
					private JLabel timerEnding;
					private int backCounter=0;
					private boolean isFrogDead=false;
					private boolean frogDrown=false;
					private int loadImageCounter=0;

					
					Timers t = new Timers(frogJump,frog,car,cars,timerEnding,timerFinished,component);
						
		
					
					public DrawingBoard(JLabel frogJump,CharacterCar car,JLabel timerEnding,JLabel timerFinished,JLabel stop,JLabel timer,Boxes bx,JLabel gameStarted,MenuObjects mo,Component component,CharacterFrog frog) {
						
						
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
						this.frogJump=frogJump;
						
						
					}
							
		
					protected void paintComponent(Graphics g) {
						
					//paints main menu components and starts intro music	

						
					// ****************************** move update frames from timers to drawing board to avoid flicker
					
						
					super.paintComponent(g);
					mo.draw(g);
					
					
					if(introMusic==false) {
					music.playIntroSong();
					introMusic=true;
					}
					
					
					// checking to see if gameStarted is set tu true so intro song can be stoped and to check if gameEnded so it can start timing the game
					
					if(gameStarted.getText().equals("True")) {
						
						
						
						music.stopIntroSong();
						
						img = Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/back001.png");
								
						
						if(backCounter==0) {
						g.drawImage(img, 0, 0, this);
						
						}
						
						System.out.println(loadImageCounter+"muuuuuuuuuu");
						
						if(loadImageCounter<1) {
						try {
							
								car.loadImages();
								loadImageCounter++;
								
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Cant load images", "Error", JOptionPane.PLAIN_MESSAGE);
						}
						}
						
						
						bx.draw(g);	
						started=true;
						
						//play is counter that starts playing song only once and it increases after song starts so no multiple instances of song is started
						
						if(gameMusic==false) {
						music.playGameSong();
						gameMusic=true;
						}
						
						frog.draw(g);
						frog.drawPrincess(g);
					
						}	
				
					
					//draws character after enter is pressed on popup box after the game is started
					
					if(gameStarted.getText().equals("close") && started==true) {
						
						
						
						if(gameEnded==false) {
							
							
							t.timer(timerFinished);
							
							gameEnded=true;
						}	
						
						backCounter++;
						stop.setText("Start");
						
						if(cars.getText().equals("False")) {
							
							t.timerAnimations(car,cars,timerEnding,component);
							
							t.timerBackground(cars,component);
					
							t.timerCar(car,cars,timerEnding,component);
							
							}
							
						car.drawBackground(g);
						
						
						//400x133 are image dimensions
					
						
						if(frog.getPositionX()>=car.getPositionX()+50 && frog.getPositionX()<=car.getPositionX()+400
								&& frog.getPostitionY()>=car.getPostitionY() && frog.getPostitionY()<=car.getPostitionY()+133) {
							
						
							car.drawBackgroundOver(g);  
							frog.drawDead(g);
							isFrogDead=true;	
							music.playSquish();
							t.t.stop();    // since frog is dead level timer needs to be stopped
								
							
							//310 220 y cordinates for river...x goes through while width
							
						}
						
						//check if frog is in the river
						
						if(frog.getPostitionY()>=180 && frog.getPostitionY()<=315) {
							
							car.drawBackgroundOver(g);  
							frog.drawDrown(g);
							isFrogDead=true;
							frogDrown=true;
							music.playDrowned();
							t.t.stop();
						}
						
						else if(isFrogDead==false){
							
							frog.draw(g);
							frog.drawPrincess(g);
							
						}
						
						
						
						
						
						//car.setFrame(0);
						car.draw(g);
						
						
						
						
					}
					
					
					//component.repaint();
					
					// if timer first game timer is finished it will show up box with ending message
					
					
					if(this.timerFinished.getText().equals("True") || isFrogDead==true) {
						
						if(isFrogDead) {
							
							if(frogDrown==true) {
								
								bx.drawEndDeadDrown(g);
								
								
							}else {
								
							bx.drawEndDead(g);  
							
							
							}
							
						}else {
						bx.drawEnd(g);
						
						}
						
						
						music.stopGameSong();
						stop.setText("Stop");
						t.timerE(timerEnding);
						t.animations.stop();
						t.background.stop();
						isFrogDead=false;
						car.setFrame(6);
						component.repaint();
						
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
							backCounter=0;
							music.resetSquishCount();
							music.resetDrownedCount();
							frogDrown=false;
							
						}
										
					      
						}
							
					
					}






					
					
				    
				        
				    
	
}
