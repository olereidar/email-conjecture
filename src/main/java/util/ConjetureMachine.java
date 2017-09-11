package util;

import exceptions.CommandErrorExeption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConjetureMachine {

    private static final String AT_FIRM = "@";
    private static final String DOMAIN_IDENTIFIER = ".";

    public static List<String> doEasyConjecture(List<String> nameAndFirmArray) throws CommandErrorExeption {
        final int firmIndex = getFirmIndex(nameAndFirmArray);
        final boolean hasSpecifiedDomain = hasSpecifiedDomain(nameAndFirmArray);
        List<String> names = nameAndFirmArray.subList(0, firmIndex - 1);
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
        List<String> list = new ArrayList<String>();
        list.addAll(conjectureFull(names));
        list.addAll(conjectureFirstLast(names));
        list.addAll(conjectureLastFirstSecond(names));
        list.addAll(conjectureShort(names));
        list.addAll(conjectureShortFirstSecondLongLast(names));
        list.addAll(conjectureShortFirstLast(names));
        list.addAll(conjectureShortFirstLongLast(names));
        list.addAll(names);
        //System.out.println(list);
        return list;
    }

    private static List<String> conjectureShortFirstLongLast(List<String> list) {
        List<String> conjecturedList = new ArrayList<String>();
        conjecturedList.add(getShort(getFirst(list), 1));
        conjecturedList.add(getLast(list));
        return conjectureFull(conjecturedList);
    }

    private static List<String> conjectureShortFirstLast(List<String> list) {
        return conjectureFirstLast(getShortList(list));
    }

    private static List<String> getShortList(List<String> arr) {
        return arr.stream().map(s -> getShort(s, 1)).collect(Collectors.toList());
    }

    private static List<String> conjectureShortFirstSecondLongLast(List<String> list) {
        List<String> conjecturedList = new ArrayList<String>();
        conjecturedList.addAll(getShortList(list));
        conjecturedList.remove(conjecturedList.size() - 1);
        conjecturedList.add(getLast(list));
        return conjectureFull(conjecturedList);
    }

    private static List<String> conjectureShort(List<String> list) {
        return conjectureFull(getShortList(list));
    }

    private static String getShort(String name, int howManyCharsLong) {
        return name.substring(0, howManyCharsLong);
    }

    private static List<String> conjectureFirstLast(List<String> names) {
        List<String> listFirstLast = new ArrayList<String>();
        listFirstLast.add(getFirst(names));
        listFirstLast.add(getLast(names));
        return conjectureFull(listFirstLast);
    }

    private static List<String> conjectureLastFirstSecond(List<String> names) {
        List<String> list = new ArrayList<String>();
        list.add(names.get(names.size() - 1));
        list.addAll(names);
        list.remove(list.size() - 1);
        return conjectureFull(list);
    }

    private static String getFirst(List<String> arr) {
        return arr.get(0);
    }

    private static String getLast(List<String> arr) {
        return arr.get(arr.size() - 1);
    }

    private static List<String> conjectureFull(List<String> list) {
        String[] conjecture = {
                conjectureFullWithDelimitier(list, ""),
                conjectureFullWithDelimitier(list, "."),
                conjectureFullWithDelimitier(list, "-"),
                conjectureFullWithDelimitier(list, "_"),
                conjectureFullWithDelimitier(getReversed(list), ""),
                conjectureFullWithDelimitier(getReversed(list), "."),
                conjectureFullWithDelimitier(getReversed(list), "-"),
                conjectureFullWithDelimitier(getReversed(list), "_")
        };
        return new ArrayList<String>(Arrays.asList(conjecture));
    }

    private static List<String> getReversed(List<String> list) {
        List<String> reversedList = new ArrayList<String>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    private static String conjectureFullWithDelimitier(List<String> arr, String delimiter) {
        return arr.stream().map(x -> x).collect(Collectors.joining(delimiter));
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
