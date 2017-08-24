package controller;

import model.CommandList;
import util.ArgumentExtractor;

public class Controller {

    public Controller(String[] args) {
        if (isArgument(args)){
            // TODO: Benytte argumentene som ble sendt med slik at bruker får det slik som h*n vil
                // Eksempel: argument -h skal vise hjelpetekst i konsoll.
            doConjecture(args);

        } else {
            // TODO: Bruker skal kunne konfigurere innstillingene selv.
            System.out.print("Ingen argumenter ble sendt med.");
        }
    }

    private void doConjecture(String[] args) {
        CommandList cmdList = ArgumentExtractor.extractToCommandList(args);

        System.out.println("Kommandoliste laget. Her kommer kommandoene:");
        System.out.println(cmdList);
    }

    private boolean isArgument(String[] args) {
        return args.length > 0;
    }

}
