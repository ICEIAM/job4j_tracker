package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
            users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        } return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            Account account = (Account) users.get(user);
            if (account.equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account one = findByRequisite(srcPassport, srcRequisite);
        Account two = findByRequisite(destPassport, destRequisite);
         if (one != null && two != null) {
            double srcBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
            double destBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
             if (srcBalance >= amount) {
                 one.setBalance(destBalance + amount);
                 two.setBalance(srcBalance - amount);
                 rsl = true;
             }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}