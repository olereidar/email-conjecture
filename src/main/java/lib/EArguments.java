package lib;

import commands.HelpCommand;
import commands.ICommand;

public enum EArguments {

    HELP("-h") {
        public ICommand getCorrespondingCommand(String[] values) {
            HelpCommand helpCommand = new HelpCommand();
            helpCommand.setFlagChildred(values);
            return helpCommand;
        }
    },

    NAME("-navn") {
        public ICommand getCorrespondingCommand(String[] values) {
            return null;
        }
    },

    FIRM("-firma") {
        public ICommand getCorrespondingCommand(String[] values) {
            return null;
        }
    };


    private final String argument;

    EArguments(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    public abstract ICommand getCorrespondingCommand(String[] values);

}
