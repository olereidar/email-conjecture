package lib;

public enum EArguments {

    HELP("-h") {
        public void runCommand(String[] values) {
            System.out.println("Email Conjecture er et prosjekt startet av frivillige studenter. Applikasjonen automatiserer gjetningsarbeid når man er usikker på en e-post adresse.");

            System.out.println();
            System.out.println("Bruk:");
            System.out.println("Kjør programmet fra kommandolinja etterfulgt av et flagg.");

            System.out.println();
            System.out.println("Flagg:");
            System.out.println("[-h] - viser hjelp");
        }
    };

    private final String argument;

    EArguments(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    public abstract void runCommand(String[] values);

}
