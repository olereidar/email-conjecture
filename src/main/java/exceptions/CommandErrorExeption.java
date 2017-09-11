package exceptions;

public class CommandErrorExeption extends Exception {
    public CommandErrorExeption(String s) {
        super(s + "\r\n" + "Bruk [-h] for hjelp med rett syntaks.");
    }
}
