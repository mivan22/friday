package ro.qui.friday;

import java.io.IOException;

class Test{
	public static void main(String [] args) {
		AudioPlayer player = new GstreamerAudioPlayer(args);
		CommandProcessor cmd = new CommandProcessor(player);
		try {
			cmd.process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
