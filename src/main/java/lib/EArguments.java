package lib;

import model.HelpCommand;

public enum EArguments {

    HELP("-h") {
        public void runCommand(String[] values) {
            HelpCommand helpCommand = new HelpCommand();
            System.out.println(helpCommand.getCommandText());
        }
    },

    NAME("-navn") {

        private boolean isCalled = false;

        public void runCommand(String[] values) {
            isCalled = true;

        }

        boolean isCalled() {
            return isCalled;
        }
    },

    FIRM("-firma") {

        private boolean isCalled = false;

        public void runCommand(String[] values) {
            isCalled = true;

        }

        boolean isCalled() {
            return isCalled;
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
