import facade.HomeTheaterFacade;

public class Main {

    public static void main(String[] args) {

        HomeTheaterFacade facade = new HomeTheaterFacade();

        facade.watchMovie("Interstellar");


        try {
        Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
       
        }


        System.out.println("----------------------");
        facade.endMovie();
    }
}