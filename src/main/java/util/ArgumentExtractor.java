package util;

import commands.ICommand;
import exceptions.ArgumentNotImplementedExeption;
import lib.EArguments;

import java.util.ArrayList;
import java.util.Arrays;
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


    public static String[] createConjectureArgumentsArray(String name, String firm, String domain) {
        final String DELIMITIER = " ";
        final String[] NAMES = name.split(DELIMITIER);
        final String[] FIRMS = firm.split(DELIMITIER);
        return toConjectureArgumentArray(EArguments.CONJECTURE, NAMES, "@", FIRMS, domain);
    }

    private static String[] toConjectureArgumentArray(EArguments eArgument, String[] names, String delimitier, String[] firms, String domain) {
        List<String> list = new ArrayList<>();
        list.add(eArgument.getArgument());
        list.addAll(Arrays.asList(names));
        list.add(delimitier);
        list.addAll(Arrays.asList(firms));
        if (domain.length() > 0) {
            if (!domain.contains(".")) {
                domain = String.format("%s%s", ".", domain); // legger på "." dersom det ikke skrives inn av brukeren.
            }
            list.add(domain);
        }
        return list.stream().filter(s -> s.length() > 0).toArray(String[]::new); // Fjerner alle tomme felter i arrayet og returnerer et nytt String[]
    }
}
