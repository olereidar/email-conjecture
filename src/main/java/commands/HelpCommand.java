package commands;

import java.util.Arrays;

public class HelpCommand implements ICommand {

    private final String[] HELP_COMMAND_TEXT =
            {
                    "",
                    "Bruk:",
                    "Kjør programmet fra kommandolinja etterfulgt av et flagg.",
                    "",
                    "Flagg:",
                    "[-h] - Viser denne hjelpeteksten,",
                    "[-s] - Starter generering av e-poster basert på navn og firma.",
                    "    " + "-s navn @ firma",
                    "    " + "-s fornavn mellomnavn etternavn @ firma",
                    "    " + "-s navn @ firma .domene"
            };

    private String[] flagChildren;

    public void executeCommand() {
        System.out.println(getCommandDescriptionText());
        if (hasChildren()) {
            System.err.println("Dette flagget [-h] tillater ingen argumenter og blir dermed ikke tatt hensyn til.");
        }
        Arrays.asList(HELP_COMMAND_TEXT).forEach((line) -> System.out.println(line));
    }

    private boolean hasChildren() {
        return this.flagChildren.length > 0;
    }

    public void setFlagChildred(String[] flagChildred) {
        this.flagChildren = flagChildred;
    }

    public String[] getFlagChildren() {
        return this.flagChildren;
    }

    public String getCommandDescriptionText() {
        return "Email Conjecture er et prosjekt startet av frivillige studenter. Applikasjonen automatiserer gjetningsarbeid når man er usikker på en e-post adresse.";
    }

}
