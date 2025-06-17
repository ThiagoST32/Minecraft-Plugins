package org.plugins.minevidencia.apply;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

public class IncreaseSpeed implements CommandExecutor {
    private PotionEffect potionEffect;
    private VerifyIncreaseSpeed verifyIncreaseSpeed;
    private MessageOnApplyCommand message;
    int speedIncrease = 0;


    public IncreaseSpeed() {}

    public IncreaseSpeed(PotionEffect potionEffect, MessageOnApplyCommand message, VerifyIncreaseSpeed verifyIncreaseSpeed) {
        this.verifyIncreaseSpeed = verifyIncreaseSpeed;
        this.potionEffect = potionEffect;
        this.message = message;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        this.message.onCommandApply();
        Player player = (Player) commandSender;

        if (!this.verifyIncreaseSpeed.isValidSpeedIncrease(speedIncrease)) this.message.onCommandApplyError();
        player.addPotionEffect(this.applyEffect(speedIncrease, args));

        return true;
    }

    private PotionEffect applyEffect(int speedIncrease, String[] args) {
        if (args.length > 0) {
            speedIncrease = Integer.parseInt(args[0]);
            this.potionEffect = new PotionEffect(
                    PotionEffectType.SPEED,
                    PotionEffect.INFINITE_DURATION,
                    speedIncrease,
                    true,
                    true
            );
            this.message.onCommandApplySuccess();
        }
        return this.potionEffect;
    }
}
