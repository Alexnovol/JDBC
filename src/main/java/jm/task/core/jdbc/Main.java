package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Юрий", "Мухоморов", (byte) 60);
        System.out.println("User с именем - Юрий добавлен в базу данных");
        userService.saveUser("Серафим", "Демидов", (byte) 52);
        System.out.println("User с именем - Серафим добавлен в базу данных");
        userService.saveUser("Федор", "Авдиенко", (byte) 48);
        System.out.println("User с именем - Федор добавлен в базу данных");
        userService.saveUser("Марк", "Бубенцов", (byte) 63);
        System.out.println("User с именем - Марк добавлен в базу данных");
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
