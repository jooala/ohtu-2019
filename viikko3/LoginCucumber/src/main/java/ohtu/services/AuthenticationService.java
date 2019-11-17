package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        boolean invalid = false;
        if (username.length() < 3) {
            invalid = true;
        }
        
        if (!username.matches("^[a-z]+")) {
            invalid = true;
        }
        
        if(password.length() < 8) {
            invalid = true;
        }
        int sum = 0;
        char k;
        for (int i = 0; i < password.length(); i++) {
            k = password.charAt(i);
            if (Character.isDigit(k)) {
                sum += 1; 
            }   
        }
        if (sum < 1 ) {
            invalid = true;  
        }
        
        return invalid;
    }
}
