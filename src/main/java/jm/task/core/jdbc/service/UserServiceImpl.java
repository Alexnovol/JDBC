package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import lombok.experimental.Delegate;

public class UserServiceImpl implements UserService {
    @Delegate
    private UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
}
