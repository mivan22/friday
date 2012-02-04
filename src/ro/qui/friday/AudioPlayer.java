package ro.qui.friday;

public interface AudioPlayer extends Runnable{
	/**
	 * The audio player must play something. This function
	 * gives it something to play. Usually it is in the form
	 * of a file path.
	 * @param s
	 */
	public void setSource(String s);
	
	/**
	 * TODO: comment this
	 * @return
	 */
	public boolean play();
	public boolean pause();
	public boolean stop();
	public boolean isPlaying();
	public boolean isPaused();
}
