package controller;

import exceptions.ArgumentNotImplementedExeption;
import lib.EArguments;
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
            System.out.println("Ingen argumenter ble sendt med.");
        }
    }

    private void doConjecture(String[] args) {
        try {
            CommandList cmdList = ArgumentExtractor.extractToCommandList(args);
            cmdList.forEach((command, arguments) -> {
                runCommand(command, arguments);
            });
        } catch (ArgumentNotImplementedExeption exeption) {
            System.err.print(exeption);
        }
    }

    private void runCommand(EArguments command, String[] args) {
        switch (command) {
            case HELP:
                System.out.println("You need some help. Okey!");
                break;
            default:
                System.out.println("Kjør default.");
                break;
        }
    }

    private boolean isArgument(String[] args) {
        return args.length > 0;
    }

}
