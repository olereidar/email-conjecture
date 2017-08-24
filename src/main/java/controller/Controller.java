package controller;

public class Controller {

    public Controller(String[] args) {
        if (isArgument(args)){
            // TODO: Benytte argumentene som ble sendt med slik at bruker får det slik som h*n vil
                // Eksempel: argument -h skal vise hjelpetekst i konsoll.
        } else {
            // TODO: Bruker skal kunne konfigurere innstillingene selv.
            System.out.print("Ingen argumenter ble sendt med.");
        }
    }

    private boolean isArgument(String[] args) {
        return args.length < 0 ? true : false;
    }

}
