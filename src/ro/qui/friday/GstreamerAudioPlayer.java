package ro.qui.friday;

import java.io.File;

import org.gstreamer.ElementFactory;
import org.gstreamer.Gst;
import org.gstreamer.State;
import org.gstreamer.elements.PlayBin;

public class GstreamerAudioPlayer implements AudioPlayer{
	
	private String source;
	private PlayBin playbin;
	private boolean playing;
	private boolean paused;
	
	public GstreamerAudioPlayer(String []args){
        args = Gst.init("AudioPlayer", args);
        playing = false;
        paused = false;
        playbin = new PlayBin("AudioPlayer");
        playbin.setVideoSink(ElementFactory.make("fakesink", "videosink"));
	}
	
	
	public boolean isPlaying() {
		return playing;
	}
	
	public boolean isPaused() {
		return paused;
	}

	@Override
	public void setSource(String s) {
		this.source = s;
        playbin.setInputFile(new File(s));
	}

	@Override
	public boolean play() {
		if (playing)
		{
			return true;
		}
		
		if (paused)
		{
			playbin.play();
			return true;
		}
        playbin.setState(State.PLAYING);
        System.out.println("[PLAYER] Play: "+source);
        Gst.main();
        playbin.setState(State.NULL);
        playing = true;
		return true;
	}

	@Override
	public boolean pause() {
		playbin.pause();
		paused = true;
		return true;
	}

	@Override
	public boolean stop() {
        playbin.stop();
        paused = false;
        playing = false;
        playbin.setState(State.NULL); 
		return true;
	}

	@Override
	public void run() {
		play();
	}
}
