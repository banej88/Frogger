import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class MenuObjects {
			
					private int startX=50;
					private int startY=50;
					private int endX=50;
					private int endY=90;
					private int frame=0;
					private BufferedImage title[] = new BufferedImage[6];
					
					public void loadTitle(){
						
					try {
						
					title[0] = ImageIO.read(new File("Animations/Title/title01.png"));
					title[1] = ImageIO.read(new File("Animations/Title/title02.png"));
					title[2] = ImageIO.read(new File("Animations/Title/title03.png"));
					title[3] = ImageIO.read(new File("Animations/Title/title04.png"));
					title[4] = ImageIO.read(new File("Animations/Title/title05.png"));
					title[5] = ImageIO.read(new File("Animations/Title/title06.png"));
					
					}catch (Exception e) {
						
						JOptionPane.showMessageDialog(null, "No image data", "Error", JOptionPane.PLAIN_MESSAGE);
					}	
		
					}
					
					
					
					public int getStartX() {
						
						return startX;
						
					}
					
					public int getStartY() {
						
						return startY;
					}
					
					public int getEndX() {
						
						return endX;
					}
					
					public int getEndY() {
						
						return endY;
					}
					
					public void setFrame(int frame) {
						
						this.frame=frame;
					
						
					}
	
	
					public void draw(Graphics g) {
						
									//need to update so it shows only once
						
									g.drawImage(title[frame], 0, 0,null);
									g.setColor(Color.WHITE);
									g.drawString("Start game", startX, startY);
									g.drawString("Exit game", endX, endY);
									g.drawString("Made by Branko Jesic 2020", 800, 700);
														
					}
					
				
}
