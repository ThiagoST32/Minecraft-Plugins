package org.plugins.minevidencia;

import org.bukkit.plugin.java.JavaPlugin;
import org.plugins.minevidencia.Effects.ApplySpeedEffect;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;
import org.plugins.minevidencia.apply.IncreaseSpeed;
import org.plugins.minevidencia.apply.VerifyIncreaseSpeed;

public final class IncreaseSpeedPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        MessageOnApplyCommand message = new MessageOnApplyCommand();
        VerifyIncreaseSpeed verifyIncreaseSpeed = new VerifyIncreaseSpeed();
        ApplySpeedEffect applySpeedEffect = new ApplySpeedEffect(message);
        getLogger().info("Plugin de comando iniciado!");
        getCommand("speed").setExecutor(new IncreaseSpeed(message, verifyIncreaseSpeed, applySpeedEffect));
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin de comando desligado!");
        // Plugin shutdown logic
    }
}
