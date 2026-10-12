package facade;
import subsystem.*;


public class HomeTheaterFacade{
    private final Amplifier amplifier;
    private final DvdPlayer dvdPlayer;
    private final Projector projector;
    private final Screen screen;
    private final TheaterLights lights;
    private final PopcornPopper popcornPopper;

    public HomeTheaterFacade(){
        this.amplifier = new Amplifier();
        this.dvdPlayer = new DvdPlayer();
        this.projector = new Projector();
        this.screen = new Screen();
        this.lights = new TheaterLights();
        this.popcornPopper = new PopcornPopper();
    }

    public void watchMovie(String movieName) {
        popcornPopper.turnOn();
        popcornPopper.cookPopcorn();

        lights.dimmingLight();
        screen.lowerScreen();

        projector.turnOn();
        amplifier.turnOn();
        amplifier.setVolume(50);

        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movieName);
    }

    public void endMovie() {
        popcornPopper.turnOff();

        lights.turnOn();
        screen.raiseScreen();

        projector.turnOff();
        amplifier.turnOff();

        dvdPlayer.turnOff();
        
    }
}