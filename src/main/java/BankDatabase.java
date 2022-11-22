/**
 * SMTI06, 54411850, M Haidar Hanif
 * Task Five: Automated Teller Machine
 * Auteline | Simple ATM simulator with basic features
 */

// BankDatabase.java
// Represents the bank account information database

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
public class BankDatabase {
  String url = "jdbc:mysql://159.89.117.198:3306/AG6?useSSL=false&serverTimezone=America/New_York";
  String user = "appAG6";
  String password = "Secret55!!";
  String query = "SELECT * FROM AccountInfo";
  private Account accounts[]; // array of Accounts

  // no-argument BankDatabase constructor initializes accounts
  public BankDatabase() {
//    accounts = new Account[2]; // just 2 accounts for testing
//    accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
//    accounts[1] = new Account(98765, 56789, 200.0, 200.0);
    readData();

  }

  private void readData()
  {
    try (Connection con = DriverManager.getConnection(url, user, password);
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query)) {
      int i = 0;
      accounts = new Account[10];
      while (rs.next()) {
        accounts[i] = new Account(rs.getInt("aacountNumber"),
                rs.getInt("pin"),
                rs.getFloat("availableBalance"),
                rs.getFloat("totalBalance"));
        i++;
      }

    } catch (SQLException ex) {

      Logger lgr = Logger.getLogger(ATMTest.class.getName());
      lgr.log(Level.SEVERE, ex.getMessage(), ex);
    }
  }
  // retrieve Account object containing specified account number
  Account getAccount(int accountNumber) {
    // loop through accounts searching for matching account number
    for (Account currentAccount : accounts) {
      // return current account if match found
      if (currentAccount.getAccountNumber() == accountNumber) {
        return currentAccount;
      }
    }
    return null; // if no matching account was found
  }

  // determine whether user-specified account number and PIN match
  // those of an account in the database
  public boolean authenticateUser(int userAccountNumber, int userPIN) {
    // attempt to retrieve the account with the account number
    Account userAccount = getAccount(userAccountNumber);
    // if account exists, return result of Account method validatePIN
    return userAccount != null ? userAccount.validatePIN(userPIN) : false;
  }

  // return available balance of Account with specified account number
  public double getAvailableBalance(int userAccountNumber) {

    // loop through accounts searching for matching account number
    for (Account currentAccount : accounts) {
      // return current account if match found
      if (currentAccount.getAccountNumber() == userAccountNumber) {
        return currentAccount.getAvailableBalance();
      }
    }
    return 0.0; // if no matching account was found

    //return getAccount(userAccountNumber).getAvailableBalance();
  }



  // return total balance of Account with specified account number
  public double getTotalBalance(int userAccountNumber) {

    // loop through accounts searching for matching account number
    for (Account currentAccount : accounts) {
      // return current account if match found
      if (currentAccount.getAccountNumber() == userAccountNumber) {
        return currentAccount.getTotalBalance();
      }
    }
    return 0.0; // if no matching account was found

    //return getAccount(userAccountNumber).getTotalBalance();
  }

  // credit an amount to Account with specified account number
  public void credit(int userAccountNumber, double amount) {
    getAccount(userAccountNumber).credit(amount);
  }

  // debit an amount from of Account with specified account number
  public void debit(int userAccountNumber, double amount) {
    getAccount(userAccountNumber).debit(amount);
  }

}
