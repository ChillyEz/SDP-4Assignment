package subsystem;

public class PopcornPopper {
    private boolean cooking;
    private boolean on;
    private boolean hasPopcorn;

    public void turnOn() {
        if (on) {
            System.out.println("Popcorn popper is already on.");
            return;
        }
        on = true;
        System.out.println("Popcorn popper turned on.");
    }

    public void turnOff() {
        if (!on) {
            System.out.println("Popcorn popper is already off.");
            return;
        }
        cooking = false;
        on = false;
        System.out.println("Popcorn popper turned off.");
    }

    public void cookPopcorn() {
        if (!ensurePoweredOn()) {
            return;
        }
        if (cooking) {
            System.out.println("Popcorn is already cooking.");
            return;
        }

        cooking = true;
        System.out.println("Popcorn is cooking...");
        System.out.println("Popcorn is ready.");
        cooking = false;
        hasPopcorn = true;
    }

    public void giveOutPopcorn() {
        if (!hasPopcorn) {
            System.out.println("No popcorn to dispense.");
            return;
        }
        hasPopcorn = false;
        System.out.println("Popcorn dispensed.");
    }

    private boolean ensurePoweredOn() {
        if (on) {
            return true;
        }
        System.out.println("Turn on the popcorn popper first.");
        return false;
    }
}
