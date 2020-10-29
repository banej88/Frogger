import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CharacterCar {
	
				int positionX;
				int positionY;
				int frame;
				int frame2;			
				
				Image imgBackground[]= {Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/back001.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/back002.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/back003.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/back004.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/back005.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/BackgroundLevel01/backOver.png")};
				
				
				Image img[] = {Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo001.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo002.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo003.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo004.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo005.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo006.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo007.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo008.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo009.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo010.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lambo011.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Lambo/lamboNoLambo.png")};
				
			
				
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
					
					
					graphics.drawImage(imgBackground[frame2], 0, 0, null);
					
					
				}
				
				public void drawBackgroundOver(Graphics graphics) {
	
					graphics.drawImage(imgBackground[5], 0, 0, null);
	
				}
				
				
			
				
				
}
