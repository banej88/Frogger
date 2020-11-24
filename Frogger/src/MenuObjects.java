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
					private int frame2=6;
					private BufferedImage title[] = new BufferedImage[24];
					
					public void loadTitle(){
						
					try {
						
					title[0] = ImageIO.read(new File("Animations/Title/title01.png"));
					title[1] = ImageIO.read(new File("Animations/Title/title02.png"));
					title[2] = ImageIO.read(new File("Animations/Title/title03.png"));
					title[3] = ImageIO.read(new File("Animations/Title/title04.png"));
					title[4] = ImageIO.read(new File("Animations/Title/title05.png"));
					title[5] = ImageIO.read(new File("Animations/Title/title06.png"));
					title[6] = ImageIO.read(new File("Animations/Frog/fin001.png"));
					title[7] = ImageIO.read(new File("Animations/Frog/fin002.png"));
					title[8] = ImageIO.read(new File("Animations/Frog/fin003.png"));
					title[9] = ImageIO.read(new File("Animations/Frog/fin004.png"));
					title[10] = ImageIO.read(new File("Animations/Frog/fin005.png"));
					title[11] = ImageIO.read(new File("Animations/Frog/fin006.png"));
					title[12] = ImageIO.read(new File("Animations/Frog/fin007.png"));
					title[13] = ImageIO.read(new File("Animations/Frog/fin008.png"));
					title[14] = ImageIO.read(new File("Animations/Frog/fin009.png"));
					title[15] = ImageIO.read(new File("Animations/Frog/fin010.png"));
					title[16] = ImageIO.read(new File("Animations/Frog/fin011.png"));
					title[17] = ImageIO.read(new File("Animations/Frog/fin012.png"));
					title[18] = ImageIO.read(new File("Animations/Frog/fin013.png"));
					title[19] = ImageIO.read(new File("Animations/Frog/fin014.png"));
					title[20] = ImageIO.read(new File("Animations/Frog/fin015.png"));
					
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
					
					public void setFrameEnd(int frame2) {
						
						this.frame2=frame2;
					
						
					}
	
	
					public void draw(Graphics g) {
						
									//need to update so it shows only once
						
									g.drawImage(title[frame], 0, 0,null);
									g.setColor(Color.WHITE);
									g.setFont(new Font("MS Gothic", Font.BOLD,20));
									g.drawString("Start game", startX, startY);
									g.drawString("Exit game", endX, endY);
									g.drawString("Made by Branko Jesic 2020", 700, 700);
														
					}
					
					public void drawEnd(Graphics graphics) {
						
						
									graphics.drawImage(title[frame2], 0, 0, null);
						
						//
					}
}
