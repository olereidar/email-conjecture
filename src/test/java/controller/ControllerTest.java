package controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void killStreams() {
        System.setOut(null);
    }

    @Test
    public void testMedIngenArgumenterGirVanligOppfoersel() {
        String[] args = {};
        Controller c = new Controller(args);
        assertTrue(outContent.toString().contains("Ingen argumenter ble sendt med."));
    }

    @Test
    public void testMedArgumenterGirVanligOppfoersel() {
        String[] args = {"-h"};
        Controller c = new Controller(args);
        assertTrue(outContent.toString().contains("Email Conjecture er et prosjekt startet av frivillige studenter. Applikasjonen automatiserer gjetningsarbeid når man er usikker på en e-post adresse."));
    }

}