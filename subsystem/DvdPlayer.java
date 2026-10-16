package subsystem;

public class DvdPlayer {
    private static final String WAITING_SCREEN = "Waiting screen";

    private String currentMovie = WAITING_SCREEN;
    private boolean playing;
    private boolean on;

    public void turnOn() {
        if (on) {
            System.out.println("DVD player is already on.");
            return;
        }
        on = true;
        System.out.println("DVD player turned on.");
    }

    public void turnOff() {
        if (!on) {
            System.out.println("DVD player is already off.");
            return;
        }
        stopMovie();
        on = false;
        System.out.println("DVD player turned off.");
    }

    public void playMovie() {
        playMovie(currentMovie);
    }

    public void playMovie(String movieName) {
        if (!ensurePoweredOn("play a movie")) {
            return;
        }
        if (movieName == null || movieName.isBlank()) {
            System.out.println("Movie name must not be empty.");
            return;
        }

        currentMovie = movieName.trim();
        playing = true;
        System.out.println("Now playing: " + currentMovie + ".");
    }

    public void stopMovie() {
        if (!on || !playing) {
            return;
        }
        playing = false;
        System.out.println("Movie stopped: " + currentMovie + ".");
        currentMovie = WAITING_SCREEN;
    }

    public void togglePause() {
        if (!ensurePoweredOn("pause or unpause")) {
            return;
        }
        if (WAITING_SCREEN.equals(currentMovie)) {
            System.out.println("No movie loaded.");
            return;
        }
        playing = !playing;
        System.out.println(playing ? "Movie resumed: " + currentMovie + "." : "Movie paused.");
    }

    public void ejectDisc() {
        if (!ensurePoweredOn("eject a disc")) {
            return;
        }
        stopMovie();
        System.out.println("Disc ejected.");
    }

    private boolean ensurePoweredOn(String action) {
        if (on) {
            return true;
        }
        System.out.println("Turn on the DVD player before you " + action + ".");
        return false;
    }
}
