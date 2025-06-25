package org.plugins.minevidencia.Effects;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

public class ApplySpeedEffect {
    private final MessageOnApplyCommand message;
    int speedIncrease;
    private PotionEffect potionEffect;

    public ApplySpeedEffect(MessageOnApplyCommand message) {
        this.message = message;
    }

    public PotionEffect execute(String args, CommandSender sender) {
        Player player = (Player) sender;
        try {
            speedIncrease = Integer.parseInt(args);
            player.removePotionEffect(PotionEffectType.SPEED);
            potionEffect = new PotionEffect(
                    PotionEffectType.SPEED,
                    PotionEffect.INFINITE_DURATION,
                    speedIncrease,
                    true,
                    true
            );
            this.message.onCommandApplySuccess(sender);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            this.message.onCommandApplyError(sender);
        }
        return potionEffect;
    }
}
