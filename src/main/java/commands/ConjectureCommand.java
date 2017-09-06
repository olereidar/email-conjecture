package commands;

import java.util.ArrayList;

public class ConjectureCommand implements ICommand {

    private String[] nameAndFirmArray;

    public void setFlagChildred(String[] flagChildred) {
        this.nameAndFirmArray = flagChildred;
    }

    public String[] getFlagChildren() {
        return nameAndFirmArray;
    }

    public String getCommandDescriptionText() {
        return "[-s] Starter generering av e-poster basert på navn og firma.";
    }

    public void executeCommand() {
        System.out.println(getCommandDescriptionText());
        // TODO: Lage et smart util for å trekke ut navn og firma.
        // Nå tar programmet bare i mot to argumenter (med mellomrom som skiller de)
        String name = nameAndFirmArray[0];
        String firm = nameAndFirmArray[1];

        // TODO: Utvide util for å lage en e-post på mange flere måter.
        // Dvs. flytt denne funksjonaliteten ut i en util.
        ArrayList<String> listOfConjecturedEmails = doEasyConjecture(name, firm);
        listOfConjecturedEmails.forEach((email) -> System.out.println(email));
    }

    private ArrayList<String> doEasyConjecture(String name, String firm) {
        ArrayList<String> list = new ArrayList<String>();
        String firstConjecture = String.format("%s@%s.no", name, firm);
        String secondConjecture = String.format("%s@%s.com", name, firm);
        String thirdConjecture = String.format("%s@%s.net", name, firm);
        list.add(firstConjecture);
        list.add(secondConjecture);
        list.add(thirdConjecture);
        return list;
    }

}
