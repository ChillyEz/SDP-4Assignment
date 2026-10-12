package subsystem;

public class Projector {
    private boolean isOn = false;
    private String imageMode = "STANDARD";

    public void turnOn(){
        if(!isOn){
            isOn = true;
            System.out.println("Projector now is active");
        }else{
            System.out.println("Projector now is active you can't turn it On!");
        }
    }

    public void turnOff(){
        if(isOn){
            isOn = false;
            System.out.println("Projector now is inactive");
        }else{
            System.out.println("Projector now is inactive you can't turn it Off!");
        }
    }

    public void setImageMode(String mode){
        if(isOn){
            imageMode = mode;
            System.out.println("Current Image mode : " + imageMode);
        }else{
            System.out.println("Please turn on the Projector");
        }
    }


}