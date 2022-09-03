package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.containsKey(account)) {
            users.get(user).add(account);
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
            if (users.containsKey(requisite)) {
                users.putIfAbsent(user, getAccounts(user));
            }
        }
        return (Account) getAccounts(user);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
         if (findByRequisite(srcPassport, srcRequisite) != null
                && findByRequisite(destPassport, destRequisite) != null) {
            double srcBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
            double destBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
             if (srcBalance >= amount) {
                 findByRequisite(srcPassport, srcRequisite).setBalance(destBalance + amount);
                 findByRequisite(destPassport, destRequisite).setBalance(srcBalance - amount);
                 rsl = true;
             }
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}