import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	
	private Clip clipIntro;
	private Clip clipGame;
	private Clip jump;
	private Clip squish;
	private int squishCount=0;
	
	public void playIntroSong() {
		
		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Menu Screen.wav").getAbsoluteFile());
			clipIntro = AudioSystem.getClip();
			clipIntro.open(audioInputStream);
			clipIntro.start();
			
			
		}
		catch (Exception ex) {
				
			clipIntro.stop();
			
		}
		
	}
	
	
	public void playGameSong() {
		
		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Retro Zone.wav").getAbsoluteFile());
			clipGame = AudioSystem.getClip();
			clipGame.open(audioInputStream);
			clipGame.start();
			
		}
		catch (Exception ex) {
				
			clipGame.stop();
				
		}
		
	}
	
	public void playJump() {
		
		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("hop.wav").getAbsoluteFile());
			clipIntro = AudioSystem.getClip();
			clipIntro.open(audioInputStream);
			clipIntro.start();
			
		}
		catch (Exception ex) {
				
			clipIntro.stop();
			
		}
		
	}
	
	
	
	public void playSquish() {
		
		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Squish.wav").getAbsoluteFile());
			squish = AudioSystem.getClip();
			squish.open(audioInputStream);
			
			if(squishCount<1) {
			squish.start();
			}
			squishCount++;
		}
		catch (Exception ex) {
				
			squish.stop();
			
		}
		
	}
	
	public void resetSquishCount() {
		
		this.squishCount=0;
	}
	
	
	public void stopSquish(){
		
		squish.stop();
	}
	
	public void stopIntroSong() {
		
		clipIntro.stop();
	}
	
	
	public void stopGameSong() {
		
		clipGame.stop();
	}

}
