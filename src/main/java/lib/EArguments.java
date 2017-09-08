package lib;

import commands.ConjectureCommand;
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

    CONJECTURE("-s") {
        public ICommand getCorrespondingCommand(String[] nameAndFirm) {
            ConjectureCommand conjectureCommand = new ConjectureCommand();
            conjectureCommand.setFlagChildred(nameAndFirm);
            return conjectureCommand;
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
