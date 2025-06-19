package org.plugins.minevidencia.Effects;

import org.bukkit.command.CommandSender;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

public class ApplySpeedEffect {
    int speedIncrease;
    private final MessageOnApplyCommand message;

    public ApplySpeedEffect(MessageOnApplyCommand message) {
        this.message = message;
    }

    public PotionEffect execute(String args, CommandSender commandSender) {
        speedIncrease = Integer.parseInt(args);

        PotionEffect potionEffect = new PotionEffect(
                PotionEffectType.SPEED,
                PotionEffect.INFINITE_DURATION,
                speedIncrease,
                true,
                true
        );
        this.message.onCommandApplySuccess(commandSender);
        return potionEffect;
    }
}
