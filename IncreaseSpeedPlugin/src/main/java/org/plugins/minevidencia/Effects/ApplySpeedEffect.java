package org.plugins.minevidencia.Effects;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;

public class ApplySpeedEffect {
    private final MessageOnApplyCommand message;
    int speedIncrease;

    public ApplySpeedEffect(MessageOnApplyCommand message) {
        this.message = message;
    }

    public PotionEffect execute(String args, CommandSender sender) {
        System.out.println("VALOR RECEBIDO NA FUNÇÃO DE APLICAR -> " + args);
        PotionEffect potionEffect;
        try {
            speedIncrease = Integer.parseInt(args);
            potionEffect = new PotionEffect(
                    PotionEffectType.SPEED,
                    PotionEffect.INFINITE_DURATION,
                    speedIncrease,
                    true,
                    true
            );
            this.message.onCommandApplySuccess(sender);
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("ARRAY MAIOR 2 ARGUMENTOS");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("VALOR INVALIDO");
        } catch (NullPointerException e){
            throw new NumberFormatException("VALOR NULL");
        }
        return potionEffect;
    }
}
