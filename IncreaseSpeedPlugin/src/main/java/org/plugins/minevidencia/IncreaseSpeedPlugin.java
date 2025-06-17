package org.plugins.minevidencia;

import org.bukkit.plugin.java.JavaPlugin;
import org.plugins.minevidencia.Listerners.MessageOnApplyCommand;
import org.plugins.minevidencia.apply.IncreaseSpeed;

public final class IncreaseSpeedPlugin extends JavaPlugin {

    private final MessageOnApplyCommand message;

    public IncreaseSpeedPlugin(MessageOnApplyCommand message) {
        this.message = message;
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin de comando iniciado!");
        getServer().getPluginManager().registerEvents(message, this);
        getCommand("speed").setExecutor(new IncreaseSpeed());

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin de comando desligado!");
        // Plugin shutdown logic
    }
}
