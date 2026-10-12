package subsystem;

public class PopcornPopper{
    private boolean isCooking = false;
    private boolean isOn= false;
    private boolean hasPopcorn = false;

    public void turnOn(){
        if(!isOn){
            isOn = true;
            System.out.println("PopcornPopper now is active");
        }else{
            System.out.println("PopcornPopper now is active you can't turn it On!");
        }
    }

    public void turnOff(){
        if(isOn){
            isOn = false;
            System.out.println("PopcornPopper now is inactive");
        }else{
            System.out.println("PopcornPopper now is inactive you can't turn it Off!");
        }
    }

    public void cookPopcorn(){
        if(!isOn){
            System.out.println("Please turn Popcorn Popper on");
        }else{
            if(isCooking){
                System.out.println("Wait until cooking ends");
            }else{
                isCooking = true;
                System.out.println("Popcorn is cooking");
                System.out.println("Popcorn is ready");
                isCooking = false;
                hasPopcorn = true;
            }
        }
    }

    public void giveOutPopcorn(){
        if(hasPopcorn){
            hasPopcorn = false;
            System.out.println("Popcorn have dispensed");
        }else{
            System.out.println("No Popcorn!");
        }
    }
}