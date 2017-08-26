package lib;

public enum EArguments {

    HELP("-h");

    private final String argument;

    EArguments(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

}
