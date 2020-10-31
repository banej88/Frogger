import java.awt.Color;
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
						
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Zdravo Zabice. Pokusaj da prezivis.", 310, 130);
						g.drawString("Ako uspes da prezivis dobices plazmu :) ", 310, 145);

						
					}
					
					public void drawEnd(Graphics g) {
						
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Vreme je isteklo a plazme nidje", 310, 130);
						

						
					}
					
					public void drawEndDead(Graphics g) {
						
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Zabica je zgazena...", 310, 130);
						

						
					}
					
					public void drawEndDeadDrown(Graphics g) {
						
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Zabica se utopila...", 310, 130);
						

						
					}
					
					
					
}
