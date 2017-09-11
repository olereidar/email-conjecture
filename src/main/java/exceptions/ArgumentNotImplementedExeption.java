package exceptions;

public class ArgumentNotImplementedExeption extends Exception {
    public ArgumentNotImplementedExeption(String argument) {
        super("\"" + argument + "\" er ikke et gyldig argument. For hjelp bruk argumentet \"-h\".");
    }
}
