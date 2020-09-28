package net.buildtheearth.minigames.adminchat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.UUID;

public class acChat extends Command {
    public acChat() {
        super("acchat");
    }
    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            //Re enable when ready for permission manager.
            //if(!player.getPermissions().contains("bteadminchat.chat")) {
            //  player.sendMessage(new TextComponent(ChatColor.RED  + "[AC] " + ChatColor.BLUE + "You do not have permission for this command."));
            //  return;
            //}
            String finalText = "";
            for (String s : args) {
                finalText += s + " ";
            };
            for (UUID p : AdminChat.adminChatViewers) {
                ProxyServer.getInstance().getPlayer(p).sendMessage(new TextComponent(ChatColor.RED + "[AC] "  + ChatColor.BLUE + "[" + player.getServer().getInfo().getName() + "] " + player.getDisplayName() + ": " +ChatColor.DARK_PURPLE + finalText));
            }

        } else {
            return;
        }
    }

}