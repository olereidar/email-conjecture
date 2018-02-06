package controller;

import checkMXReccord.ValidateExsistingMailServer;
import commands.ICommand;
import util.ArgumentExtractor;

import java.util.List;
import java.util.Scanner;

public class Controller {

    public Controller(String[] args) {
        ValidateExsistingMailServer ValidateExsistingMailServer= new ValidateExsistingMailServer();
        if (isArgument(args)){
            doConjecture(args);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingen argumenter ble sendt med. Programmet vil nå spørre etter det selv.");
            System.out.println("----- OBLIGATORISK -----");
            System.out.print("Navn: ");
            String name = scanner.nextLine().trim();
            System.out.print("Firma: ");
            String firm = scanner.nextLine().trim();
            System.out.println("----- IKKE OBLIGATORISK -----");
            System.out.print("Domene: ");
            String domain = scanner.nextLine().trim();
            String[] arguments = ArgumentExtractor.createConjectureArgumentsArray(name, firm, domain);
            doConjecture(arguments);
        }
        // Send inn som argument for eksempel www.domene.no
        if(args.length == 0) {
            System.err.println( "Ingen argumenter sendt inn 'website.com'" );
            System.exit(99);
        }
        // Kjør sjekk mot domene om der eksisterer mail-server
        for(int i = 0; i < args.length; i++) {
            try {
                System.out.println(args[i] + " har " +
                        ValidateExsistingMailServer.doLookup(args[i]) + " mail servere" );
            }
            catch(Exception e ) {
                System.out.println(args[i] + " : "+ e.getMessage());
            }
        }
    }

    private void doConjecture(String[] args) {
        List<ICommand> commandList = ArgumentExtractor.extractToCommandList(args);
        commandList.forEach(command -> command.executeCommand());
    }

    private boolean isArgument(String[] args) {
        return args.length > 0;
    }

}
