package main.java.GUIForms;

import main.java.ATM;
import main.java.BankDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositCash extends JFrame{
    private JButton button1;
    private JTextField textField1;
    private JButton submitButton;
    public JPanel MainPanel;


    public DepositCash(){

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back button
                ATM.showMainMenu();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //submit button
                double amount = Double.parseDouble(textField1.getText());
                ATM.bankDatabase.credit(ATM.GetAccountNumber(), amount);
                ATM.showMainMenu();
            }
        });
    }

    public void EnterDepositAmount(String amount){
        textField1.setText(amount);
    }

    public boolean PressSubmitButton(int account){
        BankDatabase db = new BankDatabase();
        double amount = Double.parseDouble(textField1.getText());

        try {
            db.credit(account, amount);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

}
