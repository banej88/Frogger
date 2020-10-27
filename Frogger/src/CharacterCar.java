import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;

public class CharacterCar {
	
				int positionX;
				int positionY;
				Image img = Toolkit.getDefaultToolkit().getImage("car01.gif");
				
				
				public CharacterCar(int x,int y) {
					
					this.positionX=x;
					this.positionY=y;
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
				
				public void draw(Graphics graphics) {
					
					
					graphics.drawImage(img, positionX, positionY, null);
					
					
				}
				
			
	
				
				
}
