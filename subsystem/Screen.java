package subsystem;

public class Screen{
    private boolean isLowered = false;

    public void lowerScreen(){
        if(!isLowered){
            isLowered = true; 
            System.out.println("Screen now is lowered");
        }else{
            System.out.println("You can't lower the Screen twice");
        }
    }

    public void raiseScreen(){
        if(isLowered){
            isLowered = false; 
            System.out.println("Screen now is raised");
        }else{
            System.out.println("You can't raise the Screen twice");
        }
    }
}