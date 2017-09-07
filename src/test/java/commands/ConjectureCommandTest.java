package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ConjectureCommandTest {

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setErr(new PrintStream(errContent));
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void killStreams() {
        System.setErr(null);
        System.setOut(null);
    }

    @Test
    public void testUtenArgumenterGiFeilmelding() throws Exception {
        ConjectureCommand cc = new ConjectureCommand();
        String[] flagChildren = {};
        cc.setFlagChildred(flagChildren);
        cc.executeCommand();
        assertTrue(errContent.toString().length() != 0);
    }

    @Test
    public void testMedFeilArgumenterGiFeilmelding() throws Exception {
        ConjectureCommand cc = new ConjectureCommand();
        String[] flagChildren = {"det", "skal", "ikke", "være", "slik"};
        cc.setFlagChildred(flagChildren);
        cc.executeCommand();
        assertTrue(errContent.toString().length() != 0);
    }

    @Test
    public void testMedRiktigToArgumenterGirVanligOppfoersel() throws Exception {
        ConjectureCommand cc = new ConjectureCommand();
        String[] flagChildren = {"olereidar", "firma"};
        cc.setFlagChildred(flagChildren);
        cc.executeCommand();
        assertTrue(errContent.toString().length() == 0);
    }

    @Test
    public void testMedRiktigArgumenterGirVanligOppfoersel() throws Exception {
        ConjectureCommand cc = new ConjectureCommand();
        String[] flagChildren = {"fornavn", "mellomnavn", "etternavn", "@", "firma"};
        cc.setFlagChildred(flagChildren);
        cc.executeCommand();
        assertTrue(errContent.toString().length() == 0);
    }
}