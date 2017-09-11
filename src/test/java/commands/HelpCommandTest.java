package commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class HelpCommandTest {

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
    public void testMedIngenFlaggGirVanligOppfoersel() throws Exception {
        HelpCommand hc = new HelpCommand();
        String[] flagChildren = {};
        hc.setFlagChildred(flagChildren);
        hc.executeCommand();
        assertTrue(errContent.toString().length() == 0);
    }

    @Test
    public void testMedFlaggGirFeilmelding() throws Exception {
        HelpCommand hc = new HelpCommand();
        String[] flagChildren = {"et", "eller", "flere", "argumenter"};
        hc.setFlagChildred(flagChildren);
        hc.executeCommand();
        assertTrue(errContent.toString().length() != 0);
    }
}