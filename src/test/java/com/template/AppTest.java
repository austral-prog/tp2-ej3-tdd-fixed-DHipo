package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    /*
     *   ----------------- Deposit -----------------
     */

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        Map<String, Integer> expectedResult = Map.of("mati", 15, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testDepositWithNegativeAmount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testDepositWithNoAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "javi", 5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    /*
    *   ----------------- WITHDRAW -----------------
     */

    @Test
    void testWithdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        Map<String, Integer> expectedResult = Map.of("mati", 5, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testWithdrawWithNegativeAmount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", -5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testWithdrawWithNoAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "javi", 5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testWithdrawWithInsufficientFunds() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "javi", 15);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "jaun", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    /*
     *   ----------------- TRANSFER -----------------
     */

    @Test
    void testTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan",5);
        Map<String, Integer> expectedResult = Map.of("mati", 5, "juan", 25);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testTransferWhitNoAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "topo", "juan",5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "juan", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testTransferWithInsufficientFunds() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "juan",50);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "juan", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testTransferWithSameAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati",5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "juan", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    /*
     *   ----------------- OTHER TESTS -----------------
     */

    @Test
    void testDepositAndTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        updatedAccounts = transfer(updatedAccounts, "mati", "juan",5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "juan", 25);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testWithdrawAndTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        updatedAccounts = transfer(updatedAccounts, "mati", "juan",5);
        Map<String, Integer> expectedResult = Map.of("mati", 0, "juan", 25);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testDepositAndWithdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        updatedAccounts = deposit(updatedAccounts, "mati",5);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "juan", 20);
        assertEquals(expectedResult, updatedAccounts);
    }

    @Test
    void testAll() {
        Map<String, Integer> accounts = Map.of("mati", 10, "juan", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        updatedAccounts = deposit(updatedAccounts, "mati",5);
        updatedAccounts = transfer(updatedAccounts, "mati","juan", 15);
        Map<String, Integer> expectedResult = Map.of("mati", 10, "juan", 20);
        assertEquals(expectedResult, updatedAccounts);
    }
}