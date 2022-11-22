/**
 * SMTI06, 54411850, M Haidar Hanif
 * Task Five: Automated Teller Machine
 * Auteline | Simple ATM simulator with basic features
 */

// ATMTest.java
// Driver program to test ATM program

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

public class ATMTest {
  private static Account[] accounts;

  // main method creates and runs the ATM
  public static void main(String[] args) {

    ATM mobileATM = new ATM(true);
    mobileATM.run();
  }

}
