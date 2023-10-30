package com.sellby.sellby.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public PasswordHasher(){}

    public String HashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean CheckHash(String passwordHash, String password){
        return BCrypt.checkpw(password, passwordHash);
    }
}
