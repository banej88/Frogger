import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class CharacterFrog {
	
				int positionX;
				int positionY;
				int frame;
				
				Image img[] = {Toolkit.getDefaultToolkit().getImage("Animations/Frog/frog001.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Frog/frog002.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Frog/frog003.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Frog/frog004.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Frog/frog005.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Frog/frogDead.png"),
						Toolkit.getDefaultToolkit().getImage("Animations/Frog/frogDrown.png")};
				
				
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
					
					
					//graphics.fillRect(positionX, positionY, 50, 50);
					graphics.drawImage(img[frame], positionX, positionY, null);
				}
				
				public void drawDead(Graphics graphics) {
					
					
					//graphics.fillRect(positionX, positionY, 50, 50);
					graphics.drawImage(img[5], positionX, positionY, null);
				}
				
				public void drawDrown(Graphics graphics) {
					
					
					//graphics.fillRect(positionX, positionY, 50, 50);
					graphics.drawImage(img[6], positionX, positionY, null);
				}
				
				
				
}
