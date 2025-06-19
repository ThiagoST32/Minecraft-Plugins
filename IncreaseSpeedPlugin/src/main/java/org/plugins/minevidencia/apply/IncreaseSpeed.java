package org.plugins.minevidencia.apply;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.plugins.minevidencia.Effects.ApplySpeedEffect;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

import java.util.Arrays;
import java.util.Objects;

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
        try {
            Player player = (Player) sender;

            if (args[0].isEmpty()){
                this.message.onCommandApplyError(sender);
                return false;
            }

            if (!this.verifyIncreaseSpeed.isValidSpeedIncrease(speedIncrease)) {
                this.message.onCommandApplyErrorIndexOutBound(sender);
                return false;
            }

            if (!args[0].equals(Integer.toString(speedIncrease))) {
                for (Player onlinePlayer : player.getServer().getOnlinePlayers()){
                    if (args[0].equals(onlinePlayer.getName())) {
                        Arrays.stream(args)
                                .filter(p -> Objects.requireNonNull(onlinePlayer.getServer().getPlayer(args[0])).isOnline());
                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.addPotionEffect(this.applySpeedEffect.execute(args[1], sender));
                        return true;
                    }
                    return false;
                }
            }

            speedIncrease = Integer.parseInt(args[0]);

            if (speedIncrease == 0){
                player.removePotionEffect(PotionEffectType.SPEED);
                this.message.onCommandApply(sender);
                return true;
            }

            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(this.applySpeedEffect.execute(args[0], sender));

            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            this.message.onCommandApplyError(sender);
        }
        return false;
    }
}
