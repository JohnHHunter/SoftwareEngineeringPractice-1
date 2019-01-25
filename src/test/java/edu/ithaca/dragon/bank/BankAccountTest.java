package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount1 = new BankAccount("a@b.com", 200);
        assertEquals(200, bankAccount1.getBalance());

        BankAccount bankAccount2 = new BankAccount("a@b.com", 150.75);
        assertEquals(150.75, bankAccount2.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());

        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-100));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(0.252));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(200));

        bankAccount.withdraw(0.50);
        assertEquals(99.50, bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertTrue(BankAccount.isEmailValid("a@b.co"));
        assertTrue(BankAccount.isEmailValid("a.@b.com"));

        assertFalse(BankAccount.isEmailValid(null));
        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("@b.com"));
        assertFalse(BankAccount.isEmailValid("@com"));
        assertFalse(BankAccount.isEmailValid("ab.@com"));
        assertFalse(BankAccount.isEmailValid("a@b.c"));
        assertFalse(BankAccount.isEmailValid("a@b.comm"));
        assertFalse(BankAccount.isEmailValid("a@b@.com"));
        assertFalse(BankAccount.isEmailValid("a$@b.com"));
    }

    @Test
    void isAmountValidTest() {
        assertTrue(BankAccount.isAmountValid(200));
        assertTrue(BankAccount.isAmountValid((200.1)));
        assertTrue(BankAccount.isAmountValid((200.20)));

        assertFalse(BankAccount.isAmountValid(-200));
        assertFalse(BankAccount.isAmountValid(200.123));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 100.2342));
    }

}