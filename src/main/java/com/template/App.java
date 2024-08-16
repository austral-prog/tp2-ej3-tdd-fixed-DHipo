package com.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App {


    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {

        if (!accounts.containsKey(account)) return accounts;
        if (amount <= 0) return accounts;

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, accounts.get(account) + amount);
        return updatedAccounts;
    }

    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {

        if (!accounts.containsKey(account)) return accounts;
        if (amount <= 0) return accounts;
        if (accounts.get(account) - amount < 0) return accounts; // Saldo insuficiente

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, accounts.get(account) - amount);
        return updatedAccounts;
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String from_account, String to_account, int amount) {

        if (Objects.equals(from_account, to_account)) return accounts;
        if (!accounts.containsKey(to_account) || !accounts.containsKey(from_account)) return accounts;
        if (accounts.get(from_account) - amount < 0) return accounts;
        if (amount <= 0) return accounts;

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(from_account, accounts.get(from_account) - amount);
        updatedAccounts.put(to_account, accounts.get(to_account) + amount);
        return updatedAccounts;
    }
}
