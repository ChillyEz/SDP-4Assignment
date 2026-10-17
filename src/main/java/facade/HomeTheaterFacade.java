package facade;

import java.util.Objects;
import subsystem.Amplifier;
import subsystem.DvdPlayer;
import subsystem.PopcornPopper;
import subsystem.Projector;
import subsystem.Screen;
import subsystem.TheaterLights;

public class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final DvdPlayer dvdPlayer;
    private final Projector projector;
    private final Screen screen;
    private final TheaterLights lights;
    private final PopcornPopper popcornPopper;
    private boolean movieRunning;

    public HomeTheaterFacade() {
        this(new Amplifier(), new DvdPlayer(), new Projector(), new Screen(), new TheaterLights(), new PopcornPopper());
    }

    HomeTheaterFacade(
            Amplifier amplifier,
            DvdPlayer dvdPlayer,
            Projector projector,
            Screen screen,
            TheaterLights lights,
            PopcornPopper popcornPopper) {
        this.amplifier = Objects.requireNonNull(amplifier, "amplifier must not be null");
        this.dvdPlayer = Objects.requireNonNull(dvdPlayer, "dvdPlayer must not be null");
        this.projector = Objects.requireNonNull(projector, "projector must not be null");
        this.screen = Objects.requireNonNull(screen, "screen must not be null");
        this.lights = Objects.requireNonNull(lights, "lights must not be null");
        this.popcornPopper = Objects.requireNonNull(popcornPopper, "popcornPopper must not be null");
    }

    public void watchMovie(String movieName) {
        String normalizedMovieName = normalizeMovieName(movieName);
        if (movieRunning) {
            System.out.println("A movie is already running.");
            return;
        }

        System.out.println("Get ready to watch a movie...");
        try {
            popcornPopper.turnOn();
            popcornPopper.cookPopcorn();
            lights.dimLights();
            screen.lowerScreen();
            projector.turnOn();
            projector.setImageMode("CINEMA");
            amplifier.turnOn();
            amplifier.setVolume(50);
            dvdPlayer.turnOn();
            dvdPlayer.playMovie(normalizedMovieName);
            movieRunning = true;
        } catch (RuntimeException exception) {
            System.out.println("Could not start movie mode: " + exception.getMessage());
            safeShutdown();
        }
    }

    public void endMovie() {
        if (!movieRunning) {
            System.out.println("Home theater is already idle.");
            return;
        }

        System.out.println("Shutting movie theater down...");
        safeShutdown();
    }

    private void safeShutdown() {
        executeSafely(dvdPlayer::stopMovie);
        executeSafely(dvdPlayer::turnOff);
        executeSafely(amplifier::turnOff);
        executeSafely(projector::turnOff);
        executeSafely(screen::raiseScreen);
        executeSafely(lights::turnOn);
        executeSafely(popcornPopper::turnOff);
        movieRunning = false;
    }

    private String normalizeMovieName(String movieName) {
        if (movieName == null || movieName.isBlank()) {
            throw new IllegalArgumentException("movieName must not be empty");
        }
        return movieName.trim();
    }

    private void executeSafely(Runnable step) {
        try {
            step.run();
        } catch (RuntimeException exception) {
            System.out.println("Shutdown step failed: " + exception.getMessage());
        }
    }
}
