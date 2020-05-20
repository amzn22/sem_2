package ru.itis.sem1.Services;

import org.springframework.security.core.Authentication;

public interface AuthCheckService {
    public boolean checkAuth(Authentication authentication, String uuid);
}