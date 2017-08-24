package util;

import lib.EArguments;
import model.CommandList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArgumentExtractor {

    public static CommandList extractToCommandList(String[] args) {
        CommandList cmdList = new CommandList();
        for (int x = 0; x < args.length; x++) {
            if (isFlag(args[x])) {
                cmdList.addCommand(getFlagArgument(args[x]), getFlagChildren(args, x));
            }
        }
        return cmdList;
    }

    private static String[] getFlagChildren(String[] args, int index) {
        ArrayList<String> flagChildren = new ArrayList<String>();
        boolean isFirstFlag = true;
        for(int i = index; i < args.length; i++) {
            if(isFlag(args[i]) && isFirstFlag) {
                isFirstFlag = false;
            } else if(isFlag(args[i]) && !isFirstFlag) {
                break;
            }
            else {
                flagChildren.add(args[i]);
            }
        }
        return flagChildren.toArray(new String[flagChildren.size()]);
    }

    private static EArguments getFlagArgument(String argument) {
        for (EArguments eArgument : EArguments.values()) {
            System.out.println(eArgument.getArgument());
            if(eArgument.getArgument().equals(argument))
                return eArgument;

        }
        // TODO: Gjør noe lurt dersom argumentet ikke finnes.
        return null;
    }

    private static boolean isFlag(String argument) {
        return argument.startsWith("-");
    }


}
