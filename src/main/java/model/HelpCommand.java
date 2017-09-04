package model;

public class HelpCommand {

    private final String HELP_COMMAND_TEXT =
            "Email Conjecture er et prosjekt startet av frivillige studenter. Applikasjonen automatiserer gjetningsarbeid når man er usikker på en e-post adresse.\r\n" +
            "\r\n" +
            "Bruk:" +
            "Kjør programmet fra kommandolinja etterfulgt av et flagg." +
            "\r\n" +
            "Flagg:" +
            "[-h] - viser hjelp";


    public String getCommandText() {
        return  HELP_COMMAND_TEXT;
    }

}
