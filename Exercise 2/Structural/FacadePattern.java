// Subsystem 1: DVD Player
class DvdPlayer {
    public void on() {
        System.out.println("DVD Player is ON.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player is OFF.");
    }
}

// Subsystem 2: Projector
class Projector {
    public void on() {
        System.out.println("Projector is ON.");
    }

    public void setWideScreenMode() {
        System.out.println("Projector is set to Wide Screen Mode.");
    }

    public void off() {
        System.out.println("Projector is OFF.");
    }
}

// Subsystem 3: Amplifier
class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON.");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier volume is set to " + level + ".");
    }

    public void off() {
        System.out.println("Amplifier is OFF.");
    }
}

// Subsystem 4: Lights
class TheaterLights {
    public void dim(int level) {
        System.out.println("Theater lights dimmed to " + level + "%.");
    }

    public void on() {
        System.out.println("Theater lights are ON.");
    }
}

// Facade: Home Theater Facade
class HomeTheaterFacade {
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;
    private TheaterLights lights;

    public HomeTheaterFacade(DvdPlayer dvdPlayer, Projector projector, Amplifier amplifier, TheaterLights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.amplifier = amplifier;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(20);
        projector.on();
        projector.setWideScreenMode();
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        System.out.println("Enjoy your movie!");
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        dvdPlayer.off();
        projector.off();
        amplifier.off();
        lights.on();
    }
}

// Client
public class FacadePattern {
    public static void main(String[] args) {
        // Create subsystem components
        DvdPlayer dvdPlayer = new DvdPlayer();
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        TheaterLights lights = new TheaterLights();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, amplifier, lights);

        // Use the facade to control the home theater
        homeTheater.watchMovie("Inception");
        System.out.println("\n--- Movie Finished ---\n");
        homeTheater.endMovie();
    }
}

/*
This program demonstrates the Facade Design Pattern by creating a HomeTheaterFacade
to simplify interactions with multiple subsystems like DVD Player, Projector, Amplifier,
and Theater Lights. The facade provides a unified interface to perform complex operations
like starting and shutting down the home theater system.
This approach enhances usability by hiding the complexity of subsystem interactions
from the client.
 */
