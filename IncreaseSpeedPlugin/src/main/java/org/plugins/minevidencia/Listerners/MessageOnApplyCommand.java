package org.plugins.minevidencia.Listerners;

import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MessageOnApplyCommand implements Listener {

    private CommandSender event;

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandApply(){
        event.sendMessage("O comando está sendo aplicado. Por favor, aguarde.");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandApplyError(){
        event.sendMessage("O comando não foi aplicado. Por favor, verifique se você digitou o comando corretamente.");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onCommandApplySuccess(){
        event.sendMessage("O comando foi aplicado com sucesso!.");
    }
}
