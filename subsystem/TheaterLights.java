package subsystem;

public class TheaterLights{
    private int brightness = 100;

    public void dimmingLight(){
        brightness = 30;
        System.out.println("Theater lights dimmed");
    }

    public void turnOn(){
        brightness = 100;
        System.out.println("Theater lights turned on");
    }

    public void turnOff(){
        brightness = 0;
        System.out.println("Theater lights turned off");
    }
}