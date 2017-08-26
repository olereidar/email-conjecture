package util;

import exceptions.ArgumentNotImplementedExeption;
import lib.EArguments;
import model.CommandList;

import java.util.ArrayList;

public class ArgumentExtractor {

    public static CommandList extractToCommandList(String[] args) throws ArgumentNotImplementedExeption {
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

    private static EArguments getFlagArgument(String argument) throws ArgumentNotImplementedExeption {
        for (EArguments eArgument : EArguments.values()) {
            if(eArgument.getArgument().equals(argument))
                return eArgument;

        }
        throw new ArgumentNotImplementedExeption(argument);
    }

    private static boolean isFlag(String argument) {
        return argument.startsWith("-");
    }


}
