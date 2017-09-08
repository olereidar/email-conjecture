import controller.Controller;
import gui.ApplicationGui;

public class App {

    public static void main(String[] args) {
        System.out.println("Email Conjecture");
        Controller controller = new Controller(args);
        ApplicationGui applicationGui = new ApplicationGui();
    }

}
