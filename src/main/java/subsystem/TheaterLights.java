package subsystem;

public class TheaterLights {
    private static final int MAX_BRIGHTNESS = 100;
    private static final int MOVIE_BRIGHTNESS = 30;
    private static final int OFF_BRIGHTNESS = 0;

    private int brightness = MAX_BRIGHTNESS;

    public void dimLights() {
        brightness = MOVIE_BRIGHTNESS;
        System.out.println("Theater lights dimmed.");
    }

    public void turnOn() {
        brightness = MAX_BRIGHTNESS;
        System.out.println("Theater lights turned on.");
    }

    public void turnOff() {
        brightness = OFF_BRIGHTNESS;
        System.out.println("Theater lights turned off.");
    }
}
