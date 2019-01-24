package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * Used to withdraw money from the account's balance
     * @param amount the amount to withdraw
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * @throws IllegalArgumentException if amount is greater than balance or negative
     */
    public void withdraw (double amount)  {
        balance -= amount;
    }


    /**
     * Returns true if
     * 1.) email contains one and only one @ but doesn't start with it
     * 2.) email has a dot after the @ symbol
     * 3.) 2 or 3 letters in the domain name
     * 4.) email body only contains alphanumeric characters and "."s
     * @param email string to check
     * @return true if matches the pattern
     */
    public static boolean isEmailValid(String email){
        if (email.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\\.[a-z]{2,3}$")) {
            return true;
        }
        else {
            return false;
        }
    }
}
