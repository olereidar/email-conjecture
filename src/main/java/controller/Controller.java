package controller;

import commands.ICommand;
import util.ArgumentExtractor;

import java.util.List;

public class Controller {

    public Controller(String[] args) {
        if (isArgument(args)){
            // TODO: Benytte argumentene som ble sendt med slik at bruker får det slik som h*n vil
                // Eksempel: argument -h skal vise hjelpetekst i konsoll.
            doConjecture(args);
        } else {
            // TODO: Bruker skal kunne konfigurere innstillingene selv.
            System.out.println("Ingen argumenter ble sendt med.");
        }
    }

    private void doConjecture(String[] args) {
        List<ICommand> commandList = ArgumentExtractor.extractToCommandList(args);
        // TODO: https://stackoverflow.com/questions/46057609/do-something-if-the-list-contains-two-objects-of-class
    }

    private boolean isArgument(String[] args) {
        return args.length > 0;
    }

}
