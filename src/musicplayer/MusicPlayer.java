package musicplayer;

import java.io.File;

import maryb.player.*;

public class MusicPlayer {
	Player p;
	
	public MusicPlayer() {
		p = new Player();
	}
	
	public void playSong(File f) {
		p.setSourceLocation(f.getAbsolutePath());
		p.play();
	}
	
	public void stopSong() {
		p.stop();
	}
	
	public void pauseSong() {
		p.pause();
	}
}
