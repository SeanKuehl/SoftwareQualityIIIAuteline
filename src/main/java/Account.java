/**
 * SMTI06, 54411850, M Haidar Hanif
 * Task Five: Automated Teller Machine
 * Auteline | Simple ATM simulator with basic features
 */

// Account.java
// Represents a bank account

package main.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;
public class Account {
  String url = "jdbc:mysql://159.89.117.198:3306/AG6?useSSL=false&serverTimezone=America/New_York";
  String user = "appAG6";
  String password = "Secret55!!";
  private int accountNumber; // account number
  private int pin; // PIN for authentication
  private double availableBalance; // funds available for withdrawal
  private double totalBalance; // funds available + pending deposits

  // Account constructor initializes attributes
  public Account(int theAccountNumber, int thePIN,
                 double theAvailableBalance, double theTotalBalance) {
    accountNumber = theAccountNumber;
    pin = thePIN;
    availableBalance = theAvailableBalance;
    totalBalance = theTotalBalance;
  }

  // determines whether a user-specified PIN matches PIN in Account
  public boolean validatePIN(int userPIN) {
    return userPIN == pin ? true : false;
  }

  // returns available balance
  public double getAvailableBalance() {
    return availableBalance;
  }

  // returns the total balance
  public double getTotalBalance() {
    return totalBalance;
  }

  // credits an amount to the account
  public void credit(double amount)
  {
    totalBalance += amount;

    int ac = getAccountNumber();

    try (Connection con = DriverManager.getConnection(url, user, password);
         Statement st = con.createStatement()) {

      st.executeUpdate("UPDATE AccountInfo SET totalBalance = " +totalBalance
              + "WHERE aacountNumber = " + ac);

    } catch (SQLException ex) {

      Logger lgr = Logger.getLogger(Account.class.getName());
      lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }
  }

  // debits an amount from the account
  public void debit(double amount)
  {
    availableBalance -= amount;
    totalBalance -= amount;

    int ac = getAccountNumber();

    try (Connection con = DriverManager.getConnection(url, user, password);
         Statement st = con.createStatement()) {

      st.executeUpdate("UPDATE AccountInfo SET availableBalance = " +availableBalance
              + "WHERE aacountNumber = " + ac);
      st.executeUpdate("UPDATE AccountInfo SET totalBalance = " +totalBalance
              + "WHERE aacountNumber = " + ac);

    } catch (SQLException ex) {

      Logger lgr = Logger.getLogger(Account.class.getName());
      lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }

  }

  // returns account number
  public int getAccountNumber() {
    return accountNumber;
  }

}
