package facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class HomeTheaterFacadeTest {

    @Test
    void watchMovieRejectsBlankMovieName() {
        HomeTheaterFacade facade = new HomeTheaterFacade();

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.watchMovie("   ")
        );
    }


    @Test
    void secondWatchMovieReportsThatMovieIsAlreadyRunning() throws Exception {
        HomeTheaterFacade facade = new HomeTheaterFacade();

        facade.watchMovie("Interstellar");
        String text = captureSystemOutput(
                () -> facade.watchMovie("Another Movie")
        );

        assertEquals("A movie is already running.", text.trim());
    }


    @Test
    void watchMovieAcceptsValidMovieName() {
        HomeTheaterFacade facade = new HomeTheaterFacade();

        assertDoesNotThrow(() -> facade.watchMovie("Interstellar"));
    }




    private String captureSystemOutput(Runnable action) {
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();

        try (PrintStream temporaryOutput = new PrintStream(capturedOutput, true, StandardCharsets.UTF_8)) {
            System.setOut(temporaryOutput);
            action.run();
        } finally {
            System.setOut(originalOutput);
        }

        return capturedOutput.toString(StandardCharsets.UTF_8);
    }

    @Test
    void endMovieStopsTheRunningMovie() {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.watchMovie("Interstellar");

        String text = captureSystemOutput(facade::endMovie);

        assertTrue(text.contains("Movie stopped: Interstellar."));
    }
}
