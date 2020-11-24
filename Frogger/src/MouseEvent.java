import java.awt.Component;
import java.awt.Frame;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEvent implements MouseListener{
	
	private JLabel gameStarted;
	private Component component;
	private List<Integer> listX = new ArrayList<Integer>();
	private List<Integer> listY = new ArrayList<Integer>();
	private List<Integer> endListY = new ArrayList<Integer>();
	private CharacterFrog frog;

	
	//
	
	
	public MouseEvent(JLabel gameStarted,CharacterFrog frog,Component component) {
		
		this.component=component;	
		this.gameStarted=gameStarted;
		
		//need to make it scalable
		
		for(int i=52;i<160;i++) {
			
			listX.add(i);
		}
		
		for(int i=110;i<125;i++) {
			
			listY.add(i);
		}

		for(int i=68;i<84;i++) {
			
			endListY.add(i);
		}
		
	}
	
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
			
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		
		
		// exiting game with mouse cordinates

		for(int x : listX) {
			
			for(int y : listY) {
			
			if(e.getX()==x && e.getY()==y) {
				
				System.exit(0);
			}
			
			}
		}
		
		// startring game with mouse cordinates	
		
		for(int x : listX) {
			
			for(int y : endListY) {
			
			if(e.getX()==x && e.getY()==y) {
					
				this.gameStarted.setText("True");
				component.repaint();	
				
			}
			
			}
		}
		
		
		
	}
	

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	
			

}
