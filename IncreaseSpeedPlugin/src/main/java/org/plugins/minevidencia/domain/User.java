package org.plugins.minevidencia.domain;

import java.util.UUID;

public class User {
    private UUID uuidPlayer;
    private String namePlayer;
    private String role;

    public User(UUID uuidPlayer, String namePlayer, String role) {
        this.uuidPlayer = uuidPlayer;
        this.namePlayer = namePlayer;
        this.role = role;
    }

    public User() {
    }

    public UUID getUuidPlayer() {
        return uuidPlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public String getRole() {
        return role;
    }
}
