package org.plugins.minevidencia.apply;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.plugins.minevidencia.Effects.ApplySpeedEffect;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

public class IncreaseSpeed implements CommandExecutor {
    private final VerifyIncreaseSpeed verifyIncreaseSpeed;
    private final MessageOnApplyCommand message;
    private final ApplySpeedEffect applySpeedEffect;
    int speedIncrease;

    public IncreaseSpeed(MessageOnApplyCommand message, VerifyIncreaseSpeed verifyIncreaseSpeed, ApplySpeedEffect applySpeedEffect) {
        this.message = message;
        this.verifyIncreaseSpeed = verifyIncreaseSpeed;
        this.applySpeedEffect = applySpeedEffect;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        if (args.length == 0){
            this.message.onCommandApplyErrorIndexOutBound(sender);
            return false;
        }

        speedIncrease = Integer.parseInt(args[0]);

        if (!this.verifyIncreaseSpeed.isValidSpeedIncrease(speedIncrease)) {
            this.message.onCommandApplyErrorIndexOutBound(sender);
            return false;
        }

        if (speedIncrease == 0){
            player.removePotionEffect(PotionEffectType.SPEED);
            this.message.onCommandApply(sender);
            return true;
        }

        player.removePotionEffect(PotionEffectType.SPEED);
        player.addPotionEffect(this.applySpeedEffect.execute(args, sender));

        return true;
    }
}
