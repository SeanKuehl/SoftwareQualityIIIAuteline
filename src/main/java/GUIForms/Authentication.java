package main.java.GUIForms;

import main.java.ATM;
import main.java.BankDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentication extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitButton;
    public JPanel MainPanel;

    public boolean authenticated = false;
    public Authentication(){



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankDatabase database = new BankDatabase();
                int accountNumber = Integer.parseInt(textField1.getText());
                int pin = Integer.parseInt((textField2.getText()));
                authenticated = database.authenticateUser(accountNumber, pin);

                if (authenticated){


                    ATM.showMainMenu();


                }
                else {
                    textField1.setText("inavalid account");
                    textField2.setText("invalid pin");
                }

            }
        });
    }
}
