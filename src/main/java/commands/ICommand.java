package commands;

public interface ICommand {
    void setFlagChildred(String[] flagChildred);
    String[] getFlagChildren();
    String getCommandDescriptionText();
    void executeCommand();
}
