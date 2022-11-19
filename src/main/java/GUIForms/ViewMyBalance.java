package main.java.GUIForms;

import main.java.ATM;
import main.java.BankDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMyBalance extends JFrame{
    private JButton button1;
    public JPanel MainPanel;
    private JLabel Available;
    private JLabel Total;


    public ViewMyBalance(){

        BankDatabase database = new BankDatabase();
        int accountNum = ATM.GetAccountNumber();

        if (accountNum == 0){

        }
        else {
            double availableBalance = database.getAvailableBalance(accountNum);
            double totalBalance = database.getTotalBalance(accountNum);




            Available.setText("Available Balance: "+ availableBalance);
            Total.setText("Total Balance: "+ totalBalance);
        }


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATM.showMainMenu();
            }
        });
    }


}
