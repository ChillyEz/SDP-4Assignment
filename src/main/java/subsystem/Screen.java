package subsystem;

public class Screen {
    private boolean lowered;

    public void lowerScreen() {
        if (lowered) {
            System.out.println("Screen is already lowered.");
            return;
        }
        lowered = true;
        System.out.println("Screen lowered.");
    }

    public void raiseScreen() {
        if (!lowered) {
            System.out.println("Screen is already raised.");
            return;
        }
        lowered = false;
        System.out.println("Screen raised.");
    }
}
