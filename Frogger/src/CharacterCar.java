import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class CharacterCar {
	
				int positionX;
				int positionY;
				int frame;
				int frame2;	
				private Component component;
				private List<Image> lista = new ArrayList<Image>();
				private BufferedImage imgBackround[] =new BufferedImage[7];
				private Image img[]=new Image[7];
				
				
				
				
				public void loadImages() throws IOException {
					
					
					imgBackround[0] = ImageIO.read(new File("Animations/BackgroundLevel01/back001.png"));
					imgBackround[1] = ImageIO.read(new File("Animations/BackgroundLevel01/back002.png"));
					imgBackround[2] = ImageIO.read(new File("Animations/BackgroundLevel01/back003.png"));
					imgBackround[3] = ImageIO.read(new File("Animations/BackgroundLevel01/back004.png"));
					imgBackround[4] = ImageIO.read(new File("Animations/BackgroundLevel01/back005.png"));
					imgBackround[5]	= ImageIO.read(new File("Animations/BackgroundLevel01/back006.png"));
					imgBackround[6]	= ImageIO.read(new File("Animations/BackgroundLevel01/backOver.png"));
					
					
					
					img[0] = ImageIO.read(new File("Animations/Lambo/lambo001.png"));
					img[1] = ImageIO.read(new File("Animations/Lambo/lambo002.png"));
					img[2] = ImageIO.read(new File("Animations/Lambo/lambo003.png"));
					img[3] = ImageIO.read(new File("Animations/Lambo/lambo004.png"));
					img[4] = ImageIO.read(new File("Animations/Lambo/lambo005.png"));
					img[5] = ImageIO.read(new File("Animations/Lambo/lambo006.png"));
					img[6] = ImageIO.read(new File("Animations/Lambo/lamboNoLambo.png"));
	
				}
				
				
				
				
				
				public CharacterCar(int x,int y,int frame) {
					
					this.positionX=x;
					this.positionY=y;
					this.frame=frame;
				}
				
				
				public int getPositionX() {
					
					return this.positionX;
					
				}
				
				public void setPositionX(int x) {
					
					this.positionX=x;
					
				}
				
				public int getPostitionY() {
					
					return this.positionY;
				}

				public void setPositionY(int y) {
					
					this.positionY=y;
				}
				
				
				public void move(int x,int y) {
					
					this.positionX=x+this.positionX;
					this.positionY=y+this.positionY;
				}
				
				public void setFrame(int frame) {
					
					this.frame=frame;
				}
				
				public void setFrameBackround(int frame2) {
					
					this.frame2=frame2;
				}
						
				public void draw(Graphics graphics) {
								
					graphics.drawImage(img[frame], positionX, positionY, null);
						
					
				}
						
				
				public void drawBackground(Graphics graphics) {

					graphics.drawImage(imgBackround[frame2], 0, 0, null);
					
					
				}
				
				public void drawBackgroundOver(Graphics graphics) {
	
					graphics.drawImage(imgBackround[6], 0, 0, null);
	
				}
				
				
			
				
				
}
