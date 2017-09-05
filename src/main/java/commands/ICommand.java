package commands;

import java.util.List;

public interface ICommand {
    void setFlagChildred(String[] flagChildred);
    String[] getFlagChildren();
    String getCommandDescriptionText();
    List<String> getCommandTextData();
    void executeCommand();
}
