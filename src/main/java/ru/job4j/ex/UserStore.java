package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rsl = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                rsl = i;
                break;
            } else if (!users[i].equals(login)) {
                throw new UserNotFoundException("Пользователь не найден!");
            }
        }
        return users[rsl];
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <= 3) {
            throw new UserInvalidException("Пользователь не валидный.");
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            try {
                User user = findUser(users, "Petr Arsentev");
                if (validate(user)) {
                System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                e.printStackTrace();
            } catch (UserNotFoundException r) {
                r.printStackTrace();
            }
        }
    }