package net.buildtheearth.minigames.adminchat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class acToggle extends Command {
    public acToggle() {
        super("actoggle");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            //Re enable when ready for permission manager.
            //if(!player.getPermissions().contains("bteadminchat.chat")) {
            //  player.sendMessage(new TextComponent(ChatColor.RED  + "[AC] " + ChatColor.BLUE + "You do not have permission for this command."));
            //  return;
            //}
            if(AdminChat.adminChatChatters.contains(player.getUniqueId())) {
                AdminChat.adminChatChatters.remove(player.getUniqueId());
                player.sendMessage(new TextComponent(ChatColor.RED + "[AC] " + ChatColor.BLUE + "You have disabled sending messages to Admin Chat."));
            } else {
                AdminChat.adminChatChatters.add(player.getUniqueId());
                if(!AdminChat.adminChatViewers.contains(player.getUniqueId())) {
                    AdminChat.adminChatViewers.add(player.getUniqueId());
                    player.sendMessage(new TextComponent(ChatColor.RED + "[AC] " + ChatColor.BLUE + "You have enabled Admin Chat Feed."));
                }
                player.sendMessage(new TextComponent(ChatColor.RED + "[AC] " + ChatColor.BLUE + "You have enabled sending messages to Admin Chat."));
            }

        } else {
            return;
        }
    }
}
