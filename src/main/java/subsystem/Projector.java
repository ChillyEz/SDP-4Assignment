package subsystem;

public class Projector {
    private static final String STANDARD_MODE = "STANDARD";

    private boolean on;
    private String imageMode = STANDARD_MODE;

    public void turnOn() {
        if (on) {
            System.out.println("Projector is already on.");
            return;
        }
        on = true;
        System.out.println("Projector turned on.");
    }

    public void turnOff() {
        if (!on) {
            System.out.println("Projector is already off.");
            return;
        }
        on = false;
        imageMode = STANDARD_MODE;
        System.out.println("Projector turned off.");
    }

    public void setImageMode(String mode) {
        if (!ensurePoweredOn()) {
            return;
        }
        if (mode == null || mode.isBlank()) {
            System.out.println("Image mode must not be empty.");
            return;
        }
        imageMode = mode.trim().toUpperCase();
        System.out.println("Projector mode set to " + imageMode + ".");
    }

    private boolean ensurePoweredOn() {
        if (on) {
            return true;
        }
        System.out.println("Turn on the projector first.");
        return false;
    }
}
