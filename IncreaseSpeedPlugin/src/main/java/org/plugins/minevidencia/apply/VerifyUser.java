package org.plugins.minevidencia.apply;

import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.jetbrains.annotations.NotNull;
import org.plugins.minevidencia.Exeception.InvalidCommandExeception;
import org.plugins.minevidencia.domain.User;

import java.util.UUID;

public class VerifyUser {
    protected boolean isValidUser(User user){
        return user != null && user.getUuidPlayer() != null && user.getNamePlayer() != null && !user.getNamePlayer().isEmpty();
    }

    protected boolean isAdmin(User user){
        return user.getRole().equalsIgnoreCase("admin");
    }

    protected boolean ifSpeedIncreaseValid(int speedIncrease) {
        return speedIncrease > 0 && speedIncrease <= 3;
    }

    protected boolean isEntityPlayer(PlayerCommandSendEvent event, EntityType entityType){
        return event.getPlayer().getType().equals(EntityType.PLAYER);
    }

    protected User getUserByUUID(User user, @NotNull UUID uuid) {
        if (isValidUser(user) && user.getUuidPlayer().equals(uuid)) {
            return user;
        }
        return new InvalidCommandExeception();
    }
}
