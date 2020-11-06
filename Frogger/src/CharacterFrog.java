import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CharacterFrog {
	
				int positionX;
				int positionY;
				int frame;
				BufferedImage img[]=new BufferedImage[8];
				
				
				public void loadFrog() throws IOException {
				
				img[0] = ImageIO.read(new File("Animations/Frog/frog001.png"));
				img[1] = ImageIO.read(new File("Animations/Frog/frog002.png"));
				img[2] = ImageIO.read(new File("Animations/Frog/frog003.png"));
				img[3] = ImageIO.read(new File("Animations/Frog/frog004.png"));
				img[4] = ImageIO.read(new File("Animations/Frog/frog005.png"));
				img[5] = ImageIO.read(new File("Animations/Frog/frogDead.png"));
				img[6] = ImageIO.read(new File("Animations/Frog/frogDrown.png"));
				img[7] = ImageIO.read(new File("Animations/Frog/princess.png"));
				
				}
				
				public CharacterFrog(int x,int y,int frame) {
					
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
				
				public void draw(Graphics graphics) {
					
					
					
					graphics.drawImage(img[frame], positionX, positionY, null);
				}
				
				public void drawDead(Graphics graphics) {
					
					
					
					graphics.drawImage(img[5], positionX, positionY, null);
				}
				
				public void drawDrown(Graphics graphics) {
					
					
					
					graphics.drawImage(img[6], positionX, positionY, null);
				}
				
				public void drawPrincess(Graphics graphics) {
					
					
				
					graphics.drawImage(img[7], 750, 60, null);
				}
				
				
				
				public void drawTimer(Graphics graphics,String seconds) {
					
					graphics.setColor(Color.WHITE);
					graphics.drawString(seconds, 50, 50);
					
					
				}
				
				
				
				
}
