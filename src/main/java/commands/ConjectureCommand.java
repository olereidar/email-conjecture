package commands;

import exceptions.CommandErrorExeption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConjectureCommand implements ICommand {

    private final String AT_FIRM = "@";
    private List<String> nameAndFirmArray;

    public void setFlagChildred(String[] flagChildred) {
        this.nameAndFirmArray = Arrays.asList(flagChildred);
    }

    public String[] getFlagChildren() {
        return nameAndFirmArray.toArray(new String[nameAndFirmArray.size()]);
    }

    public String getCommandDescriptionText() {
        return "[-s] Starter generering av e-poster basert på navn og firma.";
    }

    public void executeCommand() {
        System.out.println(getCommandDescriptionText());
        try {
            final int firmIndex = getFirmIndex(nameAndFirmArray);
            final boolean hasSpecifiedDomain = hasSpecifiedDomain(nameAndFirmArray); // TODO: ikke implementert.
            List<String> names = nameAndFirmArray.subList(0, firmIndex - 1);
            List<String> firm = nameAndFirmArray.subList(firmIndex, nameAndFirmArray.size());

            // TODO: Utvide util for å lage en e-post på mange flere måter.
            // Dvs. flytt denne funksjonaliteten ut i en util.
            List<String> listOfConjecturedEmails = doEasyConjecture(names, firm);
            listOfConjecturedEmails.forEach((email) -> System.out.println(email));
        } catch (CommandErrorExeption commandErrorExeption) {
            commandErrorExeption.printStackTrace();
        }
    }

    private List<String> doEasyConjecture(List<String> names, List<String> firm) {
        List<String> conjecturedEmails = new ArrayList<String>();
        // TODO: Begynn å gjett på e-poster
        return conjecturedEmails;
    }

    private int getFirmIndex(List<String> nameAndFirmArray) throws CommandErrorExeption {
        final int indexOfAt = nameAndFirmArray.indexOf(AT_FIRM);
        final int DOES_NOT_EXIST = -1;
        if (indexOfAt == DOES_NOT_EXIST) {
            final int ONLY_TWO_FLAG_CHILDREN = 2;
            if (nameAndFirmArray.size() == ONLY_TWO_FLAG_CHILDREN) {
                // Antar at firma kommer som andre argument dersom ikke "@" er med som argument.
                return nameAndFirmArray.size() - 1;
            } else {
                throw new CommandErrorExeption("[-s] - " + nameAndFirmArray.toString() + " er ikke gyldig.");
            }
        }
        return indexOfAt + 1;
    }

    private boolean hasSpecifiedDomain(List<String> firmArray) {
        // TODO: Implementere en sjekk på om ".no" er nevnt feks.
        return false;
    }

}
