package ro.qui.friday;
class Test{
	public static void main(String [] args) {
		AudioPlayer player = new GstreamerAudioPlayer(args);
		player.setSource("/media/7EACCA30ACC9E32F/muzica/Noisettes/07-Atticus.mp3");
		player.play();
	}	
}
