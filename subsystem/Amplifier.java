package subsystem;

public class Amplifier {
    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;

    private boolean on;
    private int volume = MAX_VOLUME;
    private boolean surroundSoundEnabled;

    public void turnOn() {
        if (on) {
            System.out.println("Amplifier is already on.");
            return;
        }
        on = true;
        System.out.println("Amplifier turned on.");
    }

    public void turnOff() {
        if (!on) {
            System.out.println("Amplifier is already off.");
            return;
        }
        on = false;
        System.out.println("Amplifier turned off.");
    }

    public void setVolume(int value) {
        if (!ensurePoweredOn("set volume")) {
            return;
        }
        if (value < MIN_VOLUME || value > MAX_VOLUME) {
            System.out.println("Volume must be between 0 and 100.");
            return;
        }
        volume = value;
        System.out.println("Amplifier volume set to " + volume + ".");
    }

    public void toggleSurroundSound() {
        if (!ensurePoweredOn("change surround sound")) {
            return;
        }
        surroundSoundEnabled = !surroundSoundEnabled;
        System.out.println("Surround sound " + (surroundSoundEnabled ? "enabled" : "disabled") + ".");
    }

    public void changeSurroundSound() {
        toggleSurroundSound();
    }

    private boolean ensurePoweredOn(String action) {
        if (on) {
            return true;
        }
        System.out.println("Turn on the amplifier before you " + action + ".");
        return false;
    }
}
