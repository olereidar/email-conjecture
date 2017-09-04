package model;

import lib.EArguments;

import java.util.HashMap;

public class CommandList extends HashMap<EArguments, String[]> {

    public void addCommand(EArguments arg, String[] values) {
        put(arg, values);
    }

}
