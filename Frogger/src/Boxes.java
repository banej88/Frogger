import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Boxes {
				
					
				
				
					private int posX=300;
					private int posY=100;
					
					
					public int getPosX() {
						
						return posX;
					}
					
					public int getPosY() {
						
						return posY;
					}
	
					public void draw(Graphics g) {
						
						g.setFont(new Font("MS Gothic", Font.BOLD,20));
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Hello Frogger,", 310, 130);
						g.drawString("Try to survive and ", 310, 160);
						g.drawString("get to the princess.", 310, 190);
						g.drawString("Press enter to continue...", 310, 220);
						
						
					}
					
					public void drawEnd(Graphics g) {
						
						g.setFont(new Font("MS Gothic", Font.BOLD,20));
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Time is up.", 310, 130);
						g.drawString("Press enter to continue...", 310, 160);

						
					}
					
					public void drawEndDead(Graphics g) {
						
						g.setFont(new Font("MS Gothic", Font.BOLD,20));
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Frogger was hit by a car.", 310, 130);
						g.drawString("Press enter to continue...", 310, 160);
						

						
					}
					
					public void drawEndDeadDrown(Graphics g) {
						
						g.setFont(new Font("MS Gothic", Font.BOLD,20));
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Frogger drowned.", 310, 130);
						g.drawString("Press enter to continue...", 310, 160);
						

						
					}
					
					public void drawEndFinal(Graphics g) {
						
						
						//

						
					}
					
				
					
					
					
}
