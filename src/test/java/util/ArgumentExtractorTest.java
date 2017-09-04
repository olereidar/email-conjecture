package util;

import exceptions.ArgumentNotImplementedExeption;
import model.CommandList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ArgumentExtractorTest {

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void killStreams() {
        System.setErr(null);
    }

    @Test
    public void testMedEtArgumentSkalGiTalletEn() {
        String[] args = {"-h", "test", "test"};
        CommandList cmdList = ArgumentExtractor.extractToCommandList(args);
        assertThat(cmdList.size(), is(1));
    }

    @Test
    public void testMedArgumentUtenFlaggSkalGiTalletNull() {
        String[] args = {"ingenFlagg", "bare", "tilfeldige", "argumenter", "uten", "mål", "eller", "mening"};
        CommandList cmdList = ArgumentExtractor.extractToCommandList(args);
        assertThat(cmdList.size(), is(0));
    }

    @Test
    public void testMedEtFlaggOgTilfeldigeArgumenterSkalGiTalletEn()  {
        String[] args = {"ingenFlagg", "bare", "tilfeldige", "argumenter", "uten", "mål", "eller", "mening", "-h", "aWildFlagAppeared"};
        CommandList cmdList = ArgumentExtractor.extractToCommandList(args);
        assertThat(cmdList.size(), is(1));
    }

    @Test
    public void testMedFeilArgumenterKasterException() {
        String[] args = {"-etArgumentSomIkkeEksisterer"};
        ArgumentExtractor.extractToCommandList(args);
        assertTrue(errContent.toString().contains("exceptions.ArgumentNotImplementedExeption"));
    }

}