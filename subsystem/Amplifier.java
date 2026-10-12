package subsystem;

public class Amplifier{
    private boolean isOn = false;
    private int volume = 100;
    private boolean surroundsound = false;

    public void turnOn(){
        if(!isOn){
            isOn = true;
            System.out.println("Amplifier now is active");
        }else{
            System.out.println("Amplifier now is active you can't turn it On!");
        }
    }

    public void turnOff(){
        if(isOn){
            isOn = false;
            System.out.println("Amplifier now is inactive");
        }else{
            System.out.println("Amplifier now is inactive you can't turn it Off!");
        }
    }

    public void setVolume(int value){
        if(isOn){
            if (0 <= value && value <= 100){
                volume = value;
                System.out.println("Volume: " + volume);
            }else{
                System.out.println("Choose correct value");
            }
        }else{
            System.out.println("Please turn on the Amplifier");
        }
    } 

    public void changeSurroundSound(){
        if(isOn){
            if(surroundsound){
                surroundsound = false;
                System.out.println("Surround Sound is disabled");
            }else{
                surroundsound = true;
                System.out.println("Surround Sound is Enabled");
            }
        }else{
            System.out.println("Please turn on the Amplifier");
        }
    }
}