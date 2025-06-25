package org.plugins.minevidencia.apply;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.plugins.minevidencia.Effects.ApplySpeedEffect;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

public class IncreaseSpeed implements CommandExecutor {
    private final MessageOnApplyCommand message;
    private final VerifyIncreaseSpeed verifyIncreaseSpeed;
    private final ApplySpeedEffect applySpeedEffect;

    public IncreaseSpeed(MessageOnApplyCommand message, VerifyIncreaseSpeed verifyIncreaseSpeed, ApplySpeedEffect applySpeedEffect) {
        this.message = message;
        this.verifyIncreaseSpeed = verifyIncreaseSpeed;
        this.applySpeedEffect = applySpeedEffect;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;

        try {

            if (args[0].isEmpty()) {
                this.message.onCommandApplyError(sender);
                return false;
            }

            if (Integer.parseInt(args[0]) == 0) {
                player.removePotionEffect(PotionEffectType.SPEED);
                this.message.onCommandApply(sender);
                return false;
            }

            if (!this.verifyIncreaseSpeed.isValidSpeedIncrease(Integer.parseInt(args[0]))) {
                this.message.onCommandApplyErrorIndexOutBound(sender);
                return false;
            }

            if (args.length == 1 && Integer.parseInt(args[0]) != 0) return player.addPotionEffect(this.applySpeedEffect.execute(args[0], sender));

            if (args.length == 2) return this.applySpeedEffectOnOtherPlayer(sender, args);

            if (sender instanceof ConsoleCommandSender) return this.applySpeedEffectOnOtherPlayer(sender, args);

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            this.message.onCommandApplyError(sender);
        }
        return false;
    }

    private boolean applySpeedEffectOnOtherPlayer(@NotNull CommandSender sender, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;
        for (Player onlinePlayer : player.getServer().getOnlinePlayers()) {
            if (onlinePlayer.isOnline() && onlinePlayer.getName().equals(args[0])) {
                return player.addPotionEffect(this.applySpeedEffect.execute(args[1], sender));
            }
        }
        this.message.onCommandApplyOnPlayerOff(sender);
        return true;
    }
}
