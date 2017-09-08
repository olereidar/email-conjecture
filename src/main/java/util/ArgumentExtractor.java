package util;

import commands.ICommand;
import exceptions.ArgumentNotImplementedExeption;
import lib.EArguments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArgumentExtractor {

    public static List<ICommand> extractToCommandList(String[] args) {
        List<ICommand> commandList = new ArrayList<ICommand>();
        sortArgumentsBasedOnFlag(args).forEach((argument, flagChildren) -> commandList.add(argument.getCorrespondingCommand(flagChildren)));
        return commandList;
    }

    private static HashMap<EArguments, String[]> sortArgumentsBasedOnFlag(String[] args) {
        HashMap<EArguments, String[]> cmdList = new HashMap<EArguments, String[]>();
        for (int x = 0; x < args.length; x++) {
            if (isFlag(args[x])) {
                try {
                    cmdList.put(getFlagArgument(args[x]), getFlagChildren(args, x));
                } catch (ArgumentNotImplementedExeption exeption) {
                    System.err.print(exeption);
                }
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
