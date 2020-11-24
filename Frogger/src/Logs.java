import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Logs {

				
				private BufferedImage log[] = new BufferedImage[2];
				private int Log01x;
				private int Log01y;
				private int Log02x;
				private int Log02y;
				
				public void loadLogImages() throws IOException {
					
					log[0]=ImageIO.read(new File("Animations/Logs/log01.png"));
					log[1]=ImageIO.read(new File("Animations/Logs/log02.png"));
					
				}
				
				//
				
				public Logs(int l01x,int l01y,int l02x,int l02y) {
					
					this.Log01x=l01x;
					this.Log01y=l01y;
					this.Log02x=l02x;
					this.Log02y=l02y;
					
				}
				
				
				
				public int getLog01X() {
					
					return this.Log01x;
				}
				
				public int getLog01Y() {
					
					return this.Log01y;
				}
				
				public int getLog02X() {
					
					return this.Log02x;
				}
				
				public int getLog02Y() {
					
					return this.Log02y;
				}
				
				public void setLog01X(int log01x) {
					
					this.Log01x=log01x;
				}
				
				public void setLog01Y(int log01y) {
					
					this.Log01y=log01y;
				}
				
				public void setLog02X(int log02x) {
					
					this.Log02x=log02x;
				}
				
				public void setLog02Y(int log02y) {
					
					this.Log02y=log02y;
				}
				
				
				public void drawLog01(Graphics g) {
					
					g.drawImage(log[0],this.Log01x,this.Log01y,null);
					
				}
				
				public void drawLog02(Graphics g) {
					
					g.drawImage(log[1],this.Log02x,this.Log02y,null);
					
				}
	
				
}
