package commands;

import exceptions.CommandErrorExeption;
import util.ConjetureMachine;

import java.util.Arrays;
import java.util.List;

public class ConjectureCommand implements ICommand {

    private List<String> nameAndFirmArray;
    private final String description = "[-s] Starter generering av e-poster basert på navn og firma.";

    public void setFlagChildred(String[] flagChildred) {
        this.nameAndFirmArray = Arrays.asList(flagChildred);
    }

    public String[] getFlagChildren() {
        return nameAndFirmArray.toArray(new String[nameAndFirmArray.size()]);
    }

    public String getCommandDescriptionText() {
        return description;
    }

    public void executeCommand() {
        System.out.println(getCommandDescriptionText());
        try {
            System.out.println(nameAndFirmArray);
            List<String> listOfConjecturedEmails = ConjetureMachine.doEasyConjecture(nameAndFirmArray);
            System.out.println("----- Lister opp alle mulige e-postadresser -----");
            listOfConjecturedEmails.forEach((email) -> System.out.println(email));
        } catch (CommandErrorExeption commandErrorExeption) {
            System.err.println(commandErrorExeption);
        }
    }

}
