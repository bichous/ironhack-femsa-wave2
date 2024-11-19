package com.spin.lab2;

public class AuthenticationServiceImpl implements AuthenticationService{

    @Override
    public boolean authenticate(String username, String password) {
        if (username == "admin") {
            if (password == "ZUgASofitrO8") {
                return true;
            }
        }
        return false;
    }
}
