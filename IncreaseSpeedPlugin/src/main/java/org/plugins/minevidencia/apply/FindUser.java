package org.plugins.minevidencia.apply;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.plugins.minevidencia.domain.User;

public class FindUser implements Listener {

    private final VerifyUser verifyUser;
    private final PlayerCommandSendEvent event;

    public FindUser(VerifyUser verifyUser, PlayerCommandSendEvent event) {
        this.verifyUser = verifyUser;
        this.event = event;
    }

    public User execute(User user, PlayerCommandSendEvent event, EntityType entityType){
        if(!this.verifyUser.isValidUser(user) && this.verifyUser.isEntityPlayer(event, entityType)) return null;
        user = this.verifyUser.getUserByUUID(user, event.getPlayer().getUniqueId());
        return user;
    }
}
