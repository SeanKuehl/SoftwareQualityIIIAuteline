package main.java.GUIForms;

import main.java.ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton viewMyBalanceButton;
    private JButton withdrawCashButton;
    private JButton depositFundsButton;
    private JButton exitButton;
    public JPanel MainPanel;


    public MainMenu(){

        viewMyBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //view my balance

                ATM.viewMyBalance();
            }
        });
        withdrawCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //withdraw cash
                ATM.showWithdrawCash();
            }
        });
        depositFundsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //deposit funds
                ATM.showDepositCash();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //exit
                ATM.showExitScreen();
            }
        });
    }


}
