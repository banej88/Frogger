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
						g.drawString("Zdravo Milena. U danasnjoj potrazi ces pronaci blago na drugoj strani.", 310, 130);
						g.drawString("Ako uspes da uzmes blago i prezivis bices nagradjena ", 310, 145);
						g.drawString("komplet lepinjom ili ustipcima. Muva vise nema. ", 310, 160);
						g.drawString("Pritisni enter da nastavis, ako ne posjesce te zla vestica Jackie. ", 310, 190);
						
					}
					
					public void drawEnd(Graphics g) {
						
						g.setColor(Color.BLACK);
						g.fillRect(getPosX(), getPosY(), 400, 200);;
						g.setColor(Color.WHITE);
						g.drawString("Vreme je isteklo.", 310, 130);
						

						
					}
					
					
					
}
