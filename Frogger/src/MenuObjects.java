import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuObjects {
			
					private int startX=50;
					private int startY=50;
					private int endX=50;
					private int endY=90;
					
					
					
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
	
	
					public void draw(Graphics g) {
						
									//need to update so it shows only once
									
									g.setColor(Color.WHITE);
									g.drawString("Start game", startX, startY);
									g.drawString("Exit game", endX, endY);
														
					}
}
