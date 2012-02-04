package ro.qui.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.gstreamer.Gst;

public class CommandProcessor {

	private BufferedReader in;
	private AudioPlayer player;
	private Thread tr;
	public CommandProcessor(AudioPlayer player) {
		this.player = player;
		InputStreamReader converter = new InputStreamReader(System.in);
		in = new BufferedReader(converter);
	}

	public void process() throws IOException {
		
		while(true){
			String cl = in.readLine();
			if(cl.equals("exit")) {
				System.out.println("exiting");
				player.stop();
				Gst.quit();
				System exit;
			} else
			if(cl.startsWith("play ")) {
				player.stop();
				cl = cl.replace("play ", "");
				player.setSource(cl);
				tr = new Thread(player);
				tr.start();
			} else
			if(cl.equals("stop")){
				player.stop();
			} else
			if(cl.equals("pause")) {
				player.pause();
			} else
			if (cl.equals("play"))
			{ if(player.isPaused())
				player.play();
			 else
				System.out.println("help");
				
			}
		}
	}
}
