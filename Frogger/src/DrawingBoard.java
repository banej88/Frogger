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
import java.util.Random;

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
					Logs log;
					Logs log2;
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
					private boolean frogVictory=false;
					private int loadImageCounter=0;
					private int timerTitle=0;
					private JLabel newTimer = new JLabel("False");
					private JLabel timeLeft = new JLabel("29");
					private int timerEndCounter=0;
					private JLabel endChange;
					
					Timers t = new Timers(timeLeft,mo,frogJump,frog,car,cars,timerEnding,timerFinished,component,newTimer,log,log2,endChange);
						
		
					
					public DrawingBoard(JLabel frogJump,CharacterCar car,JLabel timerEnding,JLabel timerFinished,JLabel stop,JLabel timer,Boxes bx,JLabel gameStarted,MenuObjects mo,Component component,CharacterFrog frog,Logs log,Logs log2,JLabel endChange) {
						
						
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
						this.log=log;
						this.log2=log2;
						this.endChange=endChange;
						
					}
							
		
					protected void paintComponent(Graphics g) {
						
					//paints main menu components and starts intro music	

						
					// After using image buffer more ram usage each time game is restarted..needs fixing
					
						
					super.paintComponent(g);
					
					
					
					if(timerTitle<1) {
					mo.loadTitle();
					t.titleTimer(mo,component);
					newTimer.setText("True");
					timerTitle++;
					}
					
					
					mo.draw(g);
					
					
					if(introMusic==false) {
					music.playIntroSong();
					introMusic=true;
					}
					
					
					// checking to see if gameStarted is set tu true so intro song can be stoped and to check if gameEnded so it can start timing the game
					
					if(gameStarted.getText().equals("True")) {
						
						
						
						music.stopIntroSong();
								
						
						if(loadImageCounter<1) {
						try {
								
								log.loadLogImages();
								log2.loadLogImages();
								car.loadImages();
								frog.loadFrog();
								loadImageCounter++;
								
						} catch (IOException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Cant load images", "Error", JOptionPane.PLAIN_MESSAGE);
						}
						}
						
						if(backCounter==0) {
							car.drawStaticBackground(g);
							
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
							
							
							t.timer(timerFinished,timeLeft,frog,newTimer);
							
							gameEnded=true;
						}	
						
						backCounter++;
						stop.setText("Start");
						
						
						
						if(cars.getText().equals("False")) {
							
							t.timerAnimations(car,cars,timerEnding,component);
							
							t.timerBackground(cars,component);
					
							t.timerCar(car,cars,timerEnding,component);
							
							t.timerLogs(log,component,log2);
							
							}
							
						car.drawBackground(g);
							
						frog.drawTimer(g, ""+timeLeft.getText());
						
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
						
						//check if frog is in the river or log
					
						
						if(frog.getPostitionY()>=180 && frog.getPostitionY()<=315) {
							
							//check if frog is on the log

							if(frog.getPositionX()>=log.getLog01X()-50 && frog.getPositionX()<=log.getLog01X()+150
									&&frog.getPostitionY()>=log.getLog01Y()-20 && frog.getPostitionY()<=log.getLog01Y()+80) {
								
								frog.setPositionX(log.getLog01X()+10);
								
								log.drawLog02(g);	
								log.drawLog01(g);
								log2.drawLog02(g);
								log2.drawLog01(g);
								frog.draw(g);
								frog.drawPrincess(g);
								
								
							}
							else if(frog.getPositionX()>=log2.getLog01X()-50 && frog.getPositionX()<=log2.getLog01X()+150
									&&frog.getPostitionY()>=log2.getLog01Y()-20 && frog.getPostitionY()<=log2.getLog01Y()+80) {
								
								frog.setPositionX(log2.getLog01X()+10);
								
								log.drawLog02(g);	
								log.drawLog01(g);
								log2.drawLog02(g);
								log2.drawLog01(g);
								frog.draw(g);
								frog.drawPrincess(g);
								
								
							}
							// top log
							
							else if(frog.getPositionX()>=log.getLog02X()-50 && frog.getPositionX()<=log.getLog02X()+180
									&&frog.getPostitionY()>=log.getLog02Y()-20 && frog.getPostitionY()<=log.getLog02Y()+80) {
								
								frog.setPositionX(log.getLog02X()+25);
								
								log.drawLog02(g);	
								log.drawLog01(g);
								log2.drawLog02(g);
								log2.drawLog01(g);
								frog.draw(g);
								frog.drawPrincess(g);
								
								
							}
							else if(frog.getPositionX()>=log2.getLog02X()-50 && frog.getPositionX()<=log2.getLog02X()+180
									&&frog.getPostitionY()>=log2.getLog02Y()-20 && frog.getPostitionY()<=log2.getLog02Y()+80) {
								
								frog.setPositionX(log2.getLog02X()+25);
								
								log.drawLog02(g);	
								log.drawLog01(g);
								log2.drawLog02(g);
								log2.drawLog01(g);
								frog.draw(g);
								frog.drawPrincess(g);
								
								
							}
														
							else{	
								
							car.drawBackgroundOver(g); 
							frog.drawDrown(g); 
							frogDrown=true;
							isFrogDead=true;
							music.playDrowned();
							t.t.stop();
							
							
							}
							
						}
						
						
						else if(frog.getPositionX()>=660 && frog.getPostitionY()<=100) {
							
							if(timerEndCounter<1) {
								t.endTimer(mo, component,endChange);
								endChange.setText("True");
								timerEndCounter++;
								}
							
								car.drawBackgroundOver(g);  
								isFrogDead=true;	
								frogVictory=true;
								t.t.stop();
								
								
							
						}
						
						else if(isFrogDead==false){
							
							frog.draw(g);
							frog.drawPrincess(g);
							
							log.drawLog02(g);	
							log.drawLog01(g);
							log2.drawLog02(g);
							log2.drawLog01(g);
							
							
							
							
							
							
						}
						
						
						
						
						
						//car.setFrame(0);
						car.draw(g);
						car.drawTruck(g);
						
						
						
						
					}
					
					
					//component.repaint();
					
					// if timer first game timer is finished it will show up box with ending message
					
					if(frogVictory==true && endChange.getText().equals("True")){
						
						
						
						mo.drawEnd(g);
						music.stopGameSong();
								
					
					}else
					
					
					if(this.timerFinished.getText().equals("True") || isFrogDead==true) {
						
						if(isFrogDead) {
							
							if(frogDrown==true) {
								
								
								bx.drawEndDeadDrown(g);
								
								
							}else if(frogVictory==true){
								
								bx.drawEndFinal(g);
								mo.setFrameEnd(20);
								mo.drawEnd(g);
								bx.drawEndFinal(g);
								
								//
								
							}else{
							
							
							bx.drawEndDead(g);  
							
							
							}
							
						}
						
						else {
							
						
						bx.drawEnd(g);
						
						
						}
						
						
						music.stopGameSong();
						stop.setText("Stop");
						t.timerE(timerEnding);
						t.animations.stop();
						t.background.stop();
						t.logs.stop();
						isFrogDead=false;
						car.setFrame(6);
						car.setFrameTruck(6);
						
						
						//component.repaint(); // causing memory leak
					
						
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
							car.setPositionX(1600);
							car.setTruckPositionX(2000);
							log.setLog01X(1600);
							log.setLog02X(1600);
							log2.setLog01X(1600);
							log2.setLog02X(1600);
							this.cars.setText("False");
							backCounter=0;
							music.resetSquishCount();
							music.resetDrownedCount();
							frogDrown=false;
							timerTitle=0;
							mo.setFrame(0);
							timeLeft.setText("29");
							frogVictory=false;
							timerEndCounter=0;
							mo.setFrameEnd(6);
							
							
						}
										
					      
						}
							
					
					}






					
					
				    
				        
				    
	
}
