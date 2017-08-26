package controller;

import exceptions.ArgumentNotImplementedExeption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void killStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testMedIngenArgumenterGirVanligOppfoersel() {
        String[] args = {};
        Controller c = new Controller(args);
        assertThat(outContent.toString(), is("Ingen argumenter ble sendt med.\r\n"));
    }

    @Test
    public void testMedArgumenterGirVanligOppfoersel() {
        String[] args = {"-h"};
        Controller c = new Controller(args);
        assertThat(outContent.toString(), is("You need some help. Okey!\r\n"));
    }

    @Test
    public void testMedFeilArgumenterKasterException() {
        String[] args = {"-etArgumentSomIkkeEksisterer"};
        Controller c = new Controller(args);
        assertTrue(errContent.toString().startsWith("exceptions.ArgumentNotImplementedExeption"));
    }

}