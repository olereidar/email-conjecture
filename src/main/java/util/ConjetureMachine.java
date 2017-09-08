package util;

import exceptions.CommandErrorExeption;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConjetureMachine {

    private static final String AT_FIRM = "@";
    private static final String DOMAIN_IDENTIFIER = ".";

    public static List<String> doEasyConjecture(List<String> nameAndFirmArray) throws CommandErrorExeption {
        final int firmIndex = getFirmIndex(nameAndFirmArray);
        final boolean hasSpecifiedDomain = hasSpecifiedDomain(nameAndFirmArray);
        List<String> names = nameAndFirmArray.subList(0, firmIndex);
        List<String> firm = nameAndFirmArray.subList(firmIndex, nameAndFirmArray.size());

        // TODO: Begynn å gjett på e-poster

        names = conjectureNamesToList(names);
        firm = conjectureFirmToList(firm, hasSpecifiedDomain);

        return joinConjecturedNamesFirmsToList(names, firm);
    }

    private static List<String> joinConjecturedNamesFirmsToList(List<String> names, List<String> firm) {
        //TODO
        List<String> conjecturedList = Stream.concat(names.stream(), firm.stream()).collect(Collectors.toList());
        return conjecturedList;
    }

    private static List<String> conjectureFirmToList(List<String> firm, boolean hasSpecifiedDomain) {
        // TODO
        return firm;
    }

    private static List<String> conjectureNamesToList(List<String> names) {
        // TODO
        return names;
    }

    private static int getFirmIndex(List<String> nameAndFirmArray) throws CommandErrorExeption {
        final int indexOfAt = nameAndFirmArray.indexOf(AT_FIRM);
        final int DOES_NOT_EXIST = -1;
        if (indexOfAt == DOES_NOT_EXIST || nameAndFirmArray == null) {
            throw new CommandErrorExeption("[-s] - " +
                    nameAndFirmArray == null || nameAndFirmArray.size() == 0 ?
                    "Ingen argumenter." :
                    nameAndFirmArray.toString() + " er ikke gyldig.");
        }
        return indexOfAt + 1;
    }

    private static boolean hasSpecifiedDomain(List<String> firmArray) {
        return firmArray.get(firmArray.size() - 1).contains(DOMAIN_IDENTIFIER);
    }

}
