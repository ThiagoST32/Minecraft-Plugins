package org.plugins.minevidencia.apply;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.plugins.minevidencia.domain.User;

public class IncreaseSpeed implements Listener {
    private final FindUser findUser;

    public IncreaseSpeed(FindUser findUser) {
        this.findUser = findUser;
    }

    public void applySpeedIncrease(User user, double speedIncrease, PlayerCommandSendEvent event, EntityType entityType) {
        var foundUser = this.findUser.execute(user, event, entityType);
        if (foundUser != null) {
            double newSpeed = foundUser.getSpeed()
        }
    }
}
