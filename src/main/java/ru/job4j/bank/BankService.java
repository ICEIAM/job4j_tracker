package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс представляет из себя реализацию банковского приложения.
 * @author Дмитрий Лукин.
 * @version 1.1
 */
public class BankService {
    /**
     * Поле пользователя системы.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет наличие пользователя и создает его, если таковой отсутствует.
     * @param user пользователь, которого мы хотим проверить и добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет создать счет пользователя.
     * Методом findByPassport ищется пользователь по паспорту, затем получаем информацию по счетам.
     * Если вводимого счета у пользователя нет, то он создается.
     * @param passport паспорт пользователя.
     * @param account счет пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
            users.get(user).add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользвателя по данным паспорта с помощью цикла for-each и метода keySet.
     * @param passport паспорт пользователя.
     * @return возвращаем пользователя.
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет найти пользователя по реквизитам.
     * Сначала используется метод findByPassport для поиска пользователя.
     * Затем ищется конкретный счет среди списка всех счетов пользователя.
     * @param passport паспорт.
     * @param requisite конкретные реквизиты.
     * @return возвращаем нужный счет.
     */
    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            return users.get(findByPassport(passport))
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
    /**
     * Метод, который позволяет перечислить средства с одного счета на другой.
     * Если на первом счете (с которого переводят) недостаточно средств, то метод возвращает false.
     * Методом setBalance меняются состояния счетов.
     * @param srcPassport Паспорт переводимого счета.
     * @param srcRequisite Реквизит переводимого счета.
     * @param destPassport Паспорт счета, на который переводят средства.
     * @param destRequisite Реквизиты счета, на который переводят средства.
     * @param amount Сумма переводимых средств
     * @return возвращает, прошла ли процедура.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account one = findByRequisite(srcPassport, srcRequisite);
        Account two = findByRequisite(destPassport, destRequisite);
        if (one != null && two != null && one.getBalance() >= amount) {
            one.setBalance(one.getBalance() - amount);
            two.setBalance(two.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}