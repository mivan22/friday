package ro.qui.friday;

import java.io.File;

import org.gstreamer.ElementFactory;
import org.gstreamer.Gst;
import org.gstreamer.State;
import org.gstreamer.elements.PlayBin;

public class GstreamerAudioPlayer implements AudioPlayer {
	
	private String source;
	private PlayBin playbin;
	public GstreamerAudioPlayer(String []args){
        args = Gst.init("AudioPlayer", args);
        playbin = new PlayBin("AudioPlayer");
        playbin.setVideoSink(ElementFactory.make("fakesink", "videosink"));
	}
	
	@Override
	public void setSource(String s) {
		this.source = s;
        playbin.setInputFile(new File(s));
	}

	@Override
	public boolean play() {
        playbin.setState(State.PLAYING);
        System.out.println("[PLAYER] Play: "+source);
        Gst.main();
        playbin.setState(State.NULL);
		return true;
	}

	@Override
	public boolean pause() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

}
