package com.example.davatelijazzu.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    USER,
    ADMIN,
    BAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
