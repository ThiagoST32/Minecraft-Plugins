package org.plugins.minevidencia.Listerners;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MessageOnApplyCommand {

    public void onCommandApply(CommandSender event) {
        event.sendMessage("O comando está sendo aplicado. Por favor, aguarde.");
    }

    public void onCommandApplyError(CommandSender event) {
        event.sendMessage("O comando não foi aplicado. Por favor, verifique se você digitou o comando corretamente.");
    }

    public void onCommandApplySuccess(CommandSender event) {
        event.sendMessage("O comando foi aplicado com sucesso!.");
    }

    public void onCommandApplyErrorIndexOutBound(CommandSender event) {
        event.sendMessage("O comando não foi aplicado. Por favor forneça um valor de 0 a 4");
    }
}
