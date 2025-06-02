import javax.sound.sampled.*;


public class audio {
    private Clip clip;
    private boolean isPlaying = false;
    long clipTimePosition = 0;

    public void toggleMusic(){
        if (!isPlaying) {
            isPlaying=true;
            try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(
                this.getClass().getResource("/assets/gengar_theme.wav")
                );
            clip = AudioSystem.getClip();
            clip.open(audio);

            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-27f); //sets volume

            resumeMusic();
            clip.loop(Clip.LOOP_CONTINUOUSLY); //loops audio
        } catch (Exception e) {
            e.printStackTrace();  
        }
        }
        else{
            pauseMusic();
        }
        
    }

    public void stopMusic(){ //helper function to stop music
        clip.stop();
        isPlaying=false;
    }

    public void pauseMusic(){
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
        isPlaying=false;
    }

    public void resumeMusic(){
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
        isPlaying=true;
    }

    public boolean getIsPlaying(){return isPlaying;}
}
