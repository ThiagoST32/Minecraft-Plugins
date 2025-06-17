package org.plugins.minevidencia.Listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class MessageOnApplyCommand implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandApply(PlayerCommandSendEvent event){
        event.getPlayer().sendMessage("O comando está sendo aplicado. Por favor, aguarde.");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandApplyError(PlayerCommandSendEvent event){
        event.getPlayer().sendMessage("O comando não foi aplicado. Por favor, verifique se você digitou o comando corretamente.");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandApplySuccess(PlayerCommandSendEvent event){
        event.getPlayer().sendMessage("O comando foi aplicado com sucesso!.");
    }
}
