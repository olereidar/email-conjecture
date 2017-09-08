package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class ApplicationGui extends JFrame implements ActionListener {

    JLabel firstnameLabel, displayText, lastNameLabel;
    JTextField firstName;
    JTextField lastName;
    JButton generateEmails;

    public ApplicationGui() {
        super("Email-conjecture");
        setSize(600,900);
        setBounds(200, 200, 700, 300);
        setVisible(true);

        Container contentpane = getContentPane();
        contentpane.setLayout(new GridLayout(5,1,5,10));

        generateEmails = new JButton("Generate Emails!");
        generateEmails.addActionListener(this);
        firstnameLabel = new JLabel("Firstname");
        lastNameLabel = new JLabel("Lastname");
        displayText = new JLabel("Skriv inn tekst:");
        firstName = new JTextField(10);
        lastName = new JTextField(10);
        firstName.addActionListener(this);

        contentpane.add(firstnameLabel);
        contentpane.add(firstName);
        contentpane.add(lastNameLabel);
        contentpane.add(lastName);

        contentpane.add(generateEmails);
        contentpane.add(displayText);
        contentpane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //  pack();
        paintComponents(getGraphics());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == firstName || e.getSource() == generateEmails
                ) displayText.setText("\n" + "Du skrev: " + firstName.getText());

    }
}