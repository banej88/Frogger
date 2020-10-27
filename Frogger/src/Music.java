import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	
	private Clip clipIntro;
	private Clip clipGame;
	private Clip jump;
	
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
	
	public void stopIntroSong() {
		
		clipIntro.stop();
	}
	
	
	public void stopGameSong() {
		
		clipGame.stop();
	}

}
