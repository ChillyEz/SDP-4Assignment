package subsystem;

public class DvdPlayer{
    private String currentMovie = "Waiting screen";
    private boolean isPlaying = false;
    private boolean isOn = false;

    public void turnOn(){
        if(!isOn){
            isOn = true;
            System.out.println("DvdPlayer now is active");
        }else{
            System.out.println("DvdPlayer now is active you can't turn it On!");
        }
    }

    public void turnOff(){
        if(isOn){
            isPlaying = false;
            isOn = false;
            System.out.println("DvdPlayer now is inactive");
        }else{
            System.out.println("DvdPlayer now is inactive you can't turn it Off!");
        }
    }

    public void playMovie(){
        if(isOn){
            isPlaying = true;
            System.out.println("Currently playing : " + currentMovie);
        }else{
            System.out.println("Please turn on the DVD Player");
        }
    }

    public void playMovie(String movieName){
        if(isOn){
            currentMovie = movieName;
            isPlaying = true;
            System.out.println("Currently playing : " + movieName);
        }else{
            System.out.println("Please turn on the DVD Player");
        }
    }



    public void togglePause(){
        if(isOn){
            if(isPlaying){
                isPlaying = false;
                System.out.println("Movie paused");
            }else{
                isPlaying = true;
                System.out.println("Movie is unpaused");
            }
        }else{
            System.out.println("Please turn on the DVD Player");
        }
    }

    public void discEjection(){
        isPlaying = false;
        System.out.println("disc is ready to be ejected");
    }
}